package ink.ikx.rt.impl.jei.impl.slots;

import ink.ikx.rt.api.instance.jei.interfaces.slots.JEILiquidSlot;
import crafttweaker.api.liquid.ILiquidStack;

public class JEILiquidSlotImpl extends JEISlotImpl implements JEILiquidSlot {

    public boolean isBase;
    public int width;
    public int heigh;

    public JEILiquidSlotImpl(boolean isInput, int x, int y,
        int width, int heigh, boolean isBase, String texture) {
        super(isInput, x, y, texture);

        this.isBase = isBase;
        this.width = width;
        this.heigh = heigh;
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
}
