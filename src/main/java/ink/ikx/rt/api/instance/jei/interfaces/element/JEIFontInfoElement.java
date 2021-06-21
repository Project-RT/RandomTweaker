package ink.ikx.rt.api.instance.jei.interfaces.element;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;

@ZenRegister
@ZenClass("mods.randomtweaker.JEIFontInfoElement")
public interface JEIFontInfoElement extends JEIElement {

    @ZenGetter("info")
    String getInfo();

    @ZenGetter("color")
    int getColor();

}
