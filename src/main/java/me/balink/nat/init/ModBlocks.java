package me.balink.nat.init;

import me.balink.nat.blocks.BlockNAT;
import me.balink.nat.blocks.BlockRandomBlock;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {
    public static final BlockNAT randomBlock = new BlockRandomBlock();

    @SideOnly(Side.CLIENT)
    public static void modelInit() {
        randomBlock.registerModel();
    }
}
