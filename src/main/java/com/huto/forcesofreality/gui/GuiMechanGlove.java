package com.huto.forcesofreality.gui;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.containers.ContainerMechanGlove;
import com.huto.forcesofreality.init.ItemInit;
import com.huto.forcesofreality.objects.tileenties.util.ClientTickHandler;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;

public class GuiMechanGlove extends ContainerScreen<ContainerMechanGlove> {
	public GuiMechanGlove(ContainerMechanGlove container, PlayerInventory playerInventory, ITextComponent name) {
		super(container, playerInventory, name);

		switch (container.slotcount) {
		case 3:
			GUI = new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/mechan_glove.png");
			xSize = 176;
			ySize = 168;
			break;
		case 6:
			GUI = new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/mechan_glove_superior.png");
			xSize = 176;
			ySize = 168;
			break;
		default:
			GUI = new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/mechan_glove_masterpiece.png");
			xSize = 176;
			ySize = 168;
			break;
		}
	}

	private ResourceLocation GUI;

	@Override
	protected void init() {
		super.init();
	}

	@SuppressWarnings({ "deprecation", "resource" })
	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
		RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.getMinecraft().textureManager.bindTexture(GUI);
		drawTexturedQuad(guiLeft, guiTop, xSize, ySize, 0, 0, 1, 1, 0);
	}

	private void drawTexturedQuad(int x, int y, int width, int height, float tx, float ty, float tw, float th,
			float z) {
		Tessellator tess = Tessellator.getInstance();
		BufferBuilder buffer = tess.getBuffer();

		buffer.begin(7, DefaultVertexFormats.POSITION_TEX);
		buffer.pos((double) x + 0, (double) y + height, (double) z).tex(tx, ty + th).endVertex();
		buffer.pos((double) x + width, (double) y + height, (double) z).tex(tx + tw, ty + th).endVertex();
		buffer.pos((double) x + width, (double) y + 0, (double) z).tex(tx + tw, ty).endVertex();
		buffer.pos((double) x + 0, (double) y + 0, (double) z).tex(tx, ty).endVertex();

		tess.draw();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
		this.font.drawString(matrixStack, "Modules", 7, 6, TextFormatting.GOLD.getColor());
	}
	@SuppressWarnings("deprecation")
	@Override
	public void render(MatrixStack matrixStack, int p_render_1_, int p_render_2_, float p_render_3_) {
		this.renderBackground(matrixStack);
		super.render(matrixStack, p_render_1_, p_render_2_, p_render_3_);
		this.renderHoveredTooltip(matrixStack, p_render_1_, p_render_2_);
		GlStateManager.pushMatrix();
		GlStateManager.scalef(2, 2, 2);
		matrixStack.push();
		double time = ClientTickHandler.ticksInGame ;
		matrixStack.rotate(Vector3f.YP.rotationDegrees((float) time));
		Minecraft.getInstance().getItemRenderer().renderItemAndEffectIntoGUI(new ItemStack(ItemInit.mechan_glove.get()),
				guiLeft-20, guiTop-15);
		
		matrixStack.pop();
		GlStateManager.popMatrix();
	}

	@Override
	public boolean keyPressed(int keyCode, int scanCode, int modifiers) {

		return super.keyPressed(keyCode, scanCode, modifiers);
	}
}