package com.vincenthuto.forcesofreality.common.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.minecraft.core.BlockSource;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModSpawnEggItem extends SpawnEggItem {

	protected static final List<ModSpawnEggItem> UNADDED_EGGS = new ArrayList<>();

	public static void initSpawnEggs() {
		final Map<EntityType<?>, SpawnEggItem> EGGS = ObfuscationReflectionHelper.getPrivateValue(SpawnEggItem.class,
				null, "BY_ID");
		DefaultDispenseItemBehavior dispenseBehaviour = new DefaultDispenseItemBehavior() {
			@Override
			protected ItemStack execute(BlockSource source, ItemStack stack) {
				Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
				EntityType<?> type = ((SpawnEggItem) stack.getItem()).getType(stack.getTag());
				type.spawn(source.getLevel(), stack, null, source.getPos().relative(direction), MobSpawnType.DISPENSER,
						direction != Direction.UP, false);
				stack.shrink(1);
				return stack;
			}
		};

		for (final SpawnEggItem spawnEgg : UNADDED_EGGS) {
			EGGS.put(spawnEgg.getType(null), spawnEgg);
			DispenserBlock.registerBehavior(spawnEgg, dispenseBehaviour);
		}
		UNADDED_EGGS.clear();
	}

	private final Lazy<? extends EntityType<?>> entityTypeSupplier;

	public ModSpawnEggItem(final RegistryObject<? extends EntityType<?>> entityTypeSupplier, final int primaryColour,
			final int secondaryColour, final Item.Properties properties) {
		super(null, primaryColour, secondaryColour, properties);
		this.entityTypeSupplier = Lazy.of(entityTypeSupplier::get);
		UNADDED_EGGS.add(this);
	}

	@Override
	public EntityType<?> getType(CompoundTag nbt) {
		return this.entityTypeSupplier.get();
	}
}