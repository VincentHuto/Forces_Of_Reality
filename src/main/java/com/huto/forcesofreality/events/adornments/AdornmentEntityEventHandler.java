package com.huto.forcesofreality.events.adornments;

import java.util.Collection;
import java.util.Collections;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.capabilitie.adornment.AdornmentsCapabilities;
import com.huto.forcesofreality.capabilitie.adornment.AdornmentsContainer;
import com.huto.forcesofreality.capabilitie.adornment.AdornmentsContainerProvider;
import com.huto.forcesofreality.capabilitie.adornment.IAdornmentsItemHandler;
import com.huto.forcesofreality.network.PacketHandler;
import com.huto.forcesofreality.network.adornment.SyncPacket;

import net.minecraft.world.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.GameRules;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.PacketDistributor;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AdornmentEntityEventHandler {

    @SubscribeEvent
    public static void cloneCapabilitiesEvent(PlayerEvent.Clone event) {
        try {
            event.getOriginal().getCapability(AdornmentsCapabilities.ADORNMENTS).ifPresent(bco -> {
                CompoundTag nbt = ((AdornmentsContainer) bco).serializeNBT();
                event.getOriginal().getCapability(AdornmentsCapabilities.ADORNMENTS).ifPresent(bcn -> {
                    ((AdornmentsContainer) bcn).deserializeNBT(nbt);
                });
            });
        } catch (Exception e) {
            System.out.println("Could not clone player [" + event.getOriginal().getName() + "] runes when changing dimensions");
        }
    }

    @SubscribeEvent
    public static void attachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            event.addCapability(new ResourceLocation(ForcesOfReality.MOD_ID, "container"), new AdornmentsContainerProvider((Player) event.getObject()));
        }
    }

    @SubscribeEvent
    public static void playerJoin(EntityJoinWorldEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer player = (ServerPlayer) entity;
            syncSlots(player, Collections.singletonList(player));
        }
    }

    @SubscribeEvent
    public static void onStartTracking(PlayerEvent.StartTracking event) {
        Entity target = event.getTarget();
        if (target instanceof ServerPlayer) {
            syncSlots((ServerPlayer) target, Collections.singletonList(event.getPlayer()));
        }
    }

    @SubscribeEvent
    public static void playerTick(TickEvent.PlayerTickEvent event) {
        // player events
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            player.getCapability(AdornmentsCapabilities.ADORNMENTS).ifPresent(IAdornmentsItemHandler::tick);
        }
    }

    private static void syncSlots(Player player, Collection<? extends Player> receivers) {
        player.getCapability(AdornmentsCapabilities.ADORNMENTS).ifPresent(runes -> {
            for (byte i = 0; i < runes.getSlots(); i++) {
                syncSlot(player, i, runes.getStackInSlot(i), receivers);
            }
        });
    }

    public static void syncSlot(Player player, byte slot, ItemStack stack, Collection<? extends Player> receivers) {
        SyncPacket pkt = new SyncPacket(player.getEntityId(), slot, stack);
        for (PlayerEntity receiver : receivers) {
            PacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) receiver), pkt);
        }
    }

    @SubscribeEvent
    public static void playerDeath(LivingDropsEvent event) {
        if (event.getEntity() instanceof PlayerEntity && !event.getEntity().world.isRemote && !event.getEntity().world.getGameRules().getBoolean(GameRules.KEEP_INVENTORY)) {
            dropItemsAt((PlayerEntity) event.getEntity(), event.getDrops());
        }
    }

    private static void dropItemsAt(PlayerEntity player, Collection<ItemEntity> drops) {
        player.getCapability(AdornmentsCapabilities.ADORNMENTS).ifPresent(runes -> {
            for (int i = 0; i < runes.getSlots(); ++i) {
                if (!runes.getStackInSlot(i).isEmpty()) {
                    ItemEntity ei = new ItemEntity(player.world, player.getPosX(), player.getPosY() + player.getEyeHeight(), player.getPosZ(), runes.getStackInSlot(i).copy());
                    ei.setPickupDelay(40);
                    drops.add(ei);
                    runes.setStackInSlot(i, ItemStack.EMPTY);
                }
            }
        });
    }
}