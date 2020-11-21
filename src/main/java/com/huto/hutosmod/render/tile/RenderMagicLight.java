package com.huto.hutosmod.render.tile;

import java.util.Random;

import com.huto.hutosmod.objects.tileenties.TileEntityMagicLight;
import com.huto.hutosmod.particles.glow.GlowParticleData;
import com.huto.hutosmod.particles.glow.ParticleColor;
import com.huto.hutosmod.particles.glow.ParticleUtil;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RenderMagicLight extends TileEntityRenderer<TileEntityMagicLight> {
    public RenderMagicLight(TileEntityRendererDispatcher p_i226006_1_) {
        super(p_i226006_1_);
    }

    @Override
    public void render(TileEntityMagicLight lightTile, float v, MatrixStack matrixStack, IRenderTypeBuffer iRenderTypeBuffer, int i, int i1) {
        World world = lightTile.getWorld();
        BlockPos pos = lightTile.getPos();
        Random rand = world.rand;
        world.addParticle(
                GlowParticleData.createData(new ParticleColor(
                        rand.nextInt(lightTile.red),
                        rand.nextInt(lightTile.green),
                        rand.nextInt(lightTile.blue)
                )),
                pos.getX() +0.5 + ParticleUtil.inRange(-0.1, 0.1)  , pos.getY() +0.5  + ParticleUtil.inRange(-0.1, 0.1) , pos.getZ() +0.5 + ParticleUtil.inRange(-0.1, 0.1),
                0,0,0);;
    }
}