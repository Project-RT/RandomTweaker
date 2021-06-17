package com.ikexing.randomtweaker.impl.jei.impl.slots;

import com.ikexing.randomtweaker.api.instance.jei.interfaces.slots.JEIItemSlot;
import crafttweaker.api.item.IItemStack;

public class JEIItemSlotImpl extends JEISlotImpl implements JEIItemSlot {

    public IItemStack item;

    public JEIItemSlotImpl(IItemStack item, int id, boolean isInput,
        int x, int y, int width, int heigh, boolean isBase, String texture) {
        super(id, isInput, x, y, width, heigh, isBase, texture);

        this.item = item;
    }

    @Override
    public IItemStack getItem() {
        return this.item;
    }
}
