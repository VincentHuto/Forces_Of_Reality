package com.huto.forcesofreality.capabilities.karma;

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

	public boolean isKarmaGood() {
		if (getKarma() >= 0) {
			return true;
		} else {
			return false;
		}
	}

}
