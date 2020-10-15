package com.huto.hutosmod.objects.items;

import java.util.List;
import java.util.Optional;

import javax.annotation.Nullable;

import com.huto.hutosmod.dimension.DimensionalPosition;
import com.huto.hutosmod.sounds.SoundHandler;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class ItemResonanceDestabalizer extends Item {

	public ItemResonanceDestabalizer(Properties properties) {
		super(properties);
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip,
			ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);

		if (!Screen.hasShiftDown()) {
			tooltip.add(new TranslationTextComponent("Shift to set a home!").mergeStyle(TextFormatting.YELLOW));
			tooltip.add(new TranslationTextComponent("Righ Click to return to it.").mergeStyle(TextFormatting.GOLD));
			tooltip.add(new TranslationTextComponent("But what shall you lose?").mergeStyle(TextFormatting.WHITE));
		}
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
		ItemStack stack = player.getHeldItem(hand);
		if (hand == Hand.OFF_HAND) {
			return ActionResult.resultFail(stack);
		}
		if (!world.isRemote && player instanceof ServerPlayerEntity) {
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
			if (player.isSneaking()) {
				setLastPosition(player);
				serverPlayer.sendStatusMessage(
						new TranslationTextComponent("Home Set to: " + getLastPosition(serverPlayer).get().getPosition()
								+ getLastPosition(serverPlayer).get().getDimension()),
						true);

			} else {

				Optional<DimensionalPosition> lastPos = getLastPosition(serverPlayer);
				if (!lastPos.isPresent()) {
					serverPlayer.sendStatusMessage(new TranslationTextComponent("no_prev_position"), true);
				} else {
					DimensionalPosition p = lastPos.get();
					BlockPos bp = p.getPosition();
					ResourceLocation dimRL = p.getDimension();
					RegistryKey<World> key = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, dimRL);
					ServerWorld ovw = world.getServer().getWorld(key);
					serverPlayer.teleport(ovw, bp.getX() + 0.5, bp.getY(), bp.getZ() + 0.5, serverPlayer.rotationYaw,
							serverPlayer.rotationPitch);

					world.playSound(serverPlayer, serverPlayer.getPosition(), SoundHandler.ENTITY_SERAPHIM_DEATH,
							SoundCategory.PLAYERS, 1.0f, 1.0f);

				}
			}
		}

		return ActionResult.resultSuccess(stack);
	}

	public static Optional<DimensionalPosition> getLastPosition(PlayerEntity player) {
		CompoundNBT data = player.getPersistentData();
		if (!data.contains("dim-lastpos")) {
			return Optional.empty();
		}
		CompoundNBT pos = data.getCompound("dim-lastpos");
		return Optional.of(DimensionalPosition.fromNBT(pos));
	}

	public static void setLastPosition(PlayerEntity player) {
		CompoundNBT data = player.getPersistentData();
		BlockPos pos = player.getPosition();
		ResourceLocation dim = player.world.getDimensionKey().getLocation();
		DimensionalPosition dp = new DimensionalPosition(dim, pos);
		CompoundNBT dimNbt = dp.serializeNBT();
		data.put("dim-lastpos", dimNbt);
	}

}
