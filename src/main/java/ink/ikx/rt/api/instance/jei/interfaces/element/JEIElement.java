package ink.ikx.rt.api.instance.jei.interfaces.element;

import crafttweaker.annotations.ZenRegister;
import net.minecraft.client.Minecraft;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("mods.randomtweaker.JEIElement")
public interface JEIElement {

    @ZenGetter("u")
    int getU();

    @ZenGetter("v")
    int getV();

    @ZenGetter("x")
    int getX();

    @ZenGetter("y")
    int getY();

    @ZenGetter("width")
    int getWidth();

    @ZenGetter("heigh")
    int getHeigh();

    @ZenGetter("texture")
    default String getTexture() {
        return "randomtweaker:textures/gui/jei/jei_default.png";
    }

    void Render(Minecraft minecraft);
}
