package com.ikexing.randomtweaker.impl.events;

import com.ikexing.randomtweaker.RandomTweaker;
import com.ikexing.randomtweaker.impl.client.capability.PlayerSanityCapability;
import com.ikexing.randomtweaker.impl.client.utils.cap.PlayerSanityHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionType;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class EventHandler {

    @SubscribeEvent
    public static void onPotionRegistry(Register<Potion> event) {
        IForgeRegistry<Potion> registry = event.getRegistry();
        if (!RandomTweaker.potionRegList.isEmpty()) {
            RandomTweaker.potionRegList.forEach((k, v) -> registry.register(v));
        }
    }

    @SubscribeEvent
    public static void onPotionTypeRegistry(Register<PotionType> event) {
        IForgeRegistry<PotionType> registry = event.getRegistry();
        if (!RandomTweaker.potionTypeList.isEmpty()) {
            RandomTweaker.potionTypeList.forEach((k, v) -> registry.register(v));
        }
    }

    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinWorldEvent event) {
        Entity entity = event.getEntity();
        if (!event.getWorld().isRemote && entity instanceof EntityPlayer) {
            PlayerSanityCapability sanityCap = PlayerSanityHelper
                .getPlayerSanity((EntityPlayer) entity);
            if (sanityCap.getOriginalSanity() == 0) {
                double random = Math.random();
                sanityCap.setOriginalSanity(
                    (int) (random >= 0.6 ? random * 100 : (random + (random / 2)) * 100));
            }
            PlayerSanityHelper.sync(entity);
        }
    }

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(RandomTweaker.MODID)) {
            ConfigManager.sync(RandomTweaker.MODID, Config.Type.INSTANCE);
        }
    }
}
