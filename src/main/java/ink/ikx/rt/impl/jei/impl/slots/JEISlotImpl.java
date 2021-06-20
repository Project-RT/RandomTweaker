package ink.ikx.rt.impl.jei.impl.slots;

import ink.ikx.rt.api.instance.jei.interfaces.slots.JEISlot;

public abstract class JEISlotImpl implements JEISlot {

    public boolean isBase;
    public boolean isInput;
    public int x;
    public int y;

    public JEISlotImpl(boolean isBase, boolean isInput, int x, int y) {
        this.isBase = isBase;
        this.isInput = isInput;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean isInput() {
        return this.isInput;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public boolean isBase() { return this.isBase; }
}
