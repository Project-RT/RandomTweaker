package ink.ikx.rt.api.mods.jei.interfaces.slots;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenSetter;


@ZenClass("mods.randomtweaker.jei.JEISlot")
public interface JEISlot {

    @ZenGetter("input")
    boolean isInput();

    @ZenSetter("input")
    void setInput(boolean input);

    @ZenGetter("x")
    int getX();

    @ZenGetter("y")
    int getY();

    @ZenSetter("x")
    void setX(int x);

    @ZenSetter("y")
    void setY(int y);

    @ZenGetter("hasBase")
    boolean isHasBase();

    @ZenSetter("hasBase")
    void setHasBase(boolean hasBase);

    @SideOnly(Side.CLIENT)
    void Render(Minecraft minecraft);
}
