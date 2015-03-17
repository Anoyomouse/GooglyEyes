package com.anoyomouse.googlyeyes.network;

import com.anoyomouse.googlyeyes.network.messages.MessageTileEntityGE;
import com.anoyomouse.googlyeyes.network.messages.MessageTileEntityGooglyEyes;
import com.anoyomouse.googlyeyes.reference.Reference;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

/**
 * Copyright (c) David-John Miller AKA Anoyomouse 2015
 * <p/>
 * See LICENCE in the project directory for licence information
 */
public class PacketHandler
{
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID.toLowerCase());

	public static void init()
	{
		INSTANCE.registerMessage(MessageTileEntityGE.class, MessageTileEntityGE.class, 0, Side.CLIENT);
		INSTANCE.registerMessage(MessageTileEntityGooglyEyes.class, MessageTileEntityGooglyEyes.class, 1, Side.CLIENT);
	}
}
