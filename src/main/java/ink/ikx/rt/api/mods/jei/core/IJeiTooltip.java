package ink.ikx.rt.api.mods.jei.core;

import crafttweaker.annotations.ModOnly;
import stanhebben.zenscript.annotations.ZenClass;

@ModOnly("jei")
@FunctionalInterface
@ZenClass("mods.randomtweaker.jei.IJeiTooltip")
public interface IJeiTooltip {

    String[] action(int mouseX, int mouseY);

}
