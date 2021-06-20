package ink.ikx.rt.api.instance.jei.interfaces.element;

import stanhebben.zenscript.annotations.ZenGetter;

public interface JEIItemElement extends JEIElement{

    @ZenGetter("u")
    int getU();

    @ZenGetter("v")
    int getV();

}
