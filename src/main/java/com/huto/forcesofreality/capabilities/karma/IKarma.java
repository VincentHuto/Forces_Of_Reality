package com.huto.forcesofreality.capabilities.karma;

public interface IKarma {

	public void subtractKarma(int points);

	public void addKarma(int points);

	public void setKarma(int points);

	public int getKarma();

	public boolean isKarmaGood();
}
