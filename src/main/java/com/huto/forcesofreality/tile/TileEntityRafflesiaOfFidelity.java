package com.huto.forcesofreality.tile;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.huto.forcesofreality.init.BlockInit;
import com.huto.forcesofreality.init.ItemInit;
import com.huto.forcesofreality.init.TileEntityInit;
import com.huto.forcesofreality.recipe.ModRafflesiaRecipies;
import com.huto.forcesofreality.recipe.RecipeRafflesia;
import com.hutoslib.common.VanillaPacketDispatcher;

import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;

public class TileEntityRafflesiaOfFidelity extends TileRaffInventory implements ITickableTileEntity {
	int cooldown = 0;
	int recipeKeepTicks = 0;
	private static final int SET_KEEP_TICKS_EVENT = 0;
	private static final int SET_COOLDOWN_EVENT = 1;
	private static final int CRAFT_EFFECT_EVENT = 2;
	public final String TAG_LEVEL = "level";
	public int level = 1;
	List<ItemStack> lastRecipe = null;
	RecipeRafflesia currentRecipe;

	public TileEntityRafflesiaOfFidelity() {
		super(TileEntityInit.rafflesia_of_fidelity.get());
	}

	@Override
	public void onLoad() {
		super.onLoad();
	}

	public void addLevel(float valIn) {
		this.level += valIn;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int levelIn) {
		this.level = levelIn;
	}

	public RecipeRafflesia getCurrentRecipe() {
		for (RecipeRafflesia recipe_ : ModRafflesiaRecipies.rafflesiaRecipies) {
			if (recipe_.matches(itemHandler)) {
				currentRecipe = recipe_;
			}
		}

		return currentRecipe;
	}

	public void updateRecipe() {
		for (RecipeRafflesia recipe : ModRafflesiaRecipies.rafflesiaRecipies)
			if (recipe.matches(itemHandler)) {
				ItemStack output = recipe.getOutput().copy();
				ItemEntity outputItem = new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5,
						output);
				world.addEntity(outputItem);
			}
		VanillaPacketDispatcher.dispatchTEToNearbyPlayers(world, pos);
	}

	public boolean hasValidRecipe() {
		for (RecipeRafflesia recipe : ModRafflesiaRecipies.rafflesiaRecipies)
			if (recipe.matches(itemHandler))
				return true;

		return false;
	}

	@Override
	public boolean addItem(@Nullable PlayerEntity player, ItemStack stack, @Nullable Hand hand) {
		if (cooldown > 0 || stack.getItem() == ItemInit.allegiance_identifier.get())
			return false;

		boolean did = false;

		for (int i = 0; i < getSizeInventory(); i++)
			if (itemHandler.getStackInSlot(i).isEmpty()) {
				did = true;
				ItemStack stackToAdd = stack.copy();
				stackToAdd.setCount(1);
				itemHandler.setStackInSlot(i, stackToAdd);
				if (player == null || !player.abilities.isCreativeMode) {
					stack.shrink(1);
				}
				break;
			}

		if (did)
			VanillaPacketDispatcher.dispatchTEToNearbyPlayers(world, pos);
		return true;
	}

	@Override
	public void tick() {
		if (!world.isRemote) {
			if (cooldown > 0) {
				cooldown--;
			}
		}
	}

	// Nbt
	@Override
	public void readPacketNBT(CompoundNBT tag) {
		super.readPacketNBT(tag);
		itemHandler = createItemHandler();
		itemHandler.deserializeNBT(tag);
		level = tag.getInt(TAG_LEVEL);

	}

	@Override
	public void writePacketNBT(CompoundNBT tag) {
		super.writePacketNBT(tag);
		tag.merge(itemHandler.serializeNBT());
		tag.putInt(TAG_LEVEL, level);

	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		return super.write(compound);
	}

	@Override
	public void read(BlockState state, CompoundNBT nbt) {
		super.read(state, nbt);

	}

	@Override
	public SUpdateTileEntityPacket getUpdatePacket() {
		super.getUpdatePacket();
		CompoundNBT nbtTag = new CompoundNBT();
		nbtTag.merge(itemHandler.serializeNBT());
		nbtTag.putInt(TAG_LEVEL, level);
		return new SUpdateTileEntityPacket(getPos(), -1, nbtTag);
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		CompoundNBT tag = pkt.getNbtCompound();
		super.onDataPacket(net, pkt);
		itemHandler = createItemHandler();
		itemHandler.deserializeNBT(tag);
		level = tag.getInt(TAG_LEVEL);

	}

	@Override
	public void handleUpdateTag(BlockState state, CompoundNBT tag) {
		super.handleUpdateTag(state, tag);
		level = tag.getInt(TAG_LEVEL);

	}

	@Override
	public int getSizeInventory() {
		return 7;
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

	public boolean isEmpty() {
		for (int i = 0; i < getSizeInventory(); i++)
			if (!itemHandler.getStackInSlot(i).isEmpty())
				return false;

		return true;
	}

	@Override
	public boolean receiveClientEvent(int id, int param) {
		switch (id) {
		case SET_KEEP_TICKS_EVENT:
			recipeKeepTicks = param;
			return true;
		case SET_COOLDOWN_EVENT:
			cooldown = param;
			return true;
		case CRAFT_EFFECT_EVENT: {
			world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.AMBIENT_CAVE, SoundCategory.BLOCKS, 1, 1,
					false);
			return true;

		}
		default:
			return super.receiveClientEvent(id, param);

		}
	}

	public void onActivated(PlayerEntity player, ItemStack wand) {
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
			float manaCost = recipe.getVibeUsage() / this.level;
			ItemStack output = recipe.getOutput().copy();
			ItemEntity outputItem = new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5, output);
			if (world.isRemote) {
				world.addParticle(ParticleTypes.PORTAL, pos.getX(), pos.getY(), pos.getZ(), 0.0D, 0.0D, 0.0D);
			}
			world.addEntity(outputItem);
			currentRecipe = null;
			world.addBlockEvent(getPos(), BlockInit.rafflesia_of_fidelity.get(), SET_COOLDOWN_EVENT, 60);
			world.addBlockEvent(getPos(), BlockInit.rafflesia_of_fidelity.get(), CRAFT_EFFECT_EVENT, 0);

			for (int i = 0; i < getSizeInventory(); i++) {
				ItemStack stack = itemHandler.getStackInSlot(i);
				if (!stack.isEmpty()) {
				}
				this.sendUpdates();
				itemHandler.setStackInSlot(i, ItemStack.EMPTY);
			}
		}
	}

	public BlockState getState() {
		return world.getBlockState(pos);
	}

	public void setBlockToUpdate() {
		sendUpdates();
	}

}