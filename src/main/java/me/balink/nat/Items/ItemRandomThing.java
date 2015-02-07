package me.balink.nat.Items;

import me.balink.nat.blocks.BlockNAT;
import me.balink.nat.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemRandomThing extends ItemNAT {

    public ItemRandomThing() {
        super("RandomThing");
    }

    @Override
    public float getStrVsBlock(ItemStack stack, Block block) {
        if(block instanceof BlockNAT)
            return stack.stackSize;
        return stack.stackSize / 8.0f;
    }

    @Override
    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
        entityLiving.attackEntityFrom(DamageSource.generic, stack.stackSize / 8.0f);
        return false;
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        playerIn.heal(stack.stackSize / 8.0f);
        int range = stack.stackSize / 8 + 1;
        for(int x = -1 * range; x <= range; x++)
            for(int y = -1 * range; y <= range; y++)
                for(int z = -1 * range; z <= range; z++)
                    if(worldIn.canBlockBePlaced(ModBlocks.randomBlock, pos.add(x, y, z), false, side, playerIn, stack))
                        worldIn.setBlockState(pos.add(x, y, z), ModBlocks.randomBlock.getDefaultState());
        return false;
    }
}
