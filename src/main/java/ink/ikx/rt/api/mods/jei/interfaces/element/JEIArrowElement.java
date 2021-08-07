package ink.ikx.rt.api.mods.jei.interfaces.element;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenSetter;

@ZenRegister
@ZenClass("mods.randomtweaker.jei.JEIArrowElement")
public interface JEIArrowElement extends JEIElement {

    @ZenGetter("direction")
    int getDirection();

    @ZenSetter("direction")
    void setDirection(int direction);
}
