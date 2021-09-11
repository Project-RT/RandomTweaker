package ink.ikx.rt;

import cn.hutool.core.annotation.AnnotationUtil;
import com.google.common.collect.Lists;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import ink.ikx.rt.api.internal.bracket.BracketHandler;
import ink.ikx.rt.api.internal.event.CTEventManager;
import ink.ikx.rt.api.internal.event.CTPlayerSanityChangeEvent;
import ink.ikx.rt.api.internal.file.Prop;
import ink.ikx.rt.api.internal.item.IItemStackExpansion;
import ink.ikx.rt.api.internal.item.IManaHelper;
import ink.ikx.rt.api.internal.item.ManaBauble;
import ink.ikx.rt.api.internal.item.ManaItem;
import ink.ikx.rt.api.internal.player.IPlayerExpansionSanity;
import ink.ikx.rt.api.internal.utils.TileData;
import ink.ikx.rt.api.internal.world.IBlockPosExpansion;
import ink.ikx.rt.api.mods.botania.AlfPortalTileInGame;
import ink.ikx.rt.api.mods.botania.Hydroangeas;
import ink.ikx.rt.api.mods.botania.IMixinTileAlfPortal;
import ink.ikx.rt.api.mods.botania.Orechid;
import ink.ikx.rt.api.mods.botania.events.CTAlfPortalDroppedEvent;
import ink.ikx.rt.api.mods.botania.events.CTElvenTradeEvent;
import ink.ikx.rt.api.mods.botania.events.CTPoolTradeEvent;
import ink.ikx.rt.api.mods.cote.ExpandVanillaFactory;
import ink.ikx.rt.api.mods.cote.ExpandVanillaFactoryBotania;
import ink.ikx.rt.api.mods.cote.ExpandVanillaFactoryThaumcraft;
import ink.ikx.rt.api.mods.cote.aspect.AspectRepresentation;
import ink.ikx.rt.api.mods.cote.bracket.BracketHandlerCoTSubTile;
import ink.ikx.rt.api.mods.cote.bracket.BracketHandlerCotPotion;
import ink.ikx.rt.api.mods.cote.flower.ExpandWorldForSubTile;
import ink.ikx.rt.api.mods.cote.flower.SubTileEntityInGame;
import ink.ikx.rt.api.mods.cote.flower.SubTileRepresentation;
import ink.ikx.rt.api.mods.cote.flower.functional.SubTileFunctionalRepresentation;
import ink.ikx.rt.api.mods.cote.flower.generating.SubTileGeneratingRepresentation;
import ink.ikx.rt.api.mods.cote.function.PotionIsReady;
import ink.ikx.rt.api.mods.cote.function.PotionPerformEffect;
import ink.ikx.rt.api.mods.cote.function.botania.BlockActivated;
import ink.ikx.rt.api.mods.cote.function.botania.BlockAdded;
import ink.ikx.rt.api.mods.cote.function.botania.BlockHarvested;
import ink.ikx.rt.api.mods.cote.function.botania.BlockPlacedBy;
import ink.ikx.rt.api.mods.cote.function.botania.CanGeneratePassively;
import ink.ikx.rt.api.mods.cote.function.botania.CanSelect;
import ink.ikx.rt.api.mods.cote.function.botania.PopulateDropStackNBTs;
import ink.ikx.rt.api.mods.cote.function.botania.Update;
import ink.ikx.rt.api.mods.cote.function.mana.BaubleFunction;
import ink.ikx.rt.api.mods.cote.function.mana.BaubleFunctionWithReturn;
import ink.ikx.rt.api.mods.cote.function.mana.BaubleRender;
import ink.ikx.rt.api.mods.cote.function.mana.IsUsesMana;
import ink.ikx.rt.api.mods.cote.function.mana.ManaWithItem;
import ink.ikx.rt.api.mods.cote.function.mana.ManaWithPool;
import ink.ikx.rt.api.mods.cote.mana.bauble.ManaBaubleRepresentation;
import ink.ikx.rt.api.mods.cote.mana.item.ManaItemRepresentation;
import ink.ikx.rt.api.mods.cote.mana.item.tool.ManaUsingItemRepresentation;
import ink.ikx.rt.api.mods.cote.potion.PotionRepresentation;
import ink.ikx.rt.api.mods.cote.potion.PotionTypeRepresentation;
import ink.ikx.rt.api.mods.jei.BracketHandlerJEI;
import ink.ikx.rt.api.mods.jei.JEIExpansion;
import ink.ikx.rt.api.mods.jei.interfaces.element.JEIArrowElement;
import ink.ikx.rt.api.mods.jei.interfaces.element.JEICustomElement;
import ink.ikx.rt.api.mods.jei.interfaces.element.JEIElement;
import ink.ikx.rt.api.mods.jei.interfaces.element.JEIFluidElement;
import ink.ikx.rt.api.mods.jei.interfaces.element.JEIFontInfoElement;
import ink.ikx.rt.api.mods.jei.interfaces.element.JEIItemElement;
import ink.ikx.rt.api.mods.jei.interfaces.element.JEIManaBarElement;
import ink.ikx.rt.api.mods.jei.interfaces.other.JEIBackground;
import ink.ikx.rt.api.mods.jei.interfaces.other.JEIPanel;
import ink.ikx.rt.api.mods.jei.interfaces.other.JEIRecipe;
import ink.ikx.rt.api.mods.jei.interfaces.other.JEITooltip;
import ink.ikx.rt.api.mods.jei.interfaces.slots.JEIItemSlot;
import ink.ikx.rt.api.mods.jei.interfaces.slots.JEILiquidSlot;
import ink.ikx.rt.api.mods.jei.interfaces.slots.JEISlot;
import ink.ikx.rt.api.mods.naturesaura.AuraChunk;
import ink.ikx.rt.api.mods.player.IPlayerExpansionAS;
import ink.ikx.rt.api.mods.player.IPlayerExpansionFTBU;
import ink.ikx.rt.api.mods.player.IPlayerExpansionMO;
import ink.ikx.rt.api.mods.player.IPlayerExpansionTAN;
import ink.ikx.rt.api.mods.player.IPlayerExpansionTBL;
import ink.ikx.rt.api.mods.player.IPlayerExpansionTC;
import ink.ikx.rt.api.mods.player.IPlayerExpansionTF;
import ink.ikx.rt.api.mods.render.BaubleRenderHelper;
import ink.ikx.rt.api.mods.render.BotaniaFXHelper;
import ink.ikx.rt.api.mods.tbl.BLCircleGem;
import ink.ikx.rt.api.mods.world.IWorldExpansionNA;
import ink.ikx.rt.impl.config.RTConfig;
import ink.ikx.rt.impl.events.DreamJournal;
import ink.ikx.rt.impl.events.ManaBaubleEvent;
import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;

