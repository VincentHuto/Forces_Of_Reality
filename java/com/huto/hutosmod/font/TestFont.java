package com.huto.hutosmod.font;

import java.util.function.Function;

import com.huto.hutosmod.HutosMod;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.fonts.Font;
import net.minecraft.util.ResourceLocation;

public class TestFont extends FontRenderer {
	public TestFont(Function<ResourceLocation, Font> p_i232249_1_) {
		super(p_i232249_1_);
	}
	
	

	public static ResourceLocation texture = new ResourceLocation(HutosMod.MOD_ID, ":textures/font/aklo.png");

	/*
	 * public TestFont(TextureManager textureManagerIn, ResourceLocation
	 * resourceLocationIn) { super(textureManagerIn, resourceLocationIn); }
	 * 
	 * public TestFont(TextureManager textureManagerIn) { super(textureManagerIn,
	 * texture); }
	 */
}
