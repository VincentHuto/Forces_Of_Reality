package com.huto.forcesofreality.capabilitie.adornment;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.huto.forcesofreality.ForcesOfReality;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = ForcesOfReality.MOD_ID)
public class AttachAdornmentCapability {

	private static ResourceLocation cap = new ResourceLocation(ForcesOfReality.MOD_ID, "rune_cap");

	@SubscribeEvent
	public static void attachCaps(AttachCapabilitiesEvent<ItemStack> event) {
		ItemStack stack = event.getObject();
		if (stack.getItem() instanceof IAdornment && stack.getItem() != Items.AIR) {
			event.addCapability(cap, new ICapabilityProvider() {
				private final LazyOptional<IAdornment> opt = LazyOptional.of(() -> (IAdornment) stack.getItem());

				@Nonnull
				@Override
				public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
					return AdornmentsCapabilities.ITEM_ADORNMENT.orEmpty(cap, opt);
				}
			});
		}
	}
}
