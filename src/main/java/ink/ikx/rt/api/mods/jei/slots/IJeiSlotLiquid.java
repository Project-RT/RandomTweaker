package ink.ikx.rt.api.mods.jei.slots;

import crafttweaker.annotations.ModOnly;
import ink.ikx.rt.impl.mods.crafttweaker.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenProperty;

@ZenRegister
@ModOnly("jei")
@ZenClass("mods.randomtweaker.jei.IJeiSlotLiquid")
public abstract class IJeiSlotLiquid extends IJeiSlot {

    @ZenProperty
    public int width;

    @ZenProperty
    public int height;

    @ZenProperty
    public int capacityMb;

    @ZenProperty
    public boolean showCapacity;

    protected IJeiSlotLiquid(int x, int y, boolean isInput, boolean hasBase, int width,
                             int height, int capacityMb, boolean showCapacity) {
        super(x, y, isInput, hasBase);
        this.width = width;
        this.height = height;
        this.capacityMb = capacityMb;
        this.showCapacity = showCapacity;
    }

}
