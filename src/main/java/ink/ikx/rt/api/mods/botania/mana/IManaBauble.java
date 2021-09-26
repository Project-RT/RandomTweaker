package ink.ikx.rt.api.mods.botania.mana;

import ink.ikx.rt.impl.mods.crafttweaker.ModTotal;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;

/**
 * @author superhelo
 */
@ModTotal({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.item.IManaBauble")
public interface IManaBauble extends IManaItem {

    @ZenGetter("baubleType")
    String getBaubleType();
}
