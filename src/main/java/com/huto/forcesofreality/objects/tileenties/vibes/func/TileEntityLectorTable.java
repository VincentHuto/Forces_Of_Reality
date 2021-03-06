package com.huto.forcesofreality.objects.tileenties.vibes.func;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.huto.forcesofreality.capabilities.vibes.IVibrations;
import com.huto.forcesofreality.init.BlockInit;
import com.huto.forcesofreality.init.ItemInit;
import com.huto.forcesofreality.init.TileEntityInit;
import com.huto.forcesofreality.objects.items.tools.ItemKnapper;
import com.huto.forcesofreality.objects.tileenties.util.IImportableTile;
import com.huto.forcesofreality.objects.tileenties.util.VanillaPacketDispatcher;
import com.huto.forcesofreality.objects.tileenties.vibes.TileVibeSimpleInventory;
import com.huto.forcesofreality.objects.tileenties.vibes.gen.TileEntityAbsorber;
import com.huto.forcesofreality.recipes.ModInscriberRecipes;
import com.huto.forcesofreality.recipes.RecipeAutoInscriber;

import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;

public class TileEntityLectorTable extends TileVibeSimpleInventory implements ITickableTileEntity, IImportableTile {
	private static final int SET_KEEP_TICKS_EVENT = 0;
	private static final int SET_COOLDOWN_EVENT = 1;
	private static final int CRAFT_EFFECT_EVENT = 2;
	int cooldown = 0;
	int recipeKeepTicks = 0;
	float maxVibes = 200;
	public final String TAG_SIZE = "tankSize";
	List<ItemStack> lastRecipe = null;
	RecipeAutoInscriber currentRecipe;
	public final String TAG_LEVEL = "level";
	public int level = 1;
	public float clientVibes = 0.0f;
	public boolean isActive;

	public TileEntityLectorTable() {
		super(TileEntityInit.lector_table.get());
	}

