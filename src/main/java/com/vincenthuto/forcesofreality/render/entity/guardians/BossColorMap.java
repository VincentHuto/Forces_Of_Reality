package com.vincenthuto.forcesofreality.render.entity.guardians;

import java.util.EnumMap;

import net.minecraft.world.BossEvent;
import net.minecraft.world.BossEvent.BossBarColor;

public class BossColorMap {

	public static final EnumMap<BossEvent.BossBarColor, Integer> COLOR_MAP = new EnumMap<>(
			BossEvent.BossBarColor.class);

	static {
		COLOR_MAP.put(BossBarColor.PINK, 0xB90090);
		COLOR_MAP.put(BossBarColor.BLUE, 0x008FB9);
		COLOR_MAP.put(BossBarColor.RED, 0xB92A00);
		COLOR_MAP.put(BossBarColor.GREEN, 0x16B900);
		COLOR_MAP.put(BossBarColor.YELLOW, 0xB6B900);
		COLOR_MAP.put(BossBarColor.PURPLE, 0x6100B9);
		COLOR_MAP.put(BossBarColor.WHITE, 0xB9B9B9);
	}

	public static int getColor(BossEvent info) {
		return COLOR_MAP.get(info.getColor());
	}

	public static int getColor(BossEvent.BossBarColor color) {
		return COLOR_MAP.get(color);
	}

}