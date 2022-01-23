package ink.ikx.rt.impl.mods.crafttweaker;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.mc1120.CraftTweaker;
import crafttweaker.zenscript.GlobalRegistry;
import ink.ikx.rt.api.internal.utils.IInputPattern;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.discovery.ASMDataTable;

import java.util.Arrays;
import java.util.Map;

public class CraftTweakerExtension {

    public static void registerAllClass(ASMDataTable asmDataTable) {
        for (ASMDataTable.ASMData asmData : asmDataTable.getAll(RTRegister.class.getCanonicalName())) {
            try {
                Class<?> clazz = Class.forName(asmData.getClassName(), false, CraftTweakerAPI.class.getClassLoader());
                if (clazz.getAnnotation(ModOnly.class) != null) {
                    if (Loader.isModLoaded(clazz.getAnnotation(ModOnly.class).value())) {
                        CraftTweakerAPI.registerClass(clazz);
                    }
                } else if (clazz.getAnnotation(ModTotal.class) != null) {
                    String[] values = clazz.getAnnotation(ModTotal.class).value();
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
    }

    public static void registerGlobal() {
        GlobalRegistry.registerGlobal("inputPattern",
                GlobalRegistry.getStaticFunction(IInputPattern.class, "inputPattern", String[].class));

        GlobalRegistry.registerGlobal("inputPatternGet",
                GlobalRegistry.getStaticFunction(IInputPattern.class, "inputPatternGet", String[].class, Map.class));
    }

}
