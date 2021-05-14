package com.ikexing.randomtweaker;

import com.ikexing.randomtweaker.api.utils.RTGlobal;
import com.ikexing.randomtweaker.api.jei.JEIRecipe;
import crafttweaker.api.player.IPlayer;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.zenscript.GlobalRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * @author ikexing
 */
@Mod(modid = RandomTweaker.MODID, name = RandomTweaker.NAME, version = RandomTweaker.VERSION, dependencies = RandomTweaker.DESPENDENCIES)
public class RandomTweaker {
    public static final String MODID = "randomtweaker";
    public static final String NAME = "RandomTweaker";
    public static final String VERSION = "1.0.0";
    public static final String DESPENDENCIES = "required-after:crafttweaker;";

    public static List<JEIRecipe> JEIRecipes;
    private static Logger logger;

    @EventHandler
    public static void onPreInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @EventHandler
    public static void onConstruct(FMLConstructionEvent event) {
        GlobalRegistry.registerGlobal("getAllInBox", GlobalRegistry.getStaticFunction(RTGlobal.class, "getAllInBox", IBlockPos.class, IBlockPos.class));

        if (Loader.isModLoaded("thaumcraft")) {
            MinecraftForge.EVENT_BUS.register(EventHandler.class);
            GlobalRegistry.registerGlobal("giverDreamJournl", GlobalRegistry.getStaticFunction(RTGlobal.class, "giverDreamJournl", IPlayer.class));
        }
    }
}
