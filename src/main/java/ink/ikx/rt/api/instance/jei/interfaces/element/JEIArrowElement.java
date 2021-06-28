package ink.ikx.rt.api.instance.jei.interfaces.element;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;

@ZenRegister
@ZenClass("mods.randomtweaker.jei.JEIArrowElement")
public interface JEIArrowElement extends JEIElement {

    @ZenGetter("direction")
    int getDirection();
}
