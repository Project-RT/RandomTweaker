package ink.ikx.rt.impl.mods.crafttweaker;

import cn.hutool.core.annotation.AnnotationUtil;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.mc1120.CraftTweaker;
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
import java.util.Set;

public class CraftTweakerExtension {

    public static void registerAllClass(Set<ASMDataTable.ASMData> asmData) {
        for (ASMDataTable.ASMData asmDatum : asmData) {
            try {
                Class<?> clazz = Class.forName(asmDatum.getClassName(), false, CraftTweakerAPI.class.getClassLoader());
                if (AnnotationUtil.hasAnnotation(clazz, ModOnly.class)) {
                    if (Loader.isModLoaded(AnnotationUtil.getAnnotationValue(clazz, ModOnly.class))) {
                        CraftTweakerAPI.registerClass(clazz);
                    }
                } else if (AnnotationUtil.hasAnnotation(clazz, ModTotal.class)) {
                    String[] values = AnnotationUtil.getAnnotationValue(clazz, ModTotal.class);
                    if (Arrays.stream(values).allMatch(Loader::isModLoaded)) {
                        CraftTweakerAPI.registerClass(clazz);
                    }
                } else {
                    CraftTweakerAPI.registerClass(clazz);
                }
            } catch (ClassNotFoundException e) {
                CraftTweaker.LOG.catching(e);
            }
        }
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
