//package com.vincenthuto.forcesofreality.item;
//
//import java.util.List;
//
//import com.vincenthuto.forcesofreality.capa.adornment.AdornmentType;
//import com.vincenthuto.forcesofreality.capa.adornment.IAdornment;
//import com.vincenthuto.forcesofreality.capa.covenant.CovenantProvider;
//import com.vincenthuto.forcesofreality.capa.covenant.EnumCovenants;
//import com.vincenthuto.forcesofreality.capa.covenant.ICovenant;
//import com.vincenthuto.forcesofreality.font.ModTextFormatting;
//import com.vincenthuto.forcesofreality.network.PacketHandler;
//import com.vincenthuto.forcesofreality.network.coven.PacketCovenantServer;
//
//import net.minecraft.ChatFormatting;
//import net.minecraft.network.chat.Component;
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraft.world.entity.Entity;
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.TooltipFlag;
//import net.minecraft.world.level.Level;
//import net.minecraftforge.network.PacketDistributor;
//
//public class ItemAdornment extends Item implements IAdornment {
//
//	EnumCovenants assignedCovenant;
//	int deepenAmount;
//
//	public ItemAdornment(Properties properties, EnumCovenants covenIn, int deepenAmountIn) {
//		super(properties);
//		this.assignedCovenant = covenIn;
//		this.deepenAmount = deepenAmountIn;
//	}
//
//	@Override
//	public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
//		super.appendHoverText(stack, worldIn, tooltip, flagIn);
//		tooltip.add(Component.translatable(
//				ChatFormatting.GOLD + "Devoted Coven: " + ModTextFormatting.toProperCase(assignedCovenant.name())));
//		tooltip.add(Component.translatable(ChatFormatting.GREEN + "Devotion Amount: " + deepenAmount));
//
//	}
//
//	@Override
//	public AdornmentType getAdornmentType() {
//		return AdornmentType.MINOR;
//	}
//
//	public EnumCovenants getAssignedCovenant() {
//		return assignedCovenant;
//	}
//
//	public int getDeepenAmount() {
//		return deepenAmount;
//	}
//
//	@Override
//	public void inventoryTick(ItemStack stack, Level worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
//		super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
//
//	}
//
//	@Override
//	public void onEquipped(LivingEntity player) {
//		if (player instanceof Player) {
//			if (!player.getCommandSenderWorld().isClientSide) {
//				ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
//						.orElseThrow(IllegalArgumentException::new);
//				if (coven != null) {
//					coven.setCovenDevotion(getAssignedCovenant(), getDeepenAmount());
//					Player playerEnt = (Player) player;
//					PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) playerEnt),
//							new PacketCovenantServer(coven.getDevotion()));
//				}
//			}
//		}
//	}
//
//	@Override
//	public void onUnequipped(LivingEntity player) {
//		if (player instanceof Player) {
//			if (!player.getCommandSenderWorld().isClientSide) {
//				ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
//						.orElseThrow(IllegalArgumentException::new);
//				if (coven != null) {
//					coven.setCovenDevotion(getAssignedCovenant(), -getDeepenAmount());
//					Player playerEnt = (Player) player;
//					PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) playerEnt),
		//					new PacketCovenantServer(coven.getDevotion()));
//				}
//			}
//		}
//
//	}
//
//	public void setAssignedCovenant(EnumCovenants assignedCovenant) {
//		this.assignedCovenant = assignedCovenant;
//	}
//
//	public void setDeepenAmount(int deepenAmount) {
//		this.deepenAmount = deepenAmount;
//	}
//
//}
