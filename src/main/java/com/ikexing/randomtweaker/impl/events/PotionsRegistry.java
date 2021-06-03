package com.ikexing.randomtweaker.impl.events;

import com.ikexing.randomtweaker.RandomTweaker;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class PotionsRegistry {

    @SubscribeEvent
    public static void onPotionRegistry(Register<Potion> event) {
        IForgeRegistry<Potion> registry = event.getRegistry();
        if (!RandomTweaker.potionRegList.isEmpty()) {
            registry.registerAll(RandomTweaker.potionRegList.toArray(new Potion[0]));
        }
    }
}
