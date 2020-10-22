package com.huto.hutosmod.render.rune;

import org.lwjgl.opengl.GL11;

import com.huto.hutosmod.capabilities.mindrunes.IRunesItemHandler;
import com.huto.hutosmod.capabilities.mindrunes.RunesCapabilities;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.vector.Vector3f;

public class RunesRenderLayer<T extends PlayerEntity, M extends PlayerModel<T>> extends LayerRenderer<T, M> {

	public RunesRenderLayer(IEntityRenderer<T, M> entityRendererIn) {
		super(entityRendererIn);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(MatrixStack matrixStack, IRenderTypeBuffer iRenderTypeBuffer, int i, PlayerEntity player,
			float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch,
			float scale) {

		player.getCapability(RunesCapabilities.RUNES).ifPresent(inv -> {
			dispatchRenders(matrixStack, iRenderTypeBuffer, inv, player, IRenderRunes.RenderType.BODY, partialTicks);
			float yaw = player.prevRotationYawHead
					+ (player.rotationYawHead - player.prevRotationYawHead) * partialTicks;
			float yawOffset = player.prevRenderYawOffset
					+ (player.renderYawOffset - player.prevRenderYawOffset) * partialTicks;
			float pitch = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * partialTicks;

			matrixStack.push();
			matrixStack.rotate(Vector3f.YN.rotation(yawOffset * 0.0172f));
			matrixStack.rotate(Vector3f.YP.rotation(yaw * 0.0172f));
			matrixStack.rotate(Vector3f.XP.rotation(pitch * 0.0172f));
			dispatchRenders(matrixStack, iRenderTypeBuffer, inv, player, IRenderRunes.RenderType.HEAD, partialTicks);
			matrixStack.pop();
		});
	}

	@SuppressWarnings("deprecation")
	private void dispatchRenders(MatrixStack matrix, IRenderTypeBuffer iRenderTypeBuffer, IRunesItemHandler inv,
			PlayerEntity player, IRenderRunes.RenderType type, float partialTicks) {
		for (int i = 0; i < inv.getSlots(); i++) {
			ItemStack stack = inv.getStackInSlot(i);
			if (!stack.isEmpty()) {
				stack.getCapability(RunesCapabilities.ITEM_RUNE).ifPresent(rune -> {
					if (rune instanceof IRenderRunes) {
						matrix.push();
						// GL11.glColor3ub((byte) 255, (byte) 255, (byte) 255);
						// GlStateManager.color4f(1F, 1F, 1F, 1F);
						((IRenderRunes) rune).onPlayerRuneRender(matrix, iRenderTypeBuffer, player, type, partialTicks);
						matrix.pop();

					}
				});
			}
		}
	}
}