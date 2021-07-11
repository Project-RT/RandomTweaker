package ink.ikx.rt.api.mods.cote.function.mana;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IWorld;
import stanhebben.zenscript.annotations.ZenClass;

@ZenClass("mods.randomtweaker.cote.ManaItemForPoolFunction")
@FunctionalInterface
public interface ManaItemForPoolFunction {

    boolean handle(IItemStack stack, IWorld world, IBlockPos pos);

}
