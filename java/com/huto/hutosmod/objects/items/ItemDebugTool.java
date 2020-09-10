package com.huto.hutosmod.objects.items;

import javax.annotation.Nonnull;

import com.huto.hutosmod.capabilities.IVibrations;
import com.huto.hutosmod.capabilities.VibrationProvider;
import com.huto.hutosmod.objects.blocks.IActivatable;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.NonNullConsumer;

public class ItemDebugTool extends Item {

	public ItemDebugTool(Properties prop) {
		super(prop);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if (!worldIn.isRemote) {
			IVibrations vibes = playerIn.getCapability(VibrationProvider.VIBE_CAPA)
					.orElseThrow(IllegalStateException::new);
			playerIn.sendStatusMessage(new StringTextComponent(
					"Current Resonance: " + TextFormatting.DARK_PURPLE + vibes.getVibes() + "Hz"), false);
			if (playerIn.isCrouching()) {
				vibes.addVibes(10);
			}

		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

}
