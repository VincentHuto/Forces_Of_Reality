package com.huto.forcesofreality.worldgen;

import java.util.List;
import java.util.Random;
import java.util.Set;

import com.huto.forcesofreality.init.BlockInit;
import com.huto.forcesofreality.init.TreeDecoratorInit;
import com.huto.forcesofreality.objects.blocks.BlockAkebi;
import com.mojang.serialization.Codec;

import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class AkebiTreeDecorator extends TreeDecorator {
	public static final Codec<AkebiTreeDecorator> field_236866_a_ = Codec.floatRange(0.0F, 1.0F).fieldOf("probability")
			.xmap(AkebiTreeDecorator::new, (p_236868_0_) -> {
				return p_236868_0_.field_227417_b_;
			}).codec();
	public final float field_227417_b_;

	public AkebiTreeDecorator(float p_i225868_1_) {
		this.field_227417_b_ = p_i225868_1_;
	}

	public TreeDecoratorType<?> func_230380_a_() {
		return TreeDecoratorInit.AKEBI;
	}

	public void func_225576_a_(ISeedReader seedReader, Random rand, List<BlockPos> listBlockPos,
			List<BlockPos> p_225576_4_, Set<BlockPos> setBlockPos, MutableBoundingBox boundingBox) {
		if (!(rand.nextFloat() >= this.field_227417_b_)) {
			int i = listBlockPos.get(0).getY();
			listBlockPos.stream().filter((p_236867_1_) -> {
				return p_236867_1_.getY() - i <= 2;
			}).forEach((p_242865_5_) -> {
				for (Direction direction : Direction.Plane.HORIZONTAL) {
					if (rand.nextFloat() <= 0.25F) {
						Direction direction1 = direction.getOpposite();
						BlockPos blockpos = p_242865_5_.add(direction1.getXOffset(), 0, direction1.getZOffset());
						if (Feature.isAirAt(seedReader, blockpos)) {
							BlockState blockstate = BlockInit.akebi.get().getDefaultState()
									.with(BlockAkebi.AGE, Integer.valueOf(rand.nextInt(3)))
									.with(BlockAkebi.HORIZONTAL_FACING, direction);
							this.func_227423_a_(seedReader, blockpos, blockstate, setBlockPos, boundingBox);
						}
					}
				}

			});
		}
	}
}
