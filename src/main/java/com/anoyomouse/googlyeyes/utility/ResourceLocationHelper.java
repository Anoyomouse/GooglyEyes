package com.anoyomouse.googlyeyes.utility;

import com.anoyomouse.googlyeyes.reference.Reference;
import net.minecraft.util.ResourceLocation;

/**
 * Copyright (c) David-John Miller AKA Anoyomouse 2015
 * <p/>
 * See LICENCE in the project directory for licence information
 */
public class ResourceLocationHelper
{
	public static ResourceLocation getResourceLocation(String path)
	{
		return new ResourceLocation(Reference.MOD_ID.toLowerCase(), path);
	}
}
