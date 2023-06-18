package com.vincenthuto.forcesofreality.common.item.armor;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ItemSlimeRepulsionCharm extends Item {

	public static String TAG_STATE = "state";

	public static void repel(Level world, AABB effectBounds, double x, double y, double z) {
		List<Entity> list = world.getEntitiesOfClass(Entity.class, effectBounds);
		for (Entity ent : list) {
			if (ent instanceof Slime) {

				Vec3 p = new Vec3(x, y, z);
				Vec3 t = new Vec3(ent.getX(), ent.getY(), ent.getZ());
				double distance = p.distanceTo(t) + 0.1D;
				Vec3 r = new Vec3(t.x - p.x, t.y - p.y, t.z - p.z);

				ent.setDeltaMovement(r.x / 1.2D / distance, r.y / 1.2D / distance, r.z / 1.2D / distance);

				for (int countparticles = 0; countparticles <= 10; ++countparticles) {
					world.addParticle(DustParticleOptions.REDSTONE,
							ent.getX() + (world.random.nextDouble() - 0.5D) * ent.getBbWidth(),
							ent.getY() + world.random.nextDouble() * ent.getBbHeight() - ent.getMyRidingOffset() - 0.5,
							ent.getZ() + (world.random.nextDouble() - 0.5D) * ent.getBbWidth(), 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}

	public boolean state;

	public ItemSlimeRepulsionCharm(Properties prop) {
		super(prop);
		prop.stacksTo(1);

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

		if (!stack.hasTag()) {
			stack.setTag(new CompoundTag());
			CompoundTag compound = stack.getTag();
			compound.putBoolean(TAG_STATE, false);
		}
		if (stack.getTag().getBoolean(TAG_STATE)) {

			repel(worldIn, new AABB(entityIn.position().add(-4, -4, -4), entityIn.position().add(4, 4, 4)),
					entityIn.position().x() + 0.5, entityIn.position().y() + 0.5, entityIn.position().z() + 0.5);
		}

	}

	public void setState(boolean stateIn) {
		state = stateIn;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
		ItemStack stack = playerIn.getMainHandItem();
		CompoundTag compound = stack.getOrCreateTag();

		if (!compound.getBoolean(TAG_STATE)) {
			playerIn.playSound(SoundEvents.BEACON_ACTIVATE, 0.40f, 1F);
			compound.putBoolean(TAG_STATE, !compound.getBoolean(TAG_STATE));
		} else {
			playerIn.playSound(SoundEvents.BEACON_DEACTIVATE, 0.40f, 1F);
			compound.putBoolean(TAG_STATE, !compound.getBoolean(TAG_STATE));
		}

		stack.setTag(compound);
		return super.use(worldIn, playerIn, handIn);
	}
}
