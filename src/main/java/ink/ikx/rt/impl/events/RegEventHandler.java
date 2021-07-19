package ink.ikx.rt.impl.events;

import cn.hutool.core.compiler.CompilerUtil;
import cn.hutool.core.io.FileUtil;
import ink.ikx.rt.RandomTweaker;
import ink.ikx.rt.api.instance.file.Prop;
import ink.ikx.rt.api.mods.cote.flower.JAVATextContent;
import ink.ikx.rt.api.mods.cote.flower.functional.SubTileFunctionalRepresentation;
import ink.ikx.rt.impl.config.RTConfig;
import java.io.File;
import java.util.Objects;
import net.minecraft.block.Block;
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
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.BotaniaAPIClient;
import vazkii.botania.api.subtile.SubTileEntity;

@SuppressWarnings("unchecked")
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
    public static void onBlockRegistry(Register<Block> event) {
        if (RandomTweaker.subTileGeneratingMap.isEmpty()) {
            return;
        }
        RandomTweaker.subTileGeneratingMap.forEach((k, v) -> {
            String className;
            ClassLoader classLoader;
            if (v.getKey().equals("generating")) {
                String Generating = JAVATextContent.GENERATING.replace("${name}", k);
                className = "ink.ikx.rt.api.mods.cote.flower.generating.CustomSubTileGeneratingContent_" + k;
                classLoader = CompilerUtil.getCompiler(null)
                    .addSource(className, Generating)
                    .compile();
            } else {
                String Functional = JAVATextContent.FUNCTIONAL.replace("${name}", k);
                className = "ink.ikx.rt.api.mods.cote.flower.functional.SubTileFunctionalContentContent_" + k;
                classLoader = CompilerUtil.getCompiler(null)
                    .addSource(className, Functional)
                    .compile();
            }

            try {
                Class<? extends SubTileEntity> clazz = (Class<? extends SubTileEntity>) classLoader.loadClass(className);
                BotaniaAPI.registerSubTile(k, clazz);
                BotaniaAPI.addSubTileToCreativeMenu(k);
                for (Class innerClazz : clazz.getDeclaredClasses()) {
                    if (innerClazz.getSimpleName().equals("Mini")) {
                        SubTileFunctionalRepresentation v1 = (SubTileFunctionalRepresentation) v.getValue();
                        if (v1.isHasMini()) {
                            BotaniaAPI.registerMiniSubTile(k + "Chibi", innerClazz, k);
                        }
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    @SubscribeEvent
    public static void onModelRegistry(ModelRegistryEvent event) {
        if (RTConfig.RandomTweaker.PlayerSanity) {
            ModelLoader.setCustomModelResourceLocation(RandomTweaker.SANITY_GEM, 0,
                new ModelResourceLocation(
                    Objects.requireNonNull(RandomTweaker.SANITY_GEM.getRegistryName()),
                    "inventory"));
        }
        if (RandomTweaker.subTileGeneratingMap.isEmpty()) {
            return;
        }
        RandomTweaker.subTileGeneratingMap.forEach((k, v) -> {
            BotaniaAPIClient.registerSubtileModel(k, new ModelResourceLocation("contenttweaker:" + k));
            createFlowerBlockState(k);
            if (v.getValue() instanceof SubTileFunctionalRepresentation) {
                SubTileFunctionalRepresentation v1 = (SubTileFunctionalRepresentation) v.getValue();
                if (v1.isHasMini()) {
                    BotaniaAPIClient.registerSubtileModel(k + "Chibi", new ModelResourceLocation("contenttweaker:" + k + "Chibi"));
                    createFlowerBlockState(k + "Chibi");
                }
            }
        });
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
            FileUtil.writeUtf8String(JAVATextContent.FLOWER_BLOCKSTATE.replace("${name}", nameL), file);
        }
    }
}
