package com.huto.hutosmod.objects.items.runes;

import java.util.List;

import com.huto.hutosmod.capabilities.mindrunes.IRune;
import com.huto.hutosmod.capabilities.mindrunes.RuneType;
import com.huto.hutosmod.network.PacketHandler;
import com.huto.hutosmod.network.SetFlyPKT;
import com.huto.hutosmod.objects.items.ItemContractRune;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemMilkweedRune extends ItemContractRune implements IRune {

	public ItemMilkweedRune(Properties properties) {
		super(properties);
	}

	@Override
	public boolean willAutoSync(LivingEntity player) {
		return true;
	}

	@Override
	public void onWornTick(LivingEntity player) {
	}

	@Override
	public RuneType getBaubleType() {
		return RuneType.CONTRACT;
	}

	@Override
	public void onEquipped(LivingEntity player) {
		super.onEquipped(player);
		player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, .75F, 1.9f);
		if (player instanceof PlayerEntity) {
			if (!player.getEntityWorld().isRemote) {
				updateClientServerFlight((ServerPlayerEntity) player, true);
			}
		}
	}

	@Override
	public void onUnequipped(LivingEntity player) {
		super.onUnequipped(player);
		player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, .75F, 1.9f);
		if (player instanceof PlayerEntity) {
			if (!((PlayerEntity) player).isCreative()) {
				if (!player.getEntityWorld().isRemote) {
					updateClientServerFlight((ServerPlayerEntity) player, false, false);
				}
			}
		}
	}

	public static void updateClientServerFlight(ServerPlayerEntity player, boolean allowFlying) {
		updateClientServerFlight(player, allowFlying, allowFlying && player.abilities.isFlying);
	}

	public static void updateClientServerFlight(ServerPlayerEntity player, boolean allowFlying, boolean isFlying) {
		PacketHandler.HANDLER.sendToServer(new SetFlyPKT(allowFlying, isFlying));
		player.abilities.allowFlying = allowFlying;
		player.abilities.isFlying = isFlying;
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add(new StringTextComponent(TextFormatting.AQUA + "Effect:Flight"));

	}
}
