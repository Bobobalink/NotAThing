package me.balink.nat.init;

import me.balink.nat.Items.ItemBuildLaser;
import me.balink.nat.Items.ItemNAT;
import me.balink.nat.Items.ItemRandomThing;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
    public static final ItemNAT randomThing = new ItemRandomThing();
    public static final ItemNAT buildLaser = new ItemBuildLaser();

    @SideOnly(Side.CLIENT)
    public static void modelInit() {
        randomThing.registerModel();
        buildLaser.registerModel();
    }
}
