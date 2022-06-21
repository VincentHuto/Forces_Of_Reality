package com.vincenthuto.forcesofreality.font;

import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.loading.StringUtils;

public class ModTextFormatting {

	/***
	 *
	 * @param parString
	 * @param parShineLocation
	 * @param parReturnToBlack
	 * @return
	 */
	public static Rarity AURIC = Rarity.create("Auric", ChatFormatting.GOLD);

	public static String stringToGolden(String parString, int parShineLocation, boolean parReturnToBlack) {
		int stringLength = parString.length();
		if (stringLength < 1) {
			return "";
		}
		String outputString = "";
		for (int i = 0; i < stringLength; i++) {
			if ((i + parShineLocation + System.nanoTime() / 20) % 88 == 0) {
				outputString = outputString + ChatFormatting.WHITE + parString.substring(i, i + 1);
			} else if ((i + parShineLocation + System.nanoTime() / 20) % 88 == 1) {
				outputString = outputString + ChatFormatting.GOLD + parString.substring(i, i + 1);
			} else if ((i + parShineLocation + System.nanoTime() / 20) % 88 == 87) {
				outputString = outputString + ChatFormatting.WHITE + parString.substring(i, i + 1);
			} else {
				outputString = outputString + ChatFormatting.BLACK + parString.substring(i, i + 1);
			}
		}
		// return color to a common one after (most chat is white, but for other GUI
		// might want black)
		if (parReturnToBlack) {
			return outputString + ChatFormatting.BLACK;
		}
		return outputString + ChatFormatting.WHITE;
	}

	@OnlyIn(Dist.CLIENT)
	public static String stringToBlueObf(String parString, int parShineLocation, boolean parReturnToBlack) {
		int stringLength = parString.length();
		if (stringLength < 1) {
			return "";
		}
		String outputString = "";
		for (int i = 0; i < stringLength; i++) {
			if ((i + parShineLocation + System.nanoTime() / 20) % 88 == 0) {
				outputString = outputString + ChatFormatting.OBFUSCATED + parString.substring(i, i + 1);
			} else if ((i + parShineLocation + System.nanoTime() / 20) % 88 == 1) {
				outputString = outputString + ChatFormatting.RED + parString.substring(i, i + 1);
			} else if ((i + parShineLocation + System.nanoTime() / 20) % 88 == 87) {
				outputString = outputString + ChatFormatting.OBFUSCATED + parString.substring(i, i + 1);
			} else {
				outputString = outputString + ChatFormatting.RED + parString.substring(i, i + 1);
			}
		}
		// return color to a common one after (most chat is white, but for other GUI
		// might want black)
		if (parReturnToBlack) {
			return outputString + ChatFormatting.BLACK;
		}
		return outputString + ChatFormatting.WHITE;
	}

	@OnlyIn(Dist.CLIENT)
	public static String stringToRedObf(String parString, int parShineLocation, boolean parReturnToBlack) {
		int stringLength = parString.length();
		if (stringLength < 1) {
			return "";
		}
		String outputString = "";
		for (int i = 0; i < stringLength; i++) {
			if ((i + parShineLocation + System.nanoTime() / 20) % 88 == 0) {
				outputString = outputString + ChatFormatting.OBFUSCATED + parString.substring(i, i + 1);
			} else if ((i + parShineLocation + System.nanoTime() / 20) % 88 == 1) {
				outputString = outputString + ChatFormatting.RED + parString.substring(i, i + 1);
			} else if ((i + parShineLocation + System.nanoTime() / 20) % 88 == 87) {
				outputString = outputString + ChatFormatting.OBFUSCATED + parString.substring(i, i + 1);
			} else {
				outputString = outputString + ChatFormatting.BLACK + parString.substring(i, i + 1);
			}
		}
		// return color to a common one after (most chat is white, but for other GUI
		// might want black)
		if (parReturnToBlack) {
			return outputString + ChatFormatting.BLACK;
		}
		return outputString + ChatFormatting.WHITE;
	}

	@OnlyIn(Dist.CLIENT)
	public static String stringToRainbow(String parString, boolean parReturnToBlack) {
		int stringLength = parString.length();
		if (stringLength < 1) {
			return "";
		}
		String outputString = "";
		ChatFormatting[] colorChar = { ChatFormatting.RED, ChatFormatting.GOLD, ChatFormatting.YELLOW,
				ChatFormatting.GREEN, ChatFormatting.AQUA, ChatFormatting.BLUE, ChatFormatting.LIGHT_PURPLE,
				ChatFormatting.DARK_PURPLE };
		for (int i = 0; i < stringLength; i++) {
			outputString = outputString + colorChar[i % 8] + parString.substring(i, i + 1);
		}
		// return color to a common one after (most chat is white, but for other GUI
		// might want black)
		if (parReturnToBlack) {
			return outputString + ChatFormatting.BLACK;
		}
		return outputString + ChatFormatting.WHITE;
	}

	/***
	 *
	 * @param input a string to be formated
	 * @return a string formated red or blue depending of the resonant type >0 =
	 *         blue <0 = red
	 */
	@OnlyIn(Dist.CLIENT)
	public static String stringToResonant(String parString) {

		float stringValue = Float.parseFloat(parString);
		int stringLength = parString.length();
		if (stringLength < 1) {
			return "";
		}

		System.out.println(stringValue);
		String outputString = "";
		ChatFormatting[] karmicColors = { ChatFormatting.RED, ChatFormatting.DARK_RED, ChatFormatting.BLUE,
				ChatFormatting.AQUA };
		ChatFormatting[] ManaColors = { ChatFormatting.BLUE, ChatFormatting.AQUA };
		if (stringValue > 0) {

			for (int i = 0; i < stringLength; i++) {
				outputString = ChatFormatting.ITALIC + outputString + ManaColors[i % 2] + parString.substring(i, i + 1);
			}
		} else if (stringValue < 0) {
			for (int i = 0; i < stringLength; i++) {
				outputString = ChatFormatting.ITALIC + outputString + karmicColors[i % 2]
						+ parString.substring(i, i + 1);
			}

		} else if (stringValue == 0.0) {
			for (int i = 0; i < stringLength; i++) {
				outputString = ChatFormatting.WHITE + parString;
			}
		}
		return outputString;
	}

	/***
	 *
	 * @param input a string to be formated
	 * @return a string formated as such hello world = Hello world || teSt = Test
	 */

	public static String toProperCase(String input) {
		String newString = "";
		String culledString = input.replaceAll("_", " ");
		input = culledString;
		for (int i = 0; i < input.length(); i++) {

			if (i == 0) {
				String temp = StringUtils.toUpperCase(String.valueOf(input.charAt(i)));
				newString = newString + temp;
			} else {
				String temp = StringUtils.toLowerCase(String.valueOf(input.charAt(i)));
				newString = newString + temp;

			}
		}
		return newString;
	}

	public static String convertInitToLang(String text) {
		if (text == null || text.isEmpty()) {
			return text;
		}

		StringBuilder converted = new StringBuilder();
		boolean convertNext = true;
		for (char ch : text.toCharArray()) {
			if (ch == '_') {
				ch = ' ';
				convertNext = true;
			} else if (convertNext) {
				ch = Character.toTitleCase(ch);
				convertNext = false;
			} else {
				ch = Character.toLowerCase(ch);
			}
			converted.append(ch);
		}

		return converted.toString();
	}

}
