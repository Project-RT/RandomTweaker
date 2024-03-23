package ink.ikx.rt.api.mods.contenttweaker.function.mana;

import crafttweaker.api.item.IItemStack;
import youyihj.zenutils.api.zenscript.SidedZenRegister;

import stanhebben.zenscript.annotations.ZenClass;


@FunctionalInterface
@SidedZenRegister(modDeps = {"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.IGetBaubleType")
public interface IGetBaubleType {

    String call(IItemStack stack);

}

