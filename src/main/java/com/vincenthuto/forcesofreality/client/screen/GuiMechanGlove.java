package com.vincenthuto.forcesofreality.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.client.render.tile.ClientTickHandler;
import com.vincenthuto.forcesofreality.common.menu.ContainerMechanGlove;
import com.vincenthuto.forcesofreality.registry.ItemInit;
import com.vincenthuto.hutoslib.client.screen.HLGuiUtils;
import com.vincenthuto.hutoslib.math.Vector3;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;

public class GuiMechanGlove extends AbstractContainerScreen<ContainerMechanGlove> {
	private ResourceLocation GUI;

	public GuiMechanGlove(ContainerMechanGlove container, Inventory playerInventory, Component name) {
		super(container, playerInventory, name);

		switch (container.slotcount) {
		case 3:
			GUI = new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/mechan_glove.png");
			imageWidth = 176;
			imageHeight = 168;
			break;
		case 6:
			GUI = new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/mechan_glove_superior.png");
			imageWidth = 176;
			imageHeight = 168;
			break;
		default:
			GUI = new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/mechan_glove_masterpiece.png");
			imageWidth = 176;
			imageHeight = 168;
			break;
		}
	}

	@Override
	protected void init() {
		super.init();
	}

	@Override
	public boolean keyPressed(int keyCode, int scanCode, int modifiers) {

		return super.keyPressed(keyCode, scanCode, modifiers);
	}

	@Override
	public void render(GuiGraphics graphics, int p_render_1_, int p_render_2_, float p_render_3_) {
		this.renderBackground(graphics);
		super.render(graphics, p_render_1_, p_render_2_, p_render_3_);
		this.renderTooltip(graphics, p_render_1_, p_render_2_);

		graphics.pose().pushPose();
		double time = ClientTickHandler.ticksInGame;
		graphics.pose().mulPose(Vector3.YP.rotationDegrees((float) time).toMoj());
		graphics.renderItemDecorations(font, new ItemStack(ItemInit.mechan_glove.get()), leftPos - 20, topPos - 15);

		graphics.pose().popPose();

	}

	@Override
	protected void renderBg(GuiGraphics graphics, float partialTicks, int x, int y) {

		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, GUI);
		HLGuiUtils.drawTexturedModalRect(leftPos, topPos, 0, 0, imageWidth - 1, imageHeight);

	}

	@Override
	protected void renderLabels(GuiGraphics graphics, int x, int y) {
		graphics.drawCenteredString(font, "Modules", 7, 6, ChatFormatting.GOLD.getColor());
	}
}