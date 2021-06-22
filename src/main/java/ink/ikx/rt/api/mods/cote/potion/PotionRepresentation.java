package ink.ikx.rt.api.mods.cote.potion;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import ink.ikx.rt.RandomTweaker;
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
    public boolean isBadEffectIn = false;
    @ZenProperty
    public boolean isInstant = false;
    @ZenProperty
    public boolean shouldRender = true;
    @ZenProperty
    public boolean shouldRenderHUD = true;

    public PotionRepresentation(String unlocalizedName, int liquidColorIn) {
        this.liquidColorIn = liquidColorIn;
        this.unlocalizedName = unlocalizedName;
    }

    @ZenMethod
    public boolean isBadEffectIn() {
        return isBadEffectIn;
    }

    @ZenMethod
    public void setBadEffectIn(boolean badEffectIn) {
        isBadEffectIn = badEffectIn;
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
        return isInstant;
    }

    @ZenMethod
    public void setInstant(boolean instant) {
        isInstant = instant;
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
        if (RandomTweaker.potionRegList.get(unlocalizedName) == null) {
            potion = new PotionContent(this);
            RandomTweaker.potionRegList.put(unlocalizedName, potion);
        } else {
            CraftTweakerAPI.logError("All Potions must be unique. Key: contenttweaker:" + unlocalizedName + " is not.", new UnsupportedOperationException());
        }
    }

    public Potion getInternal() {
        return potion;
    }
}
