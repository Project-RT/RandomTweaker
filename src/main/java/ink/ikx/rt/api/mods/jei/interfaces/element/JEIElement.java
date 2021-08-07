package ink.ikx.rt.api.mods.jei.interfaces.element;

import crafttweaker.annotations.ZenRegister;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenSetter;

@ZenRegister
@ZenClass("mods.randomtweaker.jei.JEIElement")
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
    String getTexture();

    @ZenSetter("texture")
    void setTexture(String texture);

    @ZenSetter("u")
    void setU(int u);

    @ZenSetter("v")
    void setV(int v);

    @ZenSetter("x")
    void setX(int x);

    @ZenSetter("y")
    void setY(int y);

    @ZenSetter("width")
    void setWidth(int width);

    @ZenSetter("heigh")
    void setHeigh(int heigh);

    @SideOnly(Side.CLIENT)
    void Render(Minecraft minecraft);
}
