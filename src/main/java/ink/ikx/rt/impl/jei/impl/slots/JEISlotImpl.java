package ink.ikx.rt.impl.jei.impl.slots;

import ink.ikx.rt.api.instance.jei.interfaces.slots.JEISlot;

public class JEISlotImpl implements JEISlot {

    public boolean isInput;
    public int x;
    public int y;
    public String texture;

    public JEISlotImpl(boolean isInput, int x, int y, String texture) {
        this.isInput = isInput;
        this.x = x;
        this.y = y;
        this.texture = texture;
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
    public String getTexture() {
        return this.texture;
    }

}
