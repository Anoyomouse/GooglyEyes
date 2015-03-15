package com.anoyomouse.googlyeyes.init;

import com.anoyomouse.googlyeyes.block.BlockGE;
import com.anoyomouse.googlyeyes.block.BlockSmallEyes;
import com.anoyomouse.googlyeyes.reference.Names;
import com.anoyomouse.googlyeyes.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Copyright (c) David-John Miller AKA Anoyomouse 2015
 * <p/>
 * See LICENCE in the project directory for licence information
 */
@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
	public static final BlockGE smallEyeBlock = new BlockSmallEyes();

	public static void init()
	{
		GameRegistry.registerBlock(smallEyeBlock, Names.Blocks.GOOGLY_EYES_SMALL);
	}
}
