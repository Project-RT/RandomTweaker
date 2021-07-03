package ink.ikx.rt.api.mods.cote.item;

import com.teamacronymcoders.base.registrysystem.ItemRegistry;
import com.teamacronymcoders.contenttweaker.ContentTweaker;
import ink.ikx.rt.api.mods.cote.function.BaubleFunction;
import ink.ikx.rt.api.mods.cote.function.BaubleFunctionWithReturn;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenProperty;

/**
 * @author : superhelo
 */
@ZenClass("mods.randomtweaker.cote.ManaBauble")
public class ManaBaubleRepresentation extends ManaItemRepresentation {

    @ZenProperty
    public String baubleType;
    @ZenProperty
    public BaubleFunction onWornTick;
    @ZenProperty
    public BaubleFunction onEquipped;
    @ZenProperty
    public BaubleFunction onUnequipped;
    @ZenProperty
    public BaubleFunctionWithReturn canEquip;
    @ZenProperty
    public BaubleFunctionWithReturn canUnEquip;
    @ZenProperty
    public BaubleFunctionWithReturn willAutoSync;

    public ManaBaubleRepresentation(String unlocalizedName, int maxMana) {
        super(unlocalizedName, maxMana);
    }

    @Override
    public void setHasCreative(boolean hasCreative) {
        this.hasCreative = false;
    }

    @Override
    public boolean hasCreative() {
        return false;
    }

    @Override
    public String getTypeName() {
        return "ManaBauble";
    }

    @Override
    public void register() {
        ContentTweaker.instance.getRegistry(ItemRegistry.class, "ITEM").register(new ManaBaubleContent(this));
    }
}
