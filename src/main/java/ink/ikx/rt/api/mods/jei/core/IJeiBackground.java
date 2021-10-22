package ink.ikx.rt.api.mods.jei.core;

import crafttweaker.annotations.ModOnly;
import ink.ikx.rt.impl.mods.crafttweaker.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenProperty;

@ZenRegister
@ModOnly("jei")
@ZenClass("mods.randomtweaker.jei.IJeiBackground")
public abstract class IJeiBackground {

    @ZenProperty
    public int u;

    @ZenProperty
    public int v;

    @ZenProperty
    public int width;

    @ZenProperty
    public int height;

    @ZenProperty
    public String resourceName;

    protected IJeiBackground(int u, int v, int width, int height, String resourceName) {
        this.u = u;
        this.v = v;
        this.width = width;
        this.height = height;
        this.resourceName = resourceName;
    }

    protected IJeiBackground(int width, int height) {
        this.width = width;
        this.height = height;
    }

}
