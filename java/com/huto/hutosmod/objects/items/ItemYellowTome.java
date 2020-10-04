package com.huto.hutosmod.objects.items;

import com.huto.hutosmod.capabilities.covenant.CovenantProvider;
import com.huto.hutosmod.capabilities.covenant.EnumCovenants;
import com.huto.hutosmod.capabilities.covenant.ICovenant;
import com.huto.hutosmod.entities.EntityPlayerTentacle;
import com.huto.hutosmod.init.EntityInit;
import com.huto.hutosmod.sounds.SoundHandler;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class ItemYellowTome extends Item {

	public ItemYellowTome(Properties properties) {
		super(properties);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		RayTraceResult result = playerIn.pick(100, 0, false);
		Vector3d hitVec = result.getHitVec();
		ICovenant coven = playerIn.getCapability(CovenantProvider.COVEN_CAPA)
				.orElseThrow(IllegalArgumentException::new);
		if (coven.getCovenant() == EnumCovenants.HASTUR) {
			if (!worldIn.isRemote) {
				this.summonTentacleAid(worldIn.rand.nextInt(10), worldIn, playerIn, hitVec);

			} else {
				playerIn.playSound(SoundHandler.ENTITY_HASTUR_HIT, 0.6F, 0.8F + (float) Math.random() * 0.2F);

			}
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);

	}

	public void summonTentacleAid(int numTent, World world, PlayerEntity player, Vector3d hitVec) {
		EntityPlayerTentacle[] tentArray = new EntityPlayerTentacle[numTent];
		for (int i = 0; i < numTent; i++) {
			tentArray[i] = new EntityPlayerTentacle(EntityInit.player_tentacle.get(), world, player);
			tentArray[i].setTentacleType(world.rand.nextInt(4));
			float xMod = (world.rand.nextFloat() - 0.5F) * 8.0F;
			float yMod = (world.rand.nextFloat() - 0.5F) * 4.0F;
			float zMod = (world.rand.nextFloat() - 0.5F) * 8.0F;
			tentArray[i].setPosition(hitVec.getX() + 0.5 + xMod, hitVec.getY() + 1.5 + yMod,
					hitVec.getZ() + 0.5 + zMod);
			if (!world.isRemote) {
				world.addEntity(tentArray[i]);

			}
		}
	}

	@Override
	public ActionResultType itemInteractionForEntity(ItemStack stack, PlayerEntity playerIn, LivingEntity target,
			Hand hand) {
		return super.itemInteractionForEntity(stack, playerIn, target, hand);
	}

}
