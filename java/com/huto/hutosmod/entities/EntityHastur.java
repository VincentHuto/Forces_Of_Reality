package com.huto.hutosmod.entities;

import com.huto.hutosmod.init.ItemInit;
import com.huto.hutosmod.sounds.SoundHandler;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.TickableSound;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BossInfo;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityHastur extends MonsterEntity implements IEntityAdditionalSpawnData {

	private BlockPos source = BlockPos.ZERO;
	private static final String TAG_SOURCE_X = "sourceX";
	private static final String TAG_SOURCE_Y = "sourceY";
	private static final String TAG_SOURCE_Z = "sourcesZ";

	public int deathTicks;
	private final ServerBossInfo bossInfo = (ServerBossInfo) (new ServerBossInfo(this.getDisplayName(),
			BossInfo.Color.YELLOW, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);

	public EntityHastur(EntityType<? extends EntityHastur> type, World worldIn) {
		super(type, worldIn);

	}

	@Override
	public void tick() {
		super.tick();
		float f = (this.rand.nextFloat() - 0.5F) * 8.0F;
		float f1 = (this.rand.nextFloat() - 0.5F) * 4.0F;
		float f2 = (this.rand.nextFloat() - 0.5F) * 8.0F;
		this.world.addParticle(ParticleTypes.WARPED_SPORE, this.getPosX() + (double) f,
				this.getPosY() + 2.0D + (double) f1, this.getPosZ() + (double) f2, 0.0D, 0.0D, 0.0D);
		this.world.addParticle(ParticleTypes.CRIMSON_SPORE, this.getPosX() + (double) f,
				this.getPosY() + 2.0D + (double) f1, this.getPosZ() + (double) f2, 0.0D, 0.0D, 0.0D);
		playAttackSound(SoundHandler.ENTITY_HASTUR_HIT, 0.1f, 0.5f);
	}

	@Override
	public ItemStack getHeldItemOffhand() {
		return new ItemStack(ItemInit.destruction_orb.get(), 1);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		this.applyEntityAI();
		this.goalSelector.addGoal(7, new RandomWalkingGoal(this, 0.12));
		this.goalSelector.addGoal(5, new MoveTowardsTargetGoal(this, 2d, 10));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 5d, true));
		this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.1f));
		this.goalSelector.addGoal(1, new LookAtGoal(this, PlayerEntity.class, 6.0F));

	}

	protected void applyEntityAI() {
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
	}

	public static AttributeModifierMap.MutableAttribute setAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 20.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.15D)
				.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 15.0D);
	}

	@Override
	protected void updateAITasks() {
		super.updateAITasks();
		this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());

	}

	@Override
	public void addTrackingPlayer(ServerPlayerEntity player) {
		super.addTrackingPlayer(player);
		this.bossInfo.addPlayer(player);
	}

	@Override
	public void removeTrackingPlayer(ServerPlayerEntity player) {
		super.removeTrackingPlayer(player);
		this.bossInfo.removePlayer(player);
	}

	@Override
	public boolean isNonBoss() {
		return false;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundHandler.ENTITY_HASTUR_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundHandler.ENTITY_HASTUR_HURT;

	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundHandler.ENTITY_HASTUR_DEATH;

	}

	public void playAttackSound(SoundEvent soundIn, float volume, float pitch) {
		if (this.isHandActive()) {
			super.playSound(soundIn, volume, pitch);
		}
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
	}

	@Override
	protected float getSoundVolume() {
		return 0.4F;
	}

