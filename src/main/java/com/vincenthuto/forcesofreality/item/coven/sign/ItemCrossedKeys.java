package com.vincenthuto.forcesofreality.item.coven.sign;

import com.vincenthuto.forcesofreality.capa.covenant.EnumCovenants;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class ItemCrossedKeys extends Item /* implements IAdornment, IRenderAdornments */ {
//
//	public static void updateClientServerFlight(ServerPlayer player, boolean allowFlying) {
//		updateClientServerFlight(player, allowFlying, allowFlying && player.abilities.flying);
//	}
//
//	public static void updateClientServerFlight(ServerPlayer player, boolean allowFlying, boolean isFlying) {
//		PacketHandler.HANDLER.sendToServer(new SetFlyPKT(allowFlying, isFlying));
//		player.abilities.mayfly = allowFlying;
//		player.abilities.flying = isFlying;
//	}

	public ItemCrossedKeys(Properties properties, EnumCovenants covenIn, int deepenAmount) {
		super(properties);
		properties.rarity(Rarity.UNCOMMON);
	}
//
//	@Override
//	public EnumCovenants getAssignedCovenant() {
//		return EnumCovenants.ASCENDANT;
//	}
//
//	@Override
//	public boolean isFoil(ItemStack stack) {
//		return false;
//	}
//
//	@Override
//	public void onEquipped(LivingEntity player) {
//		player.playSound(SoundInit.ENTITY_SERAPHIM_FLARE, 1F, 1.9f);
//		if (player instanceof Player) {
//			if (!player.getCommandSenderWorld().isClientSide) {
//				ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
//						.orElseThrow(IllegalArgumentException::new);
//				if (coven != null) {
//					coven.setCovenDevotion(getAssignedCovenant(), getDeepenAmount());
//					Player playerEnt = (Player) player;
//					playerEnt.displayClientMessage(
//							Component.translatable(ChatFormatting.AQUA + "You hear the clang of bells in the distance"),
//							true);
//					PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) playerEnt),
//							new PacketCovenantServer(coven.getDevotion()));
//					if (!((Player) player).isCreative()) {
//						updateClientServerFlight((ServerPlayer) player, true);
//					}
//				}
//			}
//		}
//	}
//
//	@Override
//	@OnlyIn(Dist.CLIENT)
//	public void onPlayerAdornmentRender(PoseStack matrix, int packedLightIn, MultiBufferSource buffer, Player player,
//			RenderType type, float partialTicks) {
//		if (type == RenderType.HEAD) {
//			// boolean armor =
//			// !player.getItemStackFromSlot(ArmorItem.TypeType.HEAD).isEmpty();
//			Lighting.turnBackOn();
//			matrix.mulPose(Vector3.XN.rotationDegrees(180f).toMoj());
//			matrix.scale(0.5f, 0.5f, 0.5f);
//			matrix.translate(0, 1, 0.5);
//			Minecraft.getInstance().getItemRenderer().renderStatic(new ItemStack(ItemInit.crossed_keys.get()),
//					ItemDisplayContext.FIXED, packedLightIn, OverlayTexture.NO_OVERLAY, matrix, buffer);
//
//		}
//	}
//
//	@Override
//	public void onUnequipped(LivingEntity player) {
//		player.playSound(SoundInit.ENTITY_SERAPHIM_DEATH, 1F, 1f);
//		if (player instanceof Player) {
//			if (!player.getCommandSenderWorld().isClientSide) {
//				ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
//						.orElseThrow(IllegalArgumentException::new);
//				if (coven != null) {
//					coven.setCovenDevotion(getAssignedCovenant(), -getDeepenAmount());
//
//					Player playerEnt = (Player) player;
//					playerEnt.displayClientMessage(
//							Component.translatable(ChatFormatting.AQUA + "You hear an angelic screech in your mind"),
//							true);
//					PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) playerEnt),
//							new PacketCovenantServer(coven.getDevotion()));
//					if (!((Player) player).isCreative()) {
//						updateClientServerFlight((ServerPlayer) player, false, false);
//					}
//				}
//			}
//		}
//	}
//
//	@Override
//	public void onWornTick(LivingEntity player) {
//	}
//
//	@Override
//	public boolean willAutoSync(LivingEntity player) {
//		return true;
//	}

}
