package com.anoyomouse.googlyeyes.proxy;

import com.anoyomouse.googlyeyes.client.item.ItemRendererGooglyEyes;
import com.anoyomouse.googlyeyes.init.ModBlocks;
import com.anoyomouse.googlyeyes.reference.RenderIds;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

/**
 * Copyright (c) David-John Miller AKA Anoyomouse 2015
 * <p/>
 * See LICENCE in the project directory for licence information
 */
public class ClientProxy extends CommonProxy
{
	@Override
	public ClientProxy getClientProxy()
	{
		return this;
	}

	@Override
	public void initRenderingAndTextures()
	{
		RenderIds.smallGooglyEyes = RenderingRegistry.getNextAvailableRenderId();

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.smallEyeBlock), new ItemRendererGooglyEyes());

		// ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAlchemicalChest.class, new TileEntityRendererAlchemicalChest());
	}
}
