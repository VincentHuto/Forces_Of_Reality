package com.huto.forces_of_reality.objects.items.armor;

import java.util.List;

import javax.annotation.Nullable;

import com.huto.forces_of_reality.models.armor.ModelSparkDirector;
import com.huto.forces_of_reality.models.armor.ModelSparkDirectorArmored;
import com.huto.forces_of_reality.network.PacketHandler;
import com.huto.forces_of_reality.network.coven.PacketToggleDirectorFlightModeMessage;
import com.huto.forces_of_reality.network.coven.SetGlidePkt;
import com.huto.forces_of_reality.particles.ParticleColor;
import com.huto.forces_of_reality.particles.data.GlowParticleData;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.PacketDistributor;

public class ItemSparkDirector extends ArmorItem {

	boolean flightMode;
	public float heightModifier;
	public String TAG_MODIFIER = "heightmodifier";
	boolean isArmored;

	public ItemSparkDirector(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn,
			boolean isArmoredIn) {
		super(materialIn, slot, builderIn);
		this.isArmored = isArmoredIn;
	}

	public static void updateClientServerFlight(ServerPlayerEntity player, boolean allowGliding) {
		PacketHandler.HANDLER.sendToServer(new SetGlidePkt(allowGliding));
	}

	public boolean isArmored() {
		return isArmored;
	}

	// float heightModifier = 0.1f;
	float jumpTicks = 0;

	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		super.onArmorTick(stack, world, player);

		Vector3d newVec = player.getLookVec();
		double dx = player.getPosX() - (newVec.getX() * 0.8);
		double dy = player.getPosY() + player.getEyeHeight() - .5f;
		double dz = player.getPosZ() - (newVec.getZ() * 0.8);
		boolean flightActive = stack.getOrCreateTag().getBoolean("flightmode");
		if (flightActive) {
			if (stack.getOrCreateTag().getFloat(TAG_MODIFIER) == 0.2f) {
				world.addParticle(GlowParticleData.createData(new ParticleColor(255, 180, 0)), dx, dy, dz, 0, 0.06f, 0);
				world.addParticle(GlowParticleData.createData(new ParticleColor(255, 100, 0)), dx, dy, dz, 0, 0.06f, 0);
				world.addParticle(GlowParticleData.createData(new ParticleColor(255, 60, 0)), dx, dy, dz, 0, 0.06f, 0);
			} else {
				world.addParticle(GlowParticleData.createData(new ParticleColor(255, 100, 0)), dx, dy, dz, 0, 0.06f, 0);

			}

		}
		if (player.isAirBorne) {
			if (flightActive) {
				if (jumpTicks > 0) {
					jumpTicks--;
					player.setMotion(
							player.getMotion().add(0 + world.rand.nextFloat() * 0.1f - world.rand.nextFloat() * 0.1f,
									stack.getOrCreateTag().getFloat(TAG_MODIFIER) + world.rand.nextFloat() * 0.1f
											- world.rand.nextFloat() * 0.1f,
									0 + world.rand.nextFloat() * 0.1f - world.rand.nextFloat() * 0.1f));
					if (!world.isRemote) {
						if (!((PlayerEntity) player).isCreative()) {
							updateClientServerFlight((ServerPlayerEntity) player, true);
						}
					}
					player.startFallFlying();
				} else {
					if (!world.isRemote) {
						if (!((PlayerEntity) player).isCreative()) {
							updateClientServerFlight((ServerPlayerEntity) player, false);
						}
					}
					player.isAirBorne = false;
					jumpTicks = 5;
				}
			}
		}

	}

	public boolean isFlightMode() {
		return flightMode;
	}

	public void setFlightMode(boolean flightMode) {
		this.flightMode = flightMode;
	}

	public void toggleFlightMode(PlayerEntity playerEntity, ItemStack stack) {
		CompoundNBT nbt = stack.getOrCreateTag();
		boolean flightMode = !nbt.getBoolean("flightmode");
		nbt.putBoolean("flightmode", flightMode);
		if (playerEntity instanceof ServerPlayerEntity) {
			PacketHandler.MECHANGLOVE.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) playerEntity),
					new PacketToggleDirectorFlightModeMessage(flightMode));
		} else {
			playerEntity.sendStatusMessage(
					new StringTextComponent(
							I18n.format(flightMode ? "forces_of_reality.autopickupenabled" : "forces_of_reality.autopickupdisabled")),
					true);
		}
	}

	private boolean hasTranslation(String key) {
		return !I18n.format(key).equals(key);
	}

	private String fallbackString(String key, String fallback) {
		String tmp = I18n.format(key);
		return tmp.equals(key) ? fallback : tmp;
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip,
			ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		String translationKey = getTranslationKey();

		boolean pickupEnabled = stack.getOrCreateTag().getBoolean("flightmode");
		if (isArmored) {
			tooltip.add(new StringTextComponent(I18n.format("Armor: +7")).mergeStyle(TextFormatting.GREEN));
		} else {
			tooltip.add(new StringTextComponent(I18n.format("Armor: +0")).mergeStyle(TextFormatting.RED));
		}

		tooltip.add(
				new StringTextComponent(I18n.format("Glide Modifier: " + stack.getOrCreateTag().getFloat(TAG_MODIFIER)))
						.mergeStyle(TextFormatting.GOLD));
		if (pickupEnabled)
			tooltip.add(new StringTextComponent(I18n.format("forces_of_reality.flightmodeenabled")));
		else
			tooltip.add(new StringTextComponent(I18n.format("forces_of_reality.flightmodedisabled")));

		if (Screen.hasShiftDown()) {
			tooltip.add(new StringTextComponent(I18n.format(translationKey + ".info")));
			if (hasTranslation(translationKey + ".info2"))
				tooltip.add(new StringTextComponent(I18n.format(translationKey + ".info2")));
			if (hasTranslation(translationKey + ".info3"))
				tooltip.add(new StringTextComponent(I18n.format(translationKey + ".info3")));
		} else {
			tooltip.add(new StringTextComponent(fallbackString("forces_of_reality.shift", "Press <§6§oShift§r> for info.")));
		}
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
				if (!isArmored) {
					ModelSparkDirector model = new ModelSparkDirector();
					model.bipedBody.showModel = armorSlot == EquipmentSlotType.CHEST;
					model.isChild = _default.isChild;
					model.isSneak = _default.isSneak;
					model.isSitting = _default.isSitting;
					model.rightArmPose = _default.rightArmPose;
					model.leftArmPose = _default.leftArmPose;

					return (A) model;
				}

				else if (isArmored) {
					ModelSparkDirectorArmored model = new ModelSparkDirectorArmored();
					model.bipedBody.showModel = armorSlot == EquipmentSlotType.CHEST;
					model.isChild = _default.isChild;
					model.isSneak = _default.isSneak;
					model.isSitting = _default.isSitting;
					model.rightArmPose = _default.rightArmPose;
					model.leftArmPose = _default.leftArmPose;

					return (A) model;
				}

			}
		}
		return null;
	}

}
