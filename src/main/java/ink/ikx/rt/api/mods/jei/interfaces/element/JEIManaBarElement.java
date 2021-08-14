package ink.ikx.rt.api.mods.jei.interfaces.element;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;

@ZenRegister
@ZenClass("mods.randomtweaker.jei.JEIManaBarElement")
public interface JEIManaBarElement extends JEIElement {

    @ZenGetter
    int getMana();

    @ZenGetter
    int getMultiplesLog();

}
