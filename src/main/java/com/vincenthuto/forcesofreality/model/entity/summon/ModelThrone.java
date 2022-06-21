//package com.vincenthuto.forcesofreality.model.entity.summon;
//
//import com.mojang.blaze3d.vertex.PoseStack;
//import com.mojang.blaze3d.vertex.VertexConsumer;
//import com.vincenthuto.forcesofreality.entity.summon.EntityThrone;
//import com.vincenthuto.hutoslib.client.HLClientUtils;
//
//import net.minecraft.client.model.EntityModel;
//import net.minecraft.client.model.geom.ModelPart;
//
//public class ModelThrone extends EntityModel<EntityThrone> {
//	private final ModelPart Core;
//	private final ModelPart NSWheel;
//	private final ModelPart EWWheel;
//
//	public ModelThrone() {
//		texWidth = 64;
//		texHeight = 64;
//
//		Core = new ModelPart(this);
//		Core.setPos(0.0F, 16.0F, 0.0F);
//		Core.texOffs(16, 4).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
//
//		NSWheel = new ModelPart(this);
//		NSWheel.setPos(0.0F, 16.0F, 0.0F);
//		NSWheel.texOffs(26, 26).addBox(-1.0F, -6.0F, 6.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);
//		NSWheel.texOffs(0, 14).addBox(-1.0F, 6.0F, -6.0F, 2.0F, 2.0F, 12.0F, 0.0F, false);
//		NSWheel.texOffs(0, 0).addBox(-1.0F, -8.0F, -6.0F, 2.0F, 2.0F, 12.0F, 0.0F, false);
//		NSWheel.texOffs(0, 28).addBox(-1.0F, -6.0F, -8.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);
//
//		EWWheel = new ModelPart(this);
//		EWWheel.setPos(0.0F, 16.0F, 0.0F);
//		EWWheel.texOffs(0, 0).addBox(-6.0F, -4.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
//		EWWheel.texOffs(16, 0).addBox(-4.0F, 4.0F, -1.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);
//		EWWheel.texOffs(16, 16).addBox(-4.0F, -6.0F, -1.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);
//		EWWheel.texOffs(0, 14).addBox(4.0F, -4.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
//	}
//
//	@Override
//	public void setupAnim(EntityThrone entity, float limbSwing, float limbSwingAmount, float ageInTicks,
//			float netHeadYaw, float headPitch) {
//		float parTicks = HLClientUtils.getPartialTicks();
//
//		this.NSWheel.xRot = (entity.tickCount + parTicks) * 0.4f;
//		this.EWWheel.xRot = -(entity.tickCount + parTicks) * 0.4f;
//		this.NSWheel.yRot = (entity.tickCount + parTicks) * 0.4f;
//		this.EWWheel.zRot = -(entity.tickCount + parTicks) * 0.4f;
//	}
//
//	@Override
//	public void renderToBuffer(PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay,
//			float red, float green, float blue, float alpha) {
//		Core.render(matrixStack, buffer, packedLight, packedOverlay);
//		NSWheel.render(matrixStack, buffer, packedLight, packedOverlay);
//		EWWheel.render(matrixStack, buffer, packedLight, packedOverlay);
//	}
//
//	public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
//		modelRenderer.xRot = x;
//		modelRenderer.yRot = y;
//		modelRenderer.zRot = z;
//	}
//}