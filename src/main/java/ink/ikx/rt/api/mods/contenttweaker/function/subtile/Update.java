package ink.ikx.rt.api.mods.contenttweaker.function.subtile;

import com.teamacronymcoders.contenttweaker.api.ctobjects.blockpos.IBlockPos;
import com.teamacronymcoders.contenttweaker.api.ctobjects.world.IWorld;
import ink.ikx.rt.api.mods.contenttweaker.subtile.ISubTileEntityInGame;
import ink.ikx.rt.impl.mods.crafttweaker.ModTotal;
import ink.ikx.rt.impl.mods.crafttweaker.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;

@ZenRegister
@FunctionalInterface
@ModTotal({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.Update")
public interface Update {

    void call(ISubTileEntityInGame subTile, IWorld world, IBlockPos pos);

}