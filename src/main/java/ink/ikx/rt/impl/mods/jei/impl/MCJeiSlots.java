package ink.ikx.rt.impl.mods.jei.impl;

import ink.ikx.rt.api.mods.jei.IJeiUtils;
import ink.ikx.rt.api.mods.jei.slots.IJeiSlotItem;
import ink.ikx.rt.api.mods.jei.slots.IJeiSlotLiquid;
import ink.ikx.rt.api.mods.jei.slots.IJeiSlotRenderable;
import net.minecraft.client.Minecraft;

public class MCJeiSlots {

    public static class MCJeiSlotItem extends IJeiSlotItem implements IJeiSlotRenderable {

        public MCJeiSlotItem(int x, int y, boolean isInput, boolean hasBase) {
            super(x, y, isInput, hasBase);
        }

        @Override
        public void render(Minecraft minecraft) {
            if (!hasBase) return;
            if (isInput) {
                try {
                    ((IJeiSlotRenderable) IJeiUtils.createItemInputElement(x, y)).render(minecraft);
                }catch (ClassCastException e){
                    //
                }
            } else {
                try {
                    ((IJeiSlotRenderable) IJeiUtils.createItemOutputElement(x, y)).render(minecraft);
                }catch (ClassCastException e){
                    //
                }
            }
        }

    }

    public static class MCJeiSlotLiquid extends IJeiSlotLiquid implements IJeiSlotRenderable{

        public MCJeiSlotLiquid(int x, int y, int width, int height, int capacityMb,
                               boolean showCapacity, boolean isInput, boolean hasBase) {
            super(x, y, isInput, hasBase, width, height, capacityMb, showCapacity);
        }

        @Override
        public void render(Minecraft minecraft) {
            if (!hasBase) return;
            try {
                ((IJeiSlotRenderable) IJeiUtils.createLiquidElement(x, y, width, height)).render(minecraft);
            }catch (ClassCastException e){
                //
            }
        }

    }

}
