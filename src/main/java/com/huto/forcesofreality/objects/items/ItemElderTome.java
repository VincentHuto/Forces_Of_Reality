package com.huto.forcesofreality.objects.items;

import java.util.List;

import com.huto.forcesofreality.gui.pages.guide.GuiTomeTitle;
import com.huto.forcesofreality.render.entity.item.RenderItemTome;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemElderTome extends ItemTome {

	public ItemElderTome(Properties prop) {
		super(prop.setISTER(() -> RenderItemTome::new));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		if (worldIn.isRemote) {
			Minecraft.getInstance().displayGuiScreen(new GuiTomeTitle(true));
			playerIn.playSound(SoundEvents.ITEM_BOOK_PAGE_TURN, 0.40f, 1F);

		}
		return new ActionResult<>(ActionResultType.SUCCESS, stack);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add(new StringTextComponent(TextFormatting.DARK_PURPLE + "Elder"));
		tooltip.add(new StringTextComponent(TextFormatting.GOLD + "A guide to the world as we know it."));
	}

	@Override
	public Rarity getRarity(ItemStack par1ItemStack) {
		return Rarity.EPIC;
	}

}
