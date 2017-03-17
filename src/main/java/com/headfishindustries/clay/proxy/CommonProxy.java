package com.headfishindustries.clay.proxy;

import com.headfishindustries.clay.handler.ClayHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	@EventHandler
	public void preInit (FMLPreInitializationEvent e){
		MinecraftForge.EVENT_BUS.register(new ClayHandler());
	}
	
	@EventHandler
	public void init (FMLInitializationEvent e) {
		
	}
	
	@EventHandler
	public void postInit (FMLPostInitializationEvent e) {
		CraftDerper.removeRecipes();
	}

}
