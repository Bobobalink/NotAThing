package me.balink.nat.Items;

import me.balink.nat.blocks.BlockNAT;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ItemRandomThing extends ItemNAT {

    public ItemRandomThing() {
        super("RandomThing");
    }

    @Override
    public float getStrVsBlock(ItemStack stack, Block block) {
        if(block instanceof BlockNAT)
            return 32.0f;
        return 2.0f;
    }
}
