package ink.ikx.rt.api.mods.cote.function.botania;


import com.teamacronymcoders.contenttweaker.api.ctobjects.blockpos.IBlockPos;
import com.teamacronymcoders.contenttweaker.api.ctobjects.world.IWorld;
import crafttweaker.api.block.IBlockState;
import stanhebben.zenscript.annotations.ZenClass;

@FunctionalInterface
@ZenClass("mods.randomtweaker.cote.BlockAdded")
public interface BlockAdded {
    void call(IWorld world, IBlockPos pos, IBlockState state);
}
