package com.vincenthuto.forcesofreality.client.screen;
/*
 * package com.vincenthuto.forcesofreality.gui;
 *
 * import com.vincenthuto.forcesofreality.ForcesOfReality; import
 * com.vincenthuto.forcesofreality.containers.ContainerAdornmentBinder; import
 * com.mojang.blaze3d.matrix.MatrixStack; import
 * com.mojang.blaze3d.systems.RenderSystem;
 *
 * import net.minecraft.client.gui.screen.inventory.ContainerScreen; import
 * net.minecraft.client.renderer.BufferBuilder; import
 * net.minecraft.client.renderer.Tessellator; import
 * net.minecraft.client.renderer.vertex.DefaultVertexFormats; import
 * net.minecraft.entity.player.PlayerInventory; import
 * net.minecraft.util.ResourceLocation; import
 * net.minecraft.util.text.ITextComponent;
 *
 * public class GuiAdornmentBinder extends
 * ContainerScreen<ContainerAdornmentBinder> { public
 * GuiAdornmentBinder(ContainerAdornmentBinder container, PlayerInventory
 * playerInventory, ITextComponent name) { super(container, playerInventory,
 * name);
 *
 * switch (container.slotcount) { case 18: GUI = new
 * ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/rune_binder.png");
 * xSize = 176; ySize = 150; break; case 27: GUI = new
 * ResourceLocation(ForcesOfReality.MOD_ID,
 * "textures/gui/rune_binder_upgrade.png"); xSize = 176; ySize = 168; break;
 * default: GUI = new ResourceLocation(ForcesOfReality.MOD_ID,
 * "textures/gui/epic_gui.png"); xSize = 212; ySize = 276; break; } }
 *
 * private ResourceLocation GUI;
 *
 * @Override protected void init() { super.init(); }
 *
 * @SuppressWarnings("deprecation")
 *
 * @Override protected void drawGuiContainerBackgroundLayer(MatrixStack
 * matrixStack, float partialTicks, int x, int y) { RenderSystem.color4f(1.0f,
 * 1.0f, 1.0f, 1.0f); this.getMinecraft().textureManager.bindTexture(GUI);
 * drawTexturedQuad(guiLeft, guiTop, xSize, ySize, 0, 0, 1, 1, 0); }
 *
 * private void drawTexturedQuad(int x, int y, int width, int height, float tx,
 * float ty, float tw, float th, float z) { Tessellator tess =
 * Tessellator.getInstance(); BufferBuilder buffer = tess.getBuffer();
 *
 * buffer.begin(7, DefaultVertexFormats.POSITION_TEX); buffer.pos((double) x +
 * 0, (double) y + height, (double) z).tex(tx, ty + th).endVertex();
 * buffer.pos((double) x + width, (double) y + height, (double) z).tex(tx + tw,
 * ty + th).endVertex(); buffer.pos((double) x + width, (double) y + 0, (double)
 * z).tex(tx + tw, ty).endVertex(); buffer.pos((double) x + 0, (double) y + 0,
 * (double) z).tex(tx, ty).endVertex();
 *
 * tess.draw(); }
 *
 * @Override protected void drawGuiContainerForegroundLayer(MatrixStack
 * matrixStack, int x, int y) { this.font.drawString(matrixStack,
 * this.title.getString(), 7, 6, 0x404040); }
 *
 * @Override public void render(MatrixStack matrixStack, int p_render_1_, int
 * p_render_2_, float p_render_3_) { this.renderBackground(matrixStack);
 * super.render(matrixStack, p_render_1_, p_render_2_, p_render_3_);
 * this.renderHoveredTooltip(matrixStack, p_render_1_, p_render_2_); }
 *
 * @Override public boolean keyPressed(int keyCode, int scanCode, int modifiers)
 * {
 *
 * return super.keyPressed(keyCode, scanCode, modifiers); } }
 */