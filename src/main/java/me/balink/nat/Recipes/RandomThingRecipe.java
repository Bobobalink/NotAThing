package me.balink.nat.Recipes;

import me.balink.nat.init.ModItems;
import me.balink.nat.util.NBTHelper;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class RandomThingRecipe extends ShapelessOreRecipe {
    public RandomThingRecipe() {
        super(ModItems.randomThing, ModItems.randomThing, ModItems.randomThing);
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting var1) {
        ItemStack out = super.getCraftingResult(var1);
        byte powar = 0;
        for(int i = 0; i < var1.getSizeInventory(); i++) {
            if(var1.getStackInSlot(i) != null)
                if(NBTHelper.hasTag(var1.getStackInSlot(i), "powar"))
                    powar += NBTHelper.getByte(var1.getStackInSlot(i), "powar");
                else
                    powar++;
        }
        NBTHelper.setByte(out, "powar", powar);
        return out;
    }
}
