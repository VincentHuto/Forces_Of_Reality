package com.huto.forcesofreality.item.tool;

import javax.annotation.Nonnull;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.Explosion;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.ExplosionEvent;

import net.minecraft.world.item.Item.Properties;

public class ItemDestructOrb extends Item {

	public ItemDestructOrb(Properties prop) {
		super(prop);
	}

	@Nonnull

	@Override
	public InteractionResult onItemUse(UseOnContext context) {
		NovaExplosion explosion = new NovaExplosion(context.getWorld(), context.getPlayer(), context.getPos().getX(),
				context.getPos().getY(), context.getPos().getZ(), 4, false, Explosion.Mode.BREAK);
		if (!MinecraftForge.EVENT_BUS.post(new ExplosionEvent.Start((context.getWorld()), explosion))) {
			explosion.doExplosionA();
			explosion.doExplosionB(true);
		}
		return ActionResultType.PASS;
	}

}
