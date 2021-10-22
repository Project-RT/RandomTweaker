package ink.ikx.rt.api.mods.jei.elements;

import crafttweaker.annotations.ModOnly;
import ink.ikx.rt.impl.mods.crafttweaker.ZenRegister;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenProperty;

@ZenRegister
@ModOnly("jei")
@ZenClass("mods.randomtweaker.jei.IJeiElement")
public abstract class IJeiElement {

    @ZenProperty
    public int u;

    @ZenProperty
    public int v;

    @ZenProperty
    public int x;

    @ZenProperty
    public int y;

    @ZenProperty
    public int width;

    @ZenProperty
    public int height;

    protected IJeiElement(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    protected IJeiElement(int u, int v, int x, int y, int width, int height) {
        this.u = u;
        this.v = v;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


    @SideOnly(Side.CLIENT)
    public abstract void render(Minecraft minecraft);

}
