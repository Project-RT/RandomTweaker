package com.ikexing.randomtweaker.api.cote.potion;

import com.ikexing.randomtweaker.RandomTweaker;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;

@ZenRegister
@ModOnly("contenttweaker")
@ZenClass("mods.randomtweaker.cote.Potion")
public class PotionRepresentation {

    @ZenProperty
    public boolean isBadEffectIn;
    @ZenProperty
    public int liquidColorIn;
    @ZenProperty
    public String unlocalizedName;

    public PotionRepresentation(String unlocalizedName, boolean isBadEffectIn, int liquidColorIn) {
        this.isBadEffectIn = isBadEffectIn;
        this.liquidColorIn = liquidColorIn;
        this.unlocalizedName = unlocalizedName;
    }

    @ZenMethod
    public void register() {
        RandomTweaker.potionRegList.add(new PotionContent(this));
    }
}
