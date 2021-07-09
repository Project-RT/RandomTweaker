package ink.ikx.rt.api.mods.jei.interfaces.element;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;

@ZenRegister
@ZenClass("mods.randomtweaker.jei.JEIFontInfoElement")
public interface JEIFontInfoElement extends JEIElement {

    @ZenGetter("info")
    String getInfo();

    @ZenGetter("color")
    int getColor();

}
