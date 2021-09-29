package ink.ikx.rt.api.mods.jei.interfaces.element;

import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenSetter;

@ZenClass("mods.randomtweaker.jei.JEIFontInfoElement")
public interface JEIFontInfoElement extends JEIElement {

    @ZenGetter("info")
    String getInfo();

    @ZenGetter("color")
    int getColor();

    @ZenSetter("info")
    void setInfo(String info);

    @ZenSetter("color")
    void setColor(int color);
}
