package ink.ikx.rt.api.mods.cote.function.botania;

import com.teamacronymcoders.contenttweaker.api.ctobjects.blockpos.IBlockPos;
import com.teamacronymcoders.contenttweaker.api.ctobjects.world.IWorld;
import ink.ikx.rt.api.mods.cote.flower.generating.SubTileGeneratingContent;
import stanhebben.zenscript.annotations.ZenClass;

@FunctionalInterface
@ZenClass("mods.randomtweaker.cote.UpdateWithGenerating")
public interface UpdateWithGenerating {

    void call(SubTileGeneratingContent subtile, IWorld world, IBlockPos pos);
}
