package com.huto.forces_of_reality.capabilities.covenant;

import java.util.Map;

public interface ICovenant {

	public Map<EnumCovenants, Integer> getDevotion();

	public void setDevotion(Map<EnumCovenants, Integer> devotion);

	public void setCovenDevotion(EnumCovenants covenIn, int value);

	public int getDevotionByCoven(EnumCovenants covenIn);

	public EnumCovenants getOpposingCoven(EnumCovenants covenIn);
}
