package com.huto.forcesofreality.gui.adornments;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.containers.PlayerExpandedContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.DisplayEffectsScreen;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PlayerExpandedScreen extends DisplayEffectsScreen<PlayerExpandedContainer> {

	public static final ResourceLocation background = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/gui/gui_adornments.png");

	private float oldMouseX;
	private float oldMouseY;

	public PlayerExpandedScreen(PlayerExpandedContainer container, PlayerInventory inventory, ITextComponent name) {
		super(container, inventory, name);
	}

	@Override
	public void tick() { // tick
		this.container.runes.setEventBlock(false);
		this.updateActivePotionEffects();
		this.resetGuiLeft();
	}

	@Override
	protected void init() { // init
		this.buttons.clear(); // this.buttons
		super.init();
		this.resetGuiLeft();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int p_146979_1_, int p_146979_2_) { // drawGuiContainerForegroundLayer
		if (this.minecraft != null) { // this.minecraft
			this.minecraft.fontRenderer.func_243248_b(matrixStack, new TranslationTextComponent("container.crafting"),
					115 - 18, 8 + 22, 4210752);
		}
	}

	@Override
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) { // render
		this.renderBackground(matrixStack); // renderBackground
		super.render(matrixStack, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(matrixStack, mouseX, mouseY); // renderHoveredToolTip
		this.oldMouseX = (float) mouseX;
		this.oldMouseY = (float) mouseY;
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int mouseX,
			int mouseY) { // drawGuiContainerBackgroundLayer
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		if (this.minecraft != null) {
			this.minecraft.getTextureManager().bindTexture(background);
			int k = this.guiLeft;
			int l = this.guiTop;
			this.blit(matrixStack, k, l, 0, 0, this.xSize, this.ySize); // blit
			for (int i1 = 0; i1 < this.container.inventorySlots.size(); ++i1) {
				Slot slot = this.container.inventorySlots.get(i1);
				if (slot.getHasStack() && slot.getSlotStackLimit() == 1) {
					this.blit(matrixStack, k + slot.xPos, l + slot.yPos, 200, 0, 16, 16);
				}
			}
			InventoryScreen.drawEntityOnScreen(k + 51, l + 75, 30, (float) (k + 51) - this.oldMouseX,
					(float) (l + 75 - 50) - this.oldMouseY, this.minecraft.player);
		}
	}
	//No Longer necccisairy as you cannot acsess runes from INV anymore
	/*@Override
	public boolean keyPressed(int keyCode, int scanCode, int what) { // keyPressed
		if (ClientEventSubscriber.KEY_ADORNMENTS.isActiveAndMatches(InputMappings.getInputByCode(keyCode, scanCode))) {
			if (this.minecraft != null) {
				this.minecraft.player.closeScreen();
			}
			return true;
		} else {
			return super.keyPressed(keyCode, scanCode, what);
		}
	}
*/
	private void resetGuiLeft() {
		this.guiLeft = (this.width - this.xSize) / 2; // width
	}
}