package com.anoyomouse.googlyeyes.init;

import com.anoyomouse.googlyeyes.reference.Names;
import com.anoyomouse.googlyeyes.tileentity.TileEntityGooglyEyes;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Copyright (c) David-John Miller AKA Anoyomouse 2015
 * <p/>
 * See LICENCE in the project directory for licence information
 */
public class TileEntities
{
	public static void init()
	{
		GameRegistry.registerTileEntity(TileEntityGooglyEyes.class, Names.Blocks.GOOGLY_EYES_SMALL);
	}
}
