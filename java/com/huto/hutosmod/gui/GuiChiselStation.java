package com.huto.hutosmod.gui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.containers.ContainerChiselStation;
import com.huto.hutosmod.gui.pages.GuiButtonTextured;
import com.huto.hutosmod.network.PacketChiselCraftingEvent;
import com.huto.hutosmod.network.PacketHandler;
import com.huto.hutosmod.network.PacketUpdateChiselRunes;
import com.huto.hutosmod.objects.tileenties.TileEntityChiselStation;
import com.huto.hutosmod.recipes.RecipeChiselStation;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.IGuiEventListener;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.Button.IPressable;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.fml.client.gui.GuiUtils;

public class GuiChiselStation extends ContainerScreen<ContainerChiselStation> {
	private static final ResourceLocation GUI_Chisel = new ResourceLocation(
			HutosMod.MOD_ID + ":textures/gui/chisel_station.png");
	private final PlayerInventory playerInv;
	private final TileEntityChiselStation te;
	int left, top;
	int guiWidth = 176;
	int guiHeight = 186;
	public GuiButtonTextured[][] runeButtonArray = new GuiButtonTextured[8][8];
	int CLEARBUTTONID = 70;
	GuiButtonTextured clearButton;
	int CHISELBUTTONID = 71;
	GuiButtonTextured chiselButton;
	public List<Integer> activatedRuneList = new ArrayList<Integer>();

	public GuiChiselStation(ContainerChiselStation screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
		this.guiLeft = 0;
		this.guiTop = 0;
		this.xSize = 176;
		this.ySize = 186;
		this.playerInv = inv;
		this.te = screenContainer.getChestInventory();
	}

	@SuppressWarnings({ "deprecation", "unused" })
	@Override
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		Minecraft.getInstance().textureManager.bindTexture(GUI_Chisel);
		int centerX = (width / 2) - guiWidth / 2;
		int centerY = (height / 2) - guiHeight / 2;

