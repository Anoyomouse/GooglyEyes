package com.anoyomouse.googlyeyes.network.messages;

import com.anoyomouse.googlyeyes.tileentity.TileEntityGE;
import com.anoyomouse.googlyeyes.tileentity.TileEntityGooglyEyes;
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
public class MessageTileEntityGooglyEyes implements IMessage, IMessageHandler<MessageTileEntityGooglyEyes, IMessage>
{
	public int x, y, z;
	public byte orientation, eye_flags;
	public float pupil_x, pupil_y;

	public MessageTileEntityGooglyEyes()
	{
	}

	public MessageTileEntityGooglyEyes(TileEntityGooglyEyes tileEntityGooglyEyes)
	{
		this.x = tileEntityGooglyEyes.xCoord;
		this.y = tileEntityGooglyEyes.yCoord;
		this.z = tileEntityGooglyEyes.zCoord;
		this.orientation = (byte) tileEntityGooglyEyes.getOrientation().ordinal();

		this.eye_flags = tileEntityGooglyEyes.getEyeFlags();
		this.pupil_x = tileEntityGooglyEyes.getPupilPositionX();
		this.pupil_y = tileEntityGooglyEyes.getPupilPositionY();
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.x = buf.readInt();
		this.y = buf.readInt();
		this.z = buf.readInt();
		this.orientation = buf.readByte();

		this.eye_flags = buf.readByte();
		this.pupil_x = buf.readFloat();
		this.pupil_y = buf.readFloat();
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(this.x);
		buf.writeInt(this.y);
		buf.writeInt(this.z);
		buf.writeByte(this.orientation);

		buf.writeByte(this.eye_flags);
		buf.writeFloat(this.pupil_x);
		buf.writeFloat(this.pupil_y);
	}

	@Override
	public IMessage onMessage(MessageTileEntityGooglyEyes message, MessageContext ctx)
	{
		TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.x, message.y, message.z);

		if (tileEntity instanceof TileEntityGE)
		{
			((TileEntityGE) tileEntity).setOrientation(message.orientation);
		}

		if (tileEntity instanceof TileEntityGooglyEyes)
		{
			((TileEntityGooglyEyes) tileEntity).setEyeFlags(message.eye_flags);

			((TileEntityGooglyEyes) tileEntity).setPupilPositionX(message.pupil_x);
			((TileEntityGooglyEyes) tileEntity).setPupilPositionY(message.pupil_y);
		}

		return null;
	}

	@Override
	public String toString()
	{
		return String.format("MessageTileEntityGooglyEyes - x:%s, y:%s, z:%s, orientation:%s, eye_flags:%s, pupil_x:%s, pupil_y:%s", this.x, this.y, this.z, this.orientation, this.eye_flags, this.pupil_x, this.pupil_y);
	}
}
