package ink.ikx.rt.api.instance.jei.interfaces.slots;

import crafttweaker.annotations.ZenRegister;
import net.minecraft.client.Minecraft;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("mods.randomtweaker.JEISlot")
public interface JEISlot {

    @ZenGetter("isInput")
    boolean isInput();

    @ZenGetter("x")
    int getX();

    @ZenGetter("y")
    int getY();

    @ZenGetter("hasBase")
    boolean hasBase();

    void Render(Minecraft minecraft);
}
