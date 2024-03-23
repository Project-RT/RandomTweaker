package ink.ikx.rt.api.mods.contenttweaker.function.subtile;

import com.teamacronymcoders.contenttweaker.api.ctobjects.blockpos.IBlockPos;
import com.teamacronymcoders.contenttweaker.api.ctobjects.blockstate.ICTBlockState;
import com.teamacronymcoders.contenttweaker.api.ctobjects.entity.player.ICTPlayer;
import com.teamacronymcoders.contenttweaker.api.ctobjects.enums.Hand;
import com.teamacronymcoders.contenttweaker.api.ctobjects.world.IWorld;
import crafttweaker.api.world.IFacing;
import youyihj.zenutils.api.zenscript.SidedZenRegister;

import stanhebben.zenscript.annotations.ZenClass;


@FunctionalInterface
@SidedZenRegister(modDeps = {"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.BlockActivated")
public interface BlockActivated {

    boolean call(IWorld world, IBlockPos pos, ICTBlockState state, ICTPlayer player, Hand hand, IFacing side, float hitX, float hitY, float hitZ);

}
