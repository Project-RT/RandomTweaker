package ink.ikx.rt.impl.mods.crafttweaker;

import cn.hutool.core.annotation.AnnotationUtil;
import com.google.common.collect.Lists;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import ink.ikx.rt.api.internal.world.IBlockPosExpansion;
import net.minecraftforge.fml.common.Loader;

import java.util.List;

public class CraftTweakerExtension {

    private static final List<Class<?>> classes;

    static {
        classes = Lists.newArrayList(
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
    }

}
