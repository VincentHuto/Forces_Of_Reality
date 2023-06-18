package com.vincenthuto.forcesofreality.common.item.coven.tool;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemAllegianceIdentifier extends Item {

	public ItemAllegianceIdentifier(Properties prop) {
		super(prop);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
//
//		if (!worldIn.isClientSide) {
//			ICovenant coven = playerIn.getCapability(CovenantProvider.COVEN_CAPA)
//					.orElseThrow(IllegalStateException::new);
//
//			playerIn.getCapability(CovenantProvider.COVEN_CAPA).ifPresent(covens -> {
//				PacketHandler.sendCovenToClients(new SyncCovenPacket(covens.getDevotion(), playerIn.getId()), playerIn);
//			});
//
//			playerIn.displayClientMessage(Component.translatable(coven.getDevotion().toString()), true);
//		}

		return super.use(worldIn, playerIn, handIn);
	}

}
