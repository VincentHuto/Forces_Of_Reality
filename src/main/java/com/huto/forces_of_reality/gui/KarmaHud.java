package com.huto.forces_of_reality.gui;

import java.text.DecimalFormat;

import org.lwjgl.opengl.GL11;

import com.huto.forces_of_reality.capabilities.karma.IKarma;
import com.huto.forces_of_reality.capabilities.karma.KarmaProvider;
import com.huto.forces_of_reality.capabilities.karma.activation.IKarmaActivation;
import com.huto.forces_of_reality.capabilities.karma.activation.KarmaActivationProvider;
import com.huto.forces_of_reality.network.PacketHandler;
import com.huto.forces_of_reality.network.karma.KarmaActivationPacketClient;
import com.huto.forces_of_reality.network.karma.KarmaPacketClient;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class KarmaHud extends Screen {

	public static float karma = 0;
	private Minecraft mc;
	ClientPlayerEntity player;

	public KarmaHud(ClientPlayerEntity playerIn, Minecraft mcI) {
		super(new StringTextComponent(""));
		this.player = playerIn;
		this.mc = mcI;

	}

	@Override
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		super.render(matrixStack, mouseX, mouseY, partialTicks);

	}

	/* This helper method will render the bar */
	public void renderStatusBar(MatrixStack matrix, int screenWidth, int screenHeight, World world,
			ClientPlayerEntity playerIn) {
		if (playerIn != null) {
			IKarma karmaCap = playerIn.getCapability(KarmaProvider.KARMA_CAPA)
					.orElseThrow(IllegalArgumentException::new);
			IKarmaActivation karmaAct = playerIn.getCapability(KarmaActivationProvider.KARMA_CAPA)
					.orElseThrow(IllegalStateException::new);
			if (karmaAct != null) {
				PacketHandler.CHANNELKARMA.sendToServer(new KarmaActivationPacketClient());

				if (karmaAct.getActivation() != 0) {
					if (karmaCap != null) {

						PacketHandler.CHANNELKARMA.sendToServer(new KarmaPacketClient());
						karma = karmaCap.getKarma();
						String m = String.valueOf(karma);
						DecimalFormat d = new DecimalFormat("0.0");

						FontRenderer fr = mc.fontRenderer;
						final int vanillaExpLeftX = screenWidth / 2 - 91; // leftmost edge of the experience bar
						final int vanillaExpTopY = screenHeight - 9; // top of the experience bar

						GL11.glPushMatrix();
						GL11.glTranslatef(vanillaExpLeftX + 320, vanillaExpTopY - 8, 0);

						GL11.glPushMatrix();
						// "karma Value"
						GL11.glTranslatef(-53, 30, 0);
						fr.drawString(matrix, "Karma Value: ", -fr.getStringWidth(d.format(karma)) - 50, -30, 0x000000);
						fr.drawString(matrix, "Karma Value: ", -fr.getStringWidth(d.format(karma)) - 51, -30, 0xFFFFFF);
						GL11.glPopMatrix();

						// Digits
						GL11.glPushMatrix();
						GL11.glTranslatef(0, 21, 0);
						// Shadow String
						fr.drawString(matrix, m, -50, -20, 0x000000);
						// Blue String renders after so its on top
						fr.drawString(matrix, m, -51, -21, 0xFFFFFF);
						GL11.glPopMatrix();

						GL11.glPopMatrix();

					}
				}
			}
		}
	}
}
