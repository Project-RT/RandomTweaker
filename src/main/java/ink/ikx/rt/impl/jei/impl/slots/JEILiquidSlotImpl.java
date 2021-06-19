package ink.ikx.rt.impl.jei.impl.slots;

import ink.ikx.rt.api.instance.jei.interfaces.slots.JEILiquidSlot;

public class JEILiquidSlotImpl extends JEISlotImpl implements JEILiquidSlot {

    public boolean isBase;
    public int width = 16;
    public int heigh = 16;
    public int capacityMb = 1000;
    public boolean showCapacity = false;

    public JEILiquidSlotImpl(boolean isInput, int x, int y, int width, int heigh,
        int capacityMb, boolean showCapacity, boolean isBase, String texture) {
        super(isInput, x, y, texture);

        this.isBase = isBase;
        this.width = width;
        this.heigh = heigh;
        this.capacityMb = capacityMb;
        this.showCapacity = showCapacity;
    }

    @Override
    public boolean isBase() {
        return this.isBase;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeigh() {
        return heigh;
    }

    @Override
    public int getCapacityMb() {
        return 0;
    }

    @Override
    public boolean isShowCapacity() {
        return false;
    }

    @Override
    public String toString() {
        return "JEILiquidSlotImpl{" +
            "isBase=" + isBase +
            ", width=" + width +
            ", heigh=" + heigh +
            ", capacityMb=" + capacityMb +
            ", showCapacity=" + showCapacity +
            '}';
    }
}
