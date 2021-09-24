package ink.ikx.rt.impl.mods.jei.impl;

import ink.ikx.rt.api.mods.jei.IJeiUtils;
import ink.ikx.rt.api.mods.jei.slots.IJeiSlotItem;
import ink.ikx.rt.api.mods.jei.slots.IJeiSlotLiquid;
import net.minecraft.client.Minecraft;

public class MCJeiSlots {

    public static class MCJeiSlotItem extends IJeiSlotItem {

        public MCJeiSlotItem(int x, int y, boolean isInput, boolean hasBase) {
            super(x, y, isInput, hasBase);
        }

        @Override
        public void render(Minecraft minecraft) {
            if (!hasBase) return;
            if (isInput) {
                IJeiUtils.createItemInputElement(x, y).render(minecraft);
            } else {
                IJeiUtils.createItemOutputElement(x, y).render(minecraft);
            }
        }

    }

    public static class MCJeiSlotLiquid extends IJeiSlotLiquid {

        public MCJeiSlotLiquid(int x, int y, int width, int height, int capacityMb,
                               boolean showCapacity, boolean isInput, boolean hasBase) {
            super(x, y, isInput, hasBase, width, height, capacityMb, showCapacity);
        }

        @Override
        public void render(Minecraft minecraft) {
            IJeiUtils.createLiquidElement(x, y, width, height).render(minecraft);
        }

    }

}
