package com.headfishindustries.clay.handler;


import net.minecraft.block.BlockClay;
import net.minecraft.item.ItemSpade;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClayHandler {
	@SubscribeEvent
	public void onStartBreakBlock(BreakEvent event){
		if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof BlockClay){
			if (!(event.getPlayer().getHeldItemMainhand().getItem() instanceof ItemSpade))
			event.setCanceled(true);
			if(!(event.getPlayer().isInWater()))
			event.setCanceled(true);		
		}
	}
}
