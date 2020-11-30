package com.huto.hutosmod.objects.items.armor;

import com.huto.hutosmod.models.armor.ModelSparkDirector;
import com.huto.hutosmod.particles.ParticleColor;
import com.huto.hutosmod.particles.data.GlowParticleData;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemSparkDirector extends ArmorItem {

	public ItemSparkDirector(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
		super(materialIn, slot, builderIn);
	}

	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		super.onArmorTick(stack, world, player);

		Vector3d newVec = player.getLookVec();
		double dx = player.getPosX() - (newVec.getX() * 0.8);
		double dy = player.getPosY() + player.getEyeHeight() - .5f;
		double dz = player.getPosZ() - (newVec.getZ() * 0.8);
		world.addParticle(GlowParticleData.createData(new ParticleColor(255, 180, 0)), dx, dy, dz, 0, 0.02f, 0);
	}

	/**
	 * 
	 * A public version of whats found in player
	 * 
	 */
	public final Vector3d getVectorForRotation(float pitch, float yaw) {
		float f = pitch * ((float) Math.PI / 180F);
		float f1 = -yaw * ((float) Math.PI / 180F);
		float f2 = MathHelper.cos(f1);
		float f3 = MathHelper.sin(f1);
		float f4 = MathHelper.cos(f);
		float f5 = MathHelper.sin(f);
		return new Vector3d((double) (f3 * f4), (double) (-f5), (double) (f2 * f4));
	}

	@SuppressWarnings("unchecked")
	@Override
	@OnlyIn(Dist.CLIENT)
	public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack,
			EquipmentSlotType armorSlot, A _default) {
		if (itemStack != ItemStack.EMPTY) {
			if (itemStack.getItem() instanceof ArmorItem) {
				ModelSparkDirector model = new ModelSparkDirector();
				model.bipedBody.showModel = armorSlot == EquipmentSlotType.CHEST;
				model.isChild = _default.isChild;
				model.isSneak = _default.isSneak;
				model.isSitting = _default.isSitting;
				model.rightArmPose = _default.rightArmPose;
				model.leftArmPose = _default.leftArmPose;

				return (A) model;
			}
		}
		return null;
	}

}
