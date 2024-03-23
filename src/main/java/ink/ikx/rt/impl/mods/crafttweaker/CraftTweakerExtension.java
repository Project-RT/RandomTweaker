package ink.ikx.rt.impl.mods.crafttweaker;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.zenscript.GlobalRegistry;
import ink.ikx.rt.api.internal.file.IProp;
import ink.ikx.rt.api.internal.utils.IInputPattern;
import ink.ikx.rt.api.mods.botania.subtile.IHydroangeas;
import ink.ikx.rt.api.mods.botania.subtile.IOrechid;
import ink.ikx.rt.api.mods.contenttweaker.mana.bauble.IManaBaubleRepresentation;
import ink.ikx.rt.api.mods.contenttweaker.mana.item.IManaItemRepresentation;
import ink.ikx.rt.api.mods.contenttweaker.mana.item.tool.IIsUsesManaItemRepresentation;
import ink.ikx.rt.api.mods.contenttweaker.subtile.ISubTileEntityRepresentation;
import ink.ikx.rt.api.mods.contenttweaker.subtile.functional.ISubTileEntityFunctionalRepresentation;
import ink.ikx.rt.api.mods.contenttweaker.subtile.generating.ISubTileEntityGeneratingRepresentation;
import ink.ikx.rt.impl.internal.config.RTConfig;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.discovery.ASMDataTable;

import java.util.Arrays;
import java.util.Map;

public class CraftTweakerExtension {

    public static void registerAllClass(ASMDataTable asmDataTable) {
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
            if (Loader.isModLoaded("contenttweaker")) {
                CraftTweakerAPI.registerClass(IManaItemRepresentation.class);
                CraftTweakerAPI.registerClass(IManaBaubleRepresentation.class);
                CraftTweakerAPI.registerClass(IIsUsesManaItemRepresentation.class);
                CraftTweakerAPI.registerClass(ISubTileEntityRepresentation.class);
                CraftTweakerAPI.registerClass(ISubTileEntityFunctionalRepresentation.class);
                CraftTweakerAPI.registerClass(ISubTileEntityGeneratingRepresentation.class);
            }
        }
    }

    public static void registerGlobal() {
        GlobalRegistry.registerGlobal("inputPattern",
                GlobalRegistry.getStaticFunction(IInputPattern.class, "inputPattern", String[].class));

        GlobalRegistry.registerGlobal("inputPatternGet",
                GlobalRegistry.getStaticFunction(IInputPattern.class, "inputPatternGet", String[].class, Map.class));
    }

}
