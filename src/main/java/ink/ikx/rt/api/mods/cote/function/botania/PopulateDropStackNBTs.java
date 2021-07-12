package ink.ikx.rt.api.mods.cote.function.botania;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import stanhebben.zenscript.annotations.ZenClass;

@ZenRegister
@FunctionalInterface
@ZenClass("mods.randomtweaker.cote.populateDropStackNBTs")
public interface PopulateDropStackNBTs {
    void call(IItemStack[] drops);
}
