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
@FunctionalInterface
@ModTotal({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.IBaubleFunction")
public interface IBaubleFunction {

    void call(IItemStack bauble, IEntityLivingBase wearer);

}
