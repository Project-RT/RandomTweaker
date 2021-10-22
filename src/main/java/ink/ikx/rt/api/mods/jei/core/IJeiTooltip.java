package ink.ikx.rt.api.mods.jei.core;

import crafttweaker.annotations.ModOnly;
import ink.ikx.rt.impl.mods.crafttweaker.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;

@ZenRegister
@ModOnly("jei")
@FunctionalInterface
@ZenClass("mods.randomtweaker.jei.IJeiTooltip")
public interface IJeiTooltip {

    String[] action(int mouseX, int mouseY);

}
