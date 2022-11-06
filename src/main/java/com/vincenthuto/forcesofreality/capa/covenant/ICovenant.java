package com.vincenthuto.forcesofreality.capa.covenant;

import java.util.Map;

public interface ICovenant {

	public boolean getCovenAlignment(EnumCovenants covenIn);

	public Map<EnumCovenants, Integer> getDevotion();

	public int getDevotionByCoven(EnumCovenants covenIn);

	public EnumCovenants getOpposingCoven(EnumCovenants covenIn);

	public void setCovenDevotion(EnumCovenants covenIn, int value);

	public void setDevotion(Map<EnumCovenants, Integer> devotion);
}