public class CrTSupport {

    public static final List<Class<?>> CLASSES;

    static {
        CLASSES = Lists.newArrayList(
                BracketHandler.class,
                CTEventManager.class,
                CTPlayerSanityChangeEvent.class,
                IItemStackExpansion.class,
                IManaHelper.class,
                ManaBauble.class,
                ManaItem.class,
                TileData.class,
                IBlockPosExpansion.class,
                CTAlfPortalDroppedEvent.class,
                CTElvenTradeEvent.class,
                CTPoolTradeEvent.class,
                AlfPortalTileInGame.class,
                IMixinTileAlfPortal.class,
                AspectRepresentation.class,
                BracketHandlerCotPotion.class,
                BracketHandlerCoTSubTile.class,
                ExpandWorldForSubTile.class,
                SubTileEntityInGame.class,
                BlockActivated.class,
                BlockAdded.class,
                BlockHarvested.class,
                BlockPlacedBy.class,
                CanGeneratePassively.class,
                CanSelect.class,
                PopulateDropStackNBTs.class,
                Update.class,
                BaubleFunction.class,
                BaubleFunctionWithReturn.class,
                BaubleRender.class,
                IsUsesMana.class,
                ManaWithItem.class,
                ManaWithPool.class,
                PotionPerformEffect.class,
                PotionIsReady.class,
                PotionRepresentation.class,
                PotionTypeRepresentation.class,
                ExpandVanillaFactory.class,
                ExpandVanillaFactoryBotania.class,
                ExpandVanillaFactoryThaumcraft.class,
                JEIArrowElement.class,
                JEICustomElement.class,
                JEIElement.class,
                JEIFluidElement.class,
                JEIFontInfoElement.class,
                JEIItemElement.class,
                JEIManaBarElement.class,
                JEIBackground.class,
                JEIPanel.class,
                JEIRecipe.class,
                JEITooltip.class,
                JEIItemSlot.class,
                JEILiquidSlot.class,
                JEISlot.class,
                BracketHandlerJEI.class,
                JEIExpansion.class,
                AuraChunk.class,
                IPlayerExpansionAS.class,
                IPlayerExpansionFTBU.class,
                IPlayerExpansionMO.class,
                IPlayerExpansionTAN.class,
            IPlayerExpansionTBL.class,
            IPlayerExpansionTC.class,
            IPlayerExpansionTF.class,
            BaubleRenderHelper.class,
            BotaniaFXHelper.class,
            BLCircleGem.class,
            IWorldExpansionNA.class
        );
    }

