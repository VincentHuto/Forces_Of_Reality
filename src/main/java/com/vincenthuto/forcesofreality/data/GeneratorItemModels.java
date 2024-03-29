package com.vincenthuto.forcesofreality.data;
//package com.vincenthuto.forcesofreality.datagen;
//
//import com.vincenthuto.forcesofreality.ForcesOfReality;
//import com.vincenthuto.forcesofreality.init.BlockInit;
//import com.vincenthuto.forcesofreality.init.ItemInit;
//
//import net.minecraft.data.DataGenerator;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.level.block.Block;
//import net.minecraftforge.client.model.generators.ItemModelProvider;
//import net.minecraftforge.client.model.generators.ModelFile;
//import net.minecraftforge.common.data.ExistingFileHelper;
//import net.minecraftforge.registries.RegistryObject;
//
//public class GeneratorItemModels extends ItemModelProvider {
//	public GeneratorItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
//		super(generator, ForcesOfReality.MOD_ID, existingFileHelper);
//	}
//
//	@Override
//	protected void registerModels() {
//		// Our block items
//
//		for (RegistryObject<Block> b : BlockInit.BLOCKS.getEntries()) {
//			registerBlockModel(b.get());
//		}
//		for (RegistryObject<Item> item : ItemInit.ITEMS.getEntries()) {
//			registerBasicItem(item.get());
//		}
//		for (RegistryObject<Item> item : ItemInit.SPAWNEGGS.getEntries()) {
//			registerSpawnEggItem(item.get());
//		}
//		for (RegistryObject<Item> item : ItemInit.HANDHELDITEMS.getEntries()) {
//			registerHandheldItem(item.get());
//		}
//	}
//
//	private void registerBlockModel(Block block) {
//		String path = block.getRegistryName().getPath();
//		getBuilder(path).parent(new ModelFile.UncheckedModelFile(modLoc("block/" + path)));
//	}
//
//	private void registerBasicItem(Item item) {
//		String path = item.getRegistryName().getPath();
//		singleTexture(path, mcLoc("item/generated"), "layer0", modLoc("item/" + path));
//	}
//
//	private void registerHandheldItem(Item item) {
//		String path = item.getRegistryName().getPath();
//		singleTexture(path, mcLoc("item/handheld"), "layer0", modLoc("item/" + path));
//	}
//
//	private void registerSpawnEggItem(Item item) {
//		String path = item.getRegistryName().getPath();
//		withExistingParent(path, mcLoc("item/template_spawn_egg"));
//	}
//
//	@Override
//	public String getName() {
//		return "Item Models";
//	}
//}