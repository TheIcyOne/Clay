package com.headfishindustries.clay.handler;


import java.lang.reflect.Method;
import java.util.Objects;

import com.headfishindustries.clay.Clay;

import net.minecraft.block.Block;
import net.minecraft.block.BlockClay;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {

	public static void registerEvents() {
        EventHandler events = new EventHandler();
        MinecraftForge.EVENT_BUS.register(events);
        for (Method method : events.getClass().getDeclaredMethods())
            if (Clay.LOG_EVERYTHING && !Objects.equals(method.getName(), "registerEvents"))
                Clay.LOGGER.info("Registering @SubscribeEvent for {} to the event bus", method.getName());
    }

    @SubscribeEvent
    public void onStartBreakBlock(BreakEvent event) {
        ItemStack stack = event.getPlayer().getHeldItemMainhand();
        Block target = event.getWorld().getBlockState(event.getPos()).getBlock();
        if (!(target instanceof BlockClay)) event.setCanceled(false);
        else if (stack == null || (!(stack.getItem().getToolClasses(stack).contains("shovel"))
                || !(event.getPlayer().isInWater()))) {
            event.setCanceled(true);
            if (!event.getWorld().isRemote && !event.getPlayer().isInWater()) {
                event.getWorld().playSound(
                        null, event.getPos(), SoundHandler.NEED_WATER,
                        SoundCategory.BLOCKS, 1.0f, 1.0f);
            }
        }
    }
}
