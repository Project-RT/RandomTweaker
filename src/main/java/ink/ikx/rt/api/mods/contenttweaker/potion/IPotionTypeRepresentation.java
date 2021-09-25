package ink.ikx.rt.api.mods.contenttweaker.potion;

import crafttweaker.annotations.ModOnly;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;

@ModOnly("contenttweaker")
@ZenClass("mods.randomtweaker.cote.PotionType")
public abstract class IPotionTypeRepresentation {

    public String unlocalizedName;
    public IPotionRepresentation potion;

    @ZenProperty
    public int duration = 3600;
    @ZenProperty
    public int amplifier = 0;

    protected IPotionTypeRepresentation(String unlocalizedName, IPotionRepresentation potion) {
        this.unlocalizedName = unlocalizedName;
        this.potion = potion;
    }

    @ZenMethod
    public abstract void register();

}
