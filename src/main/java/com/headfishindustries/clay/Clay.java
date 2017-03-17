package com.headfishindustries.clay;

import com.headfishindustries.clay.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Clay.MODID, version = Clay.VERSION)
public class Clay {
	public static final String MODID = "claymod";
	public static final String VERSION = "1.1";
	
	@SidedProxy(clientSide="com.headfishindustries.clay.proxy.ClientProxy", serverSide = "com.headfishindustries.clay.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		proxy.preInit(e);
	}
	
	@EventHandler
	public void init (FMLInitializationEvent e) {
		proxy.init(e);
	}
	
	@EventHandler
	public void postInit (FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}
	
	public String getVersion() {
		return VERSION;
	}
}
