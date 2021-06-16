package com.ikexing.randomtweaker.impl.jei.impl;

import com.ikexing.randomtweaker.api.instance.jei.interfaces.JEIItemSlot;
import com.ikexing.randomtweaker.api.instance.jei.interfaces.JEISlot;
import crafttweaker.api.item.IItemStack;

public class JEIItemSlotImpl extends JEISlotImpl implements JEIItemSlot {

    public IItemStack item;

    public JEIItemSlotImpl(IItemStack item, JEISlot jeiSlot) {
        super(jeiSlot);
        this.item = item;
    }

    @Override
    public IItemStack getItem() {
        return this.item;
    }
}
