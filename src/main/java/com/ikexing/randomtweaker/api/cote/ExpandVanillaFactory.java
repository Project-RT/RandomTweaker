package com.ikexing.randomtweaker.api.cote;

import com.ikexing.randomtweaker.api.cote.potion.PotionRepresentation;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethodStatic;

@ZenRegister
@ModOnly("contenttweaker")
@ZenExpansion("mods.contenttweaker.VanillaFactory")
public class ExpandVanillaFactory {

    @ZenMethodStatic
    public static PotionRepresentation createPotion(String unlocalizedName,
        int color) {
        return new PotionRepresentation(unlocalizedName, color);
    }
}
