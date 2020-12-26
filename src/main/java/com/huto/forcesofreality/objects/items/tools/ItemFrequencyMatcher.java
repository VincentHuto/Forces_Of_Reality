package com.huto.forcesofreality.objects.items.tools;

import java.util.List;

import com.huto.forcesofreality.objects.tileenties.util.VanillaPacketDispatcher;
import com.huto.forcesofreality.objects.tileenties.vibes.gen.TileEntityAbsorber;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class ItemFrequencyMatcher extends Item {

	public static BlockPos linkedPos;
	public static String TAG_POS = "LinkedPos";
	public static String TAG_POS_NAME = "PosName";
	public static boolean state;
	public static String TAG_STATE = "state";

	public ItemFrequencyMatcher(Properties prop) {
		super(prop);

	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean stateIn) {
		state = stateIn;
	}

	public static BlockPos getLinkedPos() {
		return linkedPos;
	}

	public static void setLinkedPos(BlockPos linkedPos) {
		ItemFrequencyMatcher.linkedPos = linkedPos;
	}


	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack stack = playerIn.getHeldItemMainhand();
		CompoundNBT compound = stack.getOrCreateTag();
		if (!compound.getBoolean(TAG_STATE)) {
			playerIn.playSound(SoundEvents.BLOCK_BEACON_ACTIVATE, 0.40f, 1F);
			compound.putBoolean(TAG_STATE, !compound.getBoolean(TAG_STATE));
		} else {
			playerIn.playSound(SoundEvents.BLOCK_BEACON_DEACTIVATE, 0.40f, 1F);
			compound.putBoolean(TAG_STATE, !compound.getBoolean(TAG_STATE));

		}
		stack.setTag(compound);
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext ctx) {
		PlayerEntity player = ctx.getPlayer();
		World world = ctx.getWorld();
		ItemStack stack = ctx.getItem();
		BlockPos blockPos = ctx.getPos();
		CompoundNBT compound = stack.getOrCreateTag();

		// Always Select a new block if player is sneaking
		if (player.isSneaking()) {
			player.playSound(SoundEvents.BLOCK_BEACON_ACTIVATE, 0.40f, 1F);
			CompoundNBT posCompound = NBTUtil.writeBlockPos(blockPos);
			compound.putString(TAG_POS_NAME, I18n.format(world.getBlockState(blockPos).getBlock().getTranslationKey()));
			compound.put(TAG_POS, posCompound);
			stack.setTag(compound);
			return ActionResultType.SUCCESS;

		}

		// Link
		BlockPos readPos = NBTUtil.readBlockPos(stack.getTag().getCompound(TAG_POS));

		if (stack.getTag().getBoolean("state")) {
			if (!player.isSneaking() && world.getTileEntity(blockPos) instanceof TileEntityAbsorber) {
				TileEntityAbsorber te = (TileEntityAbsorber) world.getTileEntity(blockPos);
				player.playSound(SoundEvents.BLOCK_BEACON_DEACTIVATE, 0.40f, 1F);
				if (stack.getTag().get(TAG_POS) != null) {
					if (readPos.compareTo(new Vector3i(0, 0, 0)) != 0) {
						Vector3d teVec = new Vector3d(te.getPos().getX(), te.getPos().getY(), te.getPos().getZ());
						Vector3d readVec = new Vector3d(readPos.getX(), readPos.getY(), readPos.getZ());
						double distance = teVec.distanceTo(readVec);
						if (distance < 7) {
							te.addToLinkedBlocks(readPos);
							VanillaPacketDispatcher.dispatchTEToNearbyPlayers(te);
							return ActionResultType.SUCCESS;
						} else {
							if (world.isRemote) {
								player.sendStatusMessage(
										new StringTextComponent(TextFormatting.GOLD + "Too Far Cannot Connect"), false);
								return ActionResultType.SUCCESS;
							}
						}
					}
				}
			}
		}
		// Unlink
		if (!stack.getTag().getBoolean("state")) {
			if (!player.isSneaking() && world.getTileEntity(blockPos) instanceof TileEntityAbsorber) {
				TileEntityAbsorber te = (TileEntityAbsorber) world.getTileEntity(blockPos);
				player.playSound(SoundEvents.BLOCK_BEACON_DEACTIVATE, 0.40f, 1F);
				Vector3d teVec = new Vector3d(te.getPos().getX(), te.getPos().getY(), te.getPos().getZ());
				Vector3d readVec = new Vector3d(readPos.getX(), readPos.getY(), readPos.getZ());
				double distance = teVec.distanceTo(readVec);
				if (distance < 7) {
					te.removeFromLinkedBlocks(readPos);
					VanillaPacketDispatcher.dispatchTEToNearbyPlayers(te);
					return ActionResultType.SUCCESS;
				}

			}
		}

		return ActionResultType.SUCCESS;
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		if (stack.hasTag()) {
			if (stack.getTag().get(TAG_POS) != null) {
				tooltip.add(
						new TranslationTextComponent("Selected Block " + stack.getTag().get(TAG_POS_NAME).toString())
								.mergeStyle(TextFormatting.GOLD));
				tooltip.add(new TranslationTextComponent("Selected Coords " + stack.getTag().get(TAG_POS).toString())
						.mergeStyle(TextFormatting.GOLD));
			} else {
				tooltip.add(new TranslationTextComponent("NO POS SAVED").mergeStyle(TextFormatting.GOLD));
			}
			if (stack.getTag().getBoolean(TAG_STATE)) {
				tooltip.add(new TranslationTextComponent("State: Link").mergeStyle(TextFormatting.BLUE));
			} else {
				tooltip.add(new TranslationTextComponent("State: Unlink").mergeStyle(TextFormatting.RED));
			}
		}
	}

    public static BlockPos getConnectionPos(ItemStack wrench) {
        CompoundNBT compound = wrench.getOrCreateTag();
        return  NBTUtil.readBlockPos(compound.getCompound(TAG_POS_NAME));
    }
}
