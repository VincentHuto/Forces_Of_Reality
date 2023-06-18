package com.vincenthuto.forcesofreality.client.model.entity.guardian;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.common.entity.guardian.EntityMalformedAutomaton;

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

// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class ModelMalformedAutomaton extends EntityModel<EntityMalformedAutomaton> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ForcesOfReality.MOD_ID, "modelmalformedautomaton"), "main");
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(72, 57).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -17.0F, 0.0F));

		PartDefinition neck = partdefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(49, 63).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -17.0F, 0.0F));

		PartDefinition chest = partdefinition.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(91, 50).addBox(-2.9853F, 4.2721F, -5.0735F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(72, 72).addBox(-3.9853F, -0.7279F, -6.0735F, 8.0F, 5.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(6, 104).addBox(6.0147F, -14.7279F, -4.0735F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 11).addBox(-10.9853F, -10.7279F, -6.0735F, 22.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 11).addBox(-10.9853F, -1.7279F, -6.0735F, 22.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(54, 28).addBox(-3.9853F, -9.7279F, -6.0735F, 8.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(54, 11).addBox(-11.9853F, -9.7279F, 3.9265F, 23.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(78, 75).addBox(-2.9853F, -7.7279F, 4.9265F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(45, 65).addBox(-2.9853F, -7.7279F, 6.9265F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(72, 46).addBox(2.0147F, -7.7279F, 4.9265F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 65).addBox(2.0147F, -7.7279F, 6.9265F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(54, 24).addBox(-1.9853F, -3.7279F, 4.9265F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 63).addBox(-1.9853F, -3.7279F, 6.9265F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 85).addBox(-1.9853F, -8.7279F, 4.9265F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(39, 72).addBox(-1.9853F, -8.7279F, 6.9265F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(62, 87).addBox(-11.9853F, -9.7279F, -6.0735F, 1.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 80).addBox(11.0147F, -9.7279F, -6.0735F, 1.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 22).addBox(-9.9853F, -11.7279F, -6.0735F, 20.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.0147F, -5.2721F, 1.0735F));

		PartDefinition frontGear = chest.addOrReplaceChild("frontGear", CubeListBuilder.create().texOffs(0, 71).addBox(-2.0F, 2.0F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 71).addBox(2.0F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 71).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 71).addBox(-2.0F, 1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 71).addBox(-3.0F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 71).addBox(-2.0F, -3.0F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 71).addBox(-2.0F, -2.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 71).addBox(1.0F, 1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 71).addBox(1.0F, -2.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0147F, -5.7279F, -6.5735F));

		PartDefinition backGear = chest.addOrReplaceChild("backGear", CubeListBuilder.create().texOffs(83, 104).addBox(-0.9615F, 1.6154F, -0.5385F, 2.0F, 13.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(90, 37).addBox(-13.9615F, -1.3846F, -0.5385F, 12.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(88, 46).addBox(1.0385F, -1.3846F, -0.5385F, 13.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(91, 104).addBox(-0.9615F, -14.3846F, -0.5385F, 2.0F, 13.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 25).addBox(-11.9615F, -16.3846F, -0.5385F, 24.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 22).addBox(-11.9615F, 14.6154F, -0.5385F, 24.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 98).addBox(-15.9615F, -12.3846F, -0.5385F, 2.0F, 25.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 59).addBox(14.0385F, -12.3846F, -0.5385F, 2.0F, 25.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(46, 105).addBox(-13.9615F, -14.3846F, -0.5385F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 105).addBox(-13.9615F, 12.6154F, -0.5385F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 105).addBox(12.0385F, 12.6154F, -0.5385F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 105).addBox(12.0385F, -14.3846F, -0.5385F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 24).addBox(-1.9615F, -2.3846F, -1.5385F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.0238F, -5.3433F, 6.4649F));

		PartDefinition midLefFronPipe = chest.addOrReplaceChild("midLefFronPipe", CubeListBuilder.create().texOffs(69, 105).addBox(-7.0F, 3.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(73, 105).addBox(-7.0F, 3.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(77, 105).addBox(-7.0F, 4.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(74, 95).addBox(-7.0F, 3.0F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(105, 105).addBox(-7.0F, 2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(65, 105).addBox(-5.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(22, 105).addBox(-7.0F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(84, 20).addBox(-6.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(80, 33).addBox(-6.0F, 0.0F, 2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 105).addBox(-3.0F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0147F, -0.7279F, -4.0735F));

		PartDefinition midLefBackPipe = chest.addOrReplaceChild("midLefBackPipe", CubeListBuilder.create().texOffs(14, 105).addBox(-3.0F, 4.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(104, 34).addBox(-3.0F, 3.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(92, 8).addBox(-3.0F, 3.0F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 105).addBox(-3.0F, 3.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(102, 79).addBox(-3.0F, 2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(61, 105).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(76, 20).addBox(-2.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(68, 8).addBox(-2.0F, 0.0F, 2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(104, 102).addBox(1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(10, 105).addBox(-3.0F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0147F, -0.7279F, 0.9265F));

		PartDefinition midRightFronPipe = chest.addOrReplaceChild("midRightFronPipe", CubeListBuilder.create().texOffs(100, 94).addBox(-2.0F, 4.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(100, 34).addBox(-2.0F, 3.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(58, 100).addBox(-2.0F, 2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(54, 100).addBox(-2.0F, 3.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 88).addBox(-3.0F, 3.0F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(52, 105).addBox(-4.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(104, 87).addBox(-6.0F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(66, 54).addBox(-5.0F, 0.0F, 2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(104, 90).addBox(-2.0F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(16, 65).addBox(-5.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.9853F, -0.7279F, -4.0735F));

		PartDefinition midRightBackPipe = chest.addOrReplaceChild("midRightBackPipe", CubeListBuilder.create().texOffs(50, 100).addBox(-2.0F, 4.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(99, 65).addBox(-2.0F, 3.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 80).addBox(-3.0F, 3.0F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(37, 100).addBox(-2.0F, 3.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 99).addBox(-2.0F, 2.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 80).addBox(-4.0F, 0.0F, -3.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(99, 104).addBox(-2.0F, 0.0F, -3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(16, 63).addBox(-5.0F, 0.0F, -4.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(104, 79).addBox(-6.0F, 0.0F, -3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 65).addBox(-5.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.9853F, -0.7279F, 3.9265F));

		PartDefinition topLeftFrontPipe = chest.addOrReplaceChild("topLeftFrontPipe", CubeListBuilder.create().texOffs(6, 101).addBox(2.0F, 0.0F, -3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(80, 95).addBox(1.0F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(72, 75).addBox(1.0F, -2.0F, -3.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(84, 95).addBox(1.0F, 0.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(102, 94).addBox(-1.0F, -4.0F, -3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(72, 72).addBox(-2.0F, -3.0F, -3.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(98, 8).addBox(-1.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(88, 95).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(6, 98).addBox(-2.0F, 0.0F, -3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(92, 20).addBox(-3.0F, 0.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(88, 50).addBox(-3.0F, -2.0F, -3.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(98, 79).addBox(-4.0F, 0.0F, -3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(56, 103).addBox(0.0F, 0.0F, -3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(68, 94).addBox(-3.0F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0147F, -12.7279F, -1.0735F));

		PartDefinition topLeftBackPipe2 = chest.addOrReplaceChild("topLeftBackPipe2", CubeListBuilder.create().texOffs(0, 86).addBox(2.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(72, 4).addBox(1.0F, 0.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 33).addBox(1.0F, -2.0F, 1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(72, 0).addBox(1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(80, 28).addBox(-1.0F, -4.0F, 1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(54, 33).addBox(-2.0F, -3.0F, 1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(42, 50).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(15, 50).addBox(-1.0F, -3.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(72, 59).addBox(-2.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(6, 11).addBox(-3.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 80).addBox(-3.0F, -2.0F, 1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(39, 44).addBox(-4.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(12, 44).addBox(0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(6, 0).addBox(-3.0F, 0.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0147F, -12.7279F, -1.0735F));

		PartDefinition topRightShoulderPipe = chest.addOrReplaceChild("topRightShoulderPipe", CubeListBuilder.create().texOffs(96, 87).addBox(-5.0F, 0.0F, -3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(90, 87).addBox(-4.0F, 0.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(30, 95).addBox(-3.0F, 0.0F, -3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(96, 90).addBox(0.0F, 0.0F, -3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(90, 91).addBox(1.0F, 0.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(27, 33).addBox(1.0F, -2.0F, -3.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(24, 86).addBox(-4.0F, -2.0F, -3.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(4, 83).addBox(-1.0F, -4.0F, -3.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(4, 83).addBox(-2.0F, -4.0F, -3.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(4, 83).addBox(-1.0F, -4.0F, -3.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(18, 88).addBox(-1.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 88).addBox(-2.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 50).addBox(-3.0F, -3.0F, -3.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(28, 85).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 85).addBox(-2.0F, -3.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(5, 88).addBox(1.0F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(84, 28).addBox(-4.0F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.9853F, -12.7279F, 0.9265F));

		PartDefinition topBarF = chest.addOrReplaceChild("topBarF", CubeListBuilder.create().texOffs(74, 87).addBox(4.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(56, 4).addBox(-11.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0147F, -7.7279F, -4.0735F));

		PartDefinition topBarBottom = chest.addOrReplaceChild("topBarBottom", CubeListBuilder.create().texOffs(90, 41).addBox(-11.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(54, 46).addBox(4.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0147F, -4.7279F, -2.0735F));

		PartDefinition topBarB = chest.addOrReplaceChild("topBarB", CubeListBuilder.create().texOffs(74, 91).addBox(-11.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(56, 0).addBox(4.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0147F, -7.7279F, -0.0735F));

		PartDefinition rightArm = chest.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(52, 54).addBox(-4.0F, -3.0F, -3.0F, 4.0F, 14.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(56, 65).addBox(-1.0F, 11.0F, -3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(56, 65).addBox(-4.0F, 11.0F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(56, 65).addBox(-3.0F, 11.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(52, 74).addBox(-2.0F, 11.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 74).addBox(-1.0F, 11.0F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 74).addBox(-4.0F, 11.0F, -2.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(94, 50).addBox(-6.0F, -5.0F, -4.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 94).addBox(-5.0F, -5.0F, -5.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 33).addBox(-7.0F, -5.0F, -3.0F, 2.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(24, 88).addBox(-6.0F, -6.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(54, 50).addBox(-5.0F, -6.0F, -4.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(92, 0).addBox(-5.0F, -7.0F, -3.0F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(56, 8).addBox(-5.0F, -6.0F, 3.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(46, 54).addBox(-5.0F, -5.0F, 4.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(92, 0).addBox(-6.0F, -5.0F, 3.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.9853F, -4.7279F, -1.0735F));

		PartDefinition leftArm = chest.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(32, 54).addBox(-1.0F, -3.0F, -3.0F, 4.0F, 34.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(96, 87).addBox(4.0F, -6.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(96, 14).addBox(-1.0F, -7.0F, -3.0F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(102, 8).addBox(-1.0F, -5.0F, 4.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(37, 94).addBox(4.0F, -5.0F, 3.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(66, 57).addBox(-1.0F, -6.0F, 3.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 20).addBox(-1.0F, -6.0F, -4.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(100, 28).addBox(-1.0F, -5.0F, -5.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(27, 33).addBox(4.0F, -5.0F, -3.0F, 2.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(96, 60).addBox(4.0F, -5.0F, -4.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(13.0147F, -4.7279F, -1.0735F));

		PartDefinition hips = partdefinition.addOrReplaceChild("hips", CubeListBuilder.create().texOffs(84, 87).addBox(3.0F, 0.5F, -5.0F, 1.0F, 7.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(66, 0).addBox(-4.0F, -0.5F, -5.0F, 8.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(66, 46).addBox(-3.0F, 7.5F, -5.0F, 6.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(12, 88).addBox(-4.0F, 0.5F, -5.0F, 1.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.5F, 0.0F));

		PartDefinition rightLeg = hips.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(32, 71).addBox(-5.0F, -18.0F, -4.0F, 1.0F, 12.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(44, 78).addBox(-8.0F, -18.0F, 3.0F, 3.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(41, 68).addBox(-7.0F, -7.0F, 2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(41, 68).addBox(-7.0F, -7.0F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(41, 68).addBox(-8.0F, -7.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(33, 81).addBox(-8.0F, -19.0F, -3.0F, 3.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(38, 73).addBox(-8.0F, -18.0F, -4.0F, 3.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.5F, 0.0F));

		PartDefinition tread = rightLeg.addOrReplaceChild("tread", CubeListBuilder.create().texOffs(0, 22).addBox(-6.0F, -4.0F, 13.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 47).addBox(-5.0F, -5.0F, -5.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(5, 34).addBox(-3.0F, -5.0F, -5.0F, 1.0F, 1.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(0, 27).addBox(-6.0F, -4.0F, -6.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(1, 34).addBox(-6.0F, 0.0F, -5.0F, 4.0F, 1.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(0, 35).addBox(-4.0F, -5.0F, -5.0F, 0.0F, 5.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(7, 34).addBox(-6.0F, -5.0F, -5.0F, 1.0F, 1.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(17, 47).addBox(-5.0F, -5.0F, 8.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(20, 42).addBox(-4.0F, -17.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(22, 36).addBox(-4.0F, -16.0F, 2.0F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(22, 36).addBox(-4.0F, -16.0F, 5.0F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -1.0F, -4.0F));

		PartDefinition legBar = rightLeg.addOrReplaceChild("legBar", CubeListBuilder.create().texOffs(17, 28).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -8.0F, 0.0F));

		PartDefinition frontWheel = rightLeg.addOrReplaceChild("frontWheel", CubeListBuilder.create().texOffs(37, 33).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(24, 95).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(62, 94).addBox(-1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -3.0F, -7.0F));

		PartDefinition middleWheel = rightLeg.addOrReplaceChild("middleWheel", CubeListBuilder.create().texOffs(37, 33).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(24, 95).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(62, 94).addBox(-1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -3.0F, 0.0F));

		PartDefinition backWheel = rightLeg.addOrReplaceChild("backWheel", CubeListBuilder.create().texOffs(10, 33).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(24, 91).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(90, 60).addBox(-1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -3.0F, 7.0F));

		PartDefinition leftLeg = hips.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(96, 60).addBox(0.0F, -1.9091F, -3.9545F, 4.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(34, 94).addBox(0.0F, 13.0909F, -3.9545F, 4.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(80, 28).addBox(-1.0F, 16.0909F, -3.9545F, 6.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 19).addBox(0.0F, 16.0909F, -4.9545F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 8).addBox(0.0F, 16.0909F, 4.0455F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 11).addBox(1.0F, 7.0909F, -2.9545F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(1.0F, 2.0909F, 1.0455F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(27, 44).addBox(0.0F, 4.0909F, -3.9545F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 44).addBox(0.0F, 8.0909F, 0.0455F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(16, 59).addBox(1.0F, 2.0909F, -2.9545F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 59).addBox(1.0F, 11.0909F, 1.0455F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 4.4091F, -0.0455F));

		PartDefinition lowBarF = hips.addOrReplaceChild("lowBarF", CubeListBuilder.create().texOffs(17, 28).addBox(-5.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 5.5F, 0.0F));

		PartDefinition lowBarB = hips.addOrReplaceChild("lowBarB", CubeListBuilder.create().texOffs(98, 71).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.5F, -2.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	private final ModelPart head;
	private final ModelPart neck;
	private final ModelPart chest;

	private final ModelPart hips;

	public ModelMalformedAutomaton(ModelPart root) {
		this.head = root.getChild("head");
		this.neck = root.getChild("neck");
		this.chest = root.getChild("chest");
		this.hips = root.getChild("hips");
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		neck.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		chest.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		hips.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(EntityMalformedAutomaton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}
}