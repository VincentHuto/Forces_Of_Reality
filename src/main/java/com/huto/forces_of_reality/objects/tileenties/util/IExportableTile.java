
package com.huto.forces_of_reality.objects.tileenties.util;

import com.huto.forces_of_reality.objects.tileenties.vibes.gen.TileEntityAbsorber;

public interface IExportableTile {
	public void exportToAbsorber(TileEntityAbsorber exportTo,float rate);
	public boolean canExport();
	public void sendUpdates();

}
