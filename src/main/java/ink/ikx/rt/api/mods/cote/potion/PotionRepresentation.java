package ink.ikx.rt.api.mods.cote.potion;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import ink.ikx.rt.RandomTweaker;
import ink.ikx.rt.api.mods.cote.function.PotionIsReady;
import ink.ikx.rt.api.mods.cote.function.PotionPerformEffect;
import net.minecraft.potion.Potion;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;

@ZenRegister
@ModOnly("contenttweaker")
@ZenClass("mods.randomtweaker.cote.Potion")
public class PotionRepresentation {

    private Potion potion;

    @ZenProperty
    public int liquidColorIn;
    @ZenProperty
    public String unlocalizedName;
    @ZenProperty
    public boolean badEffectIn = false;
    @ZenProperty
    public boolean beneficial = true;
    @ZenProperty
    public boolean instant = false;
    @ZenProperty
    public boolean shouldRender = true;
    @ZenProperty
    public boolean shouldRenderHUD = true;
    @ZenProperty
    public PotionPerformEffect performEffect = null;
    @ZenProperty
    public PotionIsReady isReady = null;

    public PotionRepresentation(String unlocalizedName, int liquidColorIn) {
        this.liquidColorIn = liquidColorIn;
        this.unlocalizedName = unlocalizedName;
    }

    @ZenMethod
    public boolean isBadEffectIn() {
        return badEffectIn;
    }

    @ZenMethod
    public void setBadEffectIn(boolean badEffectIn) {
        this.badEffectIn = badEffectIn;
    }

    @ZenMethod
    public int getLiquidColorIn() {
        return liquidColorIn;
    }

    @ZenMethod
    public void setLiquidColorIn(int liquidColorIn) {
        this.liquidColorIn = liquidColorIn;
    }

    @ZenMethod
    public String getName() {
        return unlocalizedName;
    }

    @ZenMethod
    public void setName(String unlocalizedName) {
        this.unlocalizedName = unlocalizedName;
    }

    @ZenMethod
    public boolean isInstant() {
        return instant;
    }

    @ZenMethod
    public void setInstant(boolean instant) {
        this.instant = instant;
    }

    @ZenMethod
    public boolean isBeneficial() {
        return beneficial;
    }

    @ZenMethod
    public void setBeneficial(boolean beneficial) {
        this.beneficial = beneficial;
    }

    @ZenMethod
    public boolean isShouldRender() {
        return shouldRender;
    }

    @ZenMethod
    public void setShouldRender(boolean shouldRender) {
        this.shouldRender = shouldRender;
    }

    @ZenMethod
    public boolean isShouldRenderHUD() {
        return shouldRenderHUD;
    }

    @ZenMethod
    public void setShouldRenderHUD(boolean shouldRenderHUD) {
        this.shouldRenderHUD = shouldRenderHUD;
    }

    @ZenMethod
    public void register() {
        if (RandomTweaker.potionRegMap.get(unlocalizedName) == null) {
            potion = new PotionContent(this);
            RandomTweaker.potionRegMap.put(unlocalizedName, potion);
        } else {
            CraftTweakerAPI.logError("All Potions must be unique. Key: contenttweaker:" + unlocalizedName + " is not.", new UnsupportedOperationException());
        }
    }

    public Potion getInternal() {
        return potion;
    }
}
