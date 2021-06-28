package ink.ikx.rt.api.mods.cote.function;

import crafttweaker.api.entity.IEntityLivingBase;
import crafttweaker.api.item.IItemStack;
import stanhebben.zenscript.annotations.ZenClass;

@ZenClass("mods.randomtweaker.OnEquipped")
@FunctionalInterface
public interface OnEquipped {

    void handle(IItemStack bauble, IEntityLivingBase wearer);
}
