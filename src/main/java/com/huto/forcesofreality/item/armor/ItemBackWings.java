package com.huto.forcesofreality.item.armor;

import com.huto.forcesofreality.model.armor.ModelBackWings;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemBackWings extends ArmorItem {

	public ItemBackWings(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
		super(materialIn, slot, builderIn);
	}

	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		super.onArmorTick(stack, world, player);
		player.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 2, 222, false, false,false,null));

	}

	@SuppressWarnings("unchecked")
	@Override
	@OnlyIn(Dist.CLIENT)
	public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack,
			EquipmentSlotType armorSlot, A _default) {
		float wingRotation = 0;
		float destPos;
		float oFlapSpeed;
		float oFlap;
		float wingRotDelta;
		if (!entityLiving.isOnGround()) {
			wingRotDelta = 1.0F;
			destPos = (float) Math.max(0.3f, (float) -Math.sin(entityLiving.ticksExisted * 0.1f)
					* -(1 * Math.cos(entityLiving.ticksExisted * 0.1f)) * 4f);
			oFlap = wingRotation;
			oFlapSpeed = destPos;
			destPos = MathHelper.clamp(destPos, 0.0F, 1.0F);
			if (!entityLiving.isOnGround()) {
				wingRotDelta = 7.0F;
			} else {
				wingRotDelta = 1.0F;
			}
			wingRotDelta = (float) ((double) wingRotDelta * 1.9D);
			wingRotation += wingRotDelta * 0.1F;
			if (wingRotation > 1000) {
				wingRotation = 0;
			}

			if (itemStack != ItemStack.EMPTY) {
				if (itemStack.getItem() instanceof ArmorItem) {
					ModelBackWings model = new ModelBackWings();
					model.bipedBody.showModel = armorSlot == EquipmentSlotType.CHEST;
					model.isChild = _default.isChild;
					model.isSneak = _default.isSneak;
					model.isSitting = _default.isSitting;
					model.rightArmPose = _default.rightArmPose;
					model.leftArmPose = _default.leftArmPose;
					float f = MathHelper.lerp(0, oFlap, wingRotation);
					float f1 = MathHelper.lerp(0, oFlapSpeed, destPos);
					float f3 = (MathHelper.sin(f) + 1.6F) * f1;

					model.RightWing.rotateAngleZ = f3;
					model.LeftWing.rotateAngleZ = -f3;

					model.RightWing2.rotateAngleZ = f3 * 0.5f;
					model.LeftWing2.rotateAngleZ = -f3 * 0.5f;

					model.RightWing3.rotateAngleZ = f3 * 0.2f;
					model.LeftWing3.rotateAngleZ = -f3 * 0.2f;
					return (A) model;
				}
			}
		} else {
			wingRotDelta = 1.0F;

			destPos = Math.max(0.3f, (float) -Math.sin(0 * 0.4f) * 3.1f);
			oFlap = wingRotation;
			oFlapSpeed = destPos;
			if (itemStack != ItemStack.EMPTY) {
				if (itemStack.getItem() instanceof ArmorItem) {
					ModelBackWings model = new ModelBackWings();
					model.bipedBody.showModel = armorSlot == EquipmentSlotType.CHEST;
					model.isChild = _default.isChild;
					model.isSneak = _default.isSneak;
					model.isSitting = _default.isSitting;
					model.rightArmPose = _default.rightArmPose;
					model.leftArmPose = _default.leftArmPose;
					float f = MathHelper.lerp(0, oFlap, wingRotation);
					float f1 = MathHelper.lerp(0, oFlapSpeed, destPos);
					float f3 = (MathHelper.sin(f) + 1.6F) * f1;

					model.RightWing.rotateAngleZ = f3;
					model.LeftWing.rotateAngleZ = -f3;

					model.RightWing2.rotateAngleZ = f3 * 0.5f;
					model.LeftWing2.rotateAngleZ = -f3 * 0.5f;

					model.RightWing3.rotateAngleZ = f3 * 0.2f;
					model.LeftWing3.rotateAngleZ = -f3 * 0.2f;
					return (A) model;
				}
			}
		}
		return null;
	}
}
