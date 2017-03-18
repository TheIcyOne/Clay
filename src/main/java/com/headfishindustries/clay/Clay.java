package com.headfishindustries.clay;

import com.headfishindustries.clay.handler.EventHandler;
import com.headfishindustries.clay.handler.RecipeHandler;
import com.headfishindustries.clay.handler.SoundHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Clay.MODID, version = Clay.VERSION)

public class Clay {

	public static final String MODID = "claymod";
	public static final String VERSION = "%gradle.version%";

	public static final Logger LOGGER = LogManager.getLogger(MODID);
	public static final boolean LOG_EVERYTHING = true;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e){
		EventHandler.registerEvents();

	}

	@Mod.EventHandler
	public void init (FMLInitializationEvent e) {
		SoundHandler.registerSound();

	}

	@Mod.EventHandler
	public void postInit (FMLPostInitializationEvent e) {
		RecipeHandler.removeExistingRecipes();
		RecipeHandler.addBalancedRecipe();

	}

}

