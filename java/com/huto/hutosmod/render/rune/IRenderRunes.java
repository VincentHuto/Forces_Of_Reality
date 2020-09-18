package com.huto.hutosmod.render.rune;

import com.huto.hutosmod.capabilities.mindrunes.IRune;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;

/**
 * A Bauble Item that implements this will be have hooks to render something on
 * the player while its equipped.
 * This class doesn't extend IBauble to make the API not depend on the Baubles
 * API, but the item in question still needs to implement IBauble.
 */
public interface IRenderRunes extends IRune {

    /**
     * Called for the rendering of the bauble on the player. The player instance can be
     * acquired through the event parameter. Transformations are already applied for
     * the RenderType passed in. Make sure to check against the type parameter for
     * rendering.
     */
    void onPlayerBaubleRender(PlayerEntity player, RenderType type, float partialTicks);


    /**
     * A few helper methods for the render.
     */
    final class Helper {

        /**
         * Rotates the render for a bauble correctly if the player is sneaking.
         * Use for renders under {@link RenderType#BODY}.
         */
        public static void rotateIfSneaking(PlayerEntity player) {
            if (player.isSneaking())
                applySneakingRotation();
        }

        /**
         * Rotates the render for a bauble correctly for a sneaking player.
         * Use for renders under {@link RenderType#BODY}.
         */
        @SuppressWarnings("deprecation")
		public static void applySneakingRotation() {
            GlStateManager.translatef(0F, 0.2F, 0F);
            GlStateManager.rotatef(90F / (float) Math.PI, 1.0F, 0.0F, 0.0F);
        }

        /**
         * Shifts the render for a bauble correctly to the head, including sneaking rotation.
         * Use for renders under {@link RenderType#HEAD}.
         */
        @SuppressWarnings("deprecation")
		public static void translateToHeadLevel(PlayerEntity player) {
            GlStateManager.translatef(0, -player.getEyeHeight(), 0);
            if (player.isSneaking())
                GlStateManager.translatef(0.25F * MathHelper.sin(player.rotationPitch * (float) Math.PI / 180), 0.25F * MathHelper.cos(player.rotationPitch * (float) Math.PI / 180), 0F);
        }

        /**
         * Shifts the render for a bauble correctly to the face.
         * Use for renders under {@link RenderType#HEAD}, and usually after calling {@link Helper#translateToHeadLevel(PlayerEntity)}.
         */
        @SuppressWarnings("deprecation")
		public static void translateToFace() {
            GlStateManager.rotatef(90F, 0F, 1F, 0F);
            GlStateManager.rotatef(180F, 1F, 0F, 0F);
            GlStateManager.translatef(0f, -4.35f, -1.27f);
        }

        /**
         * Scales down the render to a correct size.
         * Use for any render.
         */
        @SuppressWarnings("deprecation")
		public static void defaultTransforms() {
            GlStateManager.translatef(0.0f, 3.0f, 1.0f);
            GlStateManager.scalef(0.55f, 0.55f, 0.55f);
        }

        /**
         * Shifts the render for a bauble correctly to the chest.
         * Use for renders under {@link RenderType#BODY}, and usually after calling {@link Helper#rotateIfSneaking(PlayerEntity)}.
         */
        @SuppressWarnings("deprecation")
		public static void translateToChest() {
            GlStateManager.rotatef(180F, 1F, 0F, 0F);
            GlStateManager.translatef(0F, -3.2F, -0.85F);
        }
    }

    enum RenderType {
        /**
         * Render Type for the player's body, translations apply on the player's rotation.
         * Sneaking is not handled and should be done during the render.
         *
         * @see IRenderBauble.Helper
         */
        BODY,

        /**
         * Render Type for the player's body, translations apply on the player's head rotations.
         * Sneaking is not handled and should be done during the render.
         *
         * @see IRenderBauble.Helper
         */
        HEAD;
    }
}