package ink.ikx.rt.impl.events;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Pair;
import com.teamacronymcoders.contenttweaker.ContentTweaker;
import ink.ikx.rt.RandomTweaker;
import ink.ikx.rt.api.internal.file.Prop;
import ink.ikx.rt.api.mods.cote.flower.JAVATextContent;
import ink.ikx.rt.api.mods.cote.flower.SubTileEntityInGame;
import ink.ikx.rt.api.mods.cote.flower.SubTileRepresentation;
import ink.ikx.rt.impl.config.RTConfig;
import java.io.File;
import java.util.Map.Entry;
import java.util.Objects;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionType;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import vazkii.botania.api.BotaniaAPIClient;

@EventBusSubscriber
public class RegEventHandler {

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
                new ModelResourceLocation(Objects.requireNonNull(RandomTweaker.SANITY_GEM.getRegistryName()), "inventory"));
        }
        for (Entry<String, Pair<String, SubTileRepresentation>> entries : RandomTweaker.subTileGeneratingMap.entrySet()) {
            createFlowerBlockState(entries.getKey());
            BotaniaAPIClient.registerSubtileModel(entries.getKey(), new ModelResourceLocation(ContentTweaker.MOD_ID + ":" + entries.getKey()));
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
        if (!RandomTweaker.potionRegMap.isEmpty()) {
            RandomTweaker.potionRegMap.forEach((k, v) -> registry.register(v));
        }
    }

    @SubscribeEvent
    public static void onPotionTypeRegistry(Register<PotionType> event) {
        IForgeRegistry<PotionType> registry = event.getRegistry();
        if (!RandomTweaker.potionTypeMap.isEmpty()) {
            RandomTweaker.potionTypeMap.forEach((k, v) -> registry.register(v));
        }
    }

    private static void createFlowerBlockState(String name) {
        String nameL = name.toLowerCase();
        String path = Prop.getPath(System.getProperty("user.dir"), "resources", "contenttweaker", "blockstates", nameL + ".json");
        File file = new File(path);
        if (!FileUtil.exist(file)) {
            if (nameL.contains("chibi")) {
                nameL = nameL.replace("chibi", "_chibi");
            }
            FileUtil.writeUtf8String(JAVATextContent.FLOWER_BLOCKSTATE.replace("${name}", nameL), file);
        }
    }
}
