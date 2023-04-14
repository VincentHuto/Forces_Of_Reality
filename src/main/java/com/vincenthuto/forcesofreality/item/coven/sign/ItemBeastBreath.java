package com.vincenthuto.forcesofreality.item.coven.sign;

import com.vincenthuto.forcesofreality.capa.covenant.EnumCovenants;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class ItemBeastBreath extends Item /* implements IAdornment, IRenderAdornments */ {

	public ItemBeastBreath(Properties properties, EnumCovenants covenIn, int deepenAmount) {
		super(properties);

		properties.rarity(Rarity.UNCOMMON);
	}




	@Override
	public boolean isFoil(ItemStack stack) {
		return false;
	}
//
//	@Override
//	public void onEquipped(LivingEntity player) {
//		player.playSound(SoundEvents.WOLF_HOWL, .25F, 1f);
//		if (player instanceof Player) {
//			if (!player.getCommandSenderWorld().isClientSide) {
//				ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
//						.orElseThrow(IllegalArgumentException::new);
//				if (coven != null) {
//					coven.setCovenDevotion(getAssignedCovenant(), getDeepenAmount());
//					Player playerEnt = (Player) player;
//					playerEnt.displayClientMessage(
//							Component.translatable(
//									ChatFormatting.DARK_RED + "The Howl of a Great Beast can be Heard in the Distance"),
//							true);
//					PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) playerEnt),
//							new PacketCovenantServer(coven.getDevotion()));
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
//			// !player.getItemStackFromSlot(ArmorItem.TypeType.HEAD).isEmpty();
//			matrix.mulPose(Vector3.XN.rotationDegrees(180f).toMoj());
//			matrix.scale(0.5f, 0.5f, 0.5f);
//			matrix.translate(0, 0.8, 0.5);
//			Minecraft.getInstance().getItemRenderer().renderStatic(new ItemStack(ItemInit.breath_of_the_beast.get()),
//					ItemDisplayContext.FIXED, packedLightIn, OverlayTexture.NO_OVERLAY, matrix, buffer);
//
//		}
//	}
//
//	@Override
//	public void onUnequipped(LivingEntity player) {
//		player.playSound(SoundEvents.WOLF_GROWL, .25F, 1f);
//		if (player instanceof Player) {
//			if (!player.getCommandSenderWorld().isClientSide) {
//				ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
//						.orElseThrow(IllegalArgumentException::new);
//				if (coven != null) {
//					coven.setCovenDevotion(getAssignedCovenant(), -getDeepenAmount());
//
//					Player playerEnt = (Player) player;
//					playerEnt.displayClientMessage(
//							Component.translatable(ChatFormatting.DARK_RED + "The Hunt has begun..."), true);
//					PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) playerEnt),
//							new PacketCovenantServer(coven.getDevotion()));
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
