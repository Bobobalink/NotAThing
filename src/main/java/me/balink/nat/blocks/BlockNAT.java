package me.balink.nat.blocks;

import me.balink.nat.misc.CreativeTabsNAT;
import me.balink.nat.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockNAT extends Block {
    private String name = "";
    
    public BlockNAT(Material material, String name) {
        super(material);
        this.name = name;
        GameRegistry.registerBlock(this, this.name);
        this.setUnlocalizedName(Reference.MOD_ID + ":" + this.name);
        this.setCreativeTab(CreativeTabsNAT.tabNAT);
    }

    @SideOnly(Side.CLIENT)
    public void registerModel() {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(this), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + this.name, "inventory"));
    }
}
