package com.huto.forcesofreality.item.coven.sign;

import com.huto.forcesofreality.capabilitie.adornment.IAdornment;
import com.huto.forcesofreality.capabilitie.covenant.CovenantProvider;
import com.huto.forcesofreality.capabilitie.covenant.EnumCovenants;
import com.huto.forcesofreality.capabilitie.covenant.ICovenant;
import com.huto.forcesofreality.init.ItemInit;
import com.huto.forcesofreality.item.ItemMajorAdornment;
import com.huto.forcesofreality.network.PacketHandler;
import com.huto.forcesofreality.network.coven.CovenantPacketServer;
import com.huto.forcesofreality.network.coven.SetFlyPKT;
import com.huto.forcesofreality.render.entity.layer.IRenderAdornments;
import com.huto.forcesofreality.sound.SoundHandler;
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
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.PacketDistributor;

public class ItemCrossedKeys extends ItemMajorAdornment implements IAdornment, IRenderAdornments {

	public ItemCrossedKeys(Properties properties, EnumCovenants covenIn, int deepenAmount) {
		super(properties, covenIn, deepenAmount);

		properties.rarity(Rarity.UNCOMMON);
	}

	public static void updateClientServerFlight(ServerPlayerEntity player, boolean allowFlying) {
		updateClientServerFlight(player, allowFlying, allowFlying && player.abilities.isFlying);
	}

	public static void updateClientServerFlight(ServerPlayerEntity player, boolean allowFlying, boolean isFlying) {
		PacketHandler.HANDLER.sendToServer(new SetFlyPKT(allowFlying, isFlying));
		player.abilities.allowFlying = allowFlying;
		player.abilities.isFlying = isFlying;
	}

	@Override
	public boolean willAutoSync(LivingEntity player) {
		return true;
	}

	@Override
	public void onWornTick(LivingEntity player) {
	}

	@Override
	public void onEquipped(LivingEntity player) {
		player.playSound(SoundHandler.ENTITY_SERAPHIM_FLARE, 1F, 1.9f);
		if (player instanceof PlayerEntity) {
			if (!player.getEntityWorld().isRemote) {
				ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
						.orElseThrow(IllegalArgumentException::new);
				if (coven != null) {
					coven.setCovenDevotion(getAssignedCovenant(), getDeepenAmount());
					PlayerEntity playerEnt = (PlayerEntity) player;
					playerEnt.sendStatusMessage(new StringTextComponent(
							TextFormatting.AQUA + "You hear the clang of bells in the distance"), true);
					PacketHandler.CHANNELCOVENANT.send(
							PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) playerEnt),
							new CovenantPacketServer(coven.getDevotion()));
					if (!((PlayerEntity) player).isCreative()) {
						updateClientServerFlight((ServerPlayerEntity) player, true);
					}
				}
			}
		}
	}

	@Override
	public void onUnequipped(LivingEntity player) {
		player.playSound(SoundHandler.ENTITY_SERAPHIM_DEATH, 1F, 1f);
		if (player instanceof PlayerEntity) {
			if (!player.getEntityWorld().isRemote) {
				ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
						.orElseThrow(IllegalArgumentException::new);
				if (coven != null) {
					coven.setCovenDevotion(getAssignedCovenant(), -getDeepenAmount());

					PlayerEntity playerEnt = (PlayerEntity) player;
					playerEnt.sendStatusMessage(
							new StringTextComponent(TextFormatting.AQUA + "You hear an angelic screech in your minds"),
							true);
					PacketHandler.CHANNELCOVENANT.send(
							PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) playerEnt),
							new CovenantPacketServer(coven.getDevotion()));
					if (!((PlayerEntity) player).isCreative()) {
						updateClientServerFlight((ServerPlayerEntity) player, false, false);
					}
				}
			}
		}
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return false;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void onPlayerAdornmentRender(MatrixStack matrix, int packedLightIn, IRenderTypeBuffer buffer, PlayerEntity player,
			RenderType type, float partialTicks) {
		if (type == RenderType.HEAD) {
			// boolean armor =
			// !player.getItemStackFromSlot(EquipmentSlotType.HEAD).isEmpty();
			RenderHelper.enableStandardItemLighting();
			matrix.rotate(Vector3f.XN.rotationDegrees(180f));
			matrix.scale(0.5f, 0.5f, 0.5f);
			matrix.translate(0, 1, 0.5);
			Minecraft.getInstance().getItemRenderer().renderItem(new ItemStack(ItemInit.crossed_keys.get()),
					TransformType.FIXED, packedLightIn, OverlayTexture.NO_OVERLAY, matrix, buffer);

		}
	}
	
	@Override
	public EnumCovenants getAssignedCovenant() {
		return EnumCovenants.ASCENDANT;
	}

}
