package com.huto.forcesofreality.objects.tileenties.util;

import com.huto.forcesofreality.objects.tileenties.vibes.gen.TileEntityAbsorber;

public interface ITank {
	public void importFromAbsorber(TileEntityAbsorber importFrom, float rate);

	public boolean canImport();

	public void exportToAbsorber(TileEntityAbsorber exportTo, float rate);

	public boolean canExport();

	public void sendUpdates();
}
