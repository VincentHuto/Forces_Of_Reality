package com.huto.hutosmod.objects.items;

import com.huto.hutosmod.capabilities.covenant.CovenantProvider;
import com.huto.hutosmod.capabilities.covenant.EnumCovenants;
import com.huto.hutosmod.capabilities.covenant.ICovenant;
import com.huto.hutosmod.capabilities.mindrunes.IRune;
import com.huto.hutosmod.capabilities.mindrunes.RuneType;
import com.huto.hutosmod.init.ItemInit;
import com.huto.hutosmod.network.CovenantPacketServer;
import com.huto.hutosmod.network.PacketHandler;
import com.huto.hutosmod.objects.items.runes.ItemContractRune;
import com.huto.hutosmod.render.rune.IRenderRunes;
import com.huto.hutosmod.sounds.SoundHandler;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.PacketDistributor;

public class ItemCrossedKeys extends ItemContractRune implements IRune, IRenderRunes {

	public ItemCrossedKeys(Properties properties, EnumCovenants covenIn) {
		super(properties, covenIn);
		properties.rarity(Rarity.UNCOMMON);
	}

	@Override
	public boolean willAutoSync(LivingEntity player) {
		return true;
	}

	@Override
	public void onWornTick(LivingEntity player) {
	}

	@Override
	public RuneType getRuneType() {
		return RuneType.CONTRACT;
	}

	@Override
	public void onEquipped(LivingEntity player) {
		super.onEquipped(player);
		player.playSound(SoundHandler.ENTITY_SERAPHIM_FLARE, 1F, 1.9f);
		if (player instanceof PlayerEntity) {
			if (!player.getEntityWorld().isRemote) {
				ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
						.orElseThrow(IllegalArgumentException::new);
				if (coven != null) {
					coven.setCovenDevotion(getAssignedCovenant(),
							(coven.getDevotionByCoven(getAssignedCovenant()) + 10));
					PlayerEntity playerEnt = (PlayerEntity) player;
					playerEnt.sendStatusMessage(new StringTextComponent(
							TextFormatting.AQUA + "You hear the clang of bells in the distance"), true);
					PacketHandler.CHANNELCOVENANT.send(
							PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) playerEnt),
							new CovenantPacketServer(coven.getDevotion()));

				}
			}
		}
	}

	@Override
	public void onUnequipped(LivingEntity player) {
		super.onUnequipped(player);
		player.playSound(SoundHandler.ENTITY_SERAPHIM_DEATH, 1F, 1f);
		if (player instanceof PlayerEntity) {
			if (!player.getEntityWorld().isRemote) {
				ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
						.orElseThrow(IllegalArgumentException::new);
				if (coven != null) {
					coven.setCovenDevotion(getAssignedCovenant(),
							(coven.getDevotionByCoven(getAssignedCovenant()) - 10));
					PlayerEntity playerEnt = (PlayerEntity) player;
					playerEnt.sendStatusMessage(
							new StringTextComponent(TextFormatting.AQUA + "You hear an angelic screech in your minds"),
							true);
					PacketHandler.CHANNELCOVENANT.send(
							PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) playerEnt),
							new CovenantPacketServer(coven.getDevotion()));
				}
			}
		}
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return false;
	}
/*
	@Override
	@OnlyIn(Dist.CLIENT)
	public void doRender(BipedModel<?> bipedModel, ItemStack stack, LivingEntity living, MatrixStack ms,
			IRenderTypeBuffer buffers, int light, float limbSwing, float limbSwingAmount, float partialTicks,
			float ageInTicks, float netHeadYaw, float headPitch) {
		bipedModel.bipedHead.translateRotate(ms);
		ms.translate(-0.25, -0.4, 0);
		ms.scale(0.5F, -0.5F, -0.5F);
		Minecraft.getInstance().getBlockRendererDispatcher().renderBlock(ModBlocks.tinyPlanet.getDefaultState(), ms,
				buffers, light, OverlayTexture.NO_OVERLAY);
	}*/

	@Override
	@OnlyIn(Dist.CLIENT)
	public void onPlayerRuneRender(MatrixStack matrix, int packedLightIn, IRenderTypeBuffer buffer, PlayerEntity player,
			RenderType type, float partialTicks) {
		if (type == RenderType.HEAD) {
			// boolean armor =
			// !player.getItemStackFromSlot(EquipmentSlotType.HEAD).isEmpty();
			RenderHelper.enableStandardItemLighting();
			matrix.rotate(Vector3f.XN.rotationDegrees(180f));
			matrix.scale(0.5f, 0.5f, 0.5f);
			matrix.translate(0, 1, 0.5);
			Minecraft.getInstance().getItemRenderer().renderItem(new ItemStack(ItemInit.crossed_keys.get()),
					TransformType.FIXED, packedLightIn,OverlayTexture.NO_OVERLAY, matrix, buffer);

		}
	}

}
