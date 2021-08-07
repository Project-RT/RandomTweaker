package ink.ikx.rt.api.mods.jei.interfaces.slots;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenSetter;

@ZenRegister
@ZenClass("mods.randomtweaker.jei.JEILiquidSlot")
public interface JEILiquidSlot extends JEISlot {

    @ZenGetter("width")
    int getWidth();

    @ZenSetter("width")
    void setWidth(int width);

    @ZenGetter("heigh")
    int getHeigh();

    @ZenSetter("heigh")
    void setHeigh(int heigh);

    @ZenGetter("capacityMb")
    int getCapacityMb();

    @ZenSetter("capacityMb")
    void setCapacityMb(int capacityMb);

    @ZenGetter("showCapacity")
    boolean isShowCapacity();

    @ZenGetter("showCapacity")
    void setShowCapacity(boolean isShowCapacity);

}
