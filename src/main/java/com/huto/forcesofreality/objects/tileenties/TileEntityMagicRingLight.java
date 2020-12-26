package com.huto.forcesofreality.objects.tileenties;

import javax.annotation.Nullable;

import com.huto.forcesofreality.init.TileEntityInit;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMagicRingLight extends TileEntity {

    public int red = 255;
    public int green = 125;
    public int blue = 255;

    public TileEntityMagicRingLight() {
        super(TileEntityInit.light_ring_block.get());
    }


    @Override
    @Nullable
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(this.pos, 3, this.getUpdateTag());
    }

    @Override
    public CompoundNBT getUpdateTag() {
        return this.write(new CompoundNBT());
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        super.onDataPacket(net, pkt);
        handleUpdateTag(world.getBlockState(pos),pkt.getNbtCompound());
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        super.read(state, nbt);
        this.red = nbt.getInt("red");
        this.red = red > 0 ? red : 255;
        this.green = nbt.getInt("green");
        green = this.green > 0 ? green : 125;
        this.blue = nbt.getInt("blue");
        blue = this.blue > 0 ? blue : 255;
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.putInt("red", red);
        compound.putInt("green", green);
        compound.putInt("blue", blue);
        return super.write(compound);
    }
}