package com.huto.forcesofreality.item;

import java.util.List;

import com.huto.forcesofreality.gui.pages.coven.GuiCovenTitle;
import com.huto.forcesofreality.render.entity.item.RenderItemTome;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.util.ActionResultType;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.world.item.Item.Properties;

public class ItemAdvCovenTome extends ItemTome {

	public ItemAdvCovenTome(Properties prop) {
		super(prop.setISTER(() -> RenderItemTome::new));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public InteractionResultHolder<ItemStack> onItemRightClick(Level worldIn, Player playerIn, InteractionHand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		if (worldIn.isRemote) {
			Minecraft.getInstance().displayGuiScreen(new GuiCovenTitle(true));
			playerIn.playSound(SoundEvents.ITEM_BOOK_PAGE_TURN, 0.40f, 1F);

		}
		return new ActionResult<>(ActionResultType.SUCCESS, stack);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add(new StringTextComponent(TextFormatting.LIGHT_PURPLE + "Unlocked"));
		tooltip.add(new StringTextComponent(TextFormatting.GOLD + "Contains information on all known covens."));

	}

	@Override
	public Rarity getRarity(ItemStack par1ItemStack) {
		return Rarity.EPIC;
	}

}
