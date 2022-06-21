package com.vincenthuto.forcesofreality.gui;

import java.util.ArrayList;
import java.util.List;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.vertex.PoseStack;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.container.MechanGloveItemHandler;
import com.vincenthuto.forcesofreality.item.coven.tool.ItemMechanGlove;
import com.vincenthuto.forcesofreality.item.tool.coven.module.ItemMechanModuleBase;
import com.vincenthuto.forcesofreality.network.PacketHandler;
import com.vincenthuto.forcesofreality.network.coven.PacketUpdateMechanModule;
import com.vincenthuto.hutoslib.client.screen.GuiButtonTextured;
import com.vincenthuto.hutoslib.client.screen.HLGuiUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Button.OnPress;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

@OnlyIn(Dist.CLIENT)
public class GuiMechanGloveViewer extends Screen {
	final ResourceLocation texture = new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/mechan_viewer_gui.png");
	int guiWidth = 145;
	int guiHeight = 149;
	int left, top;
	ItemStack icon;
	Minecraft mc = Minecraft.getInstance();
	Player player;
	public MechanGloveItemHandler handler;

	@OnlyIn(Dist.CLIENT)
	public GuiMechanGloveViewer(ItemStack currentBinderIn, Player playerIn) {
		super(Component.translatable("View All Patterns"));
		this.icon = currentBinderIn;
		this.player = playerIn;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		int centerX = (width / 2) - guiWidth / 2;
		int centerY = (height / 2) - guiHeight / 2;
		this.renderBackground(matrixStack);

		HLGuiUtils.drawTexturedModalRect(centerX, centerY, 0, 0, guiWidth - 1, guiHeight);

		for (int i = 0; i < renderables.size(); i++) {
			renderables.get(i).render(matrixStack, mouseX, mouseY, 511);
			// if (renderables.get(i).isHovered()) {
			ItemStack stack = ForcesOfReality.findMechanGlove(player);
			if (stack != null && stack != ItemStack.EMPTY && stack.getItem() instanceof ItemMechanGlove) {
				IItemHandler binderHandler = stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
						.orElseThrow(NullPointerException::new);
				if (binderHandler.getStackInSlot(i).getItem() instanceof ItemMechanModuleBase) {
					ItemMechanModuleBase pat = (ItemMechanModuleBase) binderHandler.getStackInSlot(i).getItem();
					List<Component> text = new ArrayList<>();
					text.add(Component.translatable(I18n.get(pat.asItem().getDescription().getString())));
					renderComponentTooltip(matrixStack, text, mouseX, mouseY);
				}
				// }
			}
		}

		{
			ItemStack stack = ForcesOfReality.findMechanGlove(player);
			if (stack != null && stack != ItemStack.EMPTY && stack.getItem() instanceof ItemMechanGlove) {
				IItemHandler binderHandler = stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
						.orElseThrow(NullPointerException::new);
				if (binderHandler instanceof MechanGloveItemHandler) {
					handler = (MechanGloveItemHandler) binderHandler;
					handler.load();
					slotcount = handler.getSlots();
					itemKey = stack.getDescriptionId();
					for (int i = 0; i < renderables.size(); i++) {
						if (binderHandler.getStackInSlot(i).getItem() instanceof ItemMechanModuleBase) {
							ItemMechanModuleBase pat = (ItemMechanModuleBase) binderHandler.getStackInSlot(i).getItem();
//							Minecraft.getInstance().getItemRenderer().renderAndDecorateItem(new ItemStack(pat.asItem()),
//									(renderables.get(i).x + 2), renderables.get(i).y + 2);
						}
					}
				}
			}
		}

		{
			Minecraft.getInstance().getItemRenderer().renderAndDecorateItem(icon, -1, -1);

		}

	}

	public int slotcount = 0;
	public String itemKey = "";

	@Override
	protected void init() {
		left = width / 2 - guiWidth / 2;
		top = height / 2 - guiHeight / 2;
		int sideLoc = left + guiWidth;
		int verticalLoc = top + guiHeight;
		renderables.clear();
		ItemStack stack = ForcesOfReality.findMechanGlove(player);
		if (stack != null && stack != ItemStack.EMPTY && stack.getItem() instanceof ItemMechanGlove) {
			IItemHandler binderHandler = stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
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
						} else if (i < 12) {
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
	public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
		return super.mouseClicked(mouseX, mouseY, mouseButton);
	}

	@Override
	public boolean isPauseScreen() {
		return false;
	}

}
