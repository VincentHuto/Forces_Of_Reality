package com.huto.hutosmod.objects.items;

import com.huto.hutosmod.capabilities.covenant.CovenantProvider;
import com.huto.hutosmod.capabilities.covenant.EnumCovenants;
import com.huto.hutosmod.capabilities.covenant.ICovenant;
import com.huto.hutosmod.capabilities.mindrunes.IRune;
import com.huto.hutosmod.capabilities.mindrunes.RuneType;
import com.huto.hutosmod.objects.items.runes.ItemContractRune;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemYellowSign extends ItemContractRune implements IRune{

	public ItemYellowSign(Properties properties) {
		super(properties);
		properties.rarity(Rarity.UNCOMMON);
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
				ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
						.orElseThrow(IllegalArgumentException::new);
				if (coven != null) {
					System.out.println(coven.getCovenant());

					if (!(coven.getCovenant() == EnumCovenants.HASTUR)) {
						coven.setCovenant(EnumCovenants.HASTUR);
						PlayerEntity playerEnt = (PlayerEntity) player;
						playerEnt.sendStatusMessage(
								new StringTextComponent(TextFormatting.YELLOW + "Lord Hastur Accepts your Fealty"),
								false);

					}
				}
			}
		}

	}

	@Override
	public void onUnequipped(LivingEntity player) {
		super.onUnequipped(player);
		player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, .75F, 1.9f);
		if (player instanceof PlayerEntity) {
			if (!player.getEntityWorld().isRemote) {
				ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
						.orElseThrow(IllegalArgumentException::new);
				if (coven != null) {
					System.out.println(coven.getCovenant());

					coven.setCovenant(EnumCovenants.NONE);
					PlayerEntity playerEnt = (PlayerEntity) player;
					playerEnt.sendStatusMessage(
							new StringTextComponent(TextFormatting.YELLOW + "Lord Hastur Renounces your Fealty"),
							false);
				}
			}
		}

	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
}
