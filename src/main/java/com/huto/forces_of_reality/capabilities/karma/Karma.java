package com.huto.forces_of_reality.capabilities.karma;

public class Karma implements IKarma {
	private int Karma = 0;

	public void subtractKarma(int points) {
		this.Karma -= points;
	}

	public void addKarma(int points) {
		this.Karma += points;
	}

	public void setKarma(int points) {
		this.Karma = points;
	}

	public int getKarma() {
		return this.Karma;
	}

}
