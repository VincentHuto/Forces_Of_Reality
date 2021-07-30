package com.huto.forcesofreality.item.coven.sign;

import com.huto.forcesofreality.capabilitie.adornment.IAdornment;
import com.huto.forcesofreality.capabilitie.covenant.CovenantProvider;
import com.huto.forcesofreality.capabilitie.covenant.EnumCovenants;
import com.huto.forcesofreality.capabilitie.covenant.ICovenant;
import com.huto.forcesofreality.init.ItemInit;
import com.huto.forcesofreality.item.ItemMajorAdornment;
import com.huto.forcesofreality.network.PacketHandler;
import com.huto.forcesofreality.network.coven.CovenantPacketServer;
import com.huto.forcesofreality.render.entity.layer.IRenderAdornments;
import com.huto.forcesofreality.sound.SoundHandler;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.PacketDistributor;

import net.minecraft.world.item.Item.Properties;

public class ItemYellowSign extends ItemMajorAdornment implements IAdornment, IRenderAdornments {

	public ItemYellowSign(Properties properties, EnumCovenants covenIn, int deepenAmount) {
		super(properties, covenIn, deepenAmount);

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
	public void onEquipped(LivingEntity player) {
		player.playSound(SoundHandler.ENTITY_HASTUR_HURT, 1F, 1f);
		if (player instanceof Player) {
			if (!player.getEntityWorld().isRemote) {
				ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
						.orElseThrow(IllegalArgumentException::new);
				if (coven != null) {
					coven.setCovenDevotion(getAssignedCovenant(), getDeepenAmount());

					PlayerEntity playerEnt = (PlayerEntity) player;
					playerEnt.sendStatusMessage(
							new StringTextComponent(TextFormatting.YELLOW + "Lord Hastur Accepts your Fealty"), true);
					PacketHandler.CHANNELCOVENANT.send(
							PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) playerEnt),
							new CovenantPacketServer(coven.getDevotion()));

				}
			}
		}
	}

	@Override
	public void onUnequipped(LivingEntity player) {
		player.playSound(SoundHandler.ENTITY_HASTUR_AMBIENT, 1F, 1f);
		if (player instanceof PlayerEntity) {
			if (!player.getEntityWorld().isRemote) {
				ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
						.orElseThrow(IllegalArgumentException::new);
				if (coven != null) {
					coven.setCovenDevotion(getAssignedCovenant(), -getDeepenAmount());

					PlayerEntity playerEnt = (PlayerEntity) player;
					playerEnt.sendStatusMessage(
							new StringTextComponent(TextFormatting.YELLOW + "Lord Hastur Renounces your Fealty"), true);
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

	@Override
	public void onPlayerAdornmentRender(MatrixStack matrix, int packedLightIn, IRenderTypeBuffer buffer, PlayerEntity player,
			RenderType type, float partialTicks) {
		if (type == RenderType.HEAD) {
			// boolean armor =
			// !player.getItemStackFromSlot(EquipmentSlotType.HEAD).isEmpty();
			matrix.rotate(Vector3f.XN.rotationDegrees(180f));
			matrix.scale(0.5f, 0.5f, 0.5f);
			matrix.translate(0, 1, 0.5);
			Minecraft.getInstance().getItemRenderer().renderItem(new ItemStack(ItemInit.yellow_sign.get()),
					TransformType.FIXED, packedLightIn, OverlayTexture.NO_OVERLAY, matrix, buffer);

		}
	}

	@Override
	public EnumCovenants getAssignedCovenant() {
		return EnumCovenants.HASTUR;
	}
}
