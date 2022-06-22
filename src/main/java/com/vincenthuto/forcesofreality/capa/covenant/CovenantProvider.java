package com.vincenthuto.forcesofreality.capa.covenant;

import java.util.Map;

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
public class CovenantProvider implements ICapabilitySerializable<Tag> {
	
	public static final Capability<ICovenant> COVEN_CAPA  =CapabilityManager.get(new CapabilityToken<ICovenant>() {});;
	private LazyOptional<ICovenant> instance = LazyOptional.of(Covenant::new);

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		return COVEN_CAPA .orEmpty(cap, instance);

	}

	@Override
	public Tag serializeNBT() {
		return writeNBT(COVEN_CAPA ,
				instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional cannot be empty!")), null);
	}

	@Override
	public void deserializeNBT(Tag nbt) {
		readNBT(COVEN_CAPA ,
				instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional cannot be empty!")), null, nbt);

	}

	public static Map<EnumCovenants, Integer> getPlayerDevotion(Player player) {
		return player.getCapability(COVEN_CAPA ).orElseThrow(IllegalStateException::new).getDevotion();
	}

	public CompoundTag writeNBT(Capability<ICovenant> capability, ICovenant instance, Direction side) {
		CompoundTag covenTag = new CompoundTag();
		instance.getDevotion().keySet().forEach((key -> {
			if (instance.getDevotion().get(key) != null) {
				covenTag.putInt(key.toString(), instance.getDevotion().get(key));
			} else {
				covenTag.putInt(key.toString(), 0);

			}
		}));
		return covenTag;
	}

	public void readNBT(Capability<ICovenant> capability, ICovenant instance, Direction side, Tag nbt) {
		if (!(instance instanceof Covenant))
			throw new IllegalArgumentException(
					"Can not deserialize to an instance that isn't the default implementation");
		CompoundTag test = (CompoundTag) nbt;
		for (EnumCovenants coven : EnumCovenants.values()) {
			instance.getDevotion().put(coven, test.getInt(coven.toString()));
		}
	}
}
