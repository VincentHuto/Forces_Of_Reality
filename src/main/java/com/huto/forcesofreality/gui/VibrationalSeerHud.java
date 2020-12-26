package com.huto.forcesofreality.gui;

import java.text.DecimalFormat;

import org.lwjgl.opengl.GL11;

import com.huto.forcesofreality.capabilities.vibes.IVibrations;
import com.huto.forcesofreality.capabilities.vibes.VibrationProvider;
import com.huto.forcesofreality.gui.pages.GuiUtil;
import com.huto.forcesofreality.network.PacketHandler;
import com.huto.forcesofreality.network.vibes.VibrationPacketClient;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class VibrationalSeerHud extends Screen {
	/* These two variables describe the size of the bar */
	private final static int BAR_HEIGHT = 9;
	private final static int BAR_SPACING_ABOVE_EXP_BAR = 3; // pixels between the BAR and the Experience Bar below it
	public static float vibes = 0;
	public static float absVibes = 0;
	public static float sync = 0;

	private Minecraft mc = Minecraft.getInstance();
	ClientPlayerEntity player;

	public VibrationalSeerHud(ClientPlayerEntity playerIn, Minecraft mcI) {
		super(new StringTextComponent(""));
		this.player = playerIn;
		this.mc = mcI;

	}

	@Override
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		super.render(matrixStack, mouseX, mouseY, partialTicks);

	}

	/* This helper method will render the bar */
	@SuppressWarnings({ "unused", "static-access" })
	public void renderStatusBar(MatrixStack matrix, int screenWidth, int screenHeight, World world,
			PlayerEntity player) {
		IVibrations vibeCap = player.getCapability(VibrationProvider.VIBE_CAPA)
				.orElseThrow(IllegalArgumentException::new);
		PacketHandler.CHANNELVIBES.sendToServer(new VibrationPacketClient());
		String m = String.valueOf(vibes);
		FontRenderer fr = mc.fontRenderer;
		DecimalFormat d = new DecimalFormat("0.0");
		vibes = vibeCap.getVibes();
		absVibes = Math.abs(vibeCap.getVibes());
		final int vanillaExpLeftX = screenWidth / 2 - 91; // leftmost edge of the experience bar
		final int vanillaExpTopY = screenHeight - 9; // top of the experience bar

		int newBarWidth = 0;
		int newBarWidth2 = 0;
		int newBarWidth3 = 0;
		int vibesValue = 0;

		if (absVibes <= 300) {
			vibesValue = (int) (absVibes - 300);

			newBarWidth = (int) (absVibes) / 2;
		}
		if (absVibes > 300 && absVibes <= 600) {
			vibesValue = (int) (absVibes - 300);
			newBarWidth = 150;
			newBarWidth2 = (int) (vibesValue) / 2;
		}
		if (absVibes > 600 && absVibes <= 900) {
			vibesValue = (int) (absVibes - 600);

			newBarWidth = 150;
			newBarWidth2 = 150;
			newBarWidth3 = (int) (vibesValue) / 2;
		}
		if (absVibes >= 900) {
			newBarWidth = 150;
			newBarWidth2 = 150;
			newBarWidth3 = 150;
		}

		GL11.glPushMatrix();
		// Black
		GL11.glPushMatrix();
		GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.0F);
		GL11.glTranslatef(vanillaExpLeftX - 1 - 39, vanillaExpTopY + 3 - BAR_SPACING_ABOVE_EXP_BAR - BAR_HEIGHT + 8, 0);
		GL11.glScalef(0.75F, 0.75F, 0.75F);
		GuiUtil.drawTexturedModalRect(-130, -5, 0, 0, newBarWidth + 2, BAR_HEIGHT + 2);
		GL11.glPopMatrix();

		// Blue Bar
		if (this.absVibes <= 300) {
			// Blue
			GL11.glColor4f(0.0F, 1.0F, 1.0F, 1.0F);
			GL11.glTranslatef(vanillaExpLeftX - 39, vanillaExpTopY - BAR_SPACING_ABOVE_EXP_BAR - BAR_HEIGHT + 8, 0);
			GL11.glScalef(0.75F, 0.75F, 0.75F);
			GuiUtil.drawTexturedModalRect(-130, 0, 0, 0, newBarWidth, BAR_HEIGHT);
			// Purple Bar
		} else if (this.absVibes > 300 && this.absVibes <= 600) {
			// Blue
			GL11.glColor4f(0.0F, 1.0F, 1.0F, 1.0F);
			GL11.glTranslatef(vanillaExpLeftX - 39, vanillaExpTopY - BAR_SPACING_ABOVE_EXP_BAR - BAR_HEIGHT + 8, 0);
			GL11.glScalef(0.75F, 0.75F, 0.75F);
			GuiUtil.drawTexturedModalRect(-130, 0, 0, 0, newBarWidth, BAR_HEIGHT);
			// Black
			GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.0F);
			GuiUtil.drawTexturedModalRect(-131, -16, 0, 0, newBarWidth2 + 2, BAR_HEIGHT + 2);
			// Purple
			GL11.glColor4f(1.0F, 0.0F, 1.0F, 0.0F);
			GuiUtil.drawTexturedModalRect(-130, -15, 0, 0, newBarWidth2, BAR_HEIGHT);
		} else {
			// Blue
			GL11.glTranslatef(vanillaExpLeftX - 39, vanillaExpTopY - BAR_SPACING_ABOVE_EXP_BAR - BAR_HEIGHT + 8, 0);
			GL11.glScalef(0.75F, 0.75F, 0.75F);
			// Blue
			GL11.glColor4f(0.0F, 1.0F, 1.0F, 1.0F);
			GuiUtil.drawTexturedModalRect(-130, 0, 0, 0, newBarWidth, BAR_HEIGHT);
			// Black
			GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.0F);
			GuiUtil.drawTexturedModalRect(-131, -16, 0, 0, newBarWidth2 + 2, BAR_HEIGHT + 2);
			// Purple
			GL11.glColor4f(1.0F, 0.0F, 1.0F, 0.0F);
			GuiUtil.drawTexturedModalRect(-130, -15, 0, 0, newBarWidth2, BAR_HEIGHT);
			// Black
			GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.0F);
			GuiUtil.drawTexturedModalRect(-131, -31, 0, 0, newBarWidth3 + 2, BAR_HEIGHT + 2);
			// Red
			GL11.glColor4f(1.0F, 0.0F, 0.0F, 0.0F);
			GuiUtil.drawTexturedModalRect(-130, -30, 0, 0, newBarWidth3, BAR_HEIGHT);
		}

		GL11.glPushMatrix();
		// "vibes Value"
		GL11.glTranslatef(-53, 30, 0);
		fr.drawString(matrix, "Resonance", -fr.getStringWidth(d.format(vibes)) - 44, -29, 0x000000);
		fr.drawString(matrix, "Resonance", -fr.getStringWidth(d.format(vibes)) - 45, -29, 0x2F9AFF);
		GL11.glPopMatrix();
		// Digits
		GL11.glPushMatrix();
		GL11.glTranslatef(24, 21, 0);
		GL11.glScalef(1.0f, 1.0f, 1);
		// Shadow String
		fr.drawString(matrix, d.format(vibes), -50, -20, 0x000000);
		// Blue String renders after so its on top
		fr.drawString(matrix, d.format(vibes), -51, -20, 0x2F9AFF);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}
