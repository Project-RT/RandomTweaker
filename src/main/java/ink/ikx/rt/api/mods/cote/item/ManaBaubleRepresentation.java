package ink.ikx.rt.api.mods.cote.item;

import com.teamacronymcoders.base.registrysystem.ItemRegistry;
import com.teamacronymcoders.contenttweaker.ContentTweaker;
import ink.ikx.rt.api.mods.cote.function.mana.BaubleFunction;
import ink.ikx.rt.api.mods.cote.function.mana.BaubleFunctionWithReturn;
import ink.ikx.rt.api.mods.cote.function.mana.BaubleRender;
import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;

/**
 * @author superhelo
 */
@RTRegisterClass({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.ManaBauble")
public class ManaBaubleRepresentation extends ManaItemRepresentation {

    @ZenProperty
    public boolean useMana;
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
    @ZenProperty
    public BaubleRender onPlayerBaubleRender;

    public ManaBaubleRepresentation(String unlocalizedName, int maxMana, String baubleType) {
        super(unlocalizedName, maxMana);
        this.setBaubleType(baubleType);
    }

    @ZenMethod
    public String getBaubleType() {
        return baubleType;
    }

    @ZenMethod
    public void setBaubleType(String baubleType) {
        this.baubleType = baubleType;
    }

    @ZenMethod
    public boolean isUseMana() {
        if (baubleType.equals("RING") || baubleType.equals("TRINKET")) {
            return false;
        }
        return useMana;
    }

    @ZenMethod
    public void setUseMana(boolean useMana) {
        this.useMana = useMana;
    }

    @Override
    public String getTypeName() {
        return "ManaBauble";
    }

    @Override
    public void register() {
        if (baubleType.equals("TRINKET")) {
            ContentTweaker.instance.getRegistry(ItemRegistry.class, "ITEM").register(new ManaTrinketContent(this));
        } else if (baubleType.equals("RING")) {
            ContentTweaker.instance.getRegistry(ItemRegistry.class, "ITEM").register(new ManaBaubleContent(this));
        } else {
            ContentTweaker.instance.getRegistry(ItemRegistry.class, "ITEM").register(new ManaUsingContent(this));
        }
    }
}