    public static void registerClassAboutCoT() {
        CraftTweakerAPI.registerClass(ManaItemRepresentation.class);
        CraftTweakerAPI.registerClass(ManaBaubleRepresentation.class);
        CraftTweakerAPI.registerClass(ManaUsingItemRepresentation.class);
    }

    public static void registerClassAboutBoT() {
        CraftTweakerAPI.registerClass(SubTileRepresentation.class);
        CraftTweakerAPI.registerClass(SubTileFunctionalRepresentation.class);
        CraftTweakerAPI.registerClass(SubTileGeneratingRepresentation.class);
    }

    public static void registerClass() {
        for (Class<?> aClass : CLASSES) {
            if (AnnotationUtil.hasAnnotation(aClass, ModOnly.class)) {
                if (Loader.isModLoaded(AnnotationUtil.getAnnotationValue(aClass, ModOnly.class))) {
                    CraftTweakerAPI.registerClass(aClass);
                }
            } else if (AnnotationUtil.hasAnnotation(aClass, RTRegisterClass.class)) {
                String[] value = AnnotationUtil.getAnnotationValue(aClass, RTRegisterClass.class);
                if (Arrays.stream(value).allMatch(Loader::isModLoaded)) {
                    CraftTweakerAPI.registerClass(aClass);
                }
            } else {
                CraftTweakerAPI.registerClass(aClass);
            }
        }
    }

    public static void registerOtherClass() throws IOException {
        if (Loader.isModLoaded("thaumcraft") && RTConfig.Thaumcraft.DreamJournal)
            MinecraftForge.EVENT_BUS.register(DreamJournal.class);
        if (Loader.isModLoaded("botania") && Loader.isModLoaded("contenttweaker"))
            MinecraftForge.EVENT_BUS.register(ManaBaubleEvent.class);
        if (RTConfig.RandomTweaker.PlayerSanity)
            CraftTweakerAPI.registerClass(IPlayerExpansionSanity.class);
        if (RTConfig.FTBUltimine.AllowCrTControl)
            CraftTweakerAPI.registerClass(IPlayerExpansionFTBU.class);
        if (RTConfig.Botania.OrechidModified)
            CraftTweakerAPI.registerClass(Orechid.class);
        if (RTConfig.Botania.HydroangeasModified)
            CraftTweakerAPI.registerClass(Hydroangeas.class);
        if (Prop.createOrDelete(RTConfig.RandomTweaker.Prop))
            CraftTweakerAPI.registerClass(Prop.class);
    }

}
