package ink.ikx.rt.api.mods.contenttweaker.function.subtile;

import crafttweaker.api.item.IItemStack;
import ink.ikx.rt.impl.mods.crafttweaker.ModTotal;
import stanhebben.zenscript.annotations.ZenClass;

@FunctionalInterface
@ModTotal({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.PopulateDropStackNBTs")
public interface PopulateDropStackNBTs {

    void call(IItemStack[] drops);

}
