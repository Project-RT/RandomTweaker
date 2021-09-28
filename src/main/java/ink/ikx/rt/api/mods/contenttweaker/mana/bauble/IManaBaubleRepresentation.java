package ink.ikx.rt.api.mods.contenttweaker.mana.bauble;

import ink.ikx.rt.api.mods.contenttweaker.function.mana.IBaubleFunction;
import ink.ikx.rt.api.mods.contenttweaker.function.mana.IBaubleFunctionWithReturn;
import ink.ikx.rt.api.mods.contenttweaker.function.mana.IBaubleRender;
import ink.ikx.rt.api.mods.contenttweaker.mana.item.IManaItemRepresentation;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;

/**
 * @author superhelo
 */
@ZenClass("mods.randomtweaker.cote.ManaBauble")
public abstract class IManaBaubleRepresentation extends IManaItemRepresentation {

    @ZenProperty
    public String baubleType;
    @ZenProperty
    public IBaubleFunction onWornTick;
    @ZenProperty
    public IBaubleFunction onEquipped;
    @ZenProperty
    public IBaubleFunction onUnequipped;
    @ZenProperty
    public IBaubleRender onPlayerBaubleRender;
    @ZenProperty
    public IBaubleFunctionWithReturn canEquip;
    @ZenProperty
    public IBaubleFunctionWithReturn canUnEquip;
    @ZenProperty
    public IBaubleFunctionWithReturn willAutoSync;

    @ZenMethod
    public String getBaubleType() {
        return baubleType;
    }

    @ZenMethod
    public void setBaubleType(String baubleType) {
        this.baubleType = baubleType;
    }

    @Override
    public String getTypeName() {
        return "ManaBauble";
    }

    @Override
    public abstract void register();

}
