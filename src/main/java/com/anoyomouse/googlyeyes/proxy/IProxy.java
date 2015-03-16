package com.anoyomouse.googlyeyes.proxy;

/**
 * Copyright (c) David-John Miller AKA Anoyomouse 2015
 * <p/>
 * See LICENCE in the project directory for licence information
 */
public interface IProxy
{
	public abstract ClientProxy getClientProxy();

	public abstract void initRenderingAndTextures();
}
