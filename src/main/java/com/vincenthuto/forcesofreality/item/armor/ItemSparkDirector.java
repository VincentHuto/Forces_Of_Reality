package com.vincenthuto.forcesofreality.item.armor;

import java.util.List;

import javax.annotation.Nullable;

import com.vincenthuto.forcesofreality.network.PacketHandler;
import com.vincenthuto.forcesofreality.network.coven.PacketToggleDirectorFlightModeMessage;
import com.vincenthuto.forcesofreality.network.coven.SetGlideAnim;
import com.vincenthuto.forcesofreality.network.coven.SetGlidePkt;
import com.vincenthuto.hutoslib.client.particle.factory.GlowParticleFactory;
import com.vincenthuto.hutoslib.client.particle.util.ParticleColor;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.PacketDistributor;

public class ItemSparkDirector extends ArmorItem {

	public static void updateClientServerFlight(ServerPlayer player, boolean allowGliding) {
		PacketHandler.HANDLER.sendToServer(new SetGlidePkt(allowGliding));
	}

	boolean flightMode;
	public float heightModifier;
	public String TAG_MODIFIER = "heightmodifier";

	boolean isArmored;

	// float heightModifier = 0.1f;
	float jumpTicks = 0;

	public ItemSparkDirector(ArmorMaterial materialIn, EquipmentSlot slot, Properties builderIn, boolean isArmoredIn) {
		super(materialIn, slot, builderIn);
		this.isArmored = isArmoredIn;
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
		String translationKey = getDescriptionId();

		boolean pickupEnabled = stack.getOrCreateTag().getBoolean("flightmode");
		if (isArmored) {
			tooltip.add(Component.translatable(I18n.get("Armor: +7")).withStyle(ChatFormatting.GREEN));
		} else {
			tooltip.add(Component.translatable(I18n.get("Armor: +0")).withStyle(ChatFormatting.RED));
		}

		tooltip.add(Component.translatable(I18n.get("Glide Modifier: " + stack.getOrCreateTag().getFloat(TAG_MODIFIER)))
				.withStyle(ChatFormatting.GOLD));
		if (pickupEnabled)
			tooltip.add(Component.translatable(I18n.get("forcesofreality.flightmodeenabled")));
		else
			tooltip.add(Component.translatable(I18n.get("forcesofreality.flightmodedisabled")));

		if (Screen.hasShiftDown()) {
			tooltip.add(Component.translatable(I18n.get(translationKey + ".info")));
			if (hasTranslation(translationKey + ".info2"))
				tooltip.add(Component.translatable(I18n.get(translationKey + ".info2")));
			if (hasTranslation(translationKey + ".info3"))
				tooltip.add(Component.translatable(I18n.get(translationKey + ".info3")));
		} else {
			tooltip.add(Component
					.translatable(fallbackString("forcesofreality.shift", "Press <�6�oShift�r> for info.")));
		}
	}

