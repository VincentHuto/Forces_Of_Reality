package com.huto.hutosmod.objects.items;

import com.huto.hutosmod.capabilities.karma.IKarma;
import com.huto.hutosmod.capabilities.karma.KarmaProvider;
import com.huto.hutosmod.capabilities.karma.activation.IKarmaActivation;
import com.huto.hutosmod.capabilities.karma.activation.KarmaActivationProvider;
import com.huto.hutosmod.network.KarmaActivationPacketServer;
import com.huto.hutosmod.network.KarmaPacketServer;
import com.huto.hutosmod.network.PacketHandler;

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
		if (!worldIn.isRemote) {
			IKarma karma = playerIn.getCapability(KarmaProvider.KARMA_CAPA).orElseThrow(IllegalStateException::new);
			IKarmaActivation karmaAct = playerIn.getCapability(KarmaActivationProvider.KARMA_CAPA)
					.orElseThrow(IllegalStateException::new);
			if (karmaAct.getActivation() == 0) {
				//karma.setKarma(0);
				playerIn.sendStatusMessage(new StringTextComponent("Activating Karma!"), false);
				karmaAct.setKarmaActivation(1);
				// Sync Packet with server
				PacketHandler.CHANNELKARMA.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) playerIn),
						new KarmaActivationPacketServer(karmaAct.getActivation()));
				PacketHandler.CHANNELKARMA.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) playerIn),
						new KarmaPacketServer(karma.getKarma()));
				playerIn.getHeldItemMainhand().shrink(1);
				return super.onItemRightClick(worldIn, playerIn, handIn);

			}
			if (karmaAct.getActivation() == 1) {
				//karma.setKarma(0);
				playerIn.sendStatusMessage(new StringTextComponent("Deactivating Karma!"), false);
				karmaAct.setKarmaActivation(0);
				// Sync Packet with server
				PacketHandler.CHANNELKARMA.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) playerIn),
						new KarmaActivationPacketServer(karmaAct.getActivation()));
				PacketHandler.CHANNELKARMA.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) playerIn),
						new KarmaPacketServer(karma.getKarma()));
				playerIn.getHeldItemMainhand().shrink(1);
				return super.onItemRightClick(worldIn, playerIn, handIn);
			}
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

}
