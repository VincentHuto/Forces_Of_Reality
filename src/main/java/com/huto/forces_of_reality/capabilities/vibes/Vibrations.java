package com.huto.forces_of_reality.capabilities.vibes;

public class Vibrations implements IVibrations {
	private float vibes = 0.0F;

	public void subtractVibes(float points) {
		this.vibes -= points;
	}

	public void addVibes(float points) {
		this.vibes += points;
	}

	public void setVibes(float points) {
		this.vibes = points;
	}

	public float getVibes() {
		return this.vibes;
	}

}
