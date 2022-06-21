package com.vincenthuto.forcesofreality.item.coven.tool;

import java.util.List;
import java.util.Random;

import com.vincenthuto.forcesofreality.init.SoundInit;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.EntityTeleportEvent;

public class ItemDestabilizationCharm extends Item {

	public static boolean state;
	public static String TAG_STATE = "state";

	Random rand = new Random();

	public ItemDestabilizationCharm(Properties prop) {
		super(prop);

	}

	@Override
	public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
		if (stack.hasTag()) {
			if (stack.getTag().getBoolean(TAG_STATE)) {
				tooltip.add(Component.translatable("State: On").withStyle(ChatFormatting.BLUE));
			} else {
				tooltip.add(Component.translatable("State: Off").withStyle(ChatFormatting.RED));
			}
		}
	}

	public boolean getState() {
		return state;
	}

	@Override
	public void inventoryTick(ItemStack stack, Level worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
		if (stack.getOrCreateTag().getBoolean(TAG_STATE)) {
		}
		/*
		 * if (entityIn instanceof PlayerEntity) { PlayerEntity player = (PlayerEntity)
		 * entityIn; if (player.world.rand.nextInt(20) == 0) { teleportRandomly(worldIn,
		 * player); } }
		 */

	}

	/*
	 * @Override public ActionResultType onItemUse(ItemUseContext context) {
	 * ItemStack stack = context.getPlayer().getHeldItemMainhand(); if
	 * (!stack.hasTag()) { stack.setTag(new CompoundTag()); CompoundTag compound =
	 * stack.getTag(); compound.putBoolean(TAG_STATE, false); } CompoundTag compound
	 * = stack.getTag(); if (!compound.getBoolean(TAG_STATE)) {
	 * compound.putBoolean(TAG_STATE, !compound.getBoolean(TAG_STATE)); } else {
	 * compound.putBoolean(TAG_STATE, !compound.getBoolean(TAG_STATE)); }
	 * stack.setTag(compound); return super.onItemUse(context); }
	 */

	public void setState(boolean stateIn) {
		state = stateIn;
	}

	/**
	 * Teleport to a random nearby position
	 */
	public boolean teleportRandomly(Level world, Player player) {
		if (!world.isClientSide()) {
			double d0 = player.getX() + (this.rand.nextDouble() - 0.5D) * 16.0D;
			double d1 = player.getY() + (this.rand.nextInt(64) - 32);
			double d2 = player.getZ() + (this.rand.nextDouble() - 0.5D) * 16.0D;
			return this.teleportTo(world, player, d0, d1, d2);
		} else {
			return false;
		}
	}

	/**
	 * Teleport the boss
	 */
	public boolean teleportTo(Level world, Player player, double x, double y, double z) {
		BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos(x, y, z);
		while (blockpos$mutable.getY() > 0 && !world.getBlockState(blockpos$mutable).getMaterial().blocksMotion()) {
			blockpos$mutable.move(Direction.DOWN);
		}
		BlockState blockstate = world.getBlockState(blockpos$mutable);
		boolean flag = blockstate.getMaterial().blocksMotion();
		boolean flag1 = blockstate.getFluidState().is(FluidTags.WATER);
		if (flag && !flag1) {
			EntityTeleportEvent event = new EntityTeleportEvent(player, x, y, z);
			if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event))
				return false;
			boolean flag2 = player.randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
			if (flag2) {
				world.playSound((Player) null, player.xo, player.yo, player.zo, SoundInit.ENTITY_DARK_YOUNG_TELEPORT.get(),
						player.getSoundSource(), 0.5f, 0.5f);
				player.playSound(SoundInit.ENTITY_DARK_YOUNG_TELEPORT.get(), 0.5f, 0.5f);
			}
			return flag2;
		} else {
			return false;
		}
	}

	/**
	 * Teleport to another entity
	 */
	public boolean teleportToEntity(Level world, Entity target, Player player) {
		Vec3 vector3d = new Vec3(player.getX() - target.getX(), player.getY(0.5D) - target.getEyeY(),
				player.getZ() - target.getZ());
		vector3d = vector3d.normalize();
		double d1 = player.getX() + (this.rand.nextDouble() - 0.5D) * 8.0D - vector3d.x * 8.0D;
		double d2 = player.getY() + (this.rand.nextInt(16) - 8) - vector3d.y * 8.0D;
		double d3 = player.getZ() + (this.rand.nextDouble() - 0.5D) * 8.0D - vector3d.z * 8.0D;
		return this.teleportTo(world, player, d1, d2, d3);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
		ItemStack stack = playerIn.getMainHandItem();
		CompoundTag compound = stack.getOrCreateTag();

		if (!compound.getBoolean(TAG_STATE)) {
			playerIn.playSound(SoundEvents.BEACON_ACTIVATE, 0.40f, 1F);
			compound.putBoolean(TAG_STATE, !compound.getBoolean(TAG_STATE));

			teleportRandomly(worldIn, playerIn);
			compound.putBoolean(TAG_STATE, !compound.getBoolean(TAG_STATE));

		} else {
			playerIn.playSound(SoundEvents.BEACON_DEACTIVATE, 0.40f, 1F);
			compound.putBoolean(TAG_STATE, !compound.getBoolean(TAG_STATE));
		}
		stack.setTag(compound);
		return super.use(worldIn, playerIn, handIn);
	}
}
