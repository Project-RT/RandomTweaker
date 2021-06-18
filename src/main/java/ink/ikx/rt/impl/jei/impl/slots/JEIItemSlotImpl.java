package ink.ikx.rt.impl.jei.impl.slots;

import ink.ikx.rt.api.instance.jei.interfaces.slots.JEIItemSlot;

public class JEIItemSlotImpl extends JEISlotImpl implements JEIItemSlot {

    private final boolean isBase;

    public JEIItemSlotImpl(boolean isInput,
        int x, int y, boolean isBase, String texture) {
        super(isInput, x, y, texture);

        this.isBase = isBase;
    }

    @Override
    public boolean isBase() {
        return this.isBase;
    }
}
