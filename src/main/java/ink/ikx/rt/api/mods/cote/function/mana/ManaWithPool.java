package ink.ikx.rt.api.mods.cote.function.mana;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IWorld;
import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import stanhebben.zenscript.annotations.ZenClass;

@RTRegisterClass({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.ManaWithPool")
@FunctionalInterface
public interface ManaWithPool {

    boolean handle(IItemStack stack, IWorld world, IBlockPos pos);

}
