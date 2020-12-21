package com.huto.forces_of_reality.objects.items;

import javax.annotation.Nonnull;

import com.huto.forces_of_reality.capabilities.vibes.IVibrations;
import com.huto.forces_of_reality.capabilities.vibes.VibrationProvider;
import com.huto.forces_of_reality.init.ItemInit;
import com.huto.forces_of_reality.network.PacketHandler;
import com.huto.forces_of_reality.network.vibes.VibrationPacketServer;
import com.huto.forces_of_reality.sounds.SoundHandler;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.PacketDistributor;

public class ItemChannelingIngot extends Item {

	public ItemChannelingIngot(Properties properties) {
		super(properties);
	}

	@Nonnull
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, @Nonnull Hand handIn) {
		playerIn.setActiveHand(handIn);
		return super.onItemRightClick(worldIn, playerIn, handIn);

	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
		if (entityLiving instanceof PlayerEntity) {
			PlayerEntity playerentity = (PlayerEntity) entityLiving;
			IVibrations vibes = playerentity.getCapability(VibrationProvider.VIBE_CAPA)
					.orElseThrow(IllegalStateException::new);
			int i = this.getUseDuration(stack) - timeLeft;
			if (i > 21 && vibes.getVibes() > 10) {
				if (!worldIn.isRemote) {
					vibes.subtractVibes(10);
					playerentity.sendStatusMessage(new StringTextComponent(
							"Reduced Resonance to: " + TextFormatting.BLUE + vibes.getVibes() + "Hz"), false);
					// Sync Packet with server
					PacketHandler.CHANNELVIBES.send(
							PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) playerentity),
							new VibrationPacketServer(vibes.getVibes()));
					ItemStack output = new ItemStack(ItemInit.emanating_ingot.get(), 1);
					ItemEntity outputItem = new ItemEntity(worldIn, entityLiving.getPosX() + 0.5,
							entityLiving.getPosY() + 1.5, entityLiving.getPosZ() + 0.5, output);
					worldIn.addEntity(outputItem);
					stack.shrink(1);

				} else {
					worldIn.playSound(playerentity, playerentity.getPosition(), SoundHandler.ITEM_STAR_SLUG_STORM,
							SoundCategory.PLAYERS, 1, 1);
				}
			}
		}
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 72000;
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.CROSSBOW;
	}

}
