package com.anoyomouse.googlyeyes.creativetab;

import com.anoyomouse.googlyeyes.init.ModItems;
import com.anoyomouse.googlyeyes.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Copyright (c) David-John Miller AKA Anoyomouse 2015
 * <p/>
 * See LICENCE in the project directory for licence information
 */
public class CreativeTabGooglyEyes
{
	public static final CreativeTabs TAB_GOOGLY_EYES = new CreativeTabs(Reference.MOD_ID.toLowerCase())
	{
		@Override
		public Item getTabIconItem()
		{
			return ModItems.smallEyes;
		}
	};
}
