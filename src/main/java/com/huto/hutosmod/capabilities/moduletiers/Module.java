package com.huto.hutosmod.capabilities.moduletiers;

public class Module implements IModule {
	private int Tier = 0;

	public void subtractTier(int points) {
		this.Tier -= points;
	}

	public void addTier(int points) {
		this.Tier += points;
	}

	public void setTier(int points) {
		this.Tier = points;
	}

	public int getTier() {
		return this.Tier;
	}

}
