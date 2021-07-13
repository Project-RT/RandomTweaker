package ink.ikx.rt.api.mods.cote.function.mana;

import crafttweaker.api.entity.IEntityLivingBase;
import crafttweaker.api.item.IItemStack;
import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import stanhebben.zenscript.annotations.ZenClass;

/**
 * @author superhelo
 */
@RTRegisterClass({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.BaubleFunctionWithReturn")
@FunctionalInterface
public interface BaubleFunctionWithReturn {

    boolean handle(IItemStack bauble, IEntityLivingBase wearer);

}
