package ink.ikx.rt.impl.jei.impl.slots;

import ink.ikx.rt.api.mods.jei.JEIExpansion;
import ink.ikx.rt.api.mods.jei.interfaces.slots.JEILiquidSlot;
import net.minecraft.client.Minecraft;

public class JEILiquidSlotImpl extends JEISlotImpl implements JEILiquidSlot {

    public int width;
    public int height;
    public int capacityMb;
    public boolean showCapacity;

    public JEILiquidSlotImpl(boolean isInput, int x, int y, int width, int heigh,
        int capacityMb, boolean showCapacity, boolean hasBase) {
        super(hasBase, isInput, x, y);

        this.width = width;
        this.height = heigh;
        this.capacityMb = capacityMb;
        this.showCapacity = showCapacity;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
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
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void setCapacityMb(int capacityMb) {
        this.capacityMb = capacityMb;
    }

    @Override
    public void setShowCapacity(boolean showCapacity) {
        this.showCapacity = showCapacity;
    }

    @Override
    public void Render(Minecraft minecraft) {
        if (this.hasBase) {
            JEIExpansion.createJEIFluidElement(this.x, this.y, this.width, this.height).Render(minecraft);
        }
    }
}
