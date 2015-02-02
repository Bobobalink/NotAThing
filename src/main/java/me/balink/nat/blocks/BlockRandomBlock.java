package me.balink.nat.blocks;

import me.balink.nat.init.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockRandomBlock extends BlockNAT{
    
    public BlockRandomBlock() {
        super(Material.wood, "RandomBlock");
        this.setHardness(1.0f);
        this.setLightLevel(15.0f);
    }
    
    @Override
    public boolean canPlaceBlockAt(World world,  BlockPos pos) {
        int x = pos.getX();
        int y = pos.getY() - 32;
        int z = pos.getZ();
        return x * x + y * y + z * z >= 1024 && super.canPlaceBlockAt(world, pos);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        if(rand.nextBoolean())
            return super.getItemDropped(state, rand, fortune);
        return ModItems.randomThing;
    }
}