		GlStateManager.pushMatrix();
		{
			GlStateManager.enableAlphaTest();
			GlStateManager.enableBlend();
			GlStateManager.color4f(1, 1, 1, 1);
			Minecraft.getInstance().textureManager.bindTexture(GUI_Chisel);

		}
		GlStateManager.popMatrix();
		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).renderButton(matrixStack, mouseX, mouseY, 10);
		}

		super.render(matrixStack, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(matrixStack, mouseX, mouseY);

		GlStateManager.pushMatrix();
		{
			GlStateManager.translatef(-80, 0, 10);
			for (int i = 0; i < 64; i++) {

				if (buttons.get(i).isHovered()) {
					renderTooltip(matrixStack, new StringTextComponent("Rune:" + i), left + guiWidth - (guiWidth - 120),
							top + guiHeight - (170));
				}
			}

			List<ITextComponent> cat1 = new ArrayList<ITextComponent>();
			cat1.add(new StringTextComponent(I18n.format("Clear Runes")));
			if (clearButton.isHovered()) {
				func_243308_b(matrixStack, cat1, left + guiWidth - (guiWidth - 120), top + guiHeight - (170));
			}
			List<ITextComponent> cat9 = new ArrayList<ITextComponent>();
			cat9.add(new StringTextComponent(I18n.format("Chisel Rune")));
			if (chiselButton.isHovered()) {
				func_243308_b(matrixStack, cat9, left + guiWidth - (guiWidth - 120), top + guiHeight - (150));
			}
		}
		GlStateManager.popMatrix();

	}

	@Override
	public void renderBackground(MatrixStack matrixStack) {
		super.renderBackground(matrixStack);
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
		this.font.drawString(matrixStack, this.te.getDisplayName().getUnformattedComponentText(), 8, 6, 65444444);
		this.font.drawString(matrixStack, this.playerInv.getDisplayName().getUnformattedComponentText(), 8,
				this.ySize - 92, 000000);
		GlStateManager.pushMatrix();
		if (te.hasValidRecipe()) {
			RecipeChiselStation currentRecipe = te.getCurrentRecipe();
			GlStateManager.translatef(0, 0, 10);
			minecraft.getItemRenderer().renderItemAndEffectIntoGUI(currentRecipe.getOutput(), 145, 44);
			GlStateManager.scalef(0.45f, 0.5f, 0.5f);
			renderTooltip(matrixStack,
					new StringTextComponent(I18n.format(currentRecipe.getOutput().getTranslationKey())), 250, 150);
		}
		GlStateManager.popMatrix();

		/*
		 * if (this.te.getRuneList() != null) { this.font.drawString(matrixStack,
		 * this.te.runesList.toString(), 8, this.ySize - 170, 000000); }
		 */
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
		GlStateManager.color4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.renderBackground(matrixStack);
		Minecraft.getInstance().getTextureManager().bindTexture(GUI_Chisel);
		GuiUtils.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize, 0f);

	}

	@Override
	protected void init() {
		super.init();
		left = width / 2 - guiWidth / 2;
		top = height / 2 - guiHeight / 2;
		buttons.clear();
		int inc = 0;
		for (int i = 0; i < runeButtonArray.length; i++) {
			for (int j = 0; j < runeButtonArray.length; j++) {
				this.addButton(runeButtonArray[i][j] = new GuiButtonTextured(GUI_Chisel, inc,
						left + guiWidth - (guiWidth - 50 - (i * 8)), top + guiHeight - (160 - (j * 8)), 8, 8, 176, 0,
						false, null, new IPressable() {
							@Override
							public void onPress(Button press) {
								if (press instanceof GuiButtonTextured) {
									GuiButtonTextured button = (GuiButtonTextured) press;
									if (button.getId() <= 64) {
										if (buttons.get(button.getId()) instanceof GuiButtonTextured) {
											GuiButtonTextured test = (GuiButtonTextured) buttons.get(button.getId());
											if (test.getState() == false) {
												test.setState(true);
												activatedRuneList.add(test.getId());
												PacketHandler.HANDLER
														.sendToServer(new PacketUpdateChiselRunes(activatedRuneList));
											} else if (test.getState() == true) {
												test.setState(false);
												activatedRuneList.remove(Integer.valueOf(test.getId()));
												PacketHandler.HANDLER
														.sendToServer(new PacketUpdateChiselRunes(activatedRuneList));
											}

										}
									}

								}
							}

						}));

				inc++;
			}
		}
		this.addButton(clearButton = new GuiButtonTextured(GUI_Chisel, CLEARBUTTONID,
				left + guiWidth - (guiWidth - 120), top + guiHeight - (170), 16, 16, 176, 16, null, (press) -> {
					// PacketHandler.INSTANCE.sendToServer(new PacketChiselCraftingEvent());
					for (int i = 0; i < 64; i++) {
						if (buttons.get(i) instanceof GuiButtonTextured) {
							GuiButtonTextured test = (GuiButtonTextured) buttons.get(i);
							if (test.getState() == true) {
								test.setState(false);
								activatedRuneList.clear();
								PacketHandler.HANDLER.sendToServer(new PacketUpdateChiselRunes(activatedRuneList));
							}
						}
					}
				}));
		this.addButton(chiselButton = new GuiButtonTextured(GUI_Chisel, CHISELBUTTONID,
				left + guiWidth - (guiWidth - 120), top + guiHeight - (150), 16, 16, 176, 48, null, (press) -> {
					PacketHandler.HANDLER.sendToServer(new PacketChiselCraftingEvent());
					for (int i = 0; i < 64; i++) {
						if (buttons.get(i) instanceof GuiButtonTextured) {
							GuiButtonTextured test = (GuiButtonTextured) buttons.get(i);
							if (test.getState() == true) {
								test.setState(false);
								activatedRuneList.clear();
								PacketHandler.HANDLER.sendToServer(new PacketUpdateChiselRunes(activatedRuneList));
							}

						}
					}
				}));
	}

	public List<Integer> getActivatedRuneList() {
		return activatedRuneList;
	}

	@Override
	protected <T extends IGuiEventListener> T addListener(T listener) {
		return super.addListener(listener);
	}

	public static int[] convertIntegers(List<Integer> integers) {
		int[] ret = new int[integers.size()];
		Iterator<Integer> iterator = integers.iterator();
		for (int i = 0; i < ret.length; i++) {
			ret[i] = iterator.next().intValue();
		}
		return ret;
	}

	@Override
	public boolean isPauseScreen() {
		return false;
	}
}