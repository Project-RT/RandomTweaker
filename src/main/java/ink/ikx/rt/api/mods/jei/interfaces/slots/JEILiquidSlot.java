package ink.ikx.rt.api.mods.jei.interfaces.slots;

import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenSetter;


@ZenClass("mods.randomtweaker.jei.JEILiquidSlot")
public interface JEILiquidSlot extends JEISlot {

    @ZenGetter("width")
    int getWidth();

    @ZenSetter("width")
    void setWidth(int width);

    @ZenGetter("height")
    int getHeight();

    @ZenSetter("height")
    void setHeight(int height);

    @ZenGetter("capacityMb")
    int getCapacityMb();

    @ZenSetter("capacityMb")
    void setCapacityMb(int capacityMb);

    @ZenGetter("showCapacity")
    boolean isShowCapacity();

    @ZenSetter("showCapacity")
    void setShowCapacity(boolean isShowCapacity);

}
