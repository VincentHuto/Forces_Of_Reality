//package com.vincenthuto.forcesofreality.client.screen.guide;
//
//import java.util.List;
//
//import com.vincenthuto.hutoslib.client.screen.guide.GuiGuidePage;
//import com.vincenthuto.hutoslib.client.screen.guide.GuiGuidePageTOC;
//import com.vincenthuto.hutoslib.client.screen.guide.TomeLib;
//
//public class ForcesGuideTOC extends GuiGuidePageTOC {
//
//	public ForcesGuideTOC(String catagoryIn) {
//		super(catagoryIn);
//	}
//
//	@Override
//	public TomeLib getOwnerTome() {
//		return new ForcesLib();
//	}
//
//	@Override
//	public List<GuiGuidePage> getPages() {
//		return getOwnerTome().getMatchingChapters(getCatagory()).pages;
//
//	}
//
//}
