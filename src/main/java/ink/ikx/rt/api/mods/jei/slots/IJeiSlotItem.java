package ink.ikx.rt.api.mods.jei.slots;

import crafttweaker.annotations.ModOnly;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import stanhebben.zenscript.annotations.ZenClass;

@RTRegister
@ModOnly("jei")
@ZenClass("mods.randomtweaker.jei.IJeiSlotItem")
public abstract class IJeiSlotItem extends IJeiSlot {

    protected IJeiSlotItem(int x, int y, boolean isInput, boolean hasBase) {
        super(x, y, isInput, hasBase);
    }

    protected IJeiSlotItem(String slotName, int x, int y, boolean isInput, boolean hasBase) {
        super(slotName, x, y, isInput, hasBase);
    }

}
