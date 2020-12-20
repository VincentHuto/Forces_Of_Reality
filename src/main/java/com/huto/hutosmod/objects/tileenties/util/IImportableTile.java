
package com.huto.hutosmod.objects.tileenties.util;

import com.huto.hutosmod.objects.tileenties.vibes.gen.TileEntityAbsorber;

public interface IImportableTile {
	public void importFromAbsorber(TileEntityAbsorber importFrom ,float rate);
	public boolean canImport();
	public void sendUpdates();

}
