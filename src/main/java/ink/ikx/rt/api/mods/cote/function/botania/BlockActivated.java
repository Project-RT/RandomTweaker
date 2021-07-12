package ink.ikx.rt.api.mods.cote.function.botania;

import com.teamacronymcoders.contenttweaker.api.ctobjects.blockpos.IBlockPos;
import com.teamacronymcoders.contenttweaker.api.ctobjects.entity.player.ICTPlayer;
import com.teamacronymcoders.contenttweaker.api.ctobjects.enums.Hand;
import com.teamacronymcoders.contenttweaker.api.ctobjects.world.IWorld;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.block.IBlockState;
import crafttweaker.api.world.IFacing;
import stanhebben.zenscript.annotations.ZenClass;

@ZenRegister
@FunctionalInterface
@ZenClass("mods.randomtweaker.cote.BlockActivated")
public interface BlockActivated {
    boolean call(IWorld world, IBlockPos pos, IBlockState state, ICTPlayer player, Hand hand, IFacing side, float hitX, float hitY, float hitZ);
}
