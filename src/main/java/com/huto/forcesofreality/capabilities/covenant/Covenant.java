package com.huto.forcesofreality.capabilities.covenant;

import java.util.HashMap;
import java.util.Map;

public class Covenant implements ICovenant {
	@SuppressWarnings("serial")
	private Map<EnumCovenants, Integer> devotion = new HashMap<EnumCovenants, Integer>(){{
		put(EnumCovenants.SELF,0);
		put(EnumCovenants.HASTUR,0);
		put(EnumCovenants.ASCENDANT,0);
		put(EnumCovenants.ELDRITCH,0);
		put(EnumCovenants.MACHINE,0);
		put(EnumCovenants.BEAST,0);

	}};

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

	public void subtractCovenCost(EnumCovenants covenIn, int value, boolean isKarmaAlign) {
		if (devotion != null) {
			if (isKarmaAlign) {
				setCovenDevotion(covenIn, -Math.abs(value));
			} else {
				setCovenDevotion(covenIn, -Math.abs(value * 2));
			}
		}
	}

	public void addCovenDevotion(EnumCovenants covenIn, int value, boolean isKarmaAlign) {
		if (devotion != null) {
			if (isKarmaAlign) {
				setCovenDevotion(covenIn, Math.abs(value));
			} else {
				setCovenDevotion(covenIn, Math.abs(value * 2));
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
		case ASCENDANT:
			return EnumCovenants.ELDRITCH;
		case BEAST:
			return EnumCovenants.MACHINE;
		case ELDRITCH:
			return EnumCovenants.ASCENDANT;
		case HASTUR:
			return EnumCovenants.SELF;
		case MACHINE:
			return EnumCovenants.BEAST;
		case SELF:
			return EnumCovenants.HASTUR;
		default:
			return null;
		}
	}

	@Override
	public boolean getCovenAlignment(EnumCovenants covenIn) {
		switch (covenIn) {
		case ASCENDANT:
			return true;
		case BEAST:
			return false;
		case ELDRITCH:
			return false;
		case HASTUR:
			return false;
		case MACHINE:
			return true;
		case SELF:
			return true;
		default:
			return false;
		}
	}

}