	@Override
	public void onLoad() {
		super.onLoad();

	}
	
	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		// TODO Auto-generated method stub
		return super.getRenderBoundingBox().grow(3);
	}

	public int getGridScale() {
		switch (this.level) {
		case 1:
			return 1;
		case 2:
			return 3;
		case 3:
			return 5;
		case 4:
			return 7;
		case 5:
			return 9;
		default:
			return 9;
		}
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

	public IVibrations getVibeCap() {
		return vibes;
	}

	public float getMaxVibes() {
		return maxVibes;
	}

	public void setMaxVibes(float maxVibes) {
		this.maxVibes = maxVibes;
	}

	public RecipeAutoInscriber getCurrentRecipe() {
		for (RecipeAutoInscriber recipe_ : ModInscriberRecipes.inscriberRecipies) {
			if (recipe_.matches(itemHandler)) {
				currentRecipe = recipe_;
			}
		}

		return currentRecipe;
	}

	public boolean hasValidRecipe() {
		for (RecipeAutoInscriber recipe : ModInscriberRecipes.inscriberRecipies)
			if (recipe.matches(itemHandler))
				return true;

		return false;
	}

	public void updateRecipe() {
		for (RecipeAutoInscriber recipe : ModInscriberRecipes.inscriberRecipies)
			if (recipe.matches(itemHandler)) {
				ItemStack output = recipe.getOutput().copy();
				ItemEntity outputItem = new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5,
						output);
				world.addEntity(outputItem);
			}
		VanillaPacketDispatcher.dispatchTEToNearbyPlayers(world, pos);
	}

	@Override
	public boolean addItem(@Nullable PlayerEntity player, ItemStack stack, @Nullable Hand hand) {
		if (cooldown > 0 || stack.getItem() == ItemInit.maker_activator.get())
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
			if(vibes.getVibes() > 0.05f) {
			vibes.subtractVibes(0.05f);
			}
		}
	}

	// NBT data
	@Override
	public void readPacketNBT(CompoundNBT tag) {
		super.readPacketNBT(tag);
		itemHandler = createItemHandler();
		itemHandler.deserializeNBT(tag);
		maxVibes = tag.getFloat(TAG_SIZE);
		clientVibes = tag.getFloat(TAG_VIBES);
		level = tag.getInt(TAG_LEVEL);

	}

	@Override
	public void writePacketNBT(CompoundNBT tag) {
		super.writePacketNBT(tag);
		tag.merge(itemHandler.serializeNBT());
		tag.putFloat(TAG_SIZE, maxVibes);
		tag.putFloat(TAG_VIBES, vibes.getVibes());
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
		nbtTag.putFloat(TAG_SIZE, maxVibes);
		nbtTag.putFloat(TAG_VIBES, vibes.getVibes());
		nbtTag.putInt(TAG_LEVEL, level);
		return new SUpdateTileEntityPacket(getPos(), -1, nbtTag);
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		CompoundNBT tag = pkt.getNbtCompound();
		super.onDataPacket(net, pkt);
		itemHandler = createItemHandler();
		itemHandler.deserializeNBT(tag);
		maxVibes = tag.getFloat(TAG_SIZE);
		clientVibes = tag.getFloat(TAG_VIBES);
		level = tag.getInt(TAG_LEVEL);

	}

	@Override
	public void handleUpdateTag(BlockState state, CompoundNBT tag) {
		super.handleUpdateTag(state, tag);
		maxVibes = tag.getFloat(TAG_SIZE);
		clientVibes = tag.getFloat(TAG_VIBES);
		level = tag.getInt(TAG_LEVEL);

	}

	@Override
	public int getSizeInventory() {
		return 2;
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
		RecipeAutoInscriber recipe = null;
		if (currentRecipe != null)
			recipe = currentRecipe;
		else
			for (RecipeAutoInscriber recipe_ : ModInscriberRecipes.inscriberRecipies) {

				if (recipe_.matches(itemHandler)) {
					recipe = recipe_;
					break;
				}
			}
		// isActive = false;

		if (recipe != null) {
			float manaCost = recipe.getVibeUsage() / this.level;
			if (vibes.getVibes() >= manaCost) {

				ItemStack output = recipe.getOutput().copy();
				ItemEntity outputItem = new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5,
						output);
				if (world.isRemote) {
					world.addParticle(ParticleTypes.PORTAL, pos.getX(), pos.getY(), pos.getZ(), 0.0D, 0.0D, 0.0D);
				}
				world.addEntity(outputItem);
				vibes.setVibes(vibes.getVibes() - manaCost);
				currentRecipe = null;
				world.addBlockEvent(getPos(), BlockInit.wand_maker.get(), SET_COOLDOWN_EVENT, 60);
				world.addBlockEvent(getPos(), BlockInit.wand_maker.get(), CRAFT_EFFECT_EVENT, 0);
				for (int i = 0; i < getItemHandler().getSlots(); i++) {
					if (getItemHandler().getStackInSlot(i).getItem() == Items.OBSIDIAN) {
						ItemStack stack = itemHandler.getStackInSlot(i);
						if (!stack.isEmpty()) {
							this.sendUpdates();
							itemHandler.setStackInSlot(i, ItemStack.EMPTY);

						}
					}
					if (getItemHandler().getStackInSlot(i).getItem() instanceof ItemKnapper) {
						ItemStack knapperIn = itemHandler.getStackInSlot(i);
						if (knapperIn.getItem() instanceof ItemKnapper) {
							ItemStack newKnapper = knapperIn.copy();
							newKnapper.attemptDamageItem(2, world.rand, null);
							itemHandler.setStackInSlot(i, newKnapper);
						}

					}

				}

			}
		}
	}

	public BlockState getState() {
		return world.getBlockState(pos);
	}

	public void setBlockToUpdate() {
		sendUpdates();
	}

	@Override
	public void importFromAbsorber(TileEntityAbsorber importFrom, float rate) {
		this.vibes.addVibes(rate);
		importFrom.vibes.subtractVibes(rate);
	}

	@Override
	public boolean canImport() {
		if (vibes.getVibes() < maxVibes) {
			return true;
		} else {
			return false;
		}
	}
}
