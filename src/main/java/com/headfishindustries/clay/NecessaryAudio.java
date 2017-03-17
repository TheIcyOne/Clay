package com.headfishindustries.clay;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class NecessaryAudio {
	
	public static final SoundEvent NEED_WATER = register("claymod:water");
	
	private static SoundEvent register(String s){
		System.out.println("Registering sound: " + s);
		return GameRegistry.register(new SoundEvent(new ResourceLocation(s)).setRegistryName(new ResourceLocation(s)));
	}
}
