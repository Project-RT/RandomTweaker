package ink.ikx.rt.impl.mods.crafttweaker;

import cn.hutool.core.annotation.AnnotationUtil;
import com.google.common.collect.Lists;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.zenscript.GlobalRegistry;
import ink.ikx.rt.api.internal.file.IProp;
import ink.ikx.rt.api.internal.utils.IInputPattern;
import ink.ikx.rt.api.internal.world.IBlockPosExpansion;
import ink.ikx.rt.api.mods.astralsorcery.IPlayerExpansionAs;
import ink.ikx.rt.api.mods.botania.IHydroangeas;
import ink.ikx.rt.api.mods.botania.IOrechid;
import ink.ikx.rt.api.mods.jei.IJeiUtils;
import ink.ikx.rt.api.mods.jei.IJeiUtilsWithBotania;
import ink.ikx.rt.api.mods.jei.JEIExpansion;
import ink.ikx.rt.api.mods.jei.core.IJeiBackground;
import ink.ikx.rt.api.mods.jei.core.IJeiPanel;
import ink.ikx.rt.api.mods.jei.core.IJeiRecipe;
import ink.ikx.rt.api.mods.jei.core.IJeiTooltip;
import ink.ikx.rt.api.mods.jei.elements.IJeiElement;
import ink.ikx.rt.api.mods.jei.elements.IJeiElements;
import ink.ikx.rt.api.mods.jei.slots.IJeiSlot;
import ink.ikx.rt.api.mods.jei.slots.IJeiSlotItem;
import ink.ikx.rt.api.mods.jei.slots.IJeiSlotLiquid;
import ink.ikx.rt.api.mods.naturesaura.IWorldExpansionNa;
import ink.ikx.rt.api.mods.thaumcraft.IPlayerExpansionTc;
import ink.ikx.rt.impl.internal.config.RTConfig;
import net.minecraftforge.fml.common.Loader;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CraftTweakerExtension {

    private static final List<Class<?>> classes;

    static {
        classes = Lists.newArrayList(
                IJeiSlot.class,
                IJeiUtils.class,
                IJeiPanel.class,
                IJeiRecipe.class,
                IJeiTooltip.class,
                IJeiElement.class,
                IJeiSlotItem.class,
                JEIExpansion.class,
                IInputPattern.class,
                IJeiSlotLiquid.class,
                IJeiBackground.class,
                IWorldExpansionNa.class,
                IBlockPosExpansion.class,
                IPlayerExpansionAs.class,
                IPlayerExpansionTc.class,
                IJeiUtilsWithBotania.class,
                IJeiElements.IJeiElementImage.class,
                IJeiElements.IJeiElementArrow.class,
                IJeiElements.IJeiElementLiquid.class,
                IJeiElements.IJeiElementManaBar.class,
                IJeiElements.IJeiElementFontInfo.class,
                IJeiElements.IJeiElementItemInput.class,
                IJeiElements.IJeiElementItemOutput.class
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
            } else if (AnnotationUtil.hasAnnotation(clazz, ModTotal.class)) {
                String[] values = AnnotationUtil.getAnnotationValue(clazz, ModTotal.class);
                if (Arrays.stream(values).allMatch(Loader::isModLoaded)) {
                    CraftTweakerAPI.registerClass(clazz);
                }
            } else {
                CraftTweakerAPI.registerClass(clazz);
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
        }
    }

    public static void registerGlobal() {

        GlobalRegistry.registerGlobal("inputPattern",
                GlobalRegistry.getStaticFunction(IInputPattern.class, "inputPattern", String[].class, Map.class));

        GlobalRegistry.registerGlobal("inputPatternWithShapeLess",
                GlobalRegistry.getStaticFunction(IInputPattern.class, "inputPatternWithShapeLess", String[].class, Map.class));
    }

}
