package com.headfishindustries.clay.proxy;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockClay;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftDerper {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void removeRecipes(){
		List<IRecipe>rlist = new ArrayList(CraftingManager.getInstance().getRecipeList());
		for (IRecipe r : rlist){
			net.minecraft.item.ItemStack out = r.getRecipeOutput();
			System.out.println(out.toString());
			Item outItem = out.getItem();
			Block outBlock = Block.getBlockFromItem(outItem);
			if (outBlock != null && outBlock instanceof BlockClay){
				//if(ItemStack.areItemStacksEqual(out, new ItemStack(outBlock, 2)))
				CraftingManager.getInstance().getRecipeList().remove(r);
				
			}
		}
		addRecipes();
	}
	public static void addRecipes(){
		//Unfortunately, we can't craft with half a dragon egg. Not yet.
		GameRegistry.addRecipe(new ItemStack(Blocks.CLAY, 2), "AAA", "ABA", "AAA", 'A', Items.CLAY_BALL, 'B', Blocks.DRAGON_EGG);
	}
}
