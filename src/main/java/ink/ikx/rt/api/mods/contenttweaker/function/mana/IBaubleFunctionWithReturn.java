package ink.ikx.rt.api.mods.contenttweaker.function.mana;

import crafttweaker.api.entity.IEntityLivingBase;
import crafttweaker.api.item.IItemStack;
import ink.ikx.rt.impl.mods.crafttweaker.ModTotal;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import stanhebben.zenscript.annotations.ZenClass;

/**
 * @author superhelo
 */
@RTRegister
@ModTotal({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.IBaubleFunctionWithReturn")
@FunctionalInterface
public interface IBaubleFunctionWithReturn {

    boolean call(IItemStack bauble, IEntityLivingBase wearer);

}
