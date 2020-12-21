package com.huto.forces_of_reality.objects.tileenties.util;

import javax.annotation.Nullable;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;

public final class ItemNBTHelper {

	private static final int[] EMPTY_INT_ARRAY = new int[0];

	/** Gets the CompoundNBT in an ItemStack. Tries to init it
	 * previously in case there isn't one present **/
	public static CompoundNBT getNBT(ItemStack stack) {
		if(!stack.hasTag())
			stack.setTag(new CompoundNBT());
		return stack.getTag();
	}

	// SETTERS ///////////////////////////////////////////////////////////////////

	public static void setBoolean(ItemStack stack, String tag, boolean b) {
		getNBT(stack).putBoolean(tag, b);
	}

	public static void setByte(ItemStack stack, String tag, byte b) {
		getNBT(stack).putByte(tag, b);
	}

	public static void setShort(ItemStack stack, String tag, short s) {
		getNBT(stack).putShort(tag, s);
	}

	public static void setInt(ItemStack stack, String tag, int i) {
		getNBT(stack).putInt(tag, i);
	}

	public static void setIntArray(ItemStack stack, String tag, int[] val) {
		getNBT(stack).putIntArray(tag, val);
	}

	public static void setLong(ItemStack stack, String tag, long l) {
		getNBT(stack).putLong(tag, l);
	}

	public static void setFloat(ItemStack stack, String tag, float f) {
		getNBT(stack).putFloat(tag, f);
	}

	public static void setDouble(ItemStack stack, String tag, double d) {
		getNBT(stack).putDouble(tag, d);
	}

	public static void setCompound(ItemStack stack, String tag, CompoundNBT cmp) {
		if(!tag.equalsIgnoreCase("ench")) // not override the enchantments
			getNBT(stack).put(tag, cmp);
	}

	public static void setString(ItemStack stack, String tag, String s) {
		getNBT(stack).putString(tag, s);
	}

	public static void setList(ItemStack stack, String tag, ListNBT list) {
		getNBT(stack).put(tag, list);
	}

	public static void removeEntry(ItemStack stack, String tag) {
		getNBT(stack).remove(tag);
	}

	// GETTERS ///////////////////////////////////////////////////////////////////

	public static boolean verifyExistance(ItemStack stack, String tag) {
		return !stack.isEmpty() && getNBT(stack).hasUniqueId(tag);
	}

	public static boolean getBoolean(ItemStack stack, String tag, boolean defaultExpected) {
		return verifyExistance(stack, tag) ? getNBT(stack).getBoolean(tag) : defaultExpected;
	}

	public static byte getByte(ItemStack stack, String tag, byte defaultExpected) {
		return verifyExistance(stack, tag) ? getNBT(stack).getByte(tag) : defaultExpected;
	}

	public static short getShort(ItemStack stack, String tag, short defaultExpected) {
		return verifyExistance(stack, tag) ? getNBT(stack).getShort(tag) : defaultExpected;
	}

	public static int getInt(ItemStack stack, String tag, int defaultExpected) {
		return verifyExistance(stack, tag) ? getNBT(stack).getInt(tag) : defaultExpected;
	}

	public static int[] getIntArray(ItemStack stack, String tag) {
		return verifyExistance(stack, tag) ? getNBT(stack).getIntArray(tag) : EMPTY_INT_ARRAY;
	}

	public static long getLong(ItemStack stack, String tag, long defaultExpected) {
		return verifyExistance(stack, tag) ? getNBT(stack).getLong(tag) : defaultExpected;
	}

	public static float getFloat(ItemStack stack, String tag, float defaultExpected) {
		return verifyExistance(stack, tag) ? getNBT(stack).getFloat(tag) : defaultExpected;
	}

	public static double getDouble(ItemStack stack, String tag, double defaultExpected) {
		return verifyExistance(stack, tag) ? getNBT(stack).getDouble(tag) : defaultExpected;
	}

	/** If nullifyOnFail is true it'll return null if it doesn't find any
	 * compounds, otherwise it'll return a new one. **/
	public static CompoundNBT getCompound(ItemStack stack, String tag, boolean nullifyOnFail) {
		return verifyExistance(stack, tag) ? getNBT(stack).getCompound(tag) : nullifyOnFail ? null : new CompoundNBT();
	}

	public static String getString(ItemStack stack, String tag, String defaultExpected) {
		return verifyExistance(stack, tag) ? getNBT(stack).getString(tag) : defaultExpected;
	}

	public static ListNBT getList(ItemStack stack, String tag, int objtype, boolean nullifyOnFail) {
		return verifyExistance(stack, tag) ? getNBT(stack).getList(tag, objtype) : nullifyOnFail ? null : new ListNBT();
	}

	/**
	 * Returns true if the `target` tag contains all of the tags and values present in the `template` tag. Recurses into
	 * compound tags and matches all template keys and values; recurses into list tags and matches the template against
	 * the first elements of target. Empty lists and compounds in the template will match target lists and compounds of
	 * any size.
	 */

	public static boolean matchTag(@Nullable INBT template, @Nullable INBT target) {
		if(template instanceof CompoundNBT && target instanceof CompoundNBT) {
			return matchTagCompound((CompoundNBT) template, (CompoundNBT) target);
		} else if(template instanceof ListNBT && target instanceof ListNBT) {
			return matchTagList((ListNBT) template, (ListNBT) target);
		} else {
			return template == null || (target != null && target.equals(template));
		}
	}

	private static boolean matchTagCompound(CompoundNBT template, CompoundNBT target) {
		if(template.size() > target.size()) return false;
		
		for(String key : template.keySet()) {
			if (!matchTag(template.get(key), target.get(key))) return false;
		}
		
		return true;
	}

	private static boolean matchTagList(ListNBT template, ListNBT target) {
		if (template.size() > target.size()) return false;

		for (int i = 0; i < template.size(); i++) {
			if (!matchTag(template.get(i), target.get(i))) return false;
		}

		return true;
	}

}
