package ink.ikx.rt.api.mods.jei.interfaces.element;

import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenSetter;

@ZenClass("mods.randomtweaker.jei.JEIArrowElement")
public interface JEIArrowElement extends JEIElement {

    @ZenGetter("direction")
    int getDirection();

    @ZenSetter("direction")
    void setDirection(int direction);
}
