package com.huto.hutosmod.objects.items.tools;

import com.huto.hutosmod.capabilities.vibes.IVibrations;
import com.huto.hutosmod.capabilities.vibes.VibrationProvider;
import com.huto.hutosmod.objects.tileenties.vibes.TileModVibes;
import com.huto.hutosmod.objects.tileenties.vibes.TileVibeSimpleInventory;
import com.ibm.icu.text.DecimalFormat;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemDebugTool extends Item {

	public ItemDebugTool(Properties prop) {
		super(prop);
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext ctx) {
		World world = ctx.getWorld();
		if (!world.isRemote) {
			PlayerEntity player = ctx.getPlayer();

			@SuppressWarnings("unused")
			ItemStack stack = ctx.getItem();
			BlockPos blockPos = ctx.getPos();
			TileEntity te = world.getTileEntity(blockPos);
			DecimalFormat df = new DecimalFormat("0.00");
			if (te instanceof TileModVibes) {
				IVibrations vibes = te.getCapability(VibrationProvider.VIBE_CAPA)
						.orElseThrow(IllegalStateException::new);
				if (!world.isRemote) {
					player.sendStatusMessage(new StringTextComponent(
							TextFormatting.GOLD + "Block Contains:" + df.format(vibes.getVibes())), false);
				}
			}

			if (te instanceof TileVibeSimpleInventory) {
				IVibrations vibes = te.getCapability(VibrationProvider.VIBE_CAPA)
						.orElseThrow(IllegalStateException::new);
				if (!world.isRemote) {
					player.sendStatusMessage(new StringTextComponent(
							TextFormatting.GOLD + "Block Contains:" + df.format(vibes.getVibes())), false);
							
				}
			}

			return super.onItemUse(ctx);
		} else {
			return ActionResultType.FAIL;
		}
	}

}
