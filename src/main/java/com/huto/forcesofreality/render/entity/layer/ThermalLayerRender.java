package com.huto.forcesofreality.render.entity.layer;

import java.util.List;

import com.huto.forcesofreality.capabilitie.covenant.CovenantProvider;
import com.huto.forcesofreality.capabilitie.covenant.EnumCovenants;
import com.huto.forcesofreality.capabilitie.covenant.ICovenant;
import com.huto.forcesofreality.entity.util.ModEntityPredicates;
import com.huto.forcesofreality.init.ItemInit;
import com.mojang.blaze3d.vertex.PoseStack;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OutlineBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public class ThermalLayerRender extends RenderType {

	private ThermalLayerRender() {
		super(null, null, 0, 0, false, false, null, null);
	}

	public static void renderWorld(RenderWorldLastEvent evt) {
		PoseStack ms = evt.getMatrixStack();
		float partialTicks = evt.getPartialTicks();
		renderThermalLayers(ms, partialTicks);
	}

	private static final Object2IntMap<Entity> ENTITY_OUTLINE_MAP = new Object2IntOpenHashMap<>(1);

	public static void renderEntityOutline(Entity entity, int red, int green, int blue, int alpha) {
		ENTITY_OUTLINE_MAP.put(entity,
				((alpha & 0xFF) << 24) | ((red & 0xFF) << 16) | ((green & 0xFF) << 8) | ((blue & 0xFF)));
	}

	public static void renderEntities(RenderLivingEvent.Pre<? super LivingEntity, ?> event) {
		LivingEntity entity = event.getEntity();
		int color = ENTITY_OUTLINE_MAP.removeInt(entity);
		if (color != 0) {
			event.setCanceled(true);
			Minecraft mc = Minecraft.getInstance();
			OutlineBufferSource buffer = mc.getRenderTypeBuffers().getOutlineBufferSource();
			MatrixStack ms = event.getMatrixStack();
			LivingRenderer<? super LivingEntity, ?> renderer = event.getRenderer();
			float partialTicks = event.getPartialRenderTick();
			float yaw = MathHelper.lerp(partialTicks, entity.prevRotationYaw, entity.rotationYaw);
			buffer.setColor((color >> 16) & 0xFF, (color >> 8) & 0xFF, color & 0xFF, (color >> 24) & 0xFF);
			renderer.render(entity, yaw, partialTicks, ms, buffer, 15728640);
			buffer.finish();
		}
	}

	private static void renderThermalLayers(MatrixStack ms, float partialTicks) {
		Minecraft mc = Minecraft.getInstance();
		PlayerEntity player = mc.player;
		if (player.isAlive()) {
			ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
					.orElseThrow(IllegalArgumentException::new);
			if (player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() != ItemInit.influence_supressor.get()) {
				if (coven != null && coven.getDevotion().get(EnumCovenants.BEAST) != null) {
					if (coven.getDevotion().get(EnumCovenants.BEAST) >= 10) {
						// if (stack.getItem() == ItemInit.beastly_bone.get()) {}
						List<Entity> entList = player.world.getEntitiesInAABBexcluding(player,
								player.getBoundingBox().grow(30), EntityPredicates.IS_ALIVE);
						for (Entity ent : entList) {
							if (ent instanceof LivingEntity) {
								LivingEntity livEnt = (LivingEntity) ent;
								if (livEnt != null) {
									if (ModEntityPredicates.WARMBLOODED.test(ent)) {
										renderEntityOutline(ent, 255, 125, 0,
												(int) (MathHelper.cos((ent.ticksExisted + partialTicks) * 0.2f) * 35
														+ 45));
									}
									if (ModEntityPredicates.COLDBLOODED.test(ent)) {
										renderEntityOutline(ent, 0, 125, 125,
												(int) (MathHelper.cos((ent.ticksExisted + partialTicks) * 0.2f) * 35
														+ 45));
									}
									if (ModEntityPredicates.UNDEAD.test(ent)) {
										renderEntityOutline(ent, 255, 255, 255,
												(int) (MathHelper.cos((ent.ticksExisted + partialTicks) * 0.2f) * 35
														+ 45));
									}
									if (ModEntityPredicates.ENDERBLOOD.test(ent)) {
										renderEntityOutline(ent, 255, 0, 255,
												(int) (MathHelper.cos((ent.ticksExisted + partialTicks) * 0.2f) * 35
														+ 45));
									}
									if (ModEntityPredicates.PLANTBLOOD.test(ent)) {
										renderEntityOutline(ent, 0, 125, 0,
												(int) (MathHelper.cos((ent.ticksExisted + partialTicks) * 0.2f) * 35
														+ 45));
									}
									if (ModEntityPredicates.INFERNALBLOOD.test(ent)) {
										renderEntityOutline(ent, 255, 0, 0,
												(int) (MathHelper.cos((ent.ticksExisted + partialTicks) * 0.2f) * 35
														+ 45));
									}
								}
							}
						}
					}
				}
			}
		}
	}
}