package me.balink.nat.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ModRecipes {

    public static void init() {
        GameRegistry.addRecipe(
                new ShapedOreRecipe(
                        new ItemStack(ModItems.randomThing, 3),
                        "a a", " b ", "a a",
                        'a', Items.nether_star,
                        'b', "stickWood"));
        GameRegistry.addRecipe(
                new ShapedOreRecipe(
                        new ItemStack(ModItems.randomThing, 2),
                        " a ", "aba", " a ",
                        'a', Items.nether_star,
                        'b', "stickWood"));
        GameRegistry.addRecipe(
                new ShapelessOreRecipe(
                        new ItemStack(Items.nether_star, 1),
                        new ItemStack(ModItems.randomThing)));
        GameRegistry.addRecipe(
                new ShapelessOreRecipe(
                        new ItemStack(ModBlocks.randomBlock, 8),
                        new ItemStack(Items.nether_star),
                        new ItemStack(ModItems.randomThing)));
    }
}
