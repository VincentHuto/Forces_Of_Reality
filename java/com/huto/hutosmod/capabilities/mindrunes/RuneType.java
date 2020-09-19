package com.huto.hutosmod.capabilities.mindrunes;

public enum RuneType {
	CONTRACT(0),
	RUNE(1,2,3),
	OVERRIDE(0,1,2,3);
/*    AMULET(0),
    RING(1, 2),1.00
1/193
How to grow edible mushrooms: Workshop and Lec
    BELT(3),
    TRINKET(0, 1, 2, 3, 4, 5, 6),
    HEAD(4),
    BODY(5),
    CHARM(6);*/

    int[] validSlots;

    RuneType(int... validSlots) {
        this.validSlots = validSlots;
    }

    public boolean hasSlot(int slot) {
        for (int s : validSlots) {
            if (s == slot) return true;
        }
        return false;
    }

    public int[] getValidSlots() {
        return validSlots;
    }
}