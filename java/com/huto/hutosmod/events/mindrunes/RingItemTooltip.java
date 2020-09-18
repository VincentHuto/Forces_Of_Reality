package com.huto.hutosmod.events.mindrunes;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.capabilities.mindrunes.RuneType;
import com.huto.hutosmod.capabilities.mindrunes.RunesCapabilities;

import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HutosMod.MOD_ID, value = Dist.CLIENT)
public class RingItemTooltip {

	@SubscribeEvent
	public static void tooltipEvent(ItemTooltipEvent event) {
		if (!event.getItemStack().isEmpty()) {
			event.getItemStack().getCapability(RunesCapabilities.ITEM_RUNE).ifPresent(bauble -> {
				RuneType bt = bauble.getBaubleType();
				TranslationTextComponent text = new TranslationTextComponent("name." + bt);
				text.getStyle().applyFormatting(TextFormatting.GOLD); // setColor(TextFormatting)
				event.getToolTip().add(text);
			});
		}
	}
}
