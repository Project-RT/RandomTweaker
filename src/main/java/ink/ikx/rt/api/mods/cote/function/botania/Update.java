package ink.ikx.rt.api.mods.cote.function.botania;

import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IWorld;
import ink.ikx.rt.api.mods.cote.flower.SubTileEntityInGame;
import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import stanhebben.zenscript.annotations.ZenClass;

@FunctionalInterface
@RTRegisterClass({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.Update")
public interface Update {

    void call(SubTileEntityInGame subtile, IWorld world, IBlockPos pos);
}
