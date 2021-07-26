package ink.ikx.rt.api.mods.cote.function.botania;

import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IWorld;
import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import stanhebben.zenscript.annotations.ZenClass;

@FunctionalInterface
@RTRegisterClass({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.CanGeneratePassively")
public interface CanGeneratePassively {

    boolean call(IBlockPos pos, IWorld world);
}
