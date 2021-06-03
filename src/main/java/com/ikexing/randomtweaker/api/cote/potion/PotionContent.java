package com.ikexing.randomtweaker.api.cote.potion;

import com.teamacronymcoders.contenttweaker.ContentTweaker;
import net.minecraft.potion.Potion;

public class PotionContent extends Potion {

    private final PotionRepresentation potionRepresentation;

    protected PotionContent(PotionRepresentation potionRepresentation) {
        super(potionRepresentation.isBadEffectIn, potionRepresentation.liquidColorIn);
        this.potionRepresentation = potionRepresentation;
        this.setPotionName(
            "effect." + ContentTweaker.MOD_ID + "." + potionRepresentation.unlocalizedName);
        this.setRegistryName(ContentTweaker.MOD_ID, potionRepresentation.unlocalizedName);
    }


    public PotionRepresentation getPotionRepresentation() {
        return potionRepresentation;
    }
}
