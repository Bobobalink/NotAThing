package me.balink.nat.init;

import me.balink.nat.Items.ItemNAT;
import me.balink.nat.Items.ItemRandomThing;
import me.balink.nat.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
    public static final ItemNAT randomThing = new ItemRandomThing();

    @SideOnly(Side.CLIENT)
    public static void clientInit() {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(randomThing, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + randomThing.getName(), "inventory"));
    }
}
