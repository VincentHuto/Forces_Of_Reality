package com.vincenthuto.forcesofreality.client.screen;

import java.util.ArrayList;
import java.util.List;

import com.mojang.blaze3d.systems.RenderSystem;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.common.item.coven.tool.ItemMechanGlove;
import com.vincenthuto.forcesofreality.common.item.tool.coven.module.ItemMechanModuleBase;
import com.vincenthuto.forcesofreality.common.menu.MechanGloveItemHandler;
import com.vincenthuto.forcesofreality.common.network.PacketHandler;
import com.vincenthuto.forcesofreality.common.network.coven.PacketUpdateMechanModule;
import com.vincenthuto.forcesofreality.registry.ItemInit;
import com.vincenthuto.hutoslib.client.HLClientUtils;
import com.vincenthuto.hutoslib.client.screen.GuiButtonTextured;
import com.vincenthuto.hutoslib.client.screen.HLGuiUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Button.OnPress;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;

public class GuiMechanGloveViewer extends Screen {
	final ResourceLocation texture = new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/mechan_viewer_gui.png");
	int guiWidth = 145;
	int guiHeight = 149;
	int left, top;
	ItemStack icon;
	Minecraft mc = Minecraft.getInstance();
	Player player;
	public MechanGloveItemHandler handler;
	public static GuiMechanGloveViewer screen;

	public int slotcount = 0;

	public String itemKey = "";

	public static void openScreenViaItem() {
		openScreen(true);
	}

	public static void openScreen(boolean ignoreNextMouseClick) {
		if (screen == null) {
			screen = new GuiMechanGloveViewer(new ItemStack(ItemInit.mechan_glove.get()),
					HLClientUtils.getClientPlayer());
		}
		Minecraft.getInstance().setScreen(screen);
	}

	@OnlyIn(Dist.CLIENT)
	public GuiMechanGloveViewer(ItemStack currentBinderIn, Player playerIn) {
		super(Component.translatable("View All Patterns"));
		this.icon = currentBinderIn;
		this.player = playerIn;
	}

	@Override
	protected void init() {
		left = width / 2 - guiWidth / 2;
		top = height / 2 - guiHeight / 2;
		int sideLoc = left + guiWidth;
		int verticalLoc = top + guiHeight;
		renderables.clear();
		ItemStack stack = ForcesOfReality.findMechanGlove(player);
		if (stack != null && stack != ItemStack.EMPTY && stack.getItem() instanceof ItemMechanGlove) {
			IItemHandler binderHandler = stack.getCapability(ForgeCapabilities.ITEM_HANDLER)
					.orElseThrow(NullPointerException::new);
			if (stack.getItem() instanceof ItemMechanGlove) {
				ItemMechanGlove glove = (ItemMechanGlove) stack.getItem();
				if (binderHandler instanceof MechanGloveItemHandler) {
					handler = (MechanGloveItemHandler) binderHandler;
					handler.load();
					slotcount = handler.getSlots();
					itemKey = stack.getDescriptionId();
					for (int i = 0; i < binderHandler.getSlots(); i++) {
						if (i < 3) {
							this.addRenderableWidget(new GuiButtonTextured(texture, i, sideLoc - (guiWidth - 30),
									(verticalLoc - 130) + (i * 45), 20, 20, 174, 98, null, new OnPress() {
										@SuppressWarnings("unused")
										@Override
										public void onPress(Button press) {
											if (press instanceof GuiButtonTextured) {
												player.playSound(SoundEvents.BOOK_PAGE_TURN, 0.40f, 1F);
												ItemStack currentStack = binderHandler
														.getStackInSlot(((GuiButtonTextured) press).getId());
												if (currentStack.getItem() instanceof ItemMechanModuleBase) {
													ItemMechanModuleBase pat = (ItemMechanModuleBase) currentStack
															.getItem();
													PacketHandler.HANDLER.sendToServer(new PacketUpdateMechanModule(
															((GuiButtonTextured) press).getId(), currentStack));
													glove.setModuleStack(currentStack);
												}
											}
										}

									}));
						} else if (i < 6) {
							this.addRenderableWidget(new GuiButtonTextured(texture, i, sideLoc - (guiWidth - 63),
									(verticalLoc - 265) + (i * 45), 20, 20, 174, 98, null, new OnPress() {

										@SuppressWarnings("unused")
										@Override
										public void onPress(Button press) {
											if (press instanceof GuiButtonTextured) {
												player.playSound(SoundEvents.BOOK_PAGE_TURN, 0.40f, 1F);
												ItemStack currentStack = binderHandler
														.getStackInSlot(((GuiButtonTextured) press).getId());
												if (currentStack.getItem() instanceof ItemMechanModuleBase) {
													ItemMechanModuleBase pat = (ItemMechanModuleBase) currentStack
															.getItem();
													PacketHandler.HANDLER.sendToServer(new PacketUpdateMechanModule(
															((GuiButtonTextured) press).getId(), currentStack));
													glove.setModuleStack(currentStack);

												}
											}
										}
									}));
						} else if (i < 9) {
							this.addRenderableWidget(new GuiButtonTextured(texture, i, sideLoc - (guiWidth - 95),
									(verticalLoc - 400) + (i * 45), 20, 20, 174, 98, null, new OnPress() {
										@SuppressWarnings("unused")
										@Override
										public void onPress(Button press) {
											if (press instanceof GuiButtonTextured) {
												ItemStack currentStack = binderHandler
														.getStackInSlot(((GuiButtonTextured) press).getId());
												player.playSound(SoundEvents.BOOK_PAGE_TURN, 0.40f, 1F);
												if (currentStack.getItem() instanceof ItemMechanModuleBase) {
													ItemMechanModuleBase pat = (ItemMechanModuleBase) currentStack
															.getItem();
													PacketHandler.HANDLER.sendToServer(new PacketUpdateMechanModule(
															((GuiButtonTextured) press).getId(), currentStack));
													glove.setModuleStack(currentStack);

												}
											}
										}
									}));
						} else if (i < 12)

						{
							this.addRenderableWidget(new GuiButtonTextured(texture, i, sideLoc - (guiWidth - 130),
									(verticalLoc - 410) + (i * 45), 20, 20, 174, 98, null, new OnPress() {
										@SuppressWarnings("unused")
										@Override
										public void onPress(Button press) {
											if (press instanceof GuiButtonTextured) {
												ItemStack currentStack = binderHandler
														.getStackInSlot(((GuiButtonTextured) press).getId());
												player.playSound(SoundEvents.BOOK_PAGE_TURN, 0.40f, 1F);
												if (currentStack.getItem() instanceof ItemMechanModuleBase) {
													ItemMechanModuleBase pat = (ItemMechanModuleBase) currentStack
															.getItem();
													PacketHandler.HANDLER.sendToServer(new PacketUpdateMechanModule(
															((GuiButtonTextured) press).getId(), currentStack));
													glove.setModuleStack(currentStack);

												}
											}
										}
									}));
						}
					}
				}
			}
		}
		super.init();
	}

