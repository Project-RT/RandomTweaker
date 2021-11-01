package ink.ikx.rt.impl.mods.crafttweaker;

import cn.hutool.core.annotation.AnnotationUtil;
import com.google.common.collect.Lists;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.zenscript.GlobalRegistry;
import ink.ikx.rt.api.internal.file.IProp;
import ink.ikx.rt.api.internal.item.IItemStackExpansion;
import ink.ikx.rt.api.internal.utils.IInputPattern;
import ink.ikx.rt.api.internal.utils.ITileData;
import ink.ikx.rt.api.internal.world.IBlockPosExpansion;
import ink.ikx.rt.api.mods.astralsorcery.IPlayerExpansionAs;
import ink.ikx.rt.api.mods.botania.IManaItemHandler;
import ink.ikx.rt.api.mods.botania.ITileAlfPortal;
import ink.ikx.rt.api.mods.botania.event.CTAlfPortalDroppedEvent;
import ink.ikx.rt.api.mods.botania.event.CTElvenTradeEvent;
import ink.ikx.rt.api.mods.botania.event.CTEventManager;
import ink.ikx.rt.api.mods.botania.event.CTPoolTradeEvent;
import ink.ikx.rt.api.mods.botania.subtile.IHydroangeas;
import ink.ikx.rt.api.mods.botania.subtile.IOrechid;
import ink.ikx.rt.api.mods.contenttweaker.ExpandVanillaFactory;
import ink.ikx.rt.api.mods.contenttweaker.ExpandVanillaFactoryWithBotania;
import ink.ikx.rt.api.mods.contenttweaker.ExpandVanillaFactoryWithThaumcraft;
import ink.ikx.rt.api.mods.contenttweaker.aspect.IAspectRepresentation;
import ink.ikx.rt.api.mods.contenttweaker.function.IPotionIsReady;
import ink.ikx.rt.api.mods.contenttweaker.function.IPotionPerformEffect;
import ink.ikx.rt.api.mods.contenttweaker.function.mana.*;
import ink.ikx.rt.api.mods.contenttweaker.function.subtile.*;
import ink.ikx.rt.api.mods.contenttweaker.mana.IManaBauble;
import ink.ikx.rt.api.mods.contenttweaker.mana.IManaHelper;
import ink.ikx.rt.api.mods.contenttweaker.mana.IManaItem;
import ink.ikx.rt.api.mods.contenttweaker.mana.bauble.IManaBaubleRepresentation;
import ink.ikx.rt.api.mods.contenttweaker.mana.item.IManaItemRepresentation;
import ink.ikx.rt.api.mods.contenttweaker.mana.item.tool.IIsUsesManaItemRepresentation;
import ink.ikx.rt.api.mods.contenttweaker.potion.IPotionRepresentation;
import ink.ikx.rt.api.mods.contenttweaker.potion.IPotionTypeRepresentation;
import ink.ikx.rt.api.mods.contenttweaker.render.IBaubleRenderHelper;
import ink.ikx.rt.api.mods.contenttweaker.render.IBotaniaFXHelper;
import ink.ikx.rt.api.mods.contenttweaker.subtile.ExpandWorldForSubTile;
import ink.ikx.rt.api.mods.contenttweaker.subtile.ISubTileEntityInGame;
import ink.ikx.rt.api.mods.contenttweaker.subtile.ISubTileEntityRepresentation;
import ink.ikx.rt.api.mods.contenttweaker.subtile.functional.ISubTileEntityFunctionalRepresentation;
import ink.ikx.rt.api.mods.contenttweaker.subtile.generating.ISubTileEntityGeneratingRepresentation;
import ink.ikx.rt.api.mods.ftbultimine.IPlayerExpansionFTBU;
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
import ink.ikx.rt.api.mods.naturesaura.IAuraChunk;
import ink.ikx.rt.api.mods.naturesaura.IWorldExpansionNa;
import ink.ikx.rt.api.mods.thaumcraft.IEntityExpansionTc;
import ink.ikx.rt.api.mods.thaumcraft.IItemStackExpansionTc;
import ink.ikx.rt.api.mods.thaumcraft.IPlayerExpansionTc;
import ink.ikx.rt.impl.internal.config.RTConfig;
import ink.ikx.rt.impl.mods.crafttweaker.brackethandler.BracketHandlerJei;
import ink.ikx.rt.impl.mods.crafttweaker.brackethandler.BracketHandlerPotion;
import ink.ikx.rt.impl.mods.crafttweaker.brackethandler.BracketHandlerSubTile;
import net.minecraftforge.fml.common.Loader;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CraftTweakerExtension {

    private static final List<Class<?>> classes;

    static {
        classes = Lists.newArrayList(
                Update.class,
                IJeiSlot.class,
                IJeiUtils.class,
                CanSelect.class,
                ITileData.class,
                IJeiPanel.class,
                IManaItem.class,
                IJeiRecipe.class,
                BlockAdded.class,
                IAuraChunk.class,
                IManaBauble.class,
                IManaHelper.class,
                IJeiTooltip.class,
                IJeiElement.class,
                IisUsesMana.class,
                IJeiSlotItem.class,
                JEIExpansion.class,
                IManaWithItem.class,
                IManaWithPool.class,
                IBaubleRender.class,
                IInputPattern.class,
                BlockPlacedBy.class,
                IPotionIsReady.class,
                CTEventManager.class,
                IJeiSlotLiquid.class,
                IJeiBackground.class,
                ITileAlfPortal.class,
                BlockActivated.class,
                BlockHarvested.class,
                IBaubleFunction.class,
                CTPoolTradeEvent.class,
                IBotaniaFXHelper.class,
                IManaItemHandler.class,
                BracketHandlerJei.class,
                CTElvenTradeEvent.class,
                IWorldExpansionNa.class,
                IEntityExpansionTc.class,
                IBlockPosExpansion.class,
                IPlayerExpansionAs.class,
                IPlayerExpansionTc.class,
                IItemStackExpansion.class,
                IBaubleRenderHelper.class,
                ExpandVanillaFactory.class,
                ISubTileEntityInGame.class,
                IJeiUtilsWithBotania.class,
                CanGeneratePassively.class,
                IPotionPerformEffect.class,
                IPlayerExpansionFTBU.class,
                BracketHandlerPotion.class,
                IItemStackExpansionTc.class,
                IPotionRepresentation.class,
                PopulateDropStackNBTs.class,
                IAspectRepresentation.class,
                ExpandWorldForSubTile.class,
                BracketHandlerSubTile.class,
                CTAlfPortalDroppedEvent.class,
                IBaubleFunctionWithReturn.class,
                IPotionTypeRepresentation.class,
                IJeiElements.IJeiElementImage.class,
                IJeiElements.IJeiElementArrow.class,
                IJeiElements.IJeiElementLiquid.class,
                ExpandVanillaFactoryWithBotania.class,
                IJeiElements.IJeiElementManaBar.class,
                IJeiElements.IJeiElementFontInfo.class,
                IJeiElements.IJeiElementItemInput.class,
                ExpandVanillaFactoryWithThaumcraft.class,
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
