package com.vincenthuto.forcesofreality.item.armor;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

public class ItemBackWings extends ArmorItem {

	public ItemBackWings(ArmorMaterial materialIn, ArmorItem.Type slot, Properties builderIn) {
		super(materialIn, slot, builderIn);
	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	@OnlyIn(Dist.CLIENT)
//	public <A extends HumanoidModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack,
//			ArmorItem.Type armorSlot, A _default) {
//		float wingRotation = 0;
//		float destPos;
//		float oFlapSpeed;
//		float oFlap;
//		float wingRotDelta;
//		if (!entityLiving.isOnGround()) {
//			wingRotDelta = 1.0F;
//			destPos = (float) Math.max(0.3f, (float) -Math.sin(entityLiving.tickCount * 0.1f)
//					* -(1 * Math.cos(entityLiving.tickCount * 0.1f)) * 4f);
//			oFlap = wingRotation;
//			oFlapSpeed = destPos;
//			destPos = Mth.clamp(destPos, 0.0F, 1.0F);
//			if (!entityLiving.isOnGround()) {
//				wingRotDelta = 7.0F;
//			} else {
//				wingRotDelta = 1.0F;
//			}
//			wingRotDelta = (float) (wingRotDelta * 1.9D);
//			wingRotation += wingRotDelta * 0.1F;
//			if (wingRotation > 1000) {
//				wingRotation = 0;
//			}
//
//			if (itemStack != ItemStack.EMPTY) {
//				if (itemStack.getItem() instanceof ArmorItem) {
//					ModelBackWings model = new ModelBackWings();
//					model.body.visible = armorSlot == ArmorItem.Type.CHEST;
//					model.young = _default.young;
//					model.crouching = _default.crouching;
//					model.riding = _default.riding;
//					model.rightArmPose = _default.rightArmPose;
//					model.leftArmPose = _default.leftArmPose;
//					float f = Mth.lerp(0, oFlap, wingRotation);
//					float f1 = Mth.lerp(0, oFlapSpeed, destPos);
//					float f3 = (Mth.sin(f) + 1.6F) * f1;
//
//					model.RightWing.zRot = f3;
//					model.LeftWing.zRot = -f3;
//
//					model.RightWing2.zRot = f3 * 0.5f;
//					model.LeftWing2.zRot = -f3 * 0.5f;
//
//					model.RightWing3.zRot = f3 * 0.2f;
//					model.LeftWing3.zRot = -f3 * 0.2f;
//					return (A) model;
//				}
//			}
//		} else {
//			wingRotDelta = 1.0F;
//
//			destPos = Math.max(0.3f, (float) -Math.sin(0 * 0.4f) * 3.1f);
//			oFlap = wingRotation;
//			oFlapSpeed = destPos;
//			if (itemStack != ItemStack.EMPTY) {
//				if (itemStack.getItem() instanceof ArmorItem) {
//					ModelBackWings model = new ModelBackWings();
//					model.body.visible = armorSlot == ArmorItem.Type.CHEST;
//					model.young = _default.young;
//					model.crouching = _default.crouching;
//					model.riding = _default.riding;
//					model.rightArmPose = _default.rightArmPose;
//					model.leftArmPose = _default.leftArmPose;
//					float f = Mth.lerp(0, oFlap, wingRotation);
//					float f1 = Mth.lerp(0, oFlapSpeed, destPos);
//					float f3 = (Mth.sin(f) + 1.6F) * f1;
//
//					model.RightWing.zRot = f3;
//					model.LeftWing.zRot = -f3;
//
//					model.RightWing2.zRot = f3 * 0.5f;
//					model.LeftWing2.zRot = -f3 * 0.5f;
//
//					model.RightWing3.zRot = f3 * 0.2f;
//					model.LeftWing3.zRot = -f3 * 0.2f;
//					return (A) model;
//				}
//			}
//		}
//		return null;
//	}
//
//	@Override
//	public void onArmorTick(ItemStack stack, Level world, Player player) {
//		super.onArmorTick(stack, world, player);
//		player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 2, 222, false, false, false, null));
//
//	}
}
