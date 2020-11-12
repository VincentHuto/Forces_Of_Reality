package com.huto.hutosmod.objects.items.tools;

import com.huto.hutosmod.capabilities.covenant.CovenantProvider;
import com.huto.hutosmod.capabilities.covenant.ICovenant;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class ItemAllegianceIdentifier extends Item {

	public ItemAllegianceIdentifier(Properties prop) {
		super(prop);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

		if (!worldIn.isRemote) {
			ICovenant coven = playerIn.getCapability(CovenantProvider.COVEN_CAPA)
					.orElseThrow(IllegalStateException::new);
			playerIn.sendStatusMessage(new StringTextComponent(coven.getDevotion().toString()), true);
		}

		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

}
