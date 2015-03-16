package com.anoyomouse.googlyeyes.network.messages;

import com.anoyomouse.googlyeyes.tileentity.TileEntityGE;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

/**
 * Copyright (c) David-John Miller AKA Anoyomouse 2015
 * <p/>
 * See LICENCE in the project directory for licence information
 */
public class MessageTileEntityGE implements IMessage, IMessageHandler<MessageTileEntityGE, IMessage>
{
	public int x, y, z;
	public byte orientation;

	public MessageTileEntityGE()
	{
	}

	public MessageTileEntityGE(TileEntityGE tileEntityGE)
	{
		this.x = tileEntityGE.xCoord;
		this.y = tileEntityGE.yCoord;
		this.z = tileEntityGE.zCoord;
		this.orientation = (byte) tileEntityGE.getOrientation().ordinal();
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.x = buf.readInt();
		this.y = buf.readInt();
		this.z = buf.readInt();
		this.orientation = buf.readByte();
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
		buf.writeByte(orientation);
	}

	@Override
	public IMessage onMessage(MessageTileEntityGE message, MessageContext ctx)
	{
		TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.x, message.y, message.z);

		if (tileEntity instanceof TileEntityGE)
		{
			((TileEntityGE) tileEntity).setOrientation(message.orientation);
		}

		return null;
	}

	@Override
	public String toString()
	{
		return String.format("MessageTileEntityGE - x:%s, y:%s, z:%s, orientation:%s", x, y, z, orientation);
	}
}
