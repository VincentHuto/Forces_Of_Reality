package com.huto.hutosmod.capabilities.covenant;

import java.util.HashMap;
import java.util.Map;

public class Covenant implements ICovenant {
//	private EnumCovenants covenant = EnumCovenants.NONE;
	private Map<EnumCovenants, Integer> devotion = new HashMap<>();

//	public void setCovenant(EnumCovenants covenIn) {
//		this.covenant = covenIn;
//	}
//
//	public EnumCovenants getCovenant() {
//		return this.covenant;
//	}

	public Map<EnumCovenants, Integer> getDevotion() {
		return devotion;
	}

	public void setDevotion(Map<EnumCovenants, Integer> devotion) {
		this.devotion = devotion;
	}

	public void setCovenDevotion(EnumCovenants covenIn, int value) {
		if (devotion != null) {
			Map<EnumCovenants, Integer> newDevo = devotion;
			newDevo.put(covenIn, value);
			setDevotion(newDevo);
		}
	}

	public int getDevotionByCoven(EnumCovenants covenIn) {
		if (devotion != null && devotion.get(covenIn) != null) {
			return devotion.get(covenIn);
		} else {
			return 0;
		}
	}
}
