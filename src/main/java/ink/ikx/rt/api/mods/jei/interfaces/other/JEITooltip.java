package ink.ikx.rt.api.mods.jei.interfaces.other;

import stanhebben.zenscript.annotations.ZenClass;

@FunctionalInterface

@ZenClass("mods.randomtweaker.jei.JEITooltip")
public interface JEITooltip {

    String[] handler(int mouseX, int mouseY);
}
