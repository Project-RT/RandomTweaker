package ink.ikx.rt.impl.jei.impl.slots;

import ink.ikx.rt.api.instance.jei.JEIExpansion;
import ink.ikx.rt.api.instance.jei.interfaces.slots.JEIItemSlot;
import net.minecraft.client.Minecraft;

public class JEIItemSlotImpl extends JEISlotImpl implements JEIItemSlot {

    public JEIItemSlotImpl(boolean isInput,
        int x, int y, boolean isBase) {
        super(isBase, isInput, x, y);
    }

    @Override
    public void Render(Minecraft minecraft) {
        JEIExpansion.createJEIItemInputElement(this.getX(), this.getY()).Render(minecraft);
    }
}
