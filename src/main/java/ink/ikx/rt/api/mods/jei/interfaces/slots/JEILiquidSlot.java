package ink.ikx.rt.api.mods.jei.interfaces.slots;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;

@ZenRegister
@ZenClass("mods.randomtweaker.jei.JEILiquidSlot")
public interface JEILiquidSlot extends JEISlot {

    @ZenGetter("width")
    int getWidth();

    @ZenGetter("heigh")
    int getHeigh();

    @ZenGetter("capacityMb")
    int getCapacityMb();

    @ZenGetter("showCapacity")
    boolean isShowCapacity();

}
