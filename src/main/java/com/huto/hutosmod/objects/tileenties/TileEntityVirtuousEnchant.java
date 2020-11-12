package com.huto.hutosmod.objects.tileenties;

import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.huto.hutosmod.containers.ContainerVirtuousEnchanter;
import com.huto.hutosmod.init.TileEntityInit;
import com.huto.hutosmod.objects.blocks.BlockVirtuousEnchant;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.InvWrapper;

public class TileEntityVirtuousEnchant extends LockableLootTileEntity
		implements ITickableTileEntity, INamedContainerProvider {
	public int ticks;
	public float field_195523_f;
	public float field_195524_g;
	public float field_195525_h;
	public float field_195526_i;
	public float nextPageTurningSpeed;
	public float pageTurningSpeed;
	public float nextPageAngle;
	public float pageAngle;
	public float field_195531_n;
	private static final Random random = new Random();

	public NonNullList<ItemStack> chestContents = NonNullList.withSize(36, ItemStack.EMPTY);
	protected int numPlayersUsing;
	private IItemHandlerModifiable items = createHandler();
	public LazyOptional<IItemHandlerModifiable> itemHandler = LazyOptional.of(() -> items);

	public TileEntityVirtuousEnchant() {
		super(TileEntityInit.virtuous_enchanter.get());
	}

	@Override
	public void tick() {

		this.pageTurningSpeed = this.nextPageTurningSpeed;
		this.pageAngle = this.nextPageAngle;
		PlayerEntity playerentity = this.world.getClosestPlayer((double) this.pos.getX() + 0.5D,
				(double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D, 3.0D, false);
		if (playerentity != null) {
			double d0 = playerentity.getPosX() - ((double) this.pos.getX() + 0.5D);
			double d1 = playerentity.getPosZ() - ((double) this.pos.getZ() + 0.5D);
			this.field_195531_n = (float) MathHelper.atan2(d1, d0);
			this.nextPageTurningSpeed += 0.1F;
			if (this.nextPageTurningSpeed < 0.5F || random.nextInt(40) == 0) {
				float f1 = this.field_195525_h;

				do {
					this.field_195525_h += (float) (random.nextInt(4) - random.nextInt(4));
				} while (f1 == this.field_195525_h);
			}
		} else {
			this.field_195531_n += 0.02F;
			this.nextPageTurningSpeed -= 0.1F;
		}

		while (this.nextPageAngle >= (float) Math.PI) {
			this.nextPageAngle -= ((float) Math.PI * 2F);
		}

		while (this.nextPageAngle < -(float) Math.PI) {
			this.nextPageAngle += ((float) Math.PI * 2F);
		}

		while (this.field_195531_n >= (float) Math.PI) {
			this.field_195531_n -= ((float) Math.PI * 2F);
		}

		while (this.field_195531_n < -(float) Math.PI) {
			this.field_195531_n += ((float) Math.PI * 2F);
		}

		float f2;
		for (f2 = this.field_195531_n - this.nextPageAngle; f2 >= (float) Math.PI; f2 -= ((float) Math.PI * 2F)) {
		}

		while (f2 < -(float) Math.PI) {
			f2 += ((float) Math.PI * 2F);
		}

		this.nextPageAngle += f2 * 0.4F;
		this.nextPageTurningSpeed = MathHelper.clamp(this.nextPageTurningSpeed, 0.0F, 1.0F);
		++this.ticks;
		this.field_195524_g = this.field_195523_f;
		float f = (this.field_195525_h - this.field_195523_f) * 0.4F;
		f = MathHelper.clamp(f, -0.2F, 0.2F);
		this.field_195526_i += (f - this.field_195526_i) * 0.9F;
		this.field_195523_f += this.field_195526_i;
	}

	@Override
	public int getSizeInventory() {
		return 2;
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
	protected ITextComponent getDefaultName() {
		return new TranslationTextComponent("container.virtuous_enchanter");
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
		// ContainerVirtuousEnchanter cont = new ContainerVirtuousEnchanter(1,
		// ClientEventSubscriber, pos), this);
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

	protected void onOpenOrClose() {
		Block block = this.getBlockState().getBlock();
		if (block instanceof BlockVirtuousEnchant) {
			this.world.addBlockEvent(this.pos, block, 1, this.numPlayersUsing);
			this.world.notifyNeighborsOfStateChange(this.pos, block);
		}
	}

	public static int getPlayersUsing(IBlockReader reader, BlockPos pos) {
		BlockState blockstate = reader.getBlockState(pos);
		if (blockstate.hasTileEntity()) {
			TileEntity tileentity = reader.getTileEntity(pos);
			if (tileentity instanceof TileEntityVirtuousEnchant) {
				return ((TileEntityVirtuousEnchant) tileentity).numPlayersUsing;
			}
		}
		return 0;
	}

	public static void swapContents(TileEntityVirtuousEnchant te, TileEntityVirtuousEnchant otherTe) {
		NonNullList<ItemStack> list = te.getItems();
		te.setItems(otherTe.getItems());
		otherTe.setItems(list);
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
	public void remove() {
		super.remove();
		if (itemHandler != null) {
			itemHandler.invalidate();
		}
	}

	@Nullable
	@Override
	public Container createMenu(int id, PlayerInventory player) {
		return new ContainerVirtuousEnchanter(id, player, this);
	}

}
