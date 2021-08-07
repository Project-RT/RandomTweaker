package ink.ikx.rt.impl.jei.impl.slots;

import ink.ikx.rt.api.mods.jei.interfaces.slots.JEISlot;

public abstract class JEISlotImpl implements JEISlot {

    public boolean hasBase;
    public boolean isInput;
    public int x;
    public int y;

    public JEISlotImpl(boolean hasBase, boolean isInput, int x, int y) {
        this.hasBase = hasBase;
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
    public boolean isHasBase() {
        return this.hasBase;
    }

    @Override
    public void setHasBase(boolean hasBase) {
        this.hasBase = hasBase;
    }

    @Override
    public void setInput(boolean input) {
        isInput = input;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }
}
