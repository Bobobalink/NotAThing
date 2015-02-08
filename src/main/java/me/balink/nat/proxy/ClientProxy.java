package me.balink.nat.proxy;

import me.balink.nat.misc.KeyBindings;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerKeyBindings() {
        ClientRegistry.registerKeyBinding(KeyBindings.explode);
        ClientRegistry.registerKeyBinding(KeyBindings.deExplode);
    }
}