/*	@Override
	public ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
		ItemStack itemstack = p_230254_1_.getHeldItem(p_230254_2_);
		if (itemstack.getItem() == Items.BOWL && !this.isChild()) {
			p_230254_1_.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
			ItemStack itemstack1 = DrinkHelper.fill(itemstack, p_230254_1_, Items.BEETROOT_SOUP.getDefaultInstance());
			p_230254_1_.setHeldItem(p_230254_2_, itemstack1);
			return ActionResultType.func_233537_a_(this.world.isRemote);
		} else {
			return super.func_230254_b_(p_230254_1_, p_230254_2_);
		}
	}*/

	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		return this.isChild() ? sizeIn.height * 0.95F : 1.3F;
	}

	// Death
	/**
	 * handles entity death timer, experience orb and particle creation
	 */
	@Override
	protected void onDeathUpdate() {
		++this.deathTicks;
		if (this.deathTicks >= 100 && this.deathTicks <= 200) {
			float f = (this.rand.nextFloat() - 0.5F) * 8.0F;
			float f1 = (this.rand.nextFloat() - 0.5F) * 4.0F;
			float f2 = (this.rand.nextFloat() - 0.5F) * 8.0F;
			this.world.addParticle(ParticleTypes.ASH, this.getPosX() + (double) f, this.getPosY() + 2.0D + (double) f1,
					this.getPosZ() + (double) f2, 0.0D, 0.0D, 0.0D);

			if (this.deathTicks >= 100) {
				this.world.addParticle(ParticleTypes.FLASH, this.getPosX() + (double) f,
						this.getPosY() + 2.0D + (double) f1, this.getPosZ() + (double) f2, 0.0D, 0.0D, 0.0D);
			}
		}

		boolean flag = this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT);

		if (this.deathTicks == 200) {
			world.playSound(this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.ENTITY_GENERIC_EXPLODE,
					SoundCategory.HOSTILE, 3f, 0.2f, false);
		}

		if (this.deathTicks == 200 && !this.world.isRemote) {
			if (flag) {
				this.dropExperience(MathHelper.floor((float) 500 * 0.2F));
			}

			this.remove();
		}
	}

	private void dropExperience(int xp) {
		while (xp > 0) {
			int i = ExperienceOrbEntity.getXPSplit(xp);
			xp -= i;
			this.world
					.addEntity(new ExperienceOrbEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ(), i));
		}

	}

	public boolean isArmored() {
		return this.getHealth() <= this.getMaxHealth() / 2.0F;
	}

	public boolean isVulnerable() {
		return this.getHealth() <= this.getMaxHealth() / 4.0F;
	}

	@Override
	public void writeSpawnData(PacketBuffer buffer) {
		buffer.writeLong(source.toLong());
		System.out.println("PLAYIBNG MUSCI");

	}

	@Override
	public void readSpawnData(PacketBuffer additionalData) {
		source = BlockPos.fromLong(additionalData.readLong());

		Minecraft.getInstance().getSoundHandler().play(new HasturMusic(this));

	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	public void writeAdditional(CompoundNBT cmp) {
		super.writeAdditional(cmp);
		cmp.putInt(TAG_SOURCE_X, source.getX());
		cmp.putInt(TAG_SOURCE_Y, source.getY());
		cmp.putInt(TAG_SOURCE_Z, source.getZ());
	}

	@Override
	public void readAdditional(CompoundNBT cmp) {
		super.readAdditional(cmp);
		int x = cmp.getInt(TAG_SOURCE_X);
		int y = cmp.getInt(TAG_SOURCE_Y);
		int z = cmp.getInt(TAG_SOURCE_Z);
		source = new BlockPos(x, y, z);
	}

	public BlockPos getSource() {
		return source;
	}

	@OnlyIn(Dist.CLIENT)
	private static class HasturMusic extends TickableSound {
		private final EntityHastur hastur;

		public HasturMusic(EntityHastur hastur) {
			super(SoundHandler.ENTITY_HASTUR_MUSIC, SoundCategory.RECORDS);
			System.out.println("PLAYIBNG MUSCI");

			this.hastur = hastur;
			this.x = hastur.getSource().getX();
			this.y = hastur.getSource().getY();
			this.z = hastur.getSource().getZ();
			this.repeat = true; // TODO restore once LWJGL3/vanilla bug fixed?
		}

		@Override
		public void tick() {
			if (!hastur.isAlive()) {
				this.finishPlaying();
			}
		}
	}

}