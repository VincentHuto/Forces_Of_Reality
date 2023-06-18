package com.vincenthuto.forcesofreality.common.tile;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.vincenthuto.forcesofreality.common.recipe.ModRafflesiaRecipies;
import com.vincenthuto.forcesofreality.common.recipe.RecipeRafflesia;
import com.vincenthuto.forcesofreality.registry.BlockEntityInit;
import com.vincenthuto.forcesofreality.registry.BlockInit;
import com.vincenthuto.forcesofreality.registry.ItemInit;
import com.vincenthuto.hutoslib.common.network.VanillaPacketDispatcher;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class BlockEntityRafflesiaOfFidelity extends BlockEntityRaffInventory {
	private static final int SET_KEEP_TICKS_EVENT = 0;
	private static final int SET_COOLDOWN_EVENT = 1;
	private static final int CRAFT_EFFECT_EVENT = 2;
	int cooldown = 0;
	int recipeKeepTicks = 0;
	public final String TAG_RANK = "rank";
	public int rank = 1;
	List<ItemStack> lastRecipe = null;
	RecipeRafflesia currentRecipe;

	public BlockEntityRafflesiaOfFidelity(BlockPos worldPosition, BlockState blockState) {
		super(BlockEntityInit.rafflesia_of_fidelity.get(), worldPosition, blockState);
	}

	@Override
	public boolean addItem(@Nullable Player player, ItemStack stack, @Nullable InteractionHand hand) {
		if (cooldown > 0 || stack.getItem() == ItemInit.allegiance_identifier.get())
			return false;

		boolean did = false;

		for (int i = 0; i < getSizeInventory(); i++)
			if (itemHandler.getStackInSlot(i).isEmpty()) {
				did = true;
				ItemStack stackToAdd = stack.copy();
				stackToAdd.setCount(1);
				itemHandler.setStackInSlot(i, stackToAdd);
				if (player == null || !player.getAbilities().instabuild) {
					stack.shrink(1);
				}
				break;
			}

		if (did)
			VanillaPacketDispatcher.dispatchTEToNearbyPlayers(getLevel(), worldPosition);
		return true;
	}
//
//	@Override
//	public void tick() {
//		if (!level().isClientSide) {
//			if (cooldown > 0) {
//				cooldown--;
//			}
//		}
//	}

	public void addRank(float valIn) {
		this.rank += valIn;
	}

	@Override
	protected SimpleItemStackHandler createItemHandler() {
		return new SimpleItemStackHandler(this, false) {
			@Override
			protected int getStackLimit(int slot, @Nonnull ItemStack stack) {
				return 1;
			}
		};
	}

	public RecipeRafflesia getCurrentRecipe() {
		for (RecipeRafflesia recipe_ : ModRafflesiaRecipies.rafflesiaRecipies) {
			if (recipe_.matches(itemHandler)) {
				currentRecipe = recipe_;
			}
		}

		return currentRecipe;
	}

	public int getRank() {
		return rank;
	}

	@Override
	public int getSizeInventory() {
		return 7;
	}

	@Override
	public BlockState getState() {
		return getLevel().getBlockState(worldPosition);
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public void handleUpdateTag(CompoundTag tag) {
		super.handleUpdateTag(tag);
		rank = tag.getInt(TAG_RANK);

	}

	public boolean hasValidRecipe() {
		for (RecipeRafflesia recipe : ModRafflesiaRecipies.rafflesiaRecipies)
			if (recipe.matches(itemHandler))
				return true;

		return false;
	}

	public boolean isEmpty() {
		for (int i = 0; i < getSizeInventory(); i++)
			if (!itemHandler.getStackInSlot(i).isEmpty())
				return false;

		return true;
	}

	@Override
	public void load(CompoundTag tag) {
		super.load(tag);
	}

	public void onActivated(Player player, ItemStack wand) {
		RecipeRafflesia recipe = null;
		if (currentRecipe != null)
			recipe = currentRecipe;
		else
			for (RecipeRafflesia recipe_ : ModRafflesiaRecipies.rafflesiaRecipies) {

				if (recipe_.matches(itemHandler)) {
					recipe = recipe_;
					break;
				}
			}

		if (recipe != null) {
			System.out.println(recipe.getVibeUsage());
			@SuppressWarnings("unused")
			float manaCost = recipe.getVibeUsage() / this.rank;
			ItemStack output = recipe.getOutput().copy();
			ItemEntity outputItem = new ItemEntity(getLevel(), worldPosition.getX() + 0.5, worldPosition.getY() + 1.5,
					worldPosition.getZ() + 0.5, output);
			if (getLevel().isClientSide) {
				getLevel().addParticle(ParticleTypes.PORTAL, worldPosition.getX(), worldPosition.getY(),
						worldPosition.getZ(), 0.0D, 0.0D, 0.0D);
			}
			getLevel().addFreshEntity(outputItem);
			currentRecipe = null;
			level.blockEvent(getBlockPos(), BlockInit.rafflesia_of_fidelity.get(), SET_COOLDOWN_EVENT, 60);
			level.blockEvent(getBlockPos(), BlockInit.rafflesia_of_fidelity.get(), CRAFT_EFFECT_EVENT, 0);

			for (int i = 0; i < getSizeInventory(); i++) {
				ItemStack stack = itemHandler.getStackInSlot(i);
				if (!stack.isEmpty()) {
				}
				this.sendUpdates();
				itemHandler.setStackInSlot(i, ItemStack.EMPTY);
			}
		}
	}

	@Override
	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
		super.onDataPacket(net, pkt);
		CompoundTag tag = pkt.getTag();
		super.onDataPacket(net, pkt);
		itemHandler = createItemHandler();
		itemHandler.deserializeNBT(tag);
		rank = tag.getInt(TAG_RANK);
	}

	@Override
	public void onLoad() {
		super.onLoad();
	}

	// Nbt
	@Override
	public void readPacketNBT(CompoundTag tag) {
		super.readPacketNBT(tag);
		itemHandler = createItemHandler();
		itemHandler.deserializeNBT(tag);
		rank = tag.getInt(TAG_RANK);

	}

	@Override
	public void saveAdditional(CompoundTag tag) {
		super.saveAdditional(tag);
	}

	@Override
	public void setBlockToUpdate() {
		sendUpdates();
	}

	public void setRank(int rankIn) {
		this.rank = rankIn;
	}

	@Override
	public boolean triggerEvent(int id, int param) {
		switch (id) {
		case SET_KEEP_TICKS_EVENT:
			recipeKeepTicks = param;
			return true;
		case SET_COOLDOWN_EVENT:
			cooldown = param;
			return true;
		case CRAFT_EFFECT_EVENT: {
			getLevel().playLocalSound(worldPosition,SoundEvents.AMBIENT_CAVE.get(), SoundSource.BLOCKS, 1f, 1f, false);
			return true;

		}
		default:
			return super.triggerEvent(id, param);

		}
	}

	public void updateRecipe() {
		for (RecipeRafflesia recipe : ModRafflesiaRecipies.rafflesiaRecipies)
			if (recipe.matches(itemHandler)) {
				ItemStack output = recipe.getOutput().copy();
				ItemEntity outputItem = new ItemEntity(getLevel(), worldPosition.getX() + 0.5, worldPosition.getY() + 1.5,
						worldPosition.getZ() + 0.5, output);
				getLevel().addFreshEntity(outputItem);
			}
		VanillaPacketDispatcher.dispatchTEToNearbyPlayers(getLevel(), worldPosition);
	}

	@Override
	public void writePacketNBT(CompoundTag tag) {
		super.writePacketNBT(tag);
		tag.merge(itemHandler.serializeNBT());
		tag.putInt(TAG_RANK, rank);

	}

}