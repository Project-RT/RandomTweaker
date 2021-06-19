package ink.ikx.rt.api.instance.jei.interfaces.slots;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.liquid.ILiquidStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;

@ZenRegister
@ZenClass("mods.randomtweaker.JEILiquidSlot")
public interface JEILiquidSlot extends JEISlot {

    @ZenGetter("isBase")
    boolean isBase();

    @ZenGetter("width")
    int getWidth();

    @ZenGetter("heigh")
    int getHeigh();

    @ZenGetter("capacityMb")
    int getCapacityMb();

    @ZenGetter("showCapacity")
    boolean isShowCapacity();

}
