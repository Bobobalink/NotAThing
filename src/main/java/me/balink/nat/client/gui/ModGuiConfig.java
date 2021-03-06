package me.balink.nat.client.gui;

import me.balink.nat.handlers.ConfigurationHandler;
import me.balink.nat.reference.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.Arrays;

public class ModGuiConfig extends GuiConfig {

    public ModGuiConfig(GuiScreen guiScreen) {
        super(
                guiScreen,
                Arrays.<IConfigElement>asList(
                        new ConfigElement(ConfigurationHandler.config.getCategory(Configuration.CATEGORY_GENERAL)),
                        new ConfigElement(ConfigurationHandler.config.getCategory("specific"))),
                Reference.MOD_ID,
                false,
                false,
                GuiConfig.getAbridgedConfigPath(ConfigurationHandler.config.toString()));
    }
}
