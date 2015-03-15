package com.anoyomouse.googlyeyes.handler;

import com.anoyomouse.googlyeyes.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Copyright (c) David-John Miller AKA Anoyomouse 2015
 * <p/>
 * See LICENCE in the project directory for licence information
 */
public class ConfigurationHandler
{
	public static Configuration configuration;
	public static boolean configValue = false;

	public static void init(File configFile)
	{
		if (configuration == null)
		{
			configuration = new Configuration(configFile);
			loadConfiguration();
		}
	}

	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
		{
			loadConfiguration();
		}
	}

	private static void loadConfiguration()
	{
		configuration.get(Configuration.CATEGORY_GENERAL, "configValue", true, "Just a simple configuration value");

		if (configuration.hasChanged())
		{
			configuration.save();
		}
	}
}
