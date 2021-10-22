package ink.ikx.rt.api.mods.contenttweaker.function.mana;

import crafttweaker.api.item.IItemStack;
import ink.ikx.rt.impl.mods.crafttweaker.ModTotal;
import ink.ikx.rt.impl.mods.crafttweaker.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;

/**
 * @author superhelo
 */
@ZenRegister
@FunctionalInterface
@ModTotal({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.IManaWithItem")
public interface IManaWithItem {

    boolean call(IItemStack stack, IItemStack otherStack);

}
