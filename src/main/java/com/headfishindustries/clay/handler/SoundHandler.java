package com.headfishindustries.clay.handler;

import com.headfishindustries.clay.Clay;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class SoundHandler {
	
	static SoundEvent CLAY_BREAK;
	
	public static void registerSound(){
		ResourceLocation path = new ResourceLocation(Clay.MODID + ":clay_break");
		if (Clay.LOG_EVERYTHING) {
			Clay.LOGGER.info("Registering sound <{}>", path);
		}
		CLAY_BREAK = new SoundEvent(path).setRegistryName("clay_break");
	}

}
