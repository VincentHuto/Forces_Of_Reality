package com.vincenthuto.forcesofreality.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.container.ContainerMechanGlove;
import com.vincenthuto.forcesofreality.init.ItemInit;
import com.vincenthuto.forcesofreality.render.tile.ClientTickHandler;
import com.vincenthuto.hutoslib.client.screen.HLGuiUtils;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;

public class GuiMechanGlove extends AbstractContainerScreen<ContainerMechanGlove> {
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

	private ResourceLocation GUI;

	@Override
	protected void init() {
		super.init();
	}

	@Override
	protected void renderBg(PoseStack matrixStack, float partialTicks, int x, int y) {

		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, GUI);
		HLGuiUtils.drawTexturedModalRect(leftPos, topPos, 0, 0, imageWidth - 1, imageHeight);

	}

	@Override
	protected void renderLabels(PoseStack matrixStack, int x, int y) {
		this.font.draw(matrixStack, "Modules", 7, 6, ChatFormatting.GOLD.getColor());
	}

	@Override
	public void render(PoseStack matrixStack, int p_render_1_, int p_render_2_, float p_render_3_) {
		this.renderBackground(matrixStack);
		super.render(matrixStack, p_render_1_, p_render_2_, p_render_3_);
		this.renderTooltip(matrixStack, p_render_1_, p_render_2_);

		matrixStack.pushPose();
		double time = ClientTickHandler.ticksInGame;
		matrixStack.mulPose(Vector3f.YP.rotationDegrees((float) time));
		Minecraft.getInstance().getItemRenderer().renderAndDecorateItem(new ItemStack(ItemInit.mechan_glove.get()),
				leftPos - 20, topPos - 15);

		matrixStack.popPose();

	}

	@Override
	public boolean keyPressed(int keyCode, int scanCode, int modifiers) {

		return super.keyPressed(keyCode, scanCode, modifiers);
	}
}