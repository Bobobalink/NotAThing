package me.balink.nat.blocks;

import me.balink.nat.init.ModItems;
import me.balink.nat.util.LogHelper;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import java.util.Random;

public class BlockRandomBlock extends BlockNAT {

    public BlockRandomBlock() {
        super(Material.wood, "RandomBlock");
        this.setHardness(1.0f);
        this.setLightLevel(15.0f);
    }

    @Override
    public boolean canPlaceBlockAt(World world, BlockPos pos) {
        return super.canPlaceBlockAt(world, pos)
               && !(world.getBlockState(pos.down()).getBlock() instanceof BlockNAT)
               && !(world.getBlockState(pos.up()).getBlock() instanceof BlockNAT)
               && !(world.getBlockState(pos.east()).getBlock() instanceof BlockNAT)
               && !(world.getBlockState(pos.west()).getBlock() instanceof BlockNAT)
               && !(world.getBlockState(pos.north()).getBlock() instanceof BlockNAT)
               && !(world.getBlockState(pos.south()).getBlock() instanceof BlockNAT);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        if(rand.nextBoolean())
            return super.getItemDropped(state, rand, fortune);
        return ModItems.randomThing;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
        ItemStack toPlace = playerIn.inventory.getCurrentItem();
        if(toPlace != null) toPlace.onItemUse(playerIn, worldIn, pos.add(1, 1, 1), EnumFacing.DOWN, 0.5f, 0.5f, 0.5f);
        LogHelper.info(pos);
        return true;
    }
}
