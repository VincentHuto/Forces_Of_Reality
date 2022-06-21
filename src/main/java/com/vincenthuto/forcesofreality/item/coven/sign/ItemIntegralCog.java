package com.vincenthuto.forcesofreality.item.coven.sign;

import com.vincenthuto.forcesofreality.capa.covenant.EnumCovenants;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class ItemIntegralCog extends Item /* implements IAdornment, IRenderAdornments */ {

	public ItemIntegralCog(Properties properties, EnumCovenants covenIn, int deepenAmount) {
		super(properties);

		properties.rarity(Rarity.UNCOMMON);
	}

//	@Override
//	public EnumCovenants getAssignedCovenant() {
//		return EnumCovenants.MACHINE;
//	}

	@Override
	public boolean isFoil(ItemStack stack) {
		return false;
	}

//	@Override
//	public void onEquipped(LivingEntity player) {
//		player.playSound(SoundEvents.PISTON_EXTEND, .25F, 1f);
//		if (player instanceof Player) {
//			if (!player.getCommandSenderWorld().isClientSide) {
//				ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
//						.orElseThrow(IllegalArgumentException::new);
//				if (coven != null) {
//					coven.setCovenDevotion(getAssignedCovenant(), getDeepenAmount());
//
//					Player playerEnt = (Player) player;
//					playerEnt.displayClientMessage(
//							Component.translatable(ChatFormatting.GOLD + "The gears in your mind spin freely"), true);
//					PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) playerEnt),
//							new CovenantPacketServer(coven.getDevotion()));
//
//				}
//			}
//		}
//	}
//
//	@Override
//	public void onPlayerAdornmentRender(PoseStack matrix, int packedLightIn, MultiBufferSource buffer, Player player,
//			RenderType type, float partialTicks) {
//		if (type == RenderType.HEAD) {
//			// boolean armor =
//			// !player.getItemStackFromSlot(EquipmentSlotType.HEAD).isEmpty();
//			matrix.mulPose(Vector3f.XN.rotationDegrees(180f));
//			matrix.scale(0.5f, 0.5f, 0.5f);
//			matrix.translate(0, 0.8, 0.5);
//			Minecraft.getInstance().getItemRenderer().renderStatic(new ItemStack(ItemInit.integral_cog.get()),
//					TransformType.FIXED, packedLightIn, OverlayTexture.NO_OVERLAY, matrix, buffer);
//
//		}
//	}
//
//	@Override
//	public void onUnequipped(LivingEntity player) {
//		player.playSound(SoundEvents.REDSTONE_TORCH_BURNOUT, .25F, 1f);
//		if (player instanceof Player) {
//			if (!player.getCommandSenderWorld().isClientSide) {
//				ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
//						.orElseThrow(IllegalArgumentException::new);
//				if (coven != null) {
//					coven.setCovenDevotion(getAssignedCovenant(), -getDeepenAmount());
//
//					Player playerEnt = (Player) player;
//					playerEnt.displayClientMessage(
//							Component.translatable(ChatFormatting.GOLD + "You feel as if your short circuiting"), true);
//					PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) playerEnt),
//							new CovenantPacketServer(coven.getDevotion()));
//
//				}
//			}
//		}
//
//	}
//
//	@Override
//	public void onWornTick(LivingEntity player) {
//	}
//
//	@Override
//	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
//
//		return super.use(worldIn, playerIn, handIn);
//	}
//
//	@Override
//	public boolean willAutoSync(LivingEntity player) {
//		return true;
//	}

}
