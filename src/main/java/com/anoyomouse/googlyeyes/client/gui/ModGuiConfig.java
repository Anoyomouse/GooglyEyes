package com.anoyomouse.googlyeyes.client.gui;

import com.anoyomouse.googlyeyes.handler.ConfigurationHandler;
import com.anoyomouse.googlyeyes.reference.Reference;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.ConfigElement;

import java.util.List;

/**
 * Copyright (c) David-John Miller AKA Anoyomouse 2015
 * <p/>
 * See LICENCE in the project directory for licence information
 */
public class ModGuiConfig extends GuiConfig
{
	public ModGuiConfig(GuiScreen guiScreen)
	{
		super(guiScreen,
			new ConfigElement<IConfigElement>(ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
			Reference.MOD_ID,
			false,
			false,
			GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
	}
}
