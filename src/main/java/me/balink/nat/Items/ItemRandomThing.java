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
            return NBTHelper.getByte(stack, "powar", (byte) 1);
        return NBTHelper.getByte(stack, "powar", (byte) 1) / 8.0f;
    }

    @Override
    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
        entityLiving.attackEntityFrom(DamageSource.generic, NBTHelper.getByte(stack, "powar", (byte) 1) / 8.0f);
        return false;
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        int range = NBTHelper.getByte(stack, "powar", (byte) 1) / 8 + 1;
        int numGoes = 0;
        outerloop:
        for(int x = 0; x <= range; x++)
            for(int y = 0; y <= range; y++)
                for(int z = 0; z <= range; z++)
                    if(worldIn.canBlockBePlaced(ModBlocks.randomBlock, pos.add(x, y, z), false, side, playerIn, stack) && removeItem(stack, playerIn)) {
                        worldIn.setBlockState(pos.add(x, y, z), ModBlocks.randomBlock.getDefaultState());
                        if(numGoes >= range)
                            break outerloop;
                        else
                            numGoes--;
                    }
        return false;
    }

    private boolean removeItem(ItemStack inUse, EntityPlayer player) {
        ItemStack[] mainInventory = player.inventory.mainInventory;
        for(int i = 0; i < mainInventory.length; i++) {
            ItemStack itemStack = mainInventory[i];
            if(itemStack != null && !(itemStack == inUse) && itemStack.getItem() instanceof ItemRandomThing && itemStack.stackSize > 0) {
                if(NBTHelper.getByte(itemStack, "powar", (byte) 1) <= 1) {
                    itemStack.stackSize--;
                    if(itemStack.stackSize <= 0)
                        mainInventory[i] = null;
                }
                else
                    NBTHelper.setByte(itemStack, "powar", (byte) (NBTHelper.getByte(itemStack, "powar", (byte) 1) - 1));
                return true;
            }
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
        playerIn.heal(NBTHelper.getByte(itemStackIn, "powar", (byte) 1) / 8.0f);
        return super.onItemRightClick(itemStackIn, worldIn, playerIn);
    }

    @Override
    public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
        if(!NBTHelper.hasTag(stack, "powar"))
            NBTHelper.setByte(stack, "powar", (byte) 1);
    }
}