	@Override
	public boolean isPauseScreen() {
		return false;
	}

	@Override
	public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
		return super.mouseClicked(mouseX, mouseY, mouseButton);
	}

	@Override
	public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
		int centerX = (width / 2) - guiWidth / 2;
		int centerY = (height / 2) - guiHeight / 2;
		this.renderBackground(graphics);
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, texture);
		HLGuiUtils.drawTexturedModalRect(centerX, centerY, 0, 0, guiWidth - 1, guiHeight);

		for (int i = 0; i < renderables.size(); i++) {
			renderables.get(i).render(graphics, mouseX, mouseY, 511);
			if (((GuiButtonTextured) renderables.get(i)).isHoveredOrFocused()) {
				ItemStack stack = ForcesOfReality.findMechanGlove(player);
				if (stack != null && stack != ItemStack.EMPTY && stack.getItem() instanceof ItemMechanGlove) {
					IItemHandler binderHandler = stack.getCapability(ForgeCapabilities.ITEM_HANDLER)
							.orElseThrow(NullPointerException::new);
					if (binderHandler.getStackInSlot(i).getItem() instanceof ItemMechanModuleBase) {
						ItemMechanModuleBase pat = (ItemMechanModuleBase) binderHandler.getStackInSlot(i).getItem();
						List<Component> text = new ArrayList<>();
						text.add(Component.translatable(I18n.get(pat.asItem().getDescription().getString())));
						graphics.renderComponentTooltip(font, text, mouseX, mouseY);
					}
				}
			}
		}

		{
			ItemStack stack = ForcesOfReality.findMechanGlove(player);
			if (stack != null && stack != ItemStack.EMPTY && stack.getItem() instanceof ItemMechanGlove) {
				IItemHandler binderHandler = stack.getCapability(ForgeCapabilities.ITEM_HANDLER)
						.orElseThrow(NullPointerException::new);
				if (binderHandler instanceof MechanGloveItemHandler) {
					handler = (MechanGloveItemHandler) binderHandler;
					handler.load();
					slotcount = handler.getSlots();
					itemKey = stack.getDescriptionId();
					for (int i = 0; i < renderables.size(); i++) {
						if (binderHandler.getStackInSlot(i).getItem() instanceof ItemMechanModuleBase) {
							ItemMechanModuleBase pat = (ItemMechanModuleBase) binderHandler.getStackInSlot(i).getItem();
							graphics.renderItemDecorations(font, new ItemStack(pat.asItem()),
									((GuiButtonTextured) renderables.get(i)).getX() + 2,
									((GuiButtonTextured) renderables.get(i)).getY() + 2);

						}
					}
				}
			}
		}

		{
			graphics.renderItemDecorations(font, icon, -1, -1);

		}

	}

}
