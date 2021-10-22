package ink.ikx.rt.api.mods.jei.slots;

import crafttweaker.annotations.ModOnly;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenProperty;

@ModOnly("jei")
@ZenClass("mods.randomtweaker.jei.IJeiSlot")
public abstract class IJeiSlot {

    @ZenProperty
    public int x;

    @ZenProperty
    public int y;

    @ZenProperty
    public boolean isInput;

    @ZenProperty
    public boolean hasBase;

    public IJeiSlot(int x, int y, boolean isInput, boolean hasBase) {
        this.x = x;
        this.y = y;
        this.isInput = isInput;
        this.hasBase = hasBase;
    }
}
