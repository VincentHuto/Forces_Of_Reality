package com.huto.forcesofreality.network.coven;

import java.util.function.Supplier;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.util.Direction;
import net.minecraft.util.Direction.AxisDirection;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketAirDraw {

	float parTick;

	public PacketAirDraw() {
	}

	public PacketAirDraw(float par) {
		this.parTick = par;
	}

	public static PacketAirDraw decode(final PacketBuffer buffer) {
		buffer.readByte();
		return new PacketAirDraw(buffer.readFloat());
	}

	public static void encode(final PacketAirDraw message, final PacketBuffer buffer) {
		buffer.writeByte(0);
		buffer.writeFloat(message.parTick);
	}

	public static void handle(final PacketAirDraw message, final Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			PlayerEntity player = ctx.get().getSender();
			if (player == null)
				return;
			if (!player.world.isRemote) {
				float pTic = message.parTick;

				ServerWorld sWorld = (ServerWorld) player.world;
				RayTraceResult trace = player.pick(2, pTic, false);
				if (trace != null) {
					if (trace.getType() == RayTraceResult.Type.BLOCK) {
						BlockRayTraceResult bHit = (BlockRayTraceResult) trace;
						Vector3d look = player.getLook(pTic);
						float one_16th = 1.0f / 16.0f;
						double x = bHit.getPos().getX();
						double y = bHit.getPos().getY();
						double z = bHit.getPos().getZ();

						double hitX = x * one_16th;
						double hitY = y * one_16th;
						double hitZ = z * one_16th;
						Direction side = bHit.getFace();
						final double offset = 0.5;
						hitX += side.getXOffset() * offset;
						hitY += side.getYOffset() * offset;
						hitZ += side.getZOffset() * offset;
						final BitLocation loc = new BitLocation(bHit);
						Vector3d truePos = new Vector3d((loc.getBitX() + 1) / 16, (loc.getBitY() + 1) / 16,
								(loc.getBitZ() + 1) / 16);
						if (player.getHorizontalFacing().getAxisDirection() == AxisDirection.NEGATIVE) {
							System.out.println(truePos);
							sWorld.spawnParticle(RedstoneParticleData.REDSTONE_DUST, hitX, hitY, hitZ, 1,
									truePos.getX(), truePos.getY(), truePos.getZ(), 0.2);
						} else {
							if (player.getHorizontalFacing().getAxisDirection() == AxisDirection.POSITIVE) {
								System.out.println(truePos);
								sWorld.spawnParticle(RedstoneParticleData.REDSTONE_DUST, hitX, hitY, hitZ, 1,
										-truePos.getX(), truePos.getY(), -truePos.getZ(), 0.2);
							}
						}

					}
				}
			}

		});
		ctx.get().setPacketHandled(true);
	}

}