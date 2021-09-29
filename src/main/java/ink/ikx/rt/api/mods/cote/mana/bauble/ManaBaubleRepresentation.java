package ink.ikx.rt.api.mods.cote.mana.bauble;

import com.teamacronymcoders.base.registrysystem.ItemRegistry;
import com.teamacronymcoders.contenttweaker.ContentTweaker;
import ink.ikx.rt.api.mods.cote.function.mana.BaubleFunction;
import ink.ikx.rt.api.mods.cote.function.mana.BaubleFunctionWithReturn;
import ink.ikx.rt.api.mods.cote.function.mana.BaubleRender;
import ink.ikx.rt.api.mods.cote.mana.item.ManaItemRepresentation;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;

/**
 * @author superhelo
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
    public BaubleRender onPlayerBaubleRender;
    @ZenProperty
    public BaubleFunctionWithReturn canEquip;
    @ZenProperty
    public BaubleFunctionWithReturn canUnEquip;
    @ZenProperty
    public BaubleFunctionWithReturn willAutoSync;

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

    @Override
    public String getTypeName() {
        return "ManaBauble";
    }

    @Override
    public void register() {
        if (baubleType.equals("TRINKET")) {
            ContentTweaker.instance.getRegistry(ItemRegistry.class, "ITEM").register(new ManaTrinketContent(this));
        } else {
            ContentTweaker.instance.getRegistry(ItemRegistry.class, "ITEM").register(new ManaBaubleContent(this));
        }
    }
}
