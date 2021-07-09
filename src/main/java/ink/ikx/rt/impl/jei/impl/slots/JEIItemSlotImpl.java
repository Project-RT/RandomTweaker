package ink.ikx.rt.impl.jei.impl.slots;

import ink.ikx.rt.api.mods.jei.JEIExpansion;
import ink.ikx.rt.api.mods.jei.interfaces.slots.JEIItemSlot;
import net.minecraft.client.Minecraft;

public class JEIItemSlotImpl extends JEISlotImpl implements JEIItemSlot {

    public JEIItemSlotImpl(boolean isInput,
        int x, int y, boolean hasBase) {
        super(hasBase, isInput, x, y);
    }

    @Override
    public void Render(Minecraft minecraft) {
        if (this.hasBase) {
            if (this.isInput) {
                JEIExpansion.createJEIItemInputElement(this.getX(), this.getY()).Render(minecraft);
            } else {
                JEIExpansion.createJEIItemOutputElement(this.getX(), this.getY()).Render(minecraft);
            }
        }
    }
}
