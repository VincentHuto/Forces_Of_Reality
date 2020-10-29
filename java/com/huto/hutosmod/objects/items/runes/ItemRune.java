package com.huto.hutosmod.objects.items.runes;

import java.util.List;

import com.huto.hutosmod.capabilities.covenant.CovenantProvider;
import com.huto.hutosmod.capabilities.covenant.EnumCovenants;
import com.huto.hutosmod.capabilities.covenant.ICovenant;
import com.huto.hutosmod.capabilities.mindrunes.IRune;
import com.huto.hutosmod.capabilities.mindrunes.RuneType;
import com.huto.hutosmod.network.CovenantPacketServer;
import com.huto.hutosmod.network.PacketHandler;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.PacketDistributor;

public class ItemRune extends Item implements IRune {
	/*
	 * public int level = 1; public String TAG_LEVEL = "level";
	 */

	EnumCovenants assignedCovenant;
	int deepenAmount;

	public ItemRune(Properties properties, EnumCovenants covenIn, int deepenAmountIn) {
		super(properties);
		this.assignedCovenant = covenIn;
		this.deepenAmount = deepenAmountIn;
	}

	@Override
	public void onEquipped(LivingEntity player) {
		if (player instanceof PlayerEntity) {
			if (!player.getEntityWorld().isRemote) {
				ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
						.orElseThrow(IllegalArgumentException::new);
				if (coven != null) {
					coven.setCovenDevotion(getAssignedCovenant(), getDeepenAmount());
					PlayerEntity playerEnt = (PlayerEntity) player;
					PacketHandler.CHANNELCOVENANT.send(
							PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) playerEnt),
							new CovenantPacketServer(coven.getDevotion()));

				}
			}
		}
	}

	@Override
	public void onUnequipped(LivingEntity player) {
		if (player instanceof PlayerEntity) {
			if (!player.getEntityWorld().isRemote) {
				ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
						.orElseThrow(IllegalArgumentException::new);
				if (coven != null) {
					coven.setCovenDevotion(getAssignedCovenant(), getDeepenAmount());
					PlayerEntity playerEnt = (PlayerEntity) player;
					PacketHandler.CHANNELCOVENANT.send(
							PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) playerEnt),
							new CovenantPacketServer(coven.getDevotion()));

				}
			}
		}

	}

	public int getDeepenAmount() {
		return deepenAmount;
	}

	public void setDeepenAmount(int deepenAmount) {
		this.deepenAmount = deepenAmount;
	}

	public EnumCovenants getAssignedCovenant() {
		return assignedCovenant;
	}

	public void setAssignedCovenant(EnumCovenants assignedCovenant) {
		this.assignedCovenant = assignedCovenant;
	}

	/*
	 * public int getLevel() { return level; }
	 * 
	 * public void setLevel(int level) { this.level = level; }
	 */
	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
		/*
		 * if (!stack.hasTag()) { stack.setTag(new CompoundNBT()); CompoundNBT compound
		 * = stack.getTag(); compound.putInt(TAG_LEVEL, level); }
		 */
	}
	/*
	 * @Override public ActionResult<ItemStack> onItemRightClick(World worldIn,
	 * PlayerEntity playerIn, Hand handIn) { ItemStack stack =
	 * playerIn.getHeldItemMainhand(); if (!stack.hasTag()) { stack.setTag(new
	 * CompoundNBT()); CompoundNBT compound = stack.getTag();
	 * compound.putInt(TAG_LEVEL, level); } CompoundNBT compound = stack.getTag();
	 * compound.putInt(TAG_LEVEL, this.getLevel());
	 * 
	 * playerIn.playSound(SoundEvents.BLOCK_BEACON_ACTIVATE, 0.40f, 1F);
	 * compound.putInt(TAG_LEVEL, level++); stack.setTag(compound); return
	 * super.onItemRightClick(worldIn, playerIn, handIn); }
	 */

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		/*
		 * if (stack.hasTag()) { tooltip.add(new TranslationTextComponent("Form: " +
		 * stack.getTag().getInt(TAG_LEVEL)) .mergeStyle(TextFormatting.BLUE)); }
		 */
	}

	@Override
	public RuneType getRuneType() {
		return RuneType.RUNE;
	}

}
