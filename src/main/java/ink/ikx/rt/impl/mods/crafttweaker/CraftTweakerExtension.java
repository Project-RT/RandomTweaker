package ink.ikx.rt.impl.mods.crafttweaker;

import cn.hutool.core.annotation.AnnotationUtil;
import com.google.common.collect.Lists;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import ink.ikx.rt.api.internal.file.IProp;
import ink.ikx.rt.api.internal.world.IBlockPosExpansion;
import ink.ikx.rt.api.mods.astralsorcery.IPlayerExpansionAs;
import ink.ikx.rt.api.mods.naturesaura.IWorldExpansionNa;
import ink.ikx.rt.impl.internal.config.RTConfig;
import net.minecraftforge.fml.common.Loader;

import java.util.List;

public class CraftTweakerExtension {

    private static final List<Class<?>> classes;

    static {
        classes = Lists.newArrayList(
                IWorldExpansionNa.class,
                IPlayerExpansionAs.class,
                IBlockPosExpansion.class
        );
    }

    // For some unknown reasons
    // My use of @ZenRegister will cause it to be called twice on the server side
    public static void registerAllClass() {
        for (Class<?> clazz : classes) {
            if (AnnotationUtil.hasAnnotation(clazz, ModOnly.class)) {
                if (Loader.isModLoaded(AnnotationUtil.getAnnotationValue(clazz, ModOnly.class))) {
                    CraftTweakerAPI.registerClass(clazz);
                }
            } else {
                CraftTweakerAPI.registerClass(clazz);
            }
        }
        registerSpecialClass();
    }

    public static void registerSpecialClass() {
        if (IProp.isRegister(RTConfig.RandomTweaker.Prop))
            CraftTweakerAPI.registerClass(IProp.class);
    }

}
