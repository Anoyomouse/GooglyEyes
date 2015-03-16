package com.anoyomouse.googlyeyes.block;

import com.anoyomouse.googlyeyes.reference.Names;
import com.anoyomouse.googlyeyes.reference.RenderIds;
import com.anoyomouse.googlyeyes.tileentity.TileEntityGooglyEyes;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Copyright (c) David-John Miller AKA Anoyomouse 2015
 * <p/>
 * See LICENCE in the project directory for licence information
 */
public class BlockSmallEyes extends BlockGE implements ITileEntityProvider
{
	public BlockSmallEyes()
	{
		super();
		this.setBlockName(Names.Blocks.GOOGLY_EYES_SMALL);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	{
		return new TileEntityGooglyEyes();
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public int getRenderType()
	{
		return RenderIds.smallGooglyEyes;
	}
}
