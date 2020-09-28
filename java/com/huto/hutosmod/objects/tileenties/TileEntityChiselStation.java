package com.huto.hutosmod.objects.tileenties;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import com.huto.hutosmod.containers.ContainerChiselStation;
import com.huto.hutosmod.init.TileEntityInit;
import com.huto.hutosmod.objects.blocks.BlockVirtuousEnchant;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.InvWrapper;

public class TileEntityChiselStation extends LockableLootTileEntity implements ITickableTileEntity {
	public NonNullList<ItemStack> chestContents = NonNullList.<ItemStack>withSize(3, ItemStack.EMPTY);
	private IItemHandlerModifiable items = createHandler();
	public LazyOptional<IItemHandlerModifiable> itemHandler = LazyOptional.of(() -> items);
	public int numPlayersUsing = 0;
	public int ticksSinceSync;
	public float lidAngle, prevLidAngle;
	public static final String TAG_RUNELIST = "RUNELIST";
	public List<Integer> runesList;
	// RecipeRuneChisel currentRecipe;
	@SuppressWarnings("unused")
	private int blockMetadata = -1;

	public TileEntityChiselStation() {
		super(TileEntityInit.runic_chisel_station.get());
	}

	@Override
	public void tick() {

	}

	@Override
	public void onLoad() {
		this.runesList = new ArrayList<Integer>();
	}

	public List<Integer> getRuneList() {
		return runesList;
	}

	public void cleartRuneList() {
		this.sendUpdates();
		if (runesList != null) {
			runesList.clear();
		}
	}

	public void setRuneList(List<Integer> runesIn) {
		runesList = runesIn;
		this.sendUpdates();

	}

	@Override
	public int getSizeInventory() {
		return 3;
	}

	@Override
	public boolean isEmpty() {
		for (ItemStack stack : this.chestContents) {
			if (!stack.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public NonNullList<ItemStack> getItems() {
		return this.chestContents;
	}

	@Override
	protected void setItems(NonNullList<ItemStack> itemsIn) {
		this.chestContents = itemsIn;

	}

	@Override
	public void read(BlockState state, CompoundNBT compound) {
		super.read(state, compound);
		this.chestContents = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
		if (!this.checkLootAndRead(compound)) {
			ItemStackHelper.loadAllItems(compound, this.chestContents);
		}

	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
		if (!this.checkLootAndWrite(compound)) {
			ItemStackHelper.saveAllItems(compound, this.chestContents);
		}
		return compound;
	}

	@Override
	public boolean receiveClientEvent(int id, int type) {
		if (id == 1) {
			this.numPlayersUsing = type;
			return true;
		} else {
			return super.receiveClientEvent(id, type);
		}
	}

	@Override
	public void openInventory(PlayerEntity player) {
		if (!player.isSpectator()) {
			if (this.numPlayersUsing < 0) {
				this.numPlayersUsing = 0;
			}

			++this.numPlayersUsing;
			this.onOpenOrClose();
		}
	}

	@Override
	public void closeInventory(PlayerEntity player) {
		if (!player.isSpectator()) {
			--this.numPlayersUsing;
			this.onOpenOrClose();
		}
	}

	public static int getPlayersUsing(IBlockReader reader, BlockPos pos) {
		BlockState blockstate = reader.getBlockState(pos);
		if (blockstate.hasTileEntity()) {
			TileEntity tileentity = reader.getTileEntity(pos);
			if (tileentity instanceof TileEntityChiselStation) {
				return ((TileEntityChiselStation) tileentity).numPlayersUsing;
			}
		}
		return 0;
	}

	public static void swapContents(TileEntityChiselStation te, TileEntityChiselStation otherTe) {
		NonNullList<ItemStack> list = te.getItems();
		te.setItems(otherTe.getItems());
		otherTe.setItems(list);
	}

	protected void onOpenOrClose() {
		Block block = this.getBlockState().getBlock();
		if (block instanceof BlockVirtuousEnchant) {
			this.world.addBlockEvent(this.pos, block, 1, this.numPlayersUsing);
			this.world.notifyNeighborsOfStateChange(this.pos, block);
		}
	}

	@Override
	public void updateContainingBlockInfo() {
		super.updateContainingBlockInfo();
		if (this.itemHandler != null) {
			this.itemHandler.invalidate();
			this.itemHandler = null;
		}
	}

	@Override
	public void remove() {
		super.remove();
		if (itemHandler != null) {
			itemHandler.invalidate();
		}
	}

	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nonnull Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return itemHandler.cast();
		}
		return super.getCapability(cap, side);
	}

	private IItemHandlerModifiable createHandler() {
		return new InvWrapper(this);
	}

	@Override
	protected ITextComponent getDefaultName() {
		return new TranslationTextComponent("container.chisel_station");
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		return new ContainerChiselStation(id, player, this);
	}

	public void sendUpdates() {
		world.markBlockRangeForRenderUpdate(pos, getBlockState(), getBlockState());
		world.notifyBlockUpdate(pos, getBlockState(), getBlockState(), 3);
		markDirty();
	}

}
