package com.ikexing.randomtweaker.api.instance.jei.interfaces;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;

@ZenRegister
@ZenClass("mods.randomtweaker.JEISlot")
public interface JEISlot {

    @ZenGetter("id")
    int getID();

    @ZenGetter("type")
    String getType();

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

    @ZenGetter("textures")
    default String getTexture() {
        return "randomtweaker:textures/gui/jei/jei_default.png";
    }

}
