package com.huto.forcesofreality.events.mindrunes;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.capabilities.mindrunes.RuneType;
import com.huto.forcesofreality.capabilities.mindrunes.RunesCapabilities;

import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, value = Dist.CLIENT)
public class RuneItemSharedTooltip {

	@SubscribeEvent
	public static void tooltipEvent(ItemTooltipEvent event) {
		if (!event.getItemStack().isEmpty()) {
			event.getItemStack().getCapability(RunesCapabilities.ITEM_RUNE).ifPresent(rune -> {
				RuneType rt = rune.getRuneType();
				TranslationTextComponent text = new TranslationTextComponent("name." + rt);
				text.getStyle().applyFormatting(TextFormatting.GOLD); // setColor(TextFormatting)
				event.getToolTip().add(text);
			});
		}
	}
}
