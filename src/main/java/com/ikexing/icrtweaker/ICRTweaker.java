package com.ikexing.icrtweaker;

import com.ikexing.icrtweaker.api.utils.ICRTweakerGlobal;
import crafttweaker.api.player.IPlayer;
import crafttweaker.zenscript.GlobalRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = ICRTweaker.MODID, name = ICRTweaker.NAME, version = ICRTweaker.VERSION, dependencies = ICRTweaker.DESPENDENCIES)
public class ICRTweaker {
    public static final String MODID = "icrtweaker";
    public static final String NAME = "ICRTweaker";
    public static final String VERSION = "1.0.0";
    public static final String DESPENDENCIES = "required-after:crafttweaker;required-after:astralsorcery;required-after:thaumcraft";

    private static Logger logger;

    @EventHandler
    public static void onPreInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @EventHandler
    public static void onConstruct(FMLConstructionEvent event) {
        GlobalRegistry.registerGlobal("giverDreamJournl", GlobalRegistry.getStaticFunction(ICRTweakerGlobal.class, "giverDreamJournl", IPlayer.class));
    }
}
