package ink.ikx.rt.api.instance.jei.interfaces.slots;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;

@ZenRegister
@ZenClass("mods.randomtweaker.JEISlot")
public interface JEISlot {

    @ZenGetter("id")
    int getID();

    @ZenGetter("isInput")
    boolean isInput();

    @ZenGetter("x")
    int getX();

    @ZenGetter("y")
    int getY();

    @ZenGetter("width")
    int getWidth();

    @ZenGetter("heigh")
    int getHeigh();

    @ZenGetter("isBase")
    boolean isBase();

    @ZenGetter("textures")
    String getTexture();

}
