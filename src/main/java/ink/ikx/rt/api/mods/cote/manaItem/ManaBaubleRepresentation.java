package ink.ikx.rt.api.mods.cote.manaItem;

import com.teamacronymcoders.base.registrysystem.ItemRegistry;
import com.teamacronymcoders.contenttweaker.ContentTweaker;
import ink.ikx.rt.api.mods.cote.function.CanEquip;
import ink.ikx.rt.api.mods.cote.function.CanUnequip;
import ink.ikx.rt.api.mods.cote.function.OnEquipped;
import ink.ikx.rt.api.mods.cote.function.OnUnequipped;
import ink.ikx.rt.api.mods.cote.function.OnWornTick;
import ink.ikx.rt.api.mods.cote.function.WillAutoSync;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenProperty;

/**
 * @author : superhelo
 */

@ZenClass("mods.randomtweaker.ManaBauble")
public class ManaBaubleRepresentation extends ManaItemRepresentation {

    @ZenProperty
    public OnWornTick onWornTick = null;
    @ZenProperty
    public OnEquipped onEquipped = null;
    @ZenProperty
    public OnUnequipped onUnequipped = null;
    @ZenProperty
    public CanEquip canEquip = null;
    @ZenProperty
    public CanUnequip canUnequip = null;
    @ZenProperty
    public WillAutoSync willAutoSync = null;

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
        return "ManaRing";
    }

    @Override
    public void register() {
        ContentTweaker.instance.getRegistry(ItemRegistry.class, "ITEM").register(new ManaBaubleBContent(this));
    }
}
