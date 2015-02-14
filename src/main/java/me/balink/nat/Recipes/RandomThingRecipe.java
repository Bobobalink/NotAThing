package me.balink.nat.Recipes;

import me.balink.nat.Items.ItemRandomThing;
import me.balink.nat.init.ModItems;
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
        int powar = 0;
        for(int i = 0; i < var1.getSizeInventory(); i++) {
            if(var1.getStackInSlot(i) != null)
                powar += NBTHelper.getInt(var1.getStackInSlot(i), "powar", 1);

        }
        NBTHelper.setInt(out, "powar", powar);
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
