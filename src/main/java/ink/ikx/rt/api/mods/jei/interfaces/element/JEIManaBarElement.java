package ink.ikx.rt.api.mods.jei.interfaces.element;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenSetter;

@ZenRegister
@ZenClass("mods.randomtweaker.jei.JEIManaBarElement")
public interface JEIManaBarElement extends JEIElement {

    @ZenGetter("mana")
    int getMana();

    @ZenGetter("log_multiples")
    int getMultiplesLog();

    @ZenSetter("mana")
    void setMana(int mana);

}
