package me.balink.nat.handlers;

import me.balink.nat.reference.Reference;
import me.balink.nat.util.LogHelper;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class configHandler {
    public static Configuration config;
    public static boolean configA = false;
    public static double configB = 0d;

    public static void init(File cFile) {
        if(config == null) {
            config = new Configuration(cFile);
            loadConfig();
        }

    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        LogHelper.info("config changed for " + event.modID);
        if(event.modID.equals(Reference.MOD_ID))
            loadConfig();
    }

    private static void loadConfig() {
        configA = config.get(Configuration.CATEGORY_GENERAL, "configA", false, "changes absolutely nothing").getBoolean();
        configB = config.get("specific", "configB", 0.5, "does very little").getDouble();

        if(config.hasChanged()) config.save();

        LogHelper.info("configA: " + configA);
        LogHelper.info("configB: " + configB);
    }
}
