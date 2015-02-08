package me.balink.nat.handlers;

import me.balink.nat.misc.KeyBindings;
import me.balink.nat.reference.Key;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class KeyInputEventHandler {

    @SubscribeEvent
    public void handleKeyInputEvent(InputEvent.KeyInputEvent event) {

    }

    private static Key getPressedKeybinding() {
        if(KeyBindings.explode.isPressed()) {
            return Key.EXPLODE;
        }
        else if(KeyBindings.deExplode.isPressed()) {
            return Key.DEEXPLODE;
        }

        return Key.UNKNOWN;
    }
}
