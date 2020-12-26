package com.huto.forcesofreality.objects.items.tools;

import javax.annotation.Nonnull;

import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.world.Explosion;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.ExplosionEvent;

public class ItemDestructOrb extends Item {

	public ItemDestructOrb(Properties prop) {
		super(prop);
	}

	@Nonnull

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		NovaExplosion explosion = new NovaExplosion(context.getWorld(), context.getPlayer(), context.getPos().getX(),
				context.getPos().getY(), context.getPos().getZ(), 5, false, Explosion.Mode.BREAK);
		if (!MinecraftForge.EVENT_BUS.post(new ExplosionEvent.Start((context.getWorld()), explosion))) {
			explosion.doExplosionA();
			explosion.doExplosionB(true);
		}
		return ActionResultType.PASS;
	}

}
