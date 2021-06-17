package com.ikexing.randomtweaker.impl.jei.impl.slots;

import com.ikexing.randomtweaker.api.instance.jei.interfaces.slots.JEILiquidSlot;
import crafttweaker.api.liquid.ILiquidStack;

public class JEILiquidSlotImpl extends JEISlotImpl implements JEILiquidSlot {

    public ILiquidStack liquid;

    public JEILiquidSlotImpl(ILiquidStack liquid, int id, boolean isInput, int x, int y,
        int width, int heigh, boolean isBase, String texture) {

        super(id, isInput, x, y, width, heigh, isBase, texture);
        this.liquid = liquid;
    }

    @Override
    public ILiquidStack liquid() {
        return this.liquid;
    }
}
