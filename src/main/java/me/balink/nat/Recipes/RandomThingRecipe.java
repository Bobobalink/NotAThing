package me.balink.nat.Recipes;

import me.balink.nat.Items.ItemRandomThing;
import me.balink.nat.init.ModItems;
import me.balink.nat.reference.NBT;
import me.balink.nat.util.NBTHelper;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class RandomThingRecipe extends ShapelessOreRecipe {
    public RandomThingRecipe() {
        super(ModItems.randomThing, ModItems.randomThing, ModItems.randomThing);
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting var1) {
        ItemStack out = super.getCraftingResult(var1);
        byte power = 0;
        for(int i = 0; i < var1.getSizeInventory(); i++) {
            if(var1.getStackInSlot(i) != null)
                power += power < 64 ? NBTHelper.getByte(var1.getStackInSlot(i), NBT.Byte.RANDOM_THING_POWER, 1) : 0;

        }
        NBTHelper.setByte(out, NBT.Byte.RANDOM_THING_POWER, power < 64 ? power : 64);
        return out;
    }

    @Override
    public boolean matches(InventoryCrafting var1, World world) {
        boolean foundActualItem = false;
        for(int x = 0; x < var1.getSizeInventory(); x++)
            if(var1.getStackInSlot(x) != null && !(var1.getStackInSlot(x).getItem() instanceof ItemRandomThing))
                return false;
            else if(!foundActualItem && var1.getStackInSlot(x) != null && var1.getStackInSlot(x).getItem() instanceof ItemRandomThing)
                foundActualItem = true;
        return foundActualItem;
    }
}
