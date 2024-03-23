package ink.ikx.rt.api.mods.contenttweaker.function.mana;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.world.IWorld;
import youyihj.zenutils.api.zenscript.SidedZenRegister;

import stanhebben.zenscript.annotations.ZenClass;


@FunctionalInterface
@SidedZenRegister(modDeps = {"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.IGetEntityLifeSpan")
public interface IGetEntityLifeSpan {

    int call(IItemStack stack, IWorld world);

}

