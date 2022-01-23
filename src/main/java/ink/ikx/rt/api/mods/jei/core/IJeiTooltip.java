package ink.ikx.rt.api.mods.jei.core;

import crafttweaker.annotations.ModOnly;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import stanhebben.zenscript.annotations.ZenClass;

@RTRegister
@ModOnly("jei")
@FunctionalInterface
@ZenClass("mods.randomtweaker.jei.IJeiTooltip")
public interface IJeiTooltip {

    String[] action(int mouseX, int mouseY);

}
