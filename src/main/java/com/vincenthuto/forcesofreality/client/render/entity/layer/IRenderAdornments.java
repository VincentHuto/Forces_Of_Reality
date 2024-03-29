package com.vincenthuto.forcesofreality.client.render.entity.layer;
//package com.vincenthuto.forcesofreality.render.entity.layer;
//
//import com.mojang.blaze3d.platform.GlStateManager;
//import com.mojang.blaze3d.vertex.PoseStack;
//import com.vincenthuto.forcesofreality.capa.adornment.IAdornment;
//
//import net.minecraft.client.model.HumanoidModel;
//import net.minecraft.client.renderer.MultiBufferSource;
//import net.minecraft.util.Mth;
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.ItemStack;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//
//public interface IRenderAdornments extends IAdornment {
//
//	void onPlayerAdornmentRender(PoseStack matrix, int packedLight, MultiBufferSource iRenderTypeBuffer, Player player,
//			RenderType type, float partialTicks);
//
//	final class Helper {
//
//		public static void rotateIfSneaking(Player player) {
//			if (player.isShiftKeyDown())
//				applySneakingRotation();
//		}
//
//		@SuppressWarnings("deprecation")
//		public static void applySneakingRotation() {
//			GlStateManager._translatef(0F, 0.2F, 0F);
//			GlStateManager._rotatef(90F / (float) Math.PI, 1.0F, 0.0F, 0.0F);
//		}
//
//		@SuppressWarnings("deprecation")
//		public static void translateToHeadLevel(Player player) {
//			GlStateManager._translatef(0, -player.getEyeHeight(), 0);
//			if (player.isShiftKeyDown())
//				GlStateManager._translatef(0.25F * Mth.sin(player.xRot * (float) Math.PI / 180),
//						0.25F * Mth.cos(player.xRot * (float) Math.PI / 180), 0F);
//		}
//
//		@SuppressWarnings("deprecation")
//		public static void translateToFace() {
//			GlStateManager._rotatef(90F, 0F, 1F, 0F);
//			GlStateManager._rotatef(180F, 1F, 0F, 0F);
//			GlStateManager._translatef(0f, -4.35f, -1.27f);
//		}
//
//		@SuppressWarnings("deprecation")
//		public static void defaultTransforms() {
//			GlStateManager._translatef(0.0f, 3.0f, 1.0f);
//			GlStateManager._scalef(0.55f, 0.55f, 0.55f);
//		}
//
//		@SuppressWarnings("deprecation")
//		public static void translateToChest() {
//			GlStateManager._rotatef(180F, 1F, 0F, 0F);
//			GlStateManager._translatef(0F, -3.2F, -0.85F);
//		}
//	}
//
//	@OnlyIn(Dist.CLIENT)
//	public static void doRender(HumanoidModel<?> bipedModel, ItemStack stack, LivingEntity player, PoseStack ms,
//			MultiBufferSource buffers, int light, float limbSwing, float limbSwingAmount, float partialTicks,
//			float ageInTicks, float netHeadYaw, float headPitch) {
//
//	}
//
//	enum RenderType {
//
//		BODY,
//
//		HEAD;
//	}
//}