package com.huto.forcesofreality.item.coven.tool;

import com.huto.forcesofreality.capabilitie.covenant.CovenantProvider;
import com.huto.forcesofreality.capabilitie.covenant.ICovenant;
import com.huto.forcesofreality.network.PacketHandler;
import com.huto.forcesofreality.network.coven.SyncCovenPacket;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.level.Level;

import net.minecraft.world.item.Item.Properties;

public class ItemAllegianceIdentifier extends Item {

	public ItemAllegianceIdentifier(Properties prop) {
		super(prop);
	}

	@Override
	public InteractionResultHolder<ItemStack> onItemRightClick(Level worldIn, Player playerIn, InteractionHand handIn) {

		if (!worldIn.isRemote) {
			ICovenant coven = playerIn.getCapability(CovenantProvider.COVEN_CAPA)
					.orElseThrow(IllegalStateException::new);

			playerIn.getCapability(CovenantProvider.COVEN_CAPA).ifPresent(covens -> {
				PacketHandler.sendCovenToClients(new SyncCovenPacket(covens.getDevotion(), playerIn.getEntityId()),
						playerIn);
			});

			playerIn.sendStatusMessage(new StringTextComponent(coven.getDevotion().toString()), true);
		}

		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

}
