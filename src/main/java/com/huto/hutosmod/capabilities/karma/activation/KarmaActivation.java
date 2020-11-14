package com.huto.hutosmod.capabilities.karma.activation;

public class KarmaActivation implements IKarmaActivation {
	private int activ = 0;

	@Override
	public void setKarmaActivation(int set) {
		this.activ = set;
	}

	@Override
	public int getActivation() {
		return activ;
	}

	@Override
	public boolean getEnabled() {
		boolean toggle = activ == 0 ? false : true;
		return toggle;
	}

}
