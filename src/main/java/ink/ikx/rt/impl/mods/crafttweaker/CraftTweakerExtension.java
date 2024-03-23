package ink.ikx.rt.impl.mods.crafttweaker;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.zenscript.GlobalRegistry;
import ink.ikx.rt.api.internal.file.IProp;
import ink.ikx.rt.api.internal.utils.IInputPattern;
import ink.ikx.rt.api.mods.botania.subtile.IHydroangeas;
import ink.ikx.rt.api.mods.botania.subtile.IOrechid;
import ink.ikx.rt.impl.internal.config.RTConfig;
import net.minecraftforge.fml.common.Loader;

import java.util.Arrays;
import java.util.Map;

public class CraftTweakerExtension {

    public static void registerAllClass() {
        registerGlobal();
        registerSpecialClass();
    }

    public static void registerSpecialClass() {
        if (IProp.isRegister(RTConfig.RandomTweaker.Prop))
            CraftTweakerAPI.registerClass(IProp.class);
        if (Loader.isModLoaded("botania")) {
            if (RTConfig.Botania.OrechidModified)
                CraftTweakerAPI.registerClass(IOrechid.class);
            if (RTConfig.Botania.HydroangeasModified)
                CraftTweakerAPI.registerClass(IHydroangeas.class);
        }
    }

    public static void registerGlobal() {
        GlobalRegistry.registerGlobal("inputPattern",
                GlobalRegistry.getStaticFunction(IInputPattern.class, "inputPattern", String[].class));
        GlobalRegistry.registerGlobal("inputPatternGet",
                GlobalRegistry.getStaticFunction(IInputPattern.class, "inputPatternGet", String[].class, Map.class));
    }

}
