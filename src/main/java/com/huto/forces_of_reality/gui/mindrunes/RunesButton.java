package com.huto.forces_of_reality.gui.mindrunes;

import org.lwjgl.opengl.GL11;

import com.huto.forces_of_reality.network.PacketHandler;
import com.huto.forces_of_reality.network.mindrunes.OpenNormalInvPacket;
import com.huto.forces_of_reality.network.mindrunes.OpenRunesInvPacket;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.client.gui.widget.button.AbstractButton;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
@OnlyIn(Dist.CLIENT)
public class RunesButton extends AbstractButton {

	@SuppressWarnings("rawtypes")
	private final ContainerScreen parentGui;

	// temp
	public boolean _isHovered = this.isHovered();
	public boolean _visible = this.active;
	public int _x = this.x;
	public int _y = this.y;
	public int _width = this.width;
	public int _height = this.height;

	@SuppressWarnings("rawtypes")
	public RunesButton(ContainerScreen parentGui, int x, int y, int width, int height) {
		super(x + parentGui.getGuiLeft() - 35, parentGui.getGuiTop() + y, width, height, new StringTextComponent(""));
		this.parentGui = parentGui;
	}

	@Override
	public void onPress() { // onPress
		if (parentGui instanceof InventoryScreen) {
			PacketHandler.INSTANCE.sendToServer(new OpenRunesInvPacket());
		} else {
			PacketHandler.INSTANCE.sendToServer(new OpenNormalInvPacket());
			this.displayNormalInventory();
		}
	}

	@SuppressWarnings({ "static-access", "deprecation" })
	@Override
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) { // render
		if (!Minecraft.getInstance().player.isCreative()) {
			if (this._visible) {
				FontRenderer fontrenderer = Minecraft.getInstance().fontRenderer;
				Minecraft.getInstance().getTextureManager().bindTexture(PlayerExpandedScreen.background);
				GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
				Minecraft.getInstance().getTextureManager().bindTexture(PlayerExpandedScreen.background);
				GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
				this._isHovered = mouseX >= _x && mouseY >= this._y && mouseX < _x + this._width
						&& mouseY < this._y + this._height;
				GlStateManager.enableBlend();
				GlStateManager.blendFuncSeparate(770, 771, 1, 0);
				GlStateManager.blendFuncSeparate(770, 771, 1, 0);
				GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				GlStateManager.pushMatrix();
				GlStateManager.translatef(0, 0, 200);
				GlStateManager.translatef(0, 0, 200);
				if (!_isHovered) {
					this.blit(matrixStack, _x, this._y, 176, 0, 10, 10); // blit
				} else {
					this.blit(matrixStack, _x, this._y, 186, 0, 10, 10); // blit
					this.drawCenteredString(matrixStack, fontrenderer,
							new TranslationTextComponent("button.runeInv").getString(), _x + 5+27,
							this._y + this._height-10, 0xffffff); // drawCenteredString
				}
				GlStateManager.popMatrix();
			}
		}
	}

	public void displayNormalInventory() {
		InventoryScreen gui = new InventoryScreen(Minecraft.getInstance().player);
		Minecraft.getInstance().displayGuiScreen(gui);
	}
}