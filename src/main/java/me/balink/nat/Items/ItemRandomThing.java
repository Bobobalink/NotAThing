package me.balink.nat.Items;

import me.balink.nat.blocks.BlockNAT;
import me.balink.nat.init.ModBlocks;
import me.balink.nat.util.NBTHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import java.util.List;

public class ItemRandomThing extends ItemNAT {

    public ItemRandomThing() {
        super("RandomThing");
    }

    @Override
    public float getStrVsBlock(ItemStack stack, Block block) {
        if(block instanceof BlockNAT)
            return (stack.stackSize * NBTHelper.getByte(stack, "powar", (byte) 1));
        return (stack.stackSize * NBTHelper.getByte(stack, "powar", (byte) 1)) / 8.0f;
    }

    @Override
    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
        entityLiving.attackEntityFrom(DamageSource.generic, (stack.stackSize * NBTHelper.getByte(stack, "powar", (byte) 1)) / 8.0f);
        return false;
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        int range = (stack.stackSize * NBTHelper.getByte(stack, "powar", (byte) 1)) / 8 + 1;
        for(int x = 0; x <= range; x++)
            for(int y = 0; y <= range; y++)
                for(int z = 0; z <= range; z++)
                    if(worldIn.canBlockBePlaced(ModBlocks.randomBlock, pos.add(x, y, z), false, side, playerIn, stack) && removeItem(stack, playerIn)) {
                        worldIn.setBlockState(pos.add(x, y, z), ModBlocks.randomBlock.getDefaultState());
                    }
        return false;
    }

    private boolean removeItem(ItemStack inUse, EntityPlayer player) {
        for(ItemStack itemStack : player.inventory.mainInventory) {
            if(itemStack != null && itemStack.getItem() instanceof ItemRandomThing && !(itemStack == inUse)) {
                itemStack.stackSize--;
                return true;
            }
        }
        if(inUse.stackSize > 0) {
            inUse.stackSize--;
            return true;
        }
        return false;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
        tooltip.add("Does very Random Things");
        tooltip.add("is a random thing");
        tooltip.add("wielded by " + playerIn.getDisplayNameString());
        tooltip.add("power: " + NBTHelper.getByte(stack, "powar", (byte) 1));
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
        playerIn.heal((itemStackIn.stackSize * NBTHelper.getByte(itemStackIn, "powar", (byte) 1)) / 8.0f);
        return super.onItemRightClick(itemStackIn, worldIn, playerIn);
    }

    @Override
    public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
        if(!NBTHelper.hasTag(stack, "powar"))
            NBTHelper.setByte(stack, "powar", (byte) 1);
    }
}
