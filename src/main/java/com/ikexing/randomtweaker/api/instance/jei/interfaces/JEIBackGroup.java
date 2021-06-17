package com.ikexing.randomtweaker.api.instance.jei.interfaces;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;

@ZenRegister
@ZenClass("mods.randomtweaker.JEIBackGroup")
public interface JEIBackGroup {

    @ZenGetter("resourceName")
    String getResourceName();

    @ZenGetter("u")
    int getU();

    @ZenGetter("v")
    int getV();

    @ZenGetter("width")
    int getWidth();

    @ZenGetter("heigh")
    int getHeight();

}
