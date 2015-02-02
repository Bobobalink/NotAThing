package me.balink.nat;

import me.balink.nat.handlers.ConfigurationHandler;
import me.balink.nat.init.ModItems;
import me.balink.nat.proxy.IProxy;
import me.balink.nat.reference.Reference;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class NotaThing {

    @Mod.Instance(Reference.MOD_ID)
    public static NotaThing instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        if(event.getSide() == Side.CLIENT)
            ModItems.clientInit();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
