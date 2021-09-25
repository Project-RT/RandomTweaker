package ink.ikx.rt.api.mods.contenttweaker.function;

import crafttweaker.annotations.ModOnly;
import stanhebben.zenscript.annotations.ZenClass;

@FunctionalInterface
@ModOnly("contenttweaker")
@ZenClass("mods.randomtweaker.cote.PotionIsReady")
public interface IPotionIsReady {

    boolean call(int duration, int amplifier);

}
