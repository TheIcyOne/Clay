package com.headfishindustries.clay.handler;

import com.headfishindustries.clay.Clay;
import net.minecraft.block.Block;
import net.minecraft.block.BlockClay;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;

public class RecipeHandler {

    public static void removeExistingRecipes() {
        List<IRecipe> recipeList = new ArrayList<>(CraftingManager.getInstance().getRecipeList());
        for (IRecipe recipe : recipeList) {
            if (recipe.getRecipeOutput() != null) {
                Item item = recipe.getRecipeOutput().getItem();
                Block block = Block.getBlockFromItem(item);
                if (block instanceof BlockClay) {
                    if (Clay.LOG_EVERYTHING) {
                        Clay.LOGGER.info("Removing recipes for <{}>", block.getRegistryName());
                    }
                    CraftingManager.getInstance().getRecipeList().remove(recipe);
                }
            }
        }
    }

    public static void addBalancedRecipe() {
        Block output = Blocks.CLAY;
        if (Clay.LOG_EVERYTHING) {
            Clay.LOGGER.info("Registering new balanced recipe for <{}>", output.getRegistryName());
        }
        GameRegistry.addRecipe(
                new ItemStack(output, 2),
                "AAA", "ABA", "AAA",
                'A', Items.CLAY_BALL,
                'B', Blocks.DRAGON_EGG
        );
    }

}
