
package com.huto.forces_of_reality.objects.tileenties.util;

import com.huto.forces_of_reality.objects.tileenties.vibes.gen.TileEntityAbsorber;

public interface IImportableTile {
	public void importFromAbsorber(TileEntityAbsorber importFrom ,float rate);
	public boolean canImport();
	public void sendUpdates();

}
