package com.vincenthuto.forcesofreality.item;

import com.vincenthuto.forcesofreality.init.EntityInit;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class ItemSlugBucket extends Item {

	public ItemSlugBucket(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
		ItemStack itemstack = playerIn.getItemInHand(handIn);
		HitResult raytraceresult = getPlayerPOVHitResult(worldIn, playerIn, ClipContext.Fluid.NONE);
		InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(playerIn,
				worldIn, itemstack, raytraceresult);
		if (ret != null)
			return ret;
		if (raytraceresult.getType() == HitResult.Type.MISS) {
			return InteractionResultHolder.pass(itemstack);
		} else if (raytraceresult.getType() != HitResult.Type.BLOCK) {
			return InteractionResultHolder.pass(itemstack);
		} else {
			BlockHitResult blockraytraceresult = (BlockHitResult) raytraceresult;
			BlockPos blockpos = blockraytraceresult.getBlockPos();
			if (!worldIn.isClientSide) {
				EntityInit.slug.get().spawn((ServerLevel) worldIn, playerIn.getItemInHand(handIn), playerIn, blockpos,
						MobSpawnType.BUCKET, true, false);
			}
		}

		return InteractionResultHolder.sidedSuccess(new ItemStack(Items.BUCKET), worldIn.isClientSide());
	}

}
