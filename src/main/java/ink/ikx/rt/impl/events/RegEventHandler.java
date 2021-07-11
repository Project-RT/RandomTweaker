package ink.ikx.rt.impl.events;

import ink.ikx.rt.RandomTweaker;
import ink.ikx.rt.api.mods.cote.tile.TileEntityContent;
import ink.ikx.rt.impl.config.RTConfig;
import java.util.Objects;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class RegEventHandler {

    @SubscribeEvent
    public static void onBlockRegistry(Register<Block> event) {
        if (Loader.isModLoaded("contenttweaker")) {
            GameRegistry.registerTileEntity(TileEntityContent.class, new ResourceLocation(RandomTweaker.MODID, "tile_entity"));
        }
    }

    @SubscribeEvent
    public static void onItemRegistry(Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        if (RTConfig.RandomTweaker.PlayerSanity) {
            registry.register(RandomTweaker.SANITY_GEM);
        }
    }

    @SubscribeEvent
    public static void onModelRegistry(ModelRegistryEvent event) {
        if (RTConfig.RandomTweaker.PlayerSanity) {
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
}
