package ink.ikx.rt.api.mods.cote.function;

import crafttweaker.api.entity.IEntityLivingBase;
import crafttweaker.api.item.IItemStack;
import stanhebben.zenscript.annotations.ZenClass;

/**
 * @author superhelo
 */
@ZenClass("mods.randomtweaker.cote.BaubleFunction")
@FunctionalInterface
public interface BaubleFunction {

    void handle(IItemStack bauble, IEntityLivingBase wearer);

}
