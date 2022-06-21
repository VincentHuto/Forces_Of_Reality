package com.vincenthuto.forcesofreality.capa.tiledevotion;

public class Devotion implements IDevotion {
	private int Devotion = 0;

	@Override
	public void removeDevotion(int points) {
		this.Devotion -= points;
	}

	@Override
	public void addDevotion(int points) {
		this.Devotion += points;
	}

	@Override
	public void setDevotion(int points) {
		this.Devotion = points;
	}

	@Override
	public int getDevotion() {
		return this.Devotion;
	}

}
