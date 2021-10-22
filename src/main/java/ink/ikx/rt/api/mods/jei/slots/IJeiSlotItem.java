package ink.ikx.rt.api.mods.jei.slots;

import crafttweaker.annotations.ModOnly;
import ink.ikx.rt.impl.mods.crafttweaker.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;

@ZenRegister
@ModOnly("jei")
@ZenClass("mods.randomtweaker.jei.IJeiSlotItem")
public abstract class IJeiSlotItem extends IJeiSlot {

    protected IJeiSlotItem(int x, int y, boolean isInput, boolean hasBase) {
        super(x, y, isInput, hasBase);
    }

}
