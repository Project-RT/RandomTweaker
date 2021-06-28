package ink.ikx.rt.api.instance.jei.interfaces.slots;

import crafttweaker.annotations.ZenRegister;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;

@ZenRegister
@ZenClass("mods.randomtweaker.jei.JEISlot")
public interface JEISlot {

    @ZenGetter("isInput")
    boolean isInput();

    @ZenGetter("x")
    int getX();

    @ZenGetter("y")
    int getY();

    @ZenGetter("hasBase")
    boolean hasBase();

    @SideOnly(Side.CLIENT)
    void Render(Minecraft minecraft);
}
