package ink.ikx.rt.api.mods.jei.interfaces.element;

import crafttweaker.annotations.ZenRegister;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;

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
    default String getTexture() {
        return "randomtweaker:textures/gui/jei/jei_default.png";
    }

    @SideOnly(Side.CLIENT)
    void Render(Minecraft minecraft);
}
