package com.anoyomouse.googlyeyes.client.renderer.model;

import com.anoyomouse.googlyeyes.reference.Models;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

/**
 * Copyright (c) David-John Miller AKA Anoyomouse 2015
 * <p/>
 * See LICENCE in the project directory for licence information
 */
@SideOnly(Side.CLIENT)
public class ModelGooglyEye
{
	private IModelCustom modelGooglyEyes;

	public ModelGooglyEye()
	{
		modelGooglyEyes = AdvancedModelLoader.loadModel(Models.GOOGLY_EYES);
	}

	public void render()
	{
		modelGooglyEyes.renderPart("Box");
	}
}
