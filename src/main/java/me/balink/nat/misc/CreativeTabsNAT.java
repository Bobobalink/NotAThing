package me.balink.nat.misc;

import me.balink.nat.init.ModItems;
import me.balink.nat.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabsNAT {
    public static final CreativeTabs tabNAT = new CreativeTabs(Reference.MOD_ID) {
        @Override
        public Item getTabIconItem() {
            return ModItems.randomThing;
        }
    };
}
