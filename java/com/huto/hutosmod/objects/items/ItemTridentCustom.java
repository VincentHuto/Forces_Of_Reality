package com.huto.hutosmod.objects.items;

import com.huto.hutosmod.capabilities.IVibrations;
import com.huto.hutosmod.capabilities.VibrationProvider;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemTridentCustom extends TridentItem {

	public ItemTridentCustom(Properties prop) {
		super(prop);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if (!worldIn.isRemote) {
			IVibrations vibes = playerIn.getCapability(VibrationProvider.VIBE_CAPA)
					.orElseThrow(IllegalStateException::new);
			playerIn.sendStatusMessage(new StringTextComponent(
					"Current Resonance: " + TextFormatting.DARK_PURPLE + vibes.getVibes() + "Hz"), false);

		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

	
	
}
