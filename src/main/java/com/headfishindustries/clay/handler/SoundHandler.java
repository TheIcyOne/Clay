package com.headfishindustries.clay.handler;

import com.headfishindustries.clay.Clay;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class SoundHandler {
	
	static SoundEvent NEED_WATER;
	static SoundEvent DANCING_CLAY;
	
	public static SoundEvent registerSound(String rl){
		ResourceLocation path = new ResourceLocation(Clay.MODID + ":" + rl);
		if (Clay.LOG_EVERYTHING) {
			Clay.LOGGER.info("Registering sound <{}>", path);
		}
		return new SoundEvent(path).setRegistryName(rl);
	}
	
	public static void registerSounds(){
		NEED_WATER = registerSound("need_water");
		DANCING_CLAY = registerSound("dancing_clay");
		
	}

}
