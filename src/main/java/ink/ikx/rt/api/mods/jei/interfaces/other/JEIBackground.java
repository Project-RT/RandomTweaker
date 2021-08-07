package ink.ikx.rt.api.mods.jei.interfaces.other;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenSetter;

@ZenRegister
@ZenClass("mods.randomtweaker.jei.JEIBackground")
public interface JEIBackground {

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

    @ZenSetter("resourceName")
    void setResourceName(String resourceName);

    @ZenSetter("u")
    void setU(int u);

    @ZenSetter("v")
    void setV(int v);

    @ZenSetter("width")
    void setWidth(int width);

    @ZenSetter("heigh")
    void setHeight(int height);

}
