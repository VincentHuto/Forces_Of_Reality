package com.huto.hutosmod.objects.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class ItemAttractionCharm extends Item {

	public static boolean state;
	public static String TAG_STATE = "state";

	public ItemAttractionCharm(Properties prop) {
		super(prop);
		prop.maxStackSize(1);

	}

	public static float getPropertyOff(ItemStack stack, @Nullable LivingEntity entityIn) {
		if (entityIn == null)
			return 0.f;
		if (!stack.isEmpty() && stack.getItem() instanceof ItemAttractionCharm)
			return !ItemAttractionCharm.isActivated(stack) ? 0.f : 1.f; // 0 - not empty
		return 0.f;
	}

	public static boolean isActivated(ItemStack stack) {
		if (stack.hasTag()) {
			CompoundNBT nbt = stack.getTag();
			return nbt.hasUniqueId(TAG_STATE) && nbt.getBoolean(TAG_STATE);
		}
		return false;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		ItemAttractionCharm.state = state;
	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
		if (!stack.hasTag()) {
			stack.setTag(new CompoundNBT());
			CompoundNBT compound = stack.getTag();
			compound.putBoolean(TAG_STATE, false);
		}

		attractItems(worldIn,
				new AxisAlignedBB(entityIn.getPositionVec().add(-4, -4, -4), entityIn.getPositionVec().add(4, 4, 4)),
				entityIn.getPositionVec().getX() + 0.5, entityIn.getPositionVec().getY() + 0.5,
				entityIn.getPositionVec().getZ() + 0.5);

	}

	/*
	 * @Override public ActionResultType onItemUse(ItemUseContext context) {
	 * ItemStack stack = context.getPlayer().getHeldItemMainhand(); if
	 * (!stack.hasTag()) { stack.setTag(new CompoundNBT()); CompoundNBT compound =
	 * stack.getTag(); compound.putBoolean(TAG_STATE, false); } CompoundNBT compound
	 * = stack.getTag();
	 * 
	 * if (compound.hasUniqueId(TAG_STATE)) { boolean lev =
	 * compound.getBoolean(TAG_STATE); compound.putBoolean(TAG_STATE, !lev); }
	 * stack.setTag(compound); return super.onItemUse(context); }
	 */

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		if (stack.hasTag() && stack.getTag().hasUniqueId(TAG_STATE)) {
			if (stack.getTag().getBoolean(TAG_STATE)) {
				tooltip.add(new TranslationTextComponent("State: On").mergeStyle(TextFormatting.BLUE));
			} else {
				tooltip.add(new TranslationTextComponent("State: Off").mergeStyle(TextFormatting.RED));
			}

		}
	}

	public static void attractItems(World world, AxisAlignedBB effectBounds, double x, double y, double z) {
		List<Entity> list = world.getEntitiesWithinAABB(Entity.class, effectBounds);
		for (Entity ent : list) {
			if ((ent instanceof ItemEntity)) {

				Vector3d p = new Vector3d(x, y, z);
				Vector3d t = new Vector3d(ent.getPosX(), ent.getPosY(), ent.getPosZ());
				double distance = p.distanceTo(t) + 0.1D;
				Vector3d r = new Vector3d(t.x - p.x, t.y - p.y, t.z - p.z);

				ent.setMotion(-r.x / 10.2D / distance * 1.3, -r.y / 10.2D / distance, -r.z / 10.2D / distance * 1.3);
				if (world.isRemote) {
					for (int countparticles = 0; countparticles <= 1; ++countparticles) {
						ent.world.addParticle(ParticleTypes.PORTAL,
								ent.getPosX() + (world.rand.nextDouble() - 0.5D) * (double) ent.getWidth(),
								ent.getPosY() + world.rand.nextDouble() * (double) ent.getHeight()
										- (double) ent.getYOffset() - 0.5,
								ent.getPosZ() + (world.rand.nextDouble() - 0.5D) * (double) ent.getWidth(), 0.0D, 0.0D,
								0.0D);
					}
				}

			}
		}
	}
}
