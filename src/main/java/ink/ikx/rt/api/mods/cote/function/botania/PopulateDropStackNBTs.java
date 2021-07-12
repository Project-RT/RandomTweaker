package ink.ikx.rt.api.mods.cote.function.botania;

import crafttweaker.api.item.IItemStack;
import stanhebben.zenscript.annotations.ZenClass;

@FunctionalInterface
@ZenClass("mods.randomtweaker.cote.populateDropStackNBTs")
public interface PopulateDropStackNBTs {
    void call(IItemStack[] drops);
}
