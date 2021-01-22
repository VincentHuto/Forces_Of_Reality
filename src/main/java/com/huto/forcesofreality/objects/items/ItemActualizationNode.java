package com.huto.forcesofreality.objects.items;

import com.huto.forcesofreality.capabilities.karma.IKarma;
import com.huto.forcesofreality.capabilities.karma.KarmaProvider;
import com.huto.forcesofreality.capabilities.karma.activation.IKarmaActivation;
import com.huto.forcesofreality.capabilities.karma.activation.KarmaActivationProvider;
import com.huto.forcesofreality.network.PacketHandler;
import com.huto.forcesofreality.network.coven.SyncKarmaPacket;
import com.huto.forcesofreality.network.karma.KarmaPacketServer;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.PacketDistributor;

public class ItemActualizationNode extends Item {

	public ItemActualizationNode(Properties prop) {
		super(prop);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

		IKarma karma = playerIn.getCapability(KarmaProvider.KARMA_CAPA).orElseThrow(IllegalStateException::new);
		IKarmaActivation karmaAct = playerIn.getCapability(KarmaActivationProvider.KARMA_CAPA)
				.orElseThrow(IllegalStateException::new);
		if (!karmaAct.getEnabled()) {
			playerIn.sendStatusMessage(new StringTextComponent("Activating Karma!"), false);
			karmaAct.setKarmaActivation(1);
			if (!worldIn.isRemote) {
				// Sync Packet with server
				PacketHandler.CHANNELKARMA.send(
						PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> (ServerPlayerEntity) playerIn),
						new SyncKarmaPacket(karmaAct.getEnabled(), playerIn.getEntityId()));
				PacketHandler.CHANNELKARMA.send(
						PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> (ServerPlayerEntity) playerIn),
						new KarmaPacketServer(karma.getKarma()));
			}
			playerIn.getHeldItemMainhand().shrink(1);
			return super.onItemRightClick(worldIn, playerIn, handIn);

		} else {
			playerIn.sendStatusMessage(new StringTextComponent("Deactivating Karma!"), false);
			karmaAct.setKarmaActivation(0);
			// Sync Packet with server
			if (!worldIn.isRemote) {
				PacketHandler.CHANNELKARMA.send(
						PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> (ServerPlayerEntity) playerIn),
						new SyncKarmaPacket(karmaAct.getEnabled(), playerIn.getEntityId()));
				PacketHandler.CHANNELKARMA.send(
						PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> (ServerPlayerEntity) playerIn),
						new KarmaPacketServer(karma.getKarma()));
				playerIn.getHeldItemMainhand().shrink(1);
			}
			return super.onItemRightClick(worldIn, playerIn, handIn);

		}
	}

}
