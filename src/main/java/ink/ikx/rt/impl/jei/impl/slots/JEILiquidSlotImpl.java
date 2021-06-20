package ink.ikx.rt.impl.jei.impl.slots;

import ink.ikx.rt.api.instance.jei.JEIExpansion;
import ink.ikx.rt.api.instance.jei.interfaces.slots.JEILiquidSlot;
import net.minecraft.client.Minecraft;

public class JEILiquidSlotImpl extends JEISlotImpl implements JEILiquidSlot {

    public int width;
    public int heigh;
    public int capacityMb;
    public boolean showCapacity;

    public JEILiquidSlotImpl(boolean isInput, int x, int y, int width, int heigh,
        int capacityMb, boolean showCapacity, boolean hasBase) {
        super(hasBase, isInput, x, y);

        this.width = width;
        this.heigh = heigh;
        this.capacityMb = capacityMb;
        this.showCapacity = showCapacity;
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
        return capacityMb;
    }

    @Override
    public boolean isShowCapacity() {
        return showCapacity;
    }

    @Override
    public void Render(Minecraft minecraft) {
        if (this.hasBase) {
            JEIExpansion.createJEIFluidElement(this.x, this.y, this.width, this.heigh).Render(minecraft);
        }
    }
}
