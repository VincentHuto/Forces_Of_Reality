package com.huto.hutosmod.objects.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class ItemRepulsionCharm extends Item {

	public static boolean state;
	public static String TAG_STATE = "state";

	public ItemRepulsionCharm(Properties prop) {
		super(prop);
		prop.maxStackSize(1);

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
		if (stack.getTag().getBoolean(TAG_STATE)) {

			repel(worldIn,
					new AxisAlignedBB(entityIn.getPositionVec().add(-4, -4, -4),
							entityIn.getPositionVec().add(4, 4, 4)),
					entityIn.getPositionVec().getX() + 0.5, entityIn.getPositionVec().getY() + 0.5,
					entityIn.getPositionVec().getZ() + 0.5);
		}

	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack stack =playerIn.getHeldItemMainhand();
		if (!stack.hasTag()) {
			stack.setTag(new CompoundNBT());
			CompoundNBT compound = stack.getTag();
			compound.putBoolean(TAG_STATE, false);
		}
		CompoundNBT compound = stack.getTag();
		if (!compound.getBoolean(TAG_STATE)) {
			compound.putBoolean(TAG_STATE, !compound.getBoolean(TAG_STATE));
		} else {
			compound.putBoolean(TAG_STATE, !compound.getBoolean(TAG_STATE));
		}
		stack.setTag(compound);		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	
/*	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		ItemStack stack = context.getPlayer().getHeldItemMainhand();
		if (!stack.hasTag()) {
			stack.setTag(new CompoundNBT());
			CompoundNBT compound = stack.getTag();
			compound.putBoolean(TAG_STATE, false);
		}
		CompoundNBT compound = stack.getTag();
		if (!compound.getBoolean(TAG_STATE)) {
			compound.putBoolean(TAG_STATE, !compound.getBoolean(TAG_STATE));
		} else {
			compound.putBoolean(TAG_STATE, !compound.getBoolean(TAG_STATE));
		}
		stack.setTag(compound);
		return super.onItemUse(context);
	}*/

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

	public static void repel(World world, AxisAlignedBB effectBounds, double x, double y, double z) {
		List<Entity> list = world.getEntitiesWithinAABB(Entity.class, effectBounds);
		for (Entity ent : list) {
			if ((ent instanceof MobEntity || ent instanceof SlimeEntity || ent instanceof FireballEntity
					|| ent instanceof ProjectileEntity)) {

				Vector3d p = new Vector3d(x, y, z);
				Vector3d t = new Vector3d(ent.getPosX(), ent.getPosY(), ent.getPosZ());
				double distance = p.distanceTo(t) + 0.1D;
				Vector3d r = new Vector3d(t.x - p.x, t.y - p.y, t.z - p.z);

				ent.setMotion(r.x / 1.2D / distance, r.y / 1.2D / distance, r.z / 1.2D / distance);

				if (world.isRemote) {
					for (int countparticles = 0; countparticles <= 10; ++countparticles) {
						ent.world.addParticle(RedstoneParticleData.REDSTONE_DUST,
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
