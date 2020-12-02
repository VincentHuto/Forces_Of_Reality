package com.huto.hutosmod.events;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.objects.items.armor.ItemSparkDirector;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = HutosMod.MOD_ID, bus = Bus.FORGE)
public class SparkDirectorForgeEvents {

	@SubscribeEvent
	public static void onPrePlayerRender(LivingFallEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			if (player.inventory.armorInventory.get(2).getItem() instanceof ItemSparkDirector) {
				ItemStack stack = player.inventory.armorInventory.get(2);
				ItemSparkDirector item = (ItemSparkDirector) stack.getItem();

				if (item.isArmored()) {
					event.setDamageMultiplier(event.getDamageMultiplier() * 0.0f);
				} else {
					if (player.getEntityWorld().getRandom().nextBoolean()) {
						event.setDamageMultiplier(event.getDamageMultiplier() * 0.2f);
					} else {
						event.setDamageMultiplier(event.getDamageMultiplier() * 0.0f);
					}
				}
			}
		}

	}

	/*
	 * @SubscribeEvent public static void onPrePlayerRender(RenderPlayerEvent.Pre
	 * event) { PlayerEntity player = event.getPlayer(); PlayerRenderer render =
	 * event.getRenderer(); PlayerModel<AbstractClientPlayerEntity> model =
	 * render.getEntityModel();
	 * 
	 * if (player != null && player.getHeldItemMainhand().getItem() ==
	 * ItemInit.demon_flute.get()) { model.bipedLeftArm.showModel = false;
	 * 
	 * model.bipedRightArm.showModel = false;
	 * 
	 * } }
	 * 
	 * @SubscribeEvent public static void holdGunPost(RenderPlayerEvent.Post event)
	 * { PlayerEntity player = event.getPlayer();
	 * PlayerModel<AbstractClientPlayerEntity> model =
	 * event.getRenderer().getEntityModel();
	 * 
	 * if (player != null && player.getHeldItemMainhand().getItem() ==
	 * ItemInit.demon_flute.get()) { renderArmModelIdleHoldingPistolAiming(model,
	 * player, event);
	 * 
	 * } }
	 * 
	 * @SuppressWarnings("unused") private static void
	 * renderArmModelIdleHoldingPistol(PlayerModel<AbstractClientPlayerEntity>
	 * model, PlayerEntity player, RenderPlayerEvent event) { MatrixStack matrix =
	 * event.getMatrixStack(); IVertexBuilder buffer = event.getBuffers()
	 * .getBuffer(model.getRenderType(((AbstractClientPlayerEntity)
	 * player).getLocationSkin())); int light = event.getLight(); int texture =
	 * OverlayTexture.NO_OVERLAY;
	 * 
	 * model.bipedRightArm.rotationPointX = -MathHelper.cos((float)
	 * Math.toRadians(player.renderYawOffset)) * 5.5F;
	 * model.bipedRightArm.rotationPointY = player.isCrouching() ? 17.5F : 20.5F;
	 * model.bipedRightArm.rotationPointZ = -MathHelper.sin((float)
	 * Math.toRadians(player.renderYawOffset)) * 5.5F;
	 * model.bipedRightArm.rotateAngleX = -1.6F - (player.rotationPitch / 90) *
	 * 1.2F; // -3.0F > -1.65F > -0.0F; model.bipedRightArm.rotateAngleY = (float)
	 * -Math.toRadians(player.renderYawOffset) + 3.2F +
	 * -Math.abs((player.rotationPitch / 90)) * -0.05F;
	 * model.bipedRightArm.rotateAngleZ = 0.0F;
	 * 
	 * model.bipedRightArm.showModel = true; model.bipedRightArm.render(matrix,
	 * buffer, light, texture); }
	 * 
	 * private static void
	 * renderArmModelIdleHoldingPistolAiming(PlayerModel<AbstractClientPlayerEntity>
	 * model, PlayerEntity player, RenderPlayerEvent event) { MatrixStack matrix =
	 * event.getMatrixStack(); IVertexBuilder buffer = event.getBuffers()
	 * .getBuffer(model.getRenderType(((AbstractClientPlayerEntity)
	 * player).getLocationSkin())); int light = event.getLight(); int texture =
	 * OverlayTexture.NO_OVERLAY;
	 * 
	 * model.bipedRightArm.rotationPointX = -MathHelper.cos((float)
	 * Math.toRadians(player.renderYawOffset)) * 5.5F;
	 * model.bipedRightArm.rotationPointY = player.isCrouching() ? 17.5F : 20.5F;
	 * model.bipedRightArm.rotationPointZ = -MathHelper.sin((float)
	 * Math.toRadians(player.renderYawOffset)) * 5.5F;
	 * model.bipedRightArm.rotateAngleX = -1.6F - (player.rotationPitch / 90) *
	 * 1.2F; // -3.0F > -1.65F > -0.0F; model.bipedRightArm.rotateAngleY = (float)
	 * -Math.toRadians(player.renderYawOffset) + 3.5F +
	 * -Math.abs((player.rotationPitch / 90)) * -0.6F;
	 * model.bipedRightArm.rotateAngleZ = 0.0F;
	 * 
	 * model.bipedLeftArm.rotationPointX = -MathHelper.cos((float)
	 * Math.toRadians(player.renderYawOffset)) * -5.5F;
	 * model.bipedLeftArm.rotationPointY = player.isCrouching() ? 17.5F : 20.5F;
	 * model.bipedLeftArm.rotationPointZ = -MathHelper.sin((float)
	 * Math.toRadians(player.renderYawOffset)) * -5.5F;
	 * model.bipedLeftArm.rotateAngleX = -1.7F - (player.rotationPitch / 90) * 1.2F;
	 * // -3.0F > -1.65F > -0.0F; model.bipedLeftArm.rotateAngleY = (float)
	 * -Math.toRadians(player.renderYawOffset) - 3.5F +
	 * -Math.abs((player.rotationPitch / 90)) * 0.6F;
	 * model.bipedLeftArm.rotateAngleZ = 0.0F;
	 * 
	 * model.bipedRightArm.showModel = true; model.bipedLeftArm.showModel = true;
	 * model.bipedRightArm.render(matrix, buffer, light, texture);
	 * model.bipedLeftArm.render(matrix, buffer, light, texture); }
	 */
}
