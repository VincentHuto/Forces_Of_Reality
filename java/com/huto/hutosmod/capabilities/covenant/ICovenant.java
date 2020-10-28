package com.huto.hutosmod.capabilities.covenant;

import java.util.Map;

public interface ICovenant {

//	public void setCovenant(EnumCovenants convenant);
//
//	public EnumCovenants getCovenant();

	public Map<EnumCovenants, Integer> getDevotion();

	public void setDevotion(Map<EnumCovenants, Integer> devotion);

	public void setCovenDevotion(EnumCovenants covenIn, int value);

	public int getDevotionByCoven( EnumCovenants covenIn);
	
	public EnumCovenants getOpposingCoven(EnumCovenants covenIn);
}
