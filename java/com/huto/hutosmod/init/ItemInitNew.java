package com.huto.hutosmod.init;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.HutosMod.HutosModItemGroup;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInitNew {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HutosMod.MOD_ID);

	public static final RegistryObject<Item> DEF_ITEM = ITEMS.register("def_item",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));

}
