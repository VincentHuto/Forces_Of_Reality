package com.huto.hutosmod.render.entity.layer;

import java.util.List;

import com.huto.hutosmod.entities.utils.ModEntityPredicates;
import com.huto.hutosmod.init.ItemInit;
import com.mojang.blaze3d.matrix.MatrixStack;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OutlineLayerBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public class ThermalLayerHelper2 extends RenderType {

	private ThermalLayerHelper2() {
		super(null, null, 0, 0, false, false, null, null);
	} // dummy

	public static void renderWorld(RenderWorldLastEvent evt) {
		MatrixStack ms = evt.getMatrixStack();
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
			OutlineLayerBuffer buffer = mc.getRenderTypeBuffers().getOutlineBufferSource();
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
		ItemStack stack = player.getHeldItemMainhand();
		if (stack == null) {
			return;
		}
		if (stack.getItem() == ItemInit.beastly_bone.get()) {
			player.world.getEntitiesInAABBexcluding(player, player.getBoundingBox().grow(30),
					ModEntityPredicates.WARMBLOODED);
			List<Entity> entList = player.world.getEntitiesInAABBexcluding(player, player.getBoundingBox().grow(30),
					ModEntityPredicates.WARMBLOODED);
			for (Entity ent : entList) {
				if (ent instanceof LivingEntity) {
					LivingEntity livEnt = (LivingEntity) ent;
					if (livEnt != null) {
						renderEntityOutline(ent, 255, 125, 0,
								(int) (MathHelper.cos((ent.ticksExisted + partialTicks) * 0.2f) * 35 + 45));
						LivingEntity target = ((LivingEntity) ent).getRevengeTarget();
						if (target != null)
							renderEntityOutline(target, 255, 0, 0, 100);
					}
				}
			}
		}
	}

}
