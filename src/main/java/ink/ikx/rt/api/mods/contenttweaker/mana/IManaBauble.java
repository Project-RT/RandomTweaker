package ink.ikx.rt.api.mods.contenttweaker.mana;

import ink.ikx.rt.impl.mods.crafttweaker.ModTotal;
import ink.ikx.rt.impl.mods.crafttweaker.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;

/**
 * @author superhelo
 */
@ZenRegister
@ModTotal({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.item.IManaBauble")
public interface IManaBauble extends IManaItem {

    @ZenGetter("baubleType")
    String getBaubleType();

}
