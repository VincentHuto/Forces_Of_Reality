package com.vincenthuto.forcesofreality.capa.tiledevotion;

public class Devotion implements IDevotion {
	private int Devotion = 0;

	public void removeDevotion(int points) {
		this.Devotion -= points;
	}

	public void addDevotion(int points) {
		this.Devotion += points;
	}

	public void setDevotion(int points) {
		this.Devotion = points;
	}

	public int getDevotion() {
		return this.Devotion;
	}

}
