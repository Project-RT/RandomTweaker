package ink.ikx.rt.api.instance.jei.interfaces.element;

import stanhebben.zenscript.annotations.ZenGetter;

public interface JEIFontInfoElement extends JEIElement {

    @ZenGetter("info")
    String getInfo();

    @ZenGetter("color")
    int getColor();

}
