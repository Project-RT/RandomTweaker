package ink.ikx.rt.api.mods.cote.function;

import crafttweaker.api.entity.IEntityLivingBase;
import crafttweaker.api.item.IItemStack;
import stanhebben.zenscript.annotations.ZenClass;

@ZenClass("mods.randomtweaker.CanUnequip")
@FunctionalInterface
public interface CanUnequip {

    boolean handle(IItemStack bauble, IEntityLivingBase wearer);
}
