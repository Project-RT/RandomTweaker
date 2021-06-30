package ink.ikx.rt.api.mods.cote.manaItem;

import com.teamacronymcoders.base.registrysystem.ItemRegistry;
import com.teamacronymcoders.contenttweaker.ContentTweaker;
import ink.ikx.rt.api.mods.cote.function.BaubleFunction;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenProperty;

/**
 * @author : superhelo
 */

@ZenClass("mods.randomtweaker.cote.ManaBauble")
public class ManaBaubleRepresentation extends ManaItemRepresentation {

    @ZenProperty
    public BaubleFunction onWornTick = null;
    @ZenProperty
    public BaubleFunction onEquipped = null;
    @ZenProperty
    public BaubleFunction onUnequipped = null;
    @ZenProperty
    public BaubleFunction canEquip = null;
    @ZenProperty
    public BaubleFunction canUnequip = null;
    @ZenProperty
    public BaubleFunction willAutoSync = null;

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
