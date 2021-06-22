package ink.ikx.rt.api.mods.cote;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import ink.ikx.rt.api.mods.cote.potion.PotionRepresentation;
import ink.ikx.rt.api.mods.cote.potion.PotionTypeRepresentation;
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
    public static PotionTypeRepresentation cretePotionType(String unlocalizedName,
        PotionRepresentation potion) {
        return new PotionTypeRepresentation(unlocalizedName, potion);
    }
}
