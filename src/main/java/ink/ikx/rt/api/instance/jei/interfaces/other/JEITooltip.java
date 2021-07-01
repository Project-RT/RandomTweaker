package ink.ikx.rt.api.instance.jei.interfaces.other;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;

@FunctionalInterface
@ZenRegister
@ZenClass("mods.randomtweaker.jei.JEITooltip")
public interface JEITooltip {

    String[] handler(int mouseX, int mouseY);
}
