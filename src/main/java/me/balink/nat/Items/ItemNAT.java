package me.balink.nat.Items;

import me.balink.nat.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemNAT extends Item {
    protected String name = "";

    public ItemNAT(String name) {
        super();
        this.name = name;
        GameRegistry.registerItem(this, this.name);
        this.setUnlocalizedName(Reference.MOD_ID + ":" + this.name);
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    public String getName() {
        return this.name;
    }
}
