package ink.ikx.rt.api.mods.cote.function;

import crafttweaker.api.entity.IEntityLivingBase;
import crafttweaker.api.item.IItemStack;
import stanhebben.zenscript.annotations.ZenClass;

@ZenClass("mods.randomtweaker.baubleFunction")
@FunctionalInterface
public interface BaubleFunction {

    boolean handle(IItemStack bauble, IEntityLivingBase wearer);

}
