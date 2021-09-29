package ink.ikx.rt.api.mods.cote.function.botania;

import crafttweaker.api.item.IItemStack;
import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import stanhebben.zenscript.annotations.ZenClass;

@FunctionalInterface
@RTRegisterClass({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.PopulateDropStackNBTs")
public interface PopulateDropStackNBTs {
    void call(IItemStack[] drops);
}
