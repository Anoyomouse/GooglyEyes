package com.anoyomouse.googlyeyes.tileentity;

import net.minecraft.nbt.NBTTagCompound;

/**
 * Copyright (c) David-John Miller AKA Anoyomouse 2015
 * <p/>
 * See LICENCE in the project directory for licence information
 */
public class TileEntityGooglyEyes extends TileEntityGE
{
	public TileEntityGooglyEyes()
	{
		super();
	}

	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound)
	{
		super.writeToNBT(nbtTagCompound);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound)
	{
		super.readFromNBT(nbtTagCompound);
	}

	@Override
	public void updateEntity()
	{
		if (!this.worldObj.isRemote)
		{
		}
	}
}
