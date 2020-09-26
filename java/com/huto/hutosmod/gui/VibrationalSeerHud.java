package com.huto.hutosmod.gui;

import java.text.DecimalFormat;

import org.lwjgl.opengl.GL11;

import com.huto.hutosmod.capabilities.vibes.IVibrations;
import com.huto.hutosmod.capabilities.vibes.VibrationProvider;
import com.huto.hutosmod.gui.pages.GuiUtil;
import com.huto.hutosmod.network.PacketHandler;
import com.huto.hutosmod.network.VibrationPacketClient;
import com.huto.hutosmod.network.VibrationPacketServer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.PacketDistributor;

@OnlyIn(Dist.CLIENT)
public class VibrationalSeerHud extends Screen {
	/* These two variables describe the size of the bar */
	private final static int BAR_HEIGHT = 9;
	private final static int BAR_SPACING_ABOVE_EXP_BAR = 3; // pixels between the BAR and the Experience Bar below it
	public static float vibes = 0;
	public static float sync = 0;

	private Minecraft mc = Minecraft.getInstance();
	ClientPlayerEntity player;

	public VibrationalSeerHud(ClientPlayerEntity playerIn) {
		super(new StringTextComponent(""));
		this.player = playerIn;

	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		super.render(matrixStack, mouseX, mouseY, partialTicks);
		IVibrations vibeCap = player.getCapability(VibrationProvider.VIBE_CAPA)
				.orElseThrow(IllegalArgumentException::new);
		vibes = vibeCap.getVibes();
		DecimalFormat d = new DecimalFormat("0.0");
		FontRenderer fr = mc.fontRenderer;
		GlStateManager.translatef(0, 0, 10f);
		fr.drawString(matrixStack, "vibes Value", -fr.getStringWidth(d.format(vibes)) - 49, -29, 0x000000);

	}

	/* This helper method will render the bar */
	@SuppressWarnings({ "unused", "static-access" })
	public void renderStatusBar(int screenWidth, int screenHeight, World world, PlayerEntity player) {
		IVibrations vibeCap = player.getCapability(VibrationProvider.VIBE_CAPA)
				.orElseThrow(IllegalArgumentException::new);
		PacketHandler.CHANNELVIBES.sendToServer(new VibrationPacketClient());
		String m = String.valueOf(vibes);
		FontRenderer fr = mc.fontRenderer;
		DecimalFormat d = new DecimalFormat("0.0");
		// System.out.println(vibeCap.getVibes());
		vibes = vibeCap.getVibes();
		final int vanillaExpLeftX = screenWidth / 2 - 91; // leftmost edge of the experience bar
		final int vanillaExpTopY = screenHeight - 9; // top of the experience bar

		int newBarWidth = 0;
		int newBarWidth2 = 0;
		int newBarWidth3 = 0;
		int vibesValue = 0;
		if (vibes <= 300) {
			vibesValue = (int) (vibes - 300);

			newBarWidth = (int) (vibes) / 2;
		}
		if (vibes > 300 && vibes <= 600) {
			vibesValue = (int) (vibes - 300);
			newBarWidth = 150;
			newBarWidth2 = (int) (vibesValue) / 2;
		}
		if (vibes > 600 && vibes <= 900) {
			vibesValue = (int) (vibes - 600);

			newBarWidth = 150;
			newBarWidth2 = 150;
			newBarWidth3 = (int) (vibesValue) / 2;
		}
		if (vibes >= 900) {
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
		if (this.vibes <= 300) {
			// Blue
			GL11.glColor4f(0.0F, 1.0F, 1.0F, 1.0F);
			GL11.glTranslatef(vanillaExpLeftX - 39, vanillaExpTopY - BAR_SPACING_ABOVE_EXP_BAR - BAR_HEIGHT + 8, 0);
			GL11.glScalef(0.75F, 0.75F, 0.75F);
			GuiUtil.drawTexturedModalRect(-130, 0, 0, 0, newBarWidth, BAR_HEIGHT);
			// Purple Bar
		} else if (this.vibes > 300 && this.vibes <= 600) {
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
		// GL11.glScalef(1.0f, 1.20f, 1);
		GL11.glTranslatef(-53, 30, 0);
		// fr.drawString(null, "vibes Value", -fr.getStringWidth(d.format(vibes)) - 49,
		// -29, 0x000000);
		// fr.drawString("vibes Value", -fr.getStringWidth(d.format(vibes)) - 50, -29,
		// 0x2F9AFF);
		GL11.glPopMatrix();
		// Digits
		GL11.glPushMatrix();
		GL11.glTranslatef(24, 21, 0);
		GL11.glScalef(1.0f, 1.0f, 1);
		// Shadow String
		// fr.drawString(d.format(vibes), -50, -20, 0x000000);
		// Blue String renders after so its on top
		// fr.drawString(d.format(vibes), -51, -20, 0x2F9AFF);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		// GL11.glPopAttrib();
	}

}
