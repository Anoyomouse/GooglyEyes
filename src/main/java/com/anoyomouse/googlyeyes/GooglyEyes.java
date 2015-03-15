package com.anoyomouse.googlyeyes;

import com.anoyomouse.googlyeyes.handler.ConfigurationHandler;
import com.anoyomouse.googlyeyes.proxy.IProxy;
import com.anoyomouse.googlyeyes.reference.Reference;
import com.anoyomouse.googlyeyes.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Copyright (c) David-John Miller AKA Anoyomouse 2015
 * <p/>
 * See LICENCE in the project directory for licence information
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class GooglyEyes
{
	@Mod.Instance(Reference.MOD_ID)
	public static GooglyEyes instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
	public static IProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());

		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

		LogHelper.info("Pre initialization Complete!");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		LogHelper.info("Initialization Complete!");
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		LogHelper.info("Post initialization Complete!");
	}
}
