package com.huto.forcesofreality.objects.items.coven.tool;

import java.util.List;
import java.util.Random;

import com.huto.forcesofreality.sounds.SoundHandler;

import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class ItemDestabilizationCharm extends Item {

	public static boolean state;
	public static String TAG_STATE = "state";

	public ItemDestabilizationCharm(Properties prop) {
		super(prop);

	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean stateIn) {
		state = stateIn;
	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
		if (stack.getOrCreateTag().getBoolean(TAG_STATE)) {
		}
		/*
		 * if (entityIn instanceof PlayerEntity) { PlayerEntity player = (PlayerEntity)
		 * entityIn; if (player.world.rand.nextInt(20) == 0) { teleportRandomly(worldIn,
		 * player); } }
		 */

	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack stack = playerIn.getHeldItemMainhand();
		CompoundNBT compound = stack.getOrCreateTag();

		if (!compound.getBoolean(TAG_STATE)) {
			playerIn.playSound(SoundEvents.BLOCK_BEACON_ACTIVATE, 0.40f, 1F);
			compound.putBoolean(TAG_STATE, !compound.getBoolean(TAG_STATE));

			teleportRandomly(worldIn, playerIn);
			compound.putBoolean(TAG_STATE, !compound.getBoolean(TAG_STATE));

		} else {
			playerIn.playSound(SoundEvents.BLOCK_BEACON_DEACTIVATE, 0.40f, 1F);
			compound.putBoolean(TAG_STATE, !compound.getBoolean(TAG_STATE));
		}
		stack.setTag(compound);
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

	/*
	 * @Override public ActionResultType onItemUse(ItemUseContext context) {
	 * ItemStack stack = context.getPlayer().getHeldItemMainhand(); if
	 * (!stack.hasTag()) { stack.setTag(new CompoundNBT()); CompoundNBT compound =
	 * stack.getTag(); compound.putBoolean(TAG_STATE, false); } CompoundNBT compound
	 * = stack.getTag(); if (!compound.getBoolean(TAG_STATE)) {
	 * compound.putBoolean(TAG_STATE, !compound.getBoolean(TAG_STATE)); } else {
	 * compound.putBoolean(TAG_STATE, !compound.getBoolean(TAG_STATE)); }
	 * stack.setTag(compound); return super.onItemUse(context); }
	 */

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		if (stack.hasTag()) {
			if (stack.getTag().getBoolean(TAG_STATE)) {
				tooltip.add(new TranslationTextComponent("State: On").mergeStyle(TextFormatting.BLUE));
			} else {
				tooltip.add(new TranslationTextComponent("State: Off").mergeStyle(TextFormatting.RED));
			}
		}
	}

	Random rand = new Random();

	/**
	 * Teleport to a random nearby position
	 */
	public boolean teleportRandomly(World world, PlayerEntity player) {
		if (!world.isRemote()) {
			double d0 = player.getPosX() + (this.rand.nextDouble() - 0.5D) * 16.0D;
			double d1 = player.getPosY() + (double) (this.rand.nextInt(64) - 32);
			double d2 = player.getPosZ() + (this.rand.nextDouble() - 0.5D) * 16.0D;
			return this.teleportTo(world, player, d0, d1, d2);
		} else {
			return false;
		}
	}

	/**
	 * Teleport to another entity
	 */
	public boolean teleportToEntity(World world, Entity target, PlayerEntity player) {
		Vector3d vector3d = new Vector3d(player.getPosX() - target.getPosX(),
				player.getPosYHeight(0.5D) - target.getPosYEye(), player.getPosZ() - target.getPosZ());
		vector3d = vector3d.normalize();
		double d1 = player.getPosX() + (this.rand.nextDouble() - 0.5D) * 8.0D - vector3d.x * 8.0D;
		double d2 = player.getPosY() + (double) (this.rand.nextInt(16) - 8) - vector3d.y * 8.0D;
		double d3 = player.getPosZ() + (this.rand.nextDouble() - 0.5D) * 8.0D - vector3d.z * 8.0D;
		return this.teleportTo(world, player, d1, d2, d3);
	}

	/**
	 * Teleport the boss
	 */
	public boolean teleportTo(World world, PlayerEntity player, double x, double y, double z) {
		BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable(x, y, z);
		while (blockpos$mutable.getY() > 0 && !world.getBlockState(blockpos$mutable).getMaterial().blocksMovement()) {
			blockpos$mutable.move(Direction.DOWN);
		}
		BlockState blockstate = world.getBlockState(blockpos$mutable);
		boolean flag = blockstate.getMaterial().blocksMovement();
		boolean flag1 = blockstate.getFluidState().isTagged(FluidTags.WATER);
		if (flag && !flag1) {
			EnderTeleportEvent event = new EnderTeleportEvent(player, x, y, z, 0);
			if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event))
				return false;
			boolean flag2 = player.attemptTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
			if (flag2) {
				world.playSound((PlayerEntity) null, player.prevPosX, player.prevPosY, player.prevPosZ,
						SoundHandler.ENTITY_DARK_YOUNG_TELEPORT, player.getSoundCategory(), 0.5f, 0.5f);
				player.playSound(SoundHandler.ENTITY_DARK_YOUNG_TELEPORT, 0.5f, 0.5f);
			}
			return flag2;
		} else {
			return false;
		}
	}
}
