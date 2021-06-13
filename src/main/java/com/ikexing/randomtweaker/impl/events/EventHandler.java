package com.ikexing.randomtweaker.impl.events;

import com.ikexing.randomtweaker.RandomTweaker;
import com.ikexing.randomtweaker.impl.client.capability.PlayerSanityCapability;
import com.ikexing.randomtweaker.impl.client.utils.cap.PlayerSanityHelper;
import com.ikexing.randomtweaker.impl.config.RTConfig;
import java.util.Objects;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class EventHandler {

    @SubscribeEvent
    public static void onItemRegistry(Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        if (RTConfig.OriginalSanity) {
            registry.register(RandomTweaker.SANITY_GEM);
        }
    }

    @SubscribeEvent
    public static void onModelRegistry(ModelRegistryEvent event) {
        if (RTConfig.OriginalSanity) {
            ModelLoader.setCustomModelResourceLocation(RandomTweaker.SANITY_GEM, 0,
                new ModelResourceLocation(
                    Objects.requireNonNull(RandomTweaker.SANITY_GEM.getRegistryName()),
                    "inventory"));
        }
    }

    @SubscribeEvent
    public static void onSoundEventRegistration(RegistryEvent.Register<SoundEvent> event) {
        IForgeRegistry<SoundEvent> registry = event.getRegistry();
        registry.register(RandomTweaker.SOUND_SAN);
    }

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
            if (sanityCap.getOriginalSanity() == 0 && RTConfig.OriginalSanity) {
                double random = Math.random();
                sanityCap.setOriginalSanity(
                    (int) (random >= 0.75 ? random * 100 : (random + (random / 2)) * 100));
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
