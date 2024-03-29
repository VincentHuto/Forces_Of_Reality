package com.vincenthuto.forcesofreality.common.capability.tiledevotion;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class DevotionProvider implements ICapabilitySerializable<Tag> {
//	//@CapabilityInject(IDevotion.class)
	public static final Capability<IDevotion> DEVO_CAPA = CapabilityManager.get(new CapabilityToken<IDevotion>() {
	});

	public static double getPlayerbloodVolume(Player player) {
		return player.getCapability(DEVO_CAPA).orElseThrow(IllegalStateException::new).getDevotion();
	}
	Devotion capability = new Devotion();

	private LazyOptional<IDevotion> instance = LazyOptional.of(() -> capability);

	@Override
	public void deserializeNBT(Tag nbt) {
		readNBT(DEVO_CAPA, instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional cannot be empty!")),
				null, nbt);
	}

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		return cap == DEVO_CAPA ? instance.cast() : LazyOptional.empty();
	}

	public void readNBT(Capability<IDevotion> capability, IDevotion instance, Direction side, Tag nbt) {
		if (!(instance instanceof Devotion))
			throw new IllegalArgumentException(
					"Can not deserialize to an instance that isn't the default implementation");
		if (nbt instanceof CompoundTag entry) {
			if (entry.contains("devotion")) {
				instance.setDevotion(entry.getInt("devotion"));
			}
		}

	}

	@Override
	public Tag serializeNBT() {
		return writeNBT(DEVO_CAPA,
				instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional cannot be empty!")), null);
	}

	public CompoundTag writeNBT(Capability<IDevotion> capability, IDevotion instance, Direction side) {
		CompoundTag entry = new CompoundTag();
		entry.putDouble("devotion", instance.getDevotion());
		return entry;
	}
}
