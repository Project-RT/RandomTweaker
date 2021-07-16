package ink.ikx.rt.api.mods.cote;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import ink.ikx.rt.api.mods.cote.aspect.AspectRepresentation;
import ink.ikx.rt.api.mods.cote.flower.generating.SubTileGeneratingRepresentation;
import ink.ikx.rt.api.mods.cote.item.ManaBaubleRepresentation;
import ink.ikx.rt.api.mods.cote.item.ManaItemRepresentation;
import ink.ikx.rt.api.mods.cote.potion.PotionRepresentation;
import ink.ikx.rt.api.mods.cote.potion.PotionTypeRepresentation;
import net.minecraftforge.fml.common.Loader;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethodStatic;

@ZenRegister
@ModOnly("contenttweaker")
@ZenExpansion("mods.contenttweaker.VanillaFactory")
public class ExpandVanillaFactory {

    @ZenMethodStatic
    public static PotionRepresentation createPotion(String unlocalizedName, int color) {
        return new PotionRepresentation(unlocalizedName, color);
    }

    @ZenMethodStatic
    public static PotionTypeRepresentation createPotionType(String unlocalizedName,
        PotionRepresentation potion) {
        return new PotionTypeRepresentation(unlocalizedName, potion);
    }

    @ZenMethodStatic
    public static ManaItemRepresentation createManaItem(String unlocalizedName, @Optional(valueLong = 500000) int maxMana) {
        if (Loader.isModLoaded("botania") && Loader.isModLoaded("contenttweaker")) {
            return new ManaItemRepresentation(unlocalizedName, maxMana);
        } else {
            CraftTweakerAPI.logError("You can only create a manaItem when both Botania and ContentTweaker installed！");
            return null;
        }
    }

    @ZenMethodStatic
    public static ManaBaubleRepresentation createManaBauble(String unlocalizedName, @Optional(valueLong = 500000) int maxMana, @Optional(value = "RING") String baubleType) {
        if (Loader.isModLoaded("botania") && Loader.isModLoaded("contenttweaker")) {
            return new ManaBaubleRepresentation(unlocalizedName, maxMana, baubleType);
        }
        CraftTweakerAPI.logError("You can only create a manaBauble when both Botania and ContentTweaker installed！");
        return null;
    }

    @ZenMethodStatic
    public static AspectRepresentation createAspect(String tag, int color) {
        if (Loader.isModLoaded("thaumcraft") && Loader.isModLoaded("contenttweaker")) {
            return new AspectRepresentation(tag, color);
        }
        CraftTweakerAPI.logError("You can only create a manaBauble when both ThaumCraft and ContentTweaker installed！");
        return null;
    }

    @ZenMethodStatic
    public static SubTileGeneratingRepresentation createSubTileGenerating(String unlocalizedName, int color) {
        if (Loader.isModLoaded("botania") && Loader.isModLoaded("contenttweaker")) {
            return new SubTileGeneratingRepresentation(color, unlocalizedName);
        }
        CraftTweakerAPI.logError("You can only create a manaBauble when both Botania and ContentTweaker installed！");
        return null;
    }
}
