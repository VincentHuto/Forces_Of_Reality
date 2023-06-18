package com.vincenthuto.forcesofreality.common.item.tool;

import javax.annotation.Nonnull;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Explosion.BlockInteraction;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.level.ExplosionEvent;

public class ItemDestructOrb extends Item {

	public ItemDestructOrb(Properties prop) {
		super(prop);
	}
	
	@Nonnull

	@Override
	public InteractionResult useOn(UseOnContext context) {
		NovaExplosion explosion = new NovaExplosion(context.getLevel(), context.getPlayer(),
				context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), 4,
				false,BlockInteraction.DESTROY_WITH_DECAY);
		if (!MinecraftForge.EVENT_BUS.post(new ExplosionEvent.Start((context.getLevel()), explosion))) {
			explosion.explode();
			explosion.finalizeExplosion(true);
		}
		return InteractionResult.PASS;
	}

}
