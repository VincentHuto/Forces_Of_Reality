package com.huto.hutosmod.capabilities.covenant;

public class Covenant implements ICovenant {
	private EnumCovenants covenant = EnumCovenants.NONE;

	public void setCovenant(EnumCovenants covenIn) {
		this.covenant = covenIn;
	}

	public EnumCovenants getCovenant() {
		return this.covenant;
	}

}
