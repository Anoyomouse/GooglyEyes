package com.anoyomouse.googlyeyes.proxy;

/**
 * Copyright (c) David-John Miller AKA Anoyomouse 2015
 * <p/>
 * See LICENCE in the project directory for licence information
 */
public class ServerProxy extends CommonProxy
{
	@Override
	public ClientProxy getClientProxy()
	{
		return null;
	}

	@Override
	public void initRenderingAndTextures()
	{
	}
}
