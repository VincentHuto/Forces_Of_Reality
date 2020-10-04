package com.huto.hutosmod.objects.tileenties.util;

import com.huto.hutosmod.objects.tileenties.TileEntityAbsorber;

public interface ITank {
	public void importFromAbsorber(TileEntityAbsorber importFrom, float rate);

	public boolean canImport();

	public void exportToAbsorber(TileEntityAbsorber exportTo, float rate);

	public boolean canExport();

	public void sendUpdates();
}
