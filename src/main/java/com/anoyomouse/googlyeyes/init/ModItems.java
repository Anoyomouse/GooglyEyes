package com.anoyomouse.googlyeyes.init;

import com.anoyomouse.googlyeyes.item.ItemGEBase;
import com.anoyomouse.googlyeyes.item.ItemGooglyEyesSmall;
import com.anoyomouse.googlyeyes.reference.Names;
import com.anoyomouse.googlyeyes.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Copyright (c) David-John Miller AKA Anoyomouse 2015
 * <p/>
 * See LICENCE in the project directory for licence information
 */
@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
	public static final ItemGEBase smallEyes = new ItemGooglyEyesSmall();

	public static void init()
	{
		GameRegistry.registerItem(smallEyes, Names.Items.GOOGLY_EYES_SMALL);
	}
}
