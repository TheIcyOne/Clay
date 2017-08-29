package com.headfishindustries.clay.handler;

import com.headfishindustries.clay.Clay;
import net.minecraft.block.Block;
import net.minecraft.block.BlockClay;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

import java.util.List;

public class RecipeHandler {

    @SuppressWarnings("rawtypes")
	public static void removeExistingRecipes() {
        List<IRecipe> recipeList = ForgeRegistries.RECIPES.getValues();
        for (IRecipe recipe : recipeList) {
            if (recipe.getRecipeOutput() != null) {
                if (Block.getBlockFromItem(recipe.getRecipeOutput().getItem()) instanceof BlockClay) {
                    if (Clay.LOG_EVERYTHING) {
                        Clay.LOGGER.info("Removing clay recipe called <{}>", recipe.getRegistryName());
                        
                    }
                    ((IForgeRegistryModifiable)ForgeRegistries.RECIPES).remove(ForgeRegistries.RECIPES.getKey(recipe));
                }
            }
        }
    }

    public static void addBalancedRecipe() {
        Block output = Blocks.CLAY;
        
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(Ingredient.fromItem(Items.CLAY_BALL));
        list.add(Ingredient.fromItem(Items.CLAY_BALL));
        list.add(Ingredient.fromItem(Items.CLAY_BALL));
        list.add(Ingredient.fromItem(Items.CLAY_BALL));
        list.add(Ingredient.fromItem(Item.getItemFromBlock(Blocks.DRAGON_EGG)));
        list.add(Ingredient.fromItem(Items.CLAY_BALL));
        list.add(Ingredient.fromItem(Items.CLAY_BALL));
        list.add(Ingredient.fromItem(Items.CLAY_BALL));
        list.add(Ingredient.fromItem(Items.CLAY_BALL));
        
        if (Clay.LOG_EVERYTHING) 
            Clay.LOGGER.info("Registering new balanced recipe for <{}>", output.getRegistryName());

        ForgeRegistries.RECIPES.register(new ShapedRecipes(null, 3, 3, list, new ItemStack(output, 2)).setRegistryName("Clay"));
    }

}
