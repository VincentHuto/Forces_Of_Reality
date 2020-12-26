
package com.huto.forcesofreality.objects.tileenties.util;

import com.huto.forcesofreality.objects.tileenties.vibes.gen.TileEntityAbsorber;

public interface IImportableTile {
	public void importFromAbsorber(TileEntityAbsorber importFrom ,float rate);
	public boolean canImport();
	public void sendUpdates();

}
