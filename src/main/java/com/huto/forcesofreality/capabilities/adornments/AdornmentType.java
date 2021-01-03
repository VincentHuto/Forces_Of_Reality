package com.huto.forcesofreality.capabilities.adornments;

public enum AdornmentType {
	MAJOR(0), MINOR(1, 2, 3), OVERRIDE(0, 1, 2, 3);

	int[] validSlots;

	AdornmentType(int... validSlots) {
		this.validSlots = validSlots;
	}

	public boolean hasSlot(int slot) {
		for (int s : validSlots) {
			if (s == slot)
				return true;
		}
		return false;
	}

	public int[] getValidSlots() {
		return validSlots;
	}
}