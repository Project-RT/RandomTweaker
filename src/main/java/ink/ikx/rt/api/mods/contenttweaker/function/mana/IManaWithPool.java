package ink.ikx.rt.api.mods.contenttweaker.function.mana;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IWorld;
import youyihj.zenutils.api.zenscript.SidedZenRegister;

import stanhebben.zenscript.annotations.ZenClass;

/**
 * @author superhelo
 */

@FunctionalInterface
@SidedZenRegister(modDeps = {"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.IManaWithPool")
public interface IManaWithPool {

    boolean call(IItemStack stack, IWorld world, IBlockPos pos);

}
