package me.balink.nat.Items;

import me.balink.nat.misc.CreativeTabsNAT;
import me.balink.nat.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemNAT extends Item {
    protected String name = "";

    public ItemNAT(String name) {
        super();
        this.name = name;
        GameRegistry.registerItem(this, this.name);
        this.setUnlocalizedName(Reference.MOD_ID + ":" + this.name);
        this.setCreativeTab(CreativeTabsNAT.tabNAT);
    }

    @SideOnly(Side.CLIENT)
    public void registerModel() {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + this.name, "inventory"));
    }
}
