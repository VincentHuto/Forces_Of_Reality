package com.vincenthuto.forcesofreality.model.entity.summon;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.summon.EntityBlackGoat;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class ModelBlackGoat extends EntityModel<EntityBlackGoat> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ForcesOfReality.MOD_ID, "modelblackgoat"), "main");
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 9).addBox(-3.25F, -5.275F, -2.995F, 7.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(34, 13).addBox(-3.25F, -3.275F, -0.995F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(-1.15F, -3.275F, -0.995F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(1.65F, -3.275F, -0.995F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(34, 10).addBox(1.75F, -3.275F, -0.995F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(26, 5).addBox(-1.25F, -3.275F, -2.995F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(24, 26).addBox(-1.25F, -3.275F, 1.005F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(24, 22).addBox(-1.25F, -3.275F, 0.905F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 13).addBox(-1.25F, -3.275F, -0.995F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 21.375F, -0.005F, 0.0F, -1.0472F, 0.0F));

		PartDefinition tent9 = body.addOrReplaceChild("tent9", CubeListBuilder.create(), PartPose.offset(6.75F, -16.275F, -3.995F));

		PartDefinition tent10 = tent9.addOrReplaceChild("tent10", CubeListBuilder.create().texOffs(34, 4).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 8.5F, 2.0F));

		PartDefinition tent17 = tent9.addOrReplaceChild("tent17", CubeListBuilder.create().texOffs(22, 33).addBox(-0.3F, -0.9F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 6.9F, 2.0F));

		PartDefinition tent18 = tent9.addOrReplaceChild("tent18", CubeListBuilder.create().texOffs(0, 37).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.1F, 6.0F, 2.5F));

		PartDefinition tent19 = tent9.addOrReplaceChild("tent19", CubeListBuilder.create().texOffs(36, 17).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 4.0F, 1.8F));

		PartDefinition tent20 = tent9.addOrReplaceChild("tent20", CubeListBuilder.create().texOffs(35, 36).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 2.0F, 2.5F));

		PartDefinition tent21 = tent9.addOrReplaceChild("tent21", CubeListBuilder.create(), PartPose.offset(-3.5F, 0.1F, 1.9F));

		PartDefinition tent22 = body.addOrReplaceChild("tent22", CubeListBuilder.create(), PartPose.offset(6.75F, -16.275F, 0.005F));

		PartDefinition tent23 = tent22.addOrReplaceChild("tent23", CubeListBuilder.create().texOffs(24, 33).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 8.5F, 2.0F));

		PartDefinition tent24 = tent22.addOrReplaceChild("tent24", CubeListBuilder.create().texOffs(6, 33).addBox(-0.1F, -0.9F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 6.9F, 2.0F));

		PartDefinition tent25 = tent22.addOrReplaceChild("tent25", CubeListBuilder.create().texOffs(31, 36).addBox(-1.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.1F, 6.0F, 2.5F));

		PartDefinition tent26 = tent22.addOrReplaceChild("tent26", CubeListBuilder.create().texOffs(27, 36).addBox(-0.5F, -2.0F, 0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 4.0F, 1.8F));

		PartDefinition tent27 = tent22.addOrReplaceChild("tent27", CubeListBuilder.create().texOffs(23, 36).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 2.0F, 2.5F));

		PartDefinition tent28 = tent22.addOrReplaceChild("tent28", CubeListBuilder.create(), PartPose.offset(-2.9F, -0.1F, 2.9F));

		PartDefinition tent29 = body.addOrReplaceChild("tent29", CubeListBuilder.create(), PartPose.offset(1.75F, -16.275F, 0.005F));

		PartDefinition tent30 = tent29.addOrReplaceChild("tent30", CubeListBuilder.create().texOffs(16, 33).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 8.5F, 2.0F));

		PartDefinition tent31 = tent29.addOrReplaceChild("tent31", CubeListBuilder.create().texOffs(22, 26).addBox(-1.1F, -0.9F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 6.9F, 2.0F));

		PartDefinition tent32 = tent29.addOrReplaceChild("tent32", CubeListBuilder.create().texOffs(19, 36).addBox(-1.5F, -2.0F, -1.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.1F, 6.0F, 2.5F));

		PartDefinition tent33 = tent29.addOrReplaceChild("tent33", CubeListBuilder.create().texOffs(15, 36).addBox(-1.5F, -2.0F, -0.1F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 4.0F, 1.8F));

		PartDefinition tent34 = tent29.addOrReplaceChild("tent34", CubeListBuilder.create().texOffs(11, 36).addBox(-1.8F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 2.0F, 2.5F));

		PartDefinition tent35 = tent29.addOrReplaceChild("tent35", CubeListBuilder.create(), PartPose.offset(-4.2F, -0.2F, 2.4F));

		PartDefinition tent36 = body.addOrReplaceChild("tent36", CubeListBuilder.create(), PartPose.offset(4.25F, -16.275F, -1.995F));

		PartDefinition tent37 = tent36.addOrReplaceChild("tent37", CubeListBuilder.create().texOffs(8, 33).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 8.5F, 2.0F));

		PartDefinition tent38 = tent36.addOrReplaceChild("tent38", CubeListBuilder.create().texOffs(6, 26).addBox(-1.1F, -0.9F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 6.9F, 2.0F));

		PartDefinition tent39 = tent36.addOrReplaceChild("tent39", CubeListBuilder.create().texOffs(7, 36).addBox(-1.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.1F, 6.0F, 2.5F));

		PartDefinition tent40 = tent36.addOrReplaceChild("tent40", CubeListBuilder.create().texOffs(0, 17).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 4.0F, 1.8F));

		PartDefinition tent41 = tent36.addOrReplaceChild("tent41", CubeListBuilder.create().texOffs(0, 9).addBox(-1.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 2.0F, 2.5F));

		PartDefinition tent42 = tent36.addOrReplaceChild("tent42", CubeListBuilder.create().texOffs(0, 0).addBox(0.1F, -1.1F, -0.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.1F, 0.1F, 1.9F));

		PartDefinition tent2 = body.addOrReplaceChild("tent2", CubeListBuilder.create(), PartPose.offset(1.75F, -16.275F, -3.995F));

		PartDefinition tent3 = tent2.addOrReplaceChild("tent3", CubeListBuilder.create().texOffs(34, 7).addBox(-6.0F, -1.0F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 8.0F, 1.0F));

		PartDefinition tent4 = tent2.addOrReplaceChild("tent4", CubeListBuilder.create().texOffs(41, 33).addBox(-5.0F, -1.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 7.0F, 0.5F));

		PartDefinition tent5 = tent2.addOrReplaceChild("tent5", CubeListBuilder.create().texOffs(38, 20).addBox(-6.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.4F, 6.0F, 2.0F));

		PartDefinition tent6 = tent2.addOrReplaceChild("tent6", CubeListBuilder.create().texOffs(38, 38).addBox(-5.0F, -2.0F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 4.0F, 0.3F));

		PartDefinition tent7 = tent2.addOrReplaceChild("tent7", CubeListBuilder.create().texOffs(4, 38).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 2.0F, 2.5F));

		PartDefinition tent8 = tent2.addOrReplaceChild("tent8", CubeListBuilder.create().texOffs(41, 22).addBox(-0.5F, -0.9F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, -0.1F, 1.5F));

		PartDefinition brain = body.addOrReplaceChild("brain", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -3.0F, 0.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(12, 18).addBox(-6.1F, -3.0F, 0.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 18).addBox(1.1F, -3.0F, 0.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(20, 13).addBox(-6.0F, -3.0F, 6.1F, 7.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(24, 24).addBox(-6.0F, -3.0F, -0.1F, 7.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(2.75F, -5.275F, -2.995F));

		PartDefinition eye1 = brain.addOrReplaceChild("eye1", CubeListBuilder.create().texOffs(30, 31).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.2337F, 0.0F, 0.4029F));

		PartDefinition eye2 = brain.addOrReplaceChild("eye2", CubeListBuilder.create().texOffs(24, 29).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.6122F, -2.0F, 6.2794F));

		PartDefinition eye3 = brain.addOrReplaceChild("eye3", CubeListBuilder.create().texOffs(28, 15).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.2179F, 0.0F, 6.3775F));

		PartDefinition eye4 = brain.addOrReplaceChild("eye4", CubeListBuilder.create().texOffs(30, 20).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.1821F, -1.0F, 0.0474F));

		PartDefinition tounge = body.addOrReplaceChild("tounge", CubeListBuilder.create().texOffs(18, 18).addBox(-0.5F, -1.5F, 0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(18, 18).mirror().addBox(-0.6866F, 2.0F, 0.1232F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(18, 18).mirror().addBox(0.1696F, 1.0F, 0.0402F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.25F, -1.775F, 0.005F));

		PartDefinition backLeftLeg = body.addOrReplaceChild("backLeftLeg", CubeListBuilder.create().texOffs(20, 0).addBox(-1.0F, 6.0F, 0.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(12, 42).addBox(-1.0F, 4.1F, 3.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(39, 41).addBox(-1.0F, 2.1F, 2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(41, 29).addBox(-1.0F, 4.1F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(35, 41).addBox(0.0F, 2.1F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(41, 12).addBox(2.0F, 4.1F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(41, 9).addBox(2.0F, 2.1F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 42).addBox(2.0F, 4.1F, 3.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(41, 6).addBox(1.0F, 2.1F, 3.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 26).addBox(0.0F, 1.1F, 1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 27).addBox(-1.0F, -0.9F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(31, 35).addBox(-1.0F, 7.0F, 4.0F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 17).addBox(-2.0F, 7.0F, 0.0F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(10, 17).addBox(3.0F, 7.0F, 0.0F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(33, 16).addBox(-1.0F, 7.0F, -1.0F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.75F, -4.375F, 3.005F));

		PartDefinition backRightLeg = body.addOrReplaceChild("backRightLeg", CubeListBuilder.create().texOffs(16, 17).addBox(-4.0F, 6.0F, -1.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(4, 41).addBox(-4.0F, 4.1F, 2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 17).addBox(-4.0F, 2.1F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 3).addBox(-4.0F, 4.1F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 0).addBox(-3.0F, 2.1F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 40).addBox(-1.0F, 4.1F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(39, 35).addBox(-1.0F, 2.1F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(39, 26).addBox(-1.0F, 4.1F, 2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 39).addBox(-2.0F, 2.1F, 2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 26).addBox(-3.0F, 1.1F, 0.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 33).addBox(-2.0F, -0.9F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(31, 26).addBox(-4.0F, 7.0F, 3.0F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 17).addBox(-5.0F, 7.0F, -1.0F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(16, 0).addBox(0.0F, 7.0F, -1.0F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(27, 19).addBox(-4.0F, 7.0F, -2.0F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.25F, -4.375F, 2.005F));

		PartDefinition frontLeg = body.addOrReplaceChild("frontLeg", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, 6.0F, -4.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(28, 39).addBox(-1.0F, 4.1F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 39).addBox(-1.0F, 2.1F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 39).addBox(-1.0F, 4.1F, -4.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 39).addBox(0.0F, 2.1F, -4.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 39).addBox(2.0F, 4.1F, -4.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 39).addBox(2.0F, 2.1F, -3.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))

		.texOffs(38, 31).addBox(2.0F, 4.1F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(38, 23).addBox(1.0F, 2.1F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 26).addBox(0.0F, 1.1F, -3.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 0).addBox(-1.0F, -0.9F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(25, 8).addBox(-1.0F, 7.0F, 0.0F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 9).addBox(-2.0F, 7.0F, -4.0F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(3.0F, 7.0F, -4.0F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(19, 5).addBox(-1.0F, 7.0F, -5.0F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.75F, -4.375F, -2.995F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	private final ModelPart body;

	public ModelBlackGoat(ModelPart root) {
		this.body = root.getChild("body");
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(EntityBlackGoat entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}
}