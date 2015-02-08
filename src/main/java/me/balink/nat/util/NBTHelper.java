/*
obtained from Pahimar's let's mod reboot
https://github.com/pahimar/LetsModReboot
 */

package me.balink.nat.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class NBTHelper {
    public static boolean hasTag(ItemStack itemStack, String keyName) {
        return itemStack != null && itemStack.getTagCompound() != null && itemStack.getTagCompound().hasKey(keyName);
    }

    public static void removeTag(ItemStack itemStack, String keyName) {
        if(itemStack.getTagCompound() != null) {
            itemStack.getTagCompound().removeTag(keyName);
        }
    }

    /**
     * Initializes the NBT Tag Compound for the given ItemStack if it is null
     *
     * @param itemStack The ItemStack for which its NBT Tag Compound is being checked for initialization
     */
    private static void initNBTTagCompound(ItemStack itemStack) {
        if(itemStack.getTagCompound() == null) {
            itemStack.setTagCompound(new NBTTagCompound());
        }
    }

    public static void setLong(ItemStack itemStack, String keyName, long keyValue) {
        initNBTTagCompound(itemStack);

        itemStack.getTagCompound().setLong(keyName, keyValue);
    }

    // String
    public static String getString(ItemStack itemStack, String keyName) {
        return getString(itemStack, keyName, "");
    }

    public static String getString(ItemStack itemStack, String keyName, String defaultValue) {
        initNBTTagCompound(itemStack);

        if(!itemStack.getTagCompound().hasKey(keyName)) {
            setString(itemStack, keyName, defaultValue);
        }

        return itemStack.getTagCompound().getString(keyName);
    }

    public static void setString(ItemStack itemStack, String keyName, String keyValue) {
        initNBTTagCompound(itemStack);

        itemStack.getTagCompound().setString(keyName, keyValue);
    }

    // boolean
    public static boolean getBoolean(ItemStack itemStack, String keyName) {
        return getBoolean(itemStack, keyName, false);

    }

    public static boolean getBoolean(ItemStack itemStack, String keyName, Boolean defaultValue) {
        initNBTTagCompound(itemStack);

        if(!itemStack.getTagCompound().hasKey(keyName)) {
            setBoolean(itemStack, keyName, defaultValue);
        }

        return itemStack.getTagCompound().getBoolean(keyName);
    }

    public static void setBoolean(ItemStack itemStack, String keyName, boolean keyValue) {
        initNBTTagCompound(itemStack);

        itemStack.getTagCompound().setBoolean(keyName, keyValue);
    }

    // byte
    public static byte getByte(ItemStack itemStack, String keyName) {
        return getByte(itemStack, keyName, (byte) 0);

    }

    public static byte getByte(ItemStack itemStack, String keyName, byte defaultValue) {
        initNBTTagCompound(itemStack);

        if(!itemStack.getTagCompound().hasKey(keyName)) {
            setByte(itemStack, keyName, defaultValue);
        }

        return itemStack.getTagCompound().getByte(keyName);
    }

    public static void setByte(ItemStack itemStack, String keyName, byte keyValue) {
        initNBTTagCompound(itemStack);

        itemStack.getTagCompound().setByte(keyName, keyValue);
    }

    // short
    public static short getShort(ItemStack itemStack, String keyName) {
        return getShort(itemStack, keyName, (short) 0);
    }

    public static short getShort(ItemStack itemStack, String keyName, short defaultValue) {
        initNBTTagCompound(itemStack);

        if(!itemStack.getTagCompound().hasKey(keyName)) {
            setShort(itemStack, keyName, defaultValue);
        }

        return itemStack.getTagCompound().getShort(keyName);
    }

    public static void setShort(ItemStack itemStack, String keyName, short keyValue) {
        initNBTTagCompound(itemStack);

        itemStack.getTagCompound().setShort(keyName, keyValue);
    }

    // int
    public static int getInt(ItemStack itemStack, String keyName) {
        return getInt(itemStack, keyName, 0);
    }

    public static int getInt(ItemStack itemStack, String keyName, int defaultValue) {
        initNBTTagCompound(itemStack);

        if(!itemStack.getTagCompound().hasKey(keyName)) {
            setInteger(itemStack, keyName, defaultValue);
        }

        return itemStack.getTagCompound().getInteger(keyName);
    }

    public static void setInteger(ItemStack itemStack, String keyName, int keyValue) {
        initNBTTagCompound(itemStack);

        itemStack.getTagCompound().setInteger(keyName, keyValue);
    }

    // long
    public static long getLong(ItemStack itemStack, String keyName) {
        return getLong(itemStack, keyName, 0);
    }

    public static long getLong(ItemStack itemStack, String keyName, long defaultValue) {
        initNBTTagCompound(itemStack);

        if(!itemStack.getTagCompound().hasKey(keyName)) {
            setLong(itemStack, keyName, defaultValue);
        }

        return itemStack.getTagCompound().getLong(keyName);
    }

    // float
    public static float getFloat(ItemStack itemStack, String keyName) {
        return getFloat(itemStack, keyName, 0f);
    }

    public static float getFloat(ItemStack itemStack, String keyName, float defaultValue) {
        initNBTTagCompound(itemStack);

        if(!itemStack.getTagCompound().hasKey(keyName)) {
            setFloat(itemStack, keyName, defaultValue);
        }

        return itemStack.getTagCompound().getFloat(keyName);
    }

    public static void setFloat(ItemStack itemStack, String keyName, float keyValue) {
        initNBTTagCompound(itemStack);

        itemStack.getTagCompound().setFloat(keyName, keyValue);
    }

    // double
    public static double getDouble(ItemStack itemStack, String keyName) {
        return getDouble(itemStack, keyName, 0);
    }

    public static double getDouble(ItemStack itemStack, String keyName, double defaultValue) {
        initNBTTagCompound(itemStack);

        if(!itemStack.getTagCompound().hasKey(keyName)) {
            setDouble(itemStack, keyName, defaultValue);
        }

        return itemStack.getTagCompound().getDouble(keyName);
    }

    public static void setDouble(ItemStack itemStack, String keyName, double keyValue) {
        initNBTTagCompound(itemStack);

        itemStack.getTagCompound().setDouble(keyName, keyValue);
    }
}