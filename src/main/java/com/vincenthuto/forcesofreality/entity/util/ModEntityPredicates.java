package com.vincenthuto.forcesofreality.entity.util;

import java.util.function.Predicate;

import com.vincenthuto.forcesofreality.entity.guardian.EntityBeastFromBeyond;
import com.vincenthuto.forcesofreality.entity.mob.EntityDerangedBeast;
import com.vincenthuto.forcesofreality.entity.summon.EntitySummonedBeast;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.PolarBear;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Strider;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;

public class ModEntityPredicates {
	public static Predicate<Entity> WARMBLOODED = new Predicate<>() {
		@Override
		public boolean test(Entity e) {
			if (e instanceof Animal || e instanceof AmbientCreature || e instanceof AbstractVillager
					|| e instanceof Player) {
				return true;
			} else {
				return false;
			}
		}
	};
	public static Predicate<Entity> VORPAL = new Predicate<>() {
		@Override
		public boolean test(Entity e) {
			if (e instanceof Raider || e instanceof Zombie || e instanceof Skeleton || e instanceof WitherSkeleton
					|| e instanceof Spider || e instanceof WitherBoss || e instanceof Creeper
					|| e instanceof EntityBeastFromBeyond || e instanceof EntitySummonedBeast
					|| e instanceof EntityDerangedBeast || e instanceof Wolf || e instanceof AbstractPiglin
					|| e instanceof PolarBear) {
				return true;
			} else {
				return false;
			}
		}
	};

	public static Predicate<Entity> COLDBLOODED = new Predicate<>() {
		@Override
		public boolean test(Entity e) {
			if (e instanceof Raider || e instanceof Zombie || e instanceof WaterAnimal || e instanceof SnowGolem
					|| e instanceof Slime) {
				return true;
			} else {
				return false;
			}
		}
	};

	public static Predicate<Entity> UNDEAD = new Predicate<>() {
		@Override
		public boolean test(Entity e) {
			if (e instanceof Skeleton || e instanceof WitherSkeleton || e instanceof Spider || e instanceof IronGolem
					|| e instanceof Silverfish || e instanceof WitherBoss) {
				return true;
			} else {
				return false;
			}
		}
	};
	public static Predicate<Entity> ENDERBLOOD = new Predicate<>() {
		@Override
		public boolean test(Entity e) {
			if (e instanceof EnderMan || e instanceof Endermite || e instanceof Endermite || e instanceof EnderDragon
					|| e instanceof Shulker || e instanceof Phantom) {
				return true;
			} else {
				return false;
			}
		}
	};
	public static Predicate<Entity> INFERNALBLOOD = new Predicate<>() {
		@Override
		public boolean test(Entity e) {
			if (e instanceof Blaze || e instanceof AbstractPiglin || e instanceof MagmaCube || e instanceof Strider
					|| e instanceof Ghast || e instanceof Hoglin || e instanceof ZombifiedPiglin) {
				return true;
			} else {
				return false;
			}
		}
	};

	public static Predicate<Entity> PLANTBLOOD = new Predicate<>() {
		@Override
		public boolean test(Entity e) {
			if (e instanceof Creeper || e instanceof Slime) {
				return true;
			} else {
				return false;
			}
		}
	};

}
