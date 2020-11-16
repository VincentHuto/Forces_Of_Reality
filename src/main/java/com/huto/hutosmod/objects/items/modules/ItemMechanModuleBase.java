package com.huto.hutosmod.objects.items.modules;

import java.util.List;

import javax.annotation.Nullable;

import com.huto.hutosmod.capabilities.moduletiers.IModule;
import com.huto.hutosmod.capabilities.moduletiers.ModuleProvider;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemMechanModuleBase extends Item {

	public ItemMechanModuleBase(Properties properties) {
		super(properties);
	}

	public void moduleUse(ItemUseContext context) {
		context.getPlayer().sendStatusMessage(new StringTextComponent("Base Module Function"), true);
	}
/*	@Nullable
	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, CompoundNBT nbt) {
		if(stack !=null){
		return new ModuleProvider();
		}else{
		return null;
		
	}*/
	@Nullable
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
	if (stack != null) {
			IModule tier = stack.getCapability(ModuleProvider.TIER_CAPA).orElseThrow(IllegalArgumentException::new);
			if (tier != null) {
				tooltip.add(new StringTextComponent(TextFormatting.GOLD + "Tier: " + tier.getTier()));
			}
		}
	}

}