	private String fallbackString(String key, String fallback) {
		String tmp = I18n.get(key);
		return tmp.equals(key) ? fallback : tmp;
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	@OnlyIn(Dist.CLIENT)
//	public <A extends HumanoidModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack,
//			EquipmentSlot armorSlot, A _default) {
//		if (itemStack != ItemStack.EMPTY) {
//			if (itemStack.getItem() instanceof ArmorItem) {
//				if (!isArmored) {
//					ModelSparkDirector model = new ModelSparkDirector();
//					model.body.visible = armorSlot == EquipmentSlot.CHEST;
//					model.young = _default.young;
//					model.crouching = _default.crouching;
//					model.riding = _default.riding;
//					model.rightArmPose = _default.rightArmPose;
//					model.leftArmPose = _default.leftArmPose;
//
//					return (A) model;
//				}
//
//				else if (isArmored) {
//					ModelSparkDirectorArmored model = new ModelSparkDirectorArmored();
//					model.body.visible = armorSlot == EquipmentSlot.CHEST;
//					model.young = _default.young;
//					model.crouching = _default.crouching;
//					model.riding = _default.riding;
//					model.rightArmPose = _default.rightArmPose;
//					model.leftArmPose = _default.leftArmPose;
//
//					return (A) model;
//				}
//
//			}
//		}
//		return null;
//	}

	/**
	 *
	 * A public version of whats found in player
	 *
	 */
	public final Vec3 getVectorForRotation(float pitch, float yaw) {
		float f = pitch * ((float) Math.PI / 180F);
		float f1 = -yaw * ((float) Math.PI / 180F);
		float f2 = Mth.cos(f1);
		float f3 = Mth.sin(f1);
		float f4 = Mth.cos(f);
		float f5 = Mth.sin(f);
		return new Vec3(f3 * f4, (-f5), f2 * f4);
	}

	private boolean hasTranslation(String key) {
		return !I18n.get(key).equals(key);
	}

	public boolean isArmored() {
		return isArmored;
	}

	public boolean isFlightMode() {
		return flightMode;
	}

	@Override
	public void onArmorTick(ItemStack stack, Level world, Player player) {
		super.onArmorTick(stack, world, player);

		Vec3 newVec = player.getLookAngle();

		double dx = player.getX() - (newVec.x() * 0.8);
		double dy = player.getY() + player.getEyeHeight() - .5f;
		double dz = player.getZ() - (newVec.z() * 0.8);
		boolean flightActive = stack.getOrCreateTag().getBoolean("flightmode");
		if (flightActive) {
			if (stack.getOrCreateTag().getFloat(TAG_MODIFIER) == 0.2f) {
				if (world.isClientSide) {
					// float rot = player.renderYawOffset;
					world.addParticle(GlowParticleFactory.createData(new ParticleColor(255, 180, 0)), dx, dy, dz, 0,
							0.06f, 0);
					world.addParticle(GlowParticleFactory.createData(new ParticleColor(255, 100, 0)), dx, dy, dz, 0,
							0.06f, 0);
					world.addParticle(GlowParticleFactory.createData(new ParticleColor(255, 60, 0)), dx, dy, dz, 0,
							0.06f, 0);
				}
			} else {
				if (world.isClientSide) {
					float rot = player.yBodyRot;
					// float rotSin = (float) (Math.sin(rot) * 100);
					float strRot = Float.valueOf(Float.toString(rot).substring(Float.toString(rot).length() - 2));
					// System.out.println(Math.cos(strRot)*0.25f);
					double x = player.getX() + Math.sin(strRot) * 0.35f;
					double y = player.getY() + 1;
					double z = player.getZ() - Math.abs(Math.cos(strRot)) * 0.35f;
					world.addParticle(GlowParticleFactory.createData(new ParticleColor(255, 100, 0)), x, y, z, 0, 0.06f,
							0);
				}

			}

		}
		if (player.hasImpulse) {
			if (flightActive) {
				if (jumpTicks > 0) {
					jumpTicks--;
					player.setDeltaMovement(player.getDeltaMovement().add(
							0 + world.random.nextFloat() * 0.1f - world.random.nextFloat() * 0.1f,
							stack.getOrCreateTag().getFloat(TAG_MODIFIER) + world.random.nextFloat() * 0.1f
									- world.random.nextFloat() * 0.1f,
							0 + world.random.nextFloat() * 0.1f - world.random.nextFloat() * 0.1f));
					if (!world.isClientSide) {
						if (!player.isCreative()) {
							updateClientServerFlight((ServerPlayer) player, true);
						}
					}
					if (!world.isClientSide) {
						PacketHandler.HANDLER.sendToServer(new SetGlideAnim());
					} else {
						player.setPose(Pose.FALL_FLYING);
						player.startFallFlying();
					}
				} else {
					if (!world.isClientSide) {
						if (!player.isCreative()) {
							updateClientServerFlight((ServerPlayer) player, false);
						}
					}
					player.hasImpulse = false;
					jumpTicks = 5;
				}
			}
		}

	}

	public void setFlightMode(boolean flightMode) {
		this.flightMode = flightMode;
	}

	public void toggleFlightMode(Player playerEntity, ItemStack stack) {
		CompoundTag nbt = stack.getOrCreateTag();
		boolean flightMode = !nbt.getBoolean("flightmode");
		nbt.putBoolean("flightmode", flightMode);
		if (playerEntity instanceof ServerPlayer) {
			PacketHandler.MECHANGLOVE.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) playerEntity),
					new PacketToggleDirectorFlightModeMessage(flightMode));
		} else {
			playerEntity.displayClientMessage(
					Component.translatable(I18n.get(
							flightMode ? "forcesofreality.autopickupenabled" : "forcesofreality.autopickupdisabled")),
					true);
		}
	}

}
