package ink.ikx.rt.api.mods.cote.function;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;

@FunctionalInterface
@ZenRegister
@ModOnly("contenttweaker")
@ZenClass("mods.randomtweaker.cotx.PotionIsReady")
public interface PotionIsReady {
    boolean call(int duration, int amplifier);
}
