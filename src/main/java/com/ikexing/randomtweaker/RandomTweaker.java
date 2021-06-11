package com.ikexing.randomtweaker;

import com.google.common.collect.BiMap;
import com.ikexing.randomtweaker.api.file.Prop;
import com.ikexing.randomtweaker.api.jei.classes.JEICustom;
import com.ikexing.randomtweaker.api.utils.RTGlobal;
import com.ikexing.randomtweaker.impl.botania.subtitle.SubTileHydroangeasModified;
import com.ikexing.randomtweaker.impl.config.RTConfig;
import com.ikexing.randomtweaker.impl.events.DreamJournal;
import com.ikexing.randomtweaker.impl.jei.Hydroangeas;
import com.ikexing.randomtweaker.impl.utils.ItemDs;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.player.IPlayer;
import crafttweaker.zenscript.GlobalRegistry;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.subtile.SubTileEntity;
import vazkii.botania.common.lib.LibBlockNames;

@Mod(modid = RandomTweaker.MODID, name = RandomTweaker.NAME, version = RandomTweaker.VERSION, dependencies = RandomTweaker.DESPENDENCIES)
public class RandomTweaker {

    public static final String MODID = "randomtweaker";
    public static final String NAME = "RandomTweaker";
    public static final String VERSION = "1.0.0";
    public static final String DESPENDENCIES = "required-after:crafttweaker;after:contenttweaker;";

    public static final String THAUMCRAFT = "thaumcraft";

    public static Logger logger;
    public static Set<ItemDs> itemDsSet = new HashSet<>();
    public static Map<String, Potion> potionRegList = new HashMap<>();
    public static Map<String, PotionType> potionTypeList = new HashMap<>();
    public static List<JEICustom> jeiCustomList = new ArrayList<>();

    @EventHandler
    public void onConstruct(FMLConstructionEvent event) throws IOException {
        GlobalRegistry.registerGlobal("printChat",
            GlobalRegistry.getStaticFunction(RTGlobal.class, "printChat", String.class));

        if (Loader.isModLoaded(THAUMCRAFT)) {
            if (RTConfig.DreamJournal) {
                MinecraftForge.EVENT_BUS.register(DreamJournal.class);
            }
            GlobalRegistry.registerGlobal("giverDreamJournl", GlobalRegistry
                .getStaticFunction(RTGlobal.class, "giverDreamJournl", IPlayer.class));
        }
        if (Prop.createOrDelete(RTConfig.Prop)) {
            CraftTweakerAPI.registerClass(Prop.class);
        }
    }

    @EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @EventHandler
    public void onInit(FMLInitializationEvent event) {
        if (!RTConfig.HydroangeasModified) {
            registryHydroangeasModified();
            Hydroangeas.init();
        }
    }

    private void registryHydroangeasModified() {
        final BiMap<String, Class<? extends SubTileEntity>> subTiles;
        try {
            Field field = BotaniaAPI.class.getDeclaredField("subTiles");
            field.setAccessible(true);
            //noinspection unchecked
            subTiles = (BiMap<String, Class<? extends SubTileEntity>>) field.get(null);

            if (subTiles != null) {
                subTiles
                    .forcePut(LibBlockNames.SUBTILE_HYDROANGEAS, SubTileHydroangeasModified.class);
            }

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
