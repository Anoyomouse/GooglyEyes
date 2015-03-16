package com.anoyomouse.googlyeyes.client.item;

import com.anoyomouse.googlyeyes.client.renderer.model.ModelGooglyEye;
import com.anoyomouse.googlyeyes.reference.Textures;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * Copyright (c) David-John Miller AKA Anoyomouse 2015
 * <p/>
 * See LICENCE in the project directory for licence information
 */
public class ItemRendererGooglyEyes implements IItemRenderer
{
	private final ModelGooglyEye modelGooglyEye;

	public ItemRendererGooglyEyes()
	{
		modelGooglyEye = new ModelGooglyEye();
	}

	@Override
	public boolean handleRenderType(ItemStack itemStack, ItemRenderType itemRenderType)
	{
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType itemRenderType, ItemStack itemStack, ItemRendererHelper itemRendererHelper)
	{
		return true;
	}

	@Override
	public void renderItem(ItemRenderType itemRenderType, ItemStack itemStack, Object... data)
	{
		switch (itemRenderType)
		{
			case ENTITY:
			{
				renderGooglyEyes(0.5F, 0.5F, 0.5F);
				return;
			}
			case EQUIPPED:
			{
				renderGooglyEyes(0.5F, 0.5F, 0.5F);
				return;
			}
			case EQUIPPED_FIRST_PERSON:
			{
				renderGooglyEyes(0.5F, 0.5F, 0.5F);
				return;
			}
			case INVENTORY:
			{
				renderGooglyEyes(0.5F, 0.5F, 0.5F);
				return;
			}
			default:
		}
	}

	private void renderGooglyEyes(float x, float y, float z)
	{
		GL11.glPushMatrix();

		// Scale, Translate, Rotate
		GL11.glScalef(1F, 1F, 1F);
		GL11.glTranslatef(x, y, z);
		GL11.glRotatef(-90F, 1F, 0, 0);

		// Bind texture
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(Textures.Model.GOOGLY_EYES);

		// Render
		modelGooglyEye.render();

		GL11.glPopMatrix();
	}
}
