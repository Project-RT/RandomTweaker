package ink.ikx.rt.api.mods.contenttweaker.function;

import crafttweaker.annotations.ModOnly;
import stanhebben.zenscript.annotations.ZenClass;

@FunctionalInterface
@ModOnly("contenttweaker")
@ZenClass("mods.randomtweaker.cote.IPotionIsReady")
public interface IPotionIsReady {

    boolean call(int duration, int amplifier);

}
