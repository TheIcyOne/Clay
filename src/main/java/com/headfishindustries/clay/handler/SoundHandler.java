package com.headfishindustries.clay.handler;

import com.headfishindustries.clay.Clay;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class SoundHandler {
	
	static SoundEvent NEED_WATER;
	
	public static void registerSound(){
		ResourceLocation path = new ResourceLocation(Clay.MODID + ":need_water");
		if (Clay.LOG_EVERYTHING) {
			Clay.LOGGER.info("Registering sound <{}>", path);
		}
		NEED_WATER = new SoundEvent(path).setRegistryName("need_water");
	}

}
