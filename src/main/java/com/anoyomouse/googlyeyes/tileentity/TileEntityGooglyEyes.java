package com.anoyomouse.googlyeyes.tileentity;

import com.anoyomouse.googlyeyes.network.PacketHandler;
import com.anoyomouse.googlyeyes.network.messages.MessageTileEntityGE;
import com.anoyomouse.googlyeyes.network.messages.MessageTileEntityGooglyEyes;
import com.anoyomouse.googlyeyes.reference.Names;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;

import java.util.List;

/**
 * Copyright (c) David-John Miller AKA Anoyomouse 2015
 * <p/>
 * See LICENCE in the project directory for licence information
 */
public class TileEntityGooglyEyes extends TileEntityGE
{
	private float pupilX, pupilY;
	private byte eyeFlags;

	public TileEntityGooglyEyes()
	{
		super();
	}

	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound)
	{
		super.writeToNBT(nbtTagCompound);

		nbtTagCompound.setFloat(Names.NBT.EYE_FLAGS, this.eyeFlags);

		nbtTagCompound.setFloat(Names.NBT.PUPIL_X, this.pupilX);
		nbtTagCompound.setFloat(Names.NBT.PUPIL_Y, this.pupilY);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound)
	{
		super.readFromNBT(nbtTagCompound);

		if (nbtTagCompound.hasKey(Names.NBT.EYE_FLAGS)) this.eyeFlags = nbtTagCompound.getByte(Names.NBT.EYE_FLAGS);

		if (nbtTagCompound.hasKey(Names.NBT.PUPIL_X)) this.pupilX = nbtTagCompound.getFloat(Names.NBT.PUPIL_X);
		if (nbtTagCompound.hasKey(Names.NBT.PUPIL_Y)) this.pupilY = nbtTagCompound.getFloat(Names.NBT.PUPIL_Y);
	}

	public Vec3 getPosition()
	{
		return Vec3.createVectorHelper(this.xCoord, this.yCoord, this.zCoord);
	}

	public float getPupilPositionX()
	{
		return this.pupilX;
	}

	public float getPupilPositionY()
	{
		return this.pupilY;
	}

	public void setPupilPositionX(float xPosition)
	{
		this.pupilX = xPosition;
	}

	public void setPupilPositionY(float yPosition)
	{
		this.pupilY = yPosition;
	}

	public byte getEyeFlags()
	{
		return this.eyeFlags;
	}

	public void setEyeFlags(byte flags)
	{
		this.eyeFlags = flags;
	}

	@Override
	public Packet getDescriptionPacket()
	{
		return PacketHandler.INSTANCE.getPacketFrom(new MessageTileEntityGooglyEyes(this));
	}

	@Override
	@SuppressWarnings("unchecked")
	public void updateEntity()
	{
		if (worldObj.isRemote)
			return;

		int range = 80;
		List<EntityPlayer> players = worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(xCoord - range, yCoord - range, zCoord - range, xCoord + range, yCoord + range, zCoord + range));

		Vec3 eyePos = this.getPosition();

		double trackedPlayerDistance = 80.0f;
		Vec3 trackedPlayerPosition = null;
		for (EntityPlayer player : players)
		{
			Vec3 playerPosition = player.getPosition(1.0f);
			if (playerPosition != null)
			{
				double newDistance = playerPosition.distanceTo(eyePos);
				if (newDistance < trackedPlayerDistance)
				{
					// This player is closer i'm going to watch him!
					trackedPlayerDistance = newDistance;
					trackedPlayerPosition = playerPosition;
				}
				break;
			}
		}

		if (trackedPlayerPosition != null)
		{
			// See Also: http://stackoverflow.com/questions/724219/how-to-convert-a-3d-point-into-2d-perspective-projection
			/**
			 * Xc,Yc = Camera Location
			 * F = Distance camera is behind the projection plane
			 * X' = ((X - Xc) * (F/Z)) + Xc
			 * Y' = ((Y - Yc) * (F/Z)) + Yc
			 */
			double xPos = ((trackedPlayerPosition.xCoord - eyePos.xCoord) * (1.0 / trackedPlayerPosition.zCoord)) + eyePos.xCoord;
			double yPos = ((trackedPlayerPosition.yCoord - eyePos.yCoord) * (1.0 / trackedPlayerPosition.zCoord)) + eyePos.yCoord;

			this.setPupilPositionX((float)Math.min(Math.max(xPos, -1), 1.0));
			this.setPupilPositionY((float) Math.min(Math.max(yPos, -1), 1.0));

			PacketHandler.INSTANCE.sendToAllAround(new MessageTileEntityGooglyEyes(this), new NetworkRegistry.TargetPoint(this.worldObj.provider.dimensionId, this.xCoord, this.yCoord, this.zCoord, 128d));
		}
	}
}
