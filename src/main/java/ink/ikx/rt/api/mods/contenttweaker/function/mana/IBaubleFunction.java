package ink.ikx.rt.api.mods.contenttweaker.function.mana;

import crafttweaker.api.entity.IEntityLivingBase;
import crafttweaker.api.item.IItemStack;
import youyihj.zenutils.api.zenscript.SidedZenRegister;

import stanhebben.zenscript.annotations.ZenClass;

/**
 * @author superhelo
 */

@FunctionalInterface
@SidedZenRegister(modDeps = {"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.IBaubleFunction")
public interface IBaubleFunction {

    void call(IItemStack bauble, IEntityLivingBase wearer);

}
