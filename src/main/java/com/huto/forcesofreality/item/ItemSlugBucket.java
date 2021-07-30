package com.huto.forcesofreality.item;

import com.huto.forcesofreality.init.EntityInit;

import net.minecraft.entity.SpawnReason;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.level.Level;
import net.minecraft.world.server.ServerWorld;

import net.minecraft.world.item.Item.Properties;

public class ItemSlugBucket extends Item {

	public ItemSlugBucket(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> onItemRightClick(Level worldIn, Player playerIn, InteractionHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		RayTraceResult raytraceresult = rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.NONE);
		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(playerIn, worldIn,
				itemstack, raytraceresult);
		if (ret != null)
			return ret;
		if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
			return ActionResult.resultPass(itemstack);
		} else if (raytraceresult.getType() != RayTraceResult.Type.BLOCK) {
			return ActionResult.resultPass(itemstack);
		} else {
			BlockRayTraceResult blockraytraceresult = (BlockRayTraceResult) raytraceresult;
			BlockPos blockpos = blockraytraceresult.getPos();
			if (!worldIn.isRemote) {
				EntityInit.slug.get().spawn((ServerWorld) worldIn, playerIn.getHeldItem(handIn), playerIn, blockpos,
						SpawnReason.BUCKET, true, false);
			}
		}

		return ActionResult.func_233538_a_(new ItemStack(Items.BUCKET), worldIn.isRemote());
	}

}
