package com.huto.hutosmod.capabilities.covenant;

import java.util.HashMap;
import java.util.Map;

public class Covenant implements ICovenant {
	private Map<EnumCovenants, Integer> devotion = new HashMap<>();

	public Map<EnumCovenants, Integer> getDevotion() {
		return devotion;
	}

	public void setDevotion(Map<EnumCovenants, Integer> devotion) {
		this.devotion = devotion;
	}

	public void setCovenDevotion(EnumCovenants covenIn, int value) {
		if (devotion != null) {
			if (getOpposingCoven(covenIn) != null) {
				Map<EnumCovenants, Integer> newDevo = devotion;
				newDevo.put(covenIn, getDevotionByCoven(covenIn) + value);
				newDevo.put(getOpposingCoven(covenIn), getDevotionByCoven(getOpposingCoven(covenIn)) - value);
				setDevotion(newDevo);
			}
		}
	}

	public int getDevotionByCoven(EnumCovenants covenIn) {
		if (devotion != null && devotion.get(covenIn) != null) {
			return devotion.get(covenIn);
		} else {
			return 0;
		}
	}

	@Override
	public EnumCovenants getOpposingCoven(EnumCovenants covenIn) {
		switch (covenIn) {
		case ASCENDENT:
			return EnumCovenants.ELDRITCH;
		case BEAST:
			return EnumCovenants.MACHINE;
		case ELDRITCH:
			return EnumCovenants.ASCENDENT;
		case HASTUR:
			return EnumCovenants.ELDRITCH;
		case MACHINE:
			return EnumCovenants.BEAST;
		case NONE:
			return null;
		default:
			return null;
		}
	}

}
