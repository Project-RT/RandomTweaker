package ink.ikx.rt.api.mods.cote;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import ink.ikx.rt.api.mods.cote.manaItem.ManaItemRepresentation;
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
            CraftTweakerAPI.logError("You can only create a manaitem when both Botania and ContentTweaker installed！");
            return null;
        }
    }
}
