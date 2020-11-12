
package com.huto.hutosmod.objects.tileenties.util;

import com.huto.hutosmod.objects.tileenties.TileEntityAbsorber;

public interface IExportableTile {
	public void exportToAbsorber(TileEntityAbsorber exportTo,float rate);
	public boolean canExport();
	public void sendUpdates();

}
