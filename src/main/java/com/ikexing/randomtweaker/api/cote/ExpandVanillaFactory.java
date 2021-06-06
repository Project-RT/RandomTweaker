package com.ikexing.randomtweaker.api.cote;

import com.ikexing.randomtweaker.api.cote.potion.PotionRepresentation;
import com.ikexing.randomtweaker.api.cote.potion.PotionTypeRepresentation;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethodStatic;

@ZenRegister
@ModOnly("contenttweaker")
@ZenExpansion("mods.contenttweaker.VanillaFactory")
public class ExpandVanillaFactory {

    @ZenMethodStatic
    public static PotionRepresentation createPotion(String name, int color) {
        return new PotionRepresentation(name, color);
    }

    @ZenMethodStatic
    public static PotionTypeRepresentation cretePotionType(String name,
        PotionRepresentation potion) {
        return new PotionTypeRepresentation(name, potion);
    }
}
