package ink.ikx.rt.api.mods.cote.potion;

import com.teamacronymcoders.contenttweaker.ContentTweaker;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import ink.ikx.rt.RandomTweaker;
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
    public String unlocalizedName;
    @ZenProperty
    public int duration = 3600;
    @ZenProperty
    public int amplifier = 0;
    @ZenProperty
    public PotionRepresentation potion;

    public PotionTypeRepresentation(String unlocalizedName, PotionRepresentation potion) {
        this.unlocalizedName = unlocalizedName;
        this.potion = potion;
        if (!potion.isInstant()) {
            this.duration = 0;
        }
    }

    @ZenMethod
    public int getDuration() {
        return duration;
    }

    @ZenMethod
    public void setDuration(int duration) {
        if (!potion.isInstant()) {
            this.duration = duration;
        } else {
            this.amplifier = 0;
        }
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
        return unlocalizedName;
    }

    @ZenMethod
    public void setName(String unlocalizedName) {
        this.unlocalizedName = unlocalizedName;
    }

    @ZenMethod
    public PotionRepresentation getPotion() {
        return potion;
    }

    @ZenMethod
    public void setPotion(PotionRepresentation potion) {
        this.potion = potion;
    }

    @ZenMethod
    public void register() {
        if (RandomTweaker.potionTypeMap.get(unlocalizedName) == null) {
            RandomTweaker.potionTypeMap.put(unlocalizedName,
                    new PotionType(ContentTweaker.MOD_ID + "." + this.unlocalizedName,
                            new PotionEffect(potion.getInternal(), duration, amplifier)).setRegistryName(unlocalizedName));
        } else {
            CraftTweakerAPI.logError(" All PotionTypes must be unique. Key: contenttweaker:" + unlocalizedName + " is not.", new UnsupportedOperationException());
        }
    }
}
