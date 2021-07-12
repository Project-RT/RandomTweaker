package ink.ikx.rt.api.mods.cote.function.botania;

import com.teamacronymcoders.contenttweaker.api.ctobjects.blockpos.IBlockPos;
import com.teamacronymcoders.contenttweaker.api.ctobjects.world.IWorld;
import stanhebben.zenscript.annotations.ZenClass;

@FunctionalInterface
@ZenClass("mods.randomtweaker.cote.populateDropStackNBTs")
public interface CanGeneratePassively {

    boolean call(IBlockPos pos, IWorld world);
}
