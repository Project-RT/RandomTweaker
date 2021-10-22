package ink.ikx.rt.api.mods.contenttweaker.function.subtile;

import com.teamacronymcoders.contenttweaker.api.ctobjects.blockpos.IBlockPos;
import com.teamacronymcoders.contenttweaker.api.ctobjects.blockstate.ICTBlockState;
import com.teamacronymcoders.contenttweaker.api.ctobjects.entity.player.ICTPlayer;
import com.teamacronymcoders.contenttweaker.api.ctobjects.world.IWorld;
import ink.ikx.rt.impl.mods.crafttweaker.ModTotal;
import ink.ikx.rt.impl.mods.crafttweaker.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;

@ZenRegister
@FunctionalInterface
@ModTotal({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.BlockHarvested")
public interface BlockHarvested {

    void call(IWorld world, IBlockPos pos, ICTBlockState state, ICTPlayer player);

}
