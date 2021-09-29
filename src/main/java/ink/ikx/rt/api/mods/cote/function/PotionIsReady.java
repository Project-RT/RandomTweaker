package ink.ikx.rt.api.mods.cote.function;

import crafttweaker.annotations.ModOnly;
import stanhebben.zenscript.annotations.ZenClass;

@FunctionalInterface
@ModOnly("contenttweaker")
@ZenClass("mods.randomtweaker.cote.PotionIsReady")
public interface PotionIsReady {
    boolean call(int duration, int amplifier);
}
