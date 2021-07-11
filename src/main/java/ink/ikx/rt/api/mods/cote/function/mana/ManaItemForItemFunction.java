package ink.ikx.rt.api.mods.cote.function.mana;

import crafttweaker.api.item.IItemStack;
import stanhebben.zenscript.annotations.ZenClass;

@ZenClass("mods.randomtweaker.cote.ManaItemForItemFunction")
@FunctionalInterface
public interface ManaItemForItemFunction {

    boolean handle(IItemStack stack, IItemStack otherStack);

}
