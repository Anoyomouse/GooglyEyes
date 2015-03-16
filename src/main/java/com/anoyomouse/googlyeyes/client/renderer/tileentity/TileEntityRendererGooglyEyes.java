package com.anoyomouse.googlyeyes.client.renderer.tileentity;

import com.anoyomouse.googlyeyes.client.renderer.model.ModelGooglyEye;
import com.anoyomouse.googlyeyes.reference.Textures;
import com.anoyomouse.googlyeyes.tileentity.TileEntityGooglyEyes;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

/**
 * Copyright (c) David-John Miller AKA Anoyomouse 2015
 * <p/>
 * See LICENCE in the project directory for licence information
 */
public class TileEntityRendererGooglyEyes extends TileEntitySpecialRenderer
{
	private final ModelGooglyEye modelGooglyEye = new ModelGooglyEye();

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick)
	{
		if (tileEntity instanceof TileEntityGooglyEyes)
		{
			GL11.glPushMatrix();

			// Scale, Translate, Rotate
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			GL11.glTranslatef((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F);

			// Bind texture
			this.bindTexture(Textures.Model.GOOGLY_EYES);

			// Render
			modelGooglyEye.render();

			GL11.glPopMatrix();
		}
	}
}
