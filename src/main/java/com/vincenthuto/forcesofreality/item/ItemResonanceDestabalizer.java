package com.vincenthuto.forcesofreality.item;

import java.util.List;
import java.util.Optional;

import javax.annotation.Nullable;

import com.vincenthuto.forcesofreality.init.SoundInit;
import com.vincenthuto.hutoslib.math.DimensionalPosition;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class ItemResonanceDestabalizer extends Item {

	public static Optional<DimensionalPosition> getLastPosition(Player player) {
		CompoundTag data = player.getPersistentData();
		if (!data.contains("dim-lastpos")) {
			return Optional.empty();
		}
		CompoundTag pos = data.getCompound("dim-lastpos");
		return Optional.of(DimensionalPosition.fromNBT(pos));
	}

	public static void setLastPosition(Player player) {
		CompoundTag data = player.getPersistentData();
		BlockPos pos = player.blockPosition();
		ResourceLocation dim = player.level.dimension().location();
		DimensionalPosition dp = new DimensionalPosition(dim, pos);
		CompoundTag dimNbt = dp.serializeNBT();
		data.put("dim-lastpos", dimNbt);
	}

	public ItemResonanceDestabalizer(Properties properties) {
		super(properties);
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		super.appendHoverText(stack, worldIn, tooltip, flagIn);

		if (!Screen.hasShiftDown()) {
			tooltip.add(Component.translatable("Shift to set a home!").withStyle(ChatFormatting.YELLOW));
			tooltip.add(Component.translatable("Righ Click to return to it.").withStyle(ChatFormatting.GOLD));
			tooltip.add(Component.translatable("But what shall you lose?").withStyle(ChatFormatting.WHITE));
		}
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		ItemStack stack = player.getItemInHand(hand);
		if (hand == InteractionHand.OFF_HAND) {
			return InteractionResultHolder.fail(stack);
		}
		if (!world.isClientSide && player instanceof ServerPlayer) {
			ServerPlayer serverPlayer = (ServerPlayer) player;
			if (player.isShiftKeyDown()) {
				setLastPosition(player);
				serverPlayer.displayClientMessage(
						Component.translatable("Home Set to: " + getLastPosition(serverPlayer).get().getPosition()
								+ getLastPosition(serverPlayer).get().getDimension()),
						true);

			} else {

				Optional<DimensionalPosition> lastPos = getLastPosition(serverPlayer);
				if (!lastPos.isPresent()) {
					serverPlayer.displayClientMessage(Component.translatable("no_prev_position"), true);
				} else {
					DimensionalPosition p = lastPos.get();
					BlockPos bp = p.getPosition();
					ResourceLocation dimRL = p.getDimension();
					ResourceKey<Level> key = ResourceKey.create(Registry.DIMENSION_REGISTRY, dimRL);
					ServerLevel ovw = world.getServer().getLevel(key);
					serverPlayer.teleportTo(ovw, bp.getX() + 0.5, bp.getY(), bp.getZ() + 0.5, serverPlayer.getYRot(),
							serverPlayer.getXRot());
//					ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
//							.orElseThrow(NullPointerException::new);
//
//					for (EnumCovenants cov : coven.getDevotion().keySet()) {
//						coven.getDevotion().put(cov, 0);
//					}
//					serverPlayer.setExperienceLevels(0);
//					PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) player),
//							new CovenantPacketServer(coven.getDevotion()));
//
//				}
				}
				player.displayClientMessage(
						Component.translatable(
								ChatFormatting.RED + "Suddenly, you feel as if all you have gained was for naught."),
						true);

				player.playSound(SoundInit.ENTITY_SERAPHIM_DEATH.get(), 0.6F, 0.8F);
			}
		
		}
		return InteractionResultHolder.success(stack);

	}

}