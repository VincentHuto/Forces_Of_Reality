package com.huto.forcesofreality.objects.items.coven.tool;

import com.huto.forcesofreality.capabilities.covenant.CovenantProvider;
import com.huto.forcesofreality.capabilities.covenant.ICovenant;
import com.huto.forcesofreality.network.PacketHandler;
import com.huto.forcesofreality.network.coven.CovenantPacketServer;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.PacketDistributor;

public class ItemAllegianceIdentifier extends Item {

	public ItemAllegianceIdentifier(Properties prop) {
		super(prop);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

		if (!worldIn.isRemote) {
			ICovenant coven = playerIn.getCapability(CovenantProvider.COVEN_CAPA)
					.orElseThrow(IllegalStateException::new);
			
			
			PacketHandler.CHANNELCOVENANT.send(
					PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) playerIn),
					new CovenantPacketServer(coven.getDevotion()));
			
			playerIn.sendStatusMessage(new StringTextComponent(coven.getDevotion().toString()), true);
		}

		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

}
