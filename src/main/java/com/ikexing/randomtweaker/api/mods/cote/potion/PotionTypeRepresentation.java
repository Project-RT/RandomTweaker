package com.ikexing.randomtweaker.api.mods.cote.potion;

import com.ikexing.randomtweaker.RandomTweaker;
import com.teamacronymcoders.contenttweaker.ContentTweaker;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.potions.IPotion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;

@ZenRegister
@ModOnly("contenttweaker")
@ZenClass("mods.randomtweaker.cote.PotionType")
public class PotionTypeRepresentation {

    @ZenProperty
    public String name;
    @ZenProperty
    public int duration = 3600;
    @ZenProperty
    public int amplifier = 0;
    @ZenProperty
    public IPotion potion;

    public PotionTypeRepresentation(String name, IPotion potion) {
        this.name = name;
        this.potion = potion;
    }

    @ZenMethod
    public int getDuration() {
        return duration;
    }

    @ZenMethod
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @ZenMethod
    public int getAmplifier() {
        return amplifier;
    }

    @ZenMethod
    public void setAmplifier(int amplifier) {
        this.amplifier = amplifier;
    }

    @ZenMethod
    public String getName() {
        return name;
    }

    @ZenMethod
    public void setName(String name) {
        this.name = name;
    }

    @ZenMethod
    public IPotion getPotion() {
        return potion;
    }

    @ZenMethod
    public void setPotion(IPotion potion) {
        this.potion = potion;
    }

    @ZenMethod
    public void register() {
        if (RandomTweaker.potionTypeList.get(name) == null) {
            RandomTweaker.potionTypeList
                .put(name, new PotionType(ContentTweaker.MOD_ID + "." + this.name,
                    new PotionEffect(CraftTweakerMC.getPotion(potion), duration, amplifier))
                    .setRegistryName(name));
        } else {
            CraftTweakerAPI
                .logError(" All PotionTypes must be unique. Key: contenttweaker:" + name + " is not.",
                    new UnsupportedOperationException());
        }
    }
}
