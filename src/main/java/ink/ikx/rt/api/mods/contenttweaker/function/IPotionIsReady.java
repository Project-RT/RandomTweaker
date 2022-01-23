package ink.ikx.rt.api.mods.contenttweaker.function;

import crafttweaker.annotations.ModOnly;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import stanhebben.zenscript.annotations.ZenClass;

@RTRegister
@FunctionalInterface
@ModOnly("contenttweaker")
@ZenClass("mods.randomtweaker.cote.IPotionIsReady")
public interface IPotionIsReady {

    boolean call(int duration, int amplifier);

}
