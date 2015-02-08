package me.balink.nat.misc;

import me.balink.nat.reference.Names;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public class KeyBindings {
    public static KeyBinding explode   = new KeyBinding(Names.Keys.EXPLODE, Keyboard.KEY_C, Names.Keys.CATEGORY);
    public static KeyBinding deExplode = new KeyBinding(Names.Keys.DEEXPLODE, Keyboard.KEY_X, Names.Keys.CATEGORY);
}
