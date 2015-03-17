package com.anoyomouse.googlyeyes.tileentity;

import com.anoyomouse.googlyeyes.network.PacketHandler;
import com.anoyomouse.googlyeyes.network.messages.MessageTileEntityGE;
import com.anoyomouse.googlyeyes.reference.Names;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Copyright (c) David-John Miller AKA Anoyomouse 2015
 * <p/>
 * See LICENCE in the project directory for licence information
 */
public class TileEntityGE extends TileEntity
{
	protected ForgeDirection orientation;

	public TileEntityGE()
	{
		orientation = ForgeDirection.SOUTH;
	}

	public ForgeDirection getOrientation()
	{
		return orientation;
	}

	public void setOrientation(ForgeDirection orientation)
	{
		this.orientation = orientation;
	}

	public void setOrientation(int orientation)
	{
		this.orientation = ForgeDirection.getOrientation(orientation);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound)
	{
		super.readFromNBT(nbtTagCompound);

		if (nbtTagCompound.hasKey(Names.NBT.ORIENTATION))
		{
			this.orientation = ForgeDirection.getOrientation(nbtTagCompound.getByte(Names.NBT.ORIENTATION));
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound)
	{
		super.writeToNBT(nbtTagCompound);

		nbtTagCompound.setByte(Names.NBT.ORIENTATION, (byte) orientation.ordinal());
	}

	@Override
	public Packet getDescriptionPacket()
	{
		return PacketHandler.INSTANCE.getPacketFrom(new MessageTileEntityGE(this));
	}
}
