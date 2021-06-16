package com.ikexing.randomtweaker.impl.jei.impl;

import com.ikexing.randomtweaker.api.instance.jei.interfaces.JEISlot;

public class JEISlotImpl implements JEISlot {

    public int id;
    public String type;
    public boolean isInput;
    public int x;
    public int y;
    public int width;
    public int heigh;
    public String texture;

    public JEISlotImpl(JEISlot jeiSlot) {
        this.id = jeiSlot.getID();
        this.type = jeiSlot.getType();
        this.isInput = jeiSlot.isInput();
        this.x = jeiSlot.getX();
        this.y = jeiSlot.getY();
        this.width = jeiSlot.getWidth();
        this.heigh = jeiSlot.getHeigh();
    }

    public JEISlotImpl(int id, String type, boolean isInput, int x, int y, int width, int heigh,
        String texture) {
        this.id = id;
        this.type = type;
        this.isInput = isInput;
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigh = heigh;
        this.texture = texture;
    }

    public JEISlotImpl(int id, String type, boolean isInput, int x, int y, int width, int heigh) {
        this.id = id;
        this.type = type;
        this.isInput = isInput;
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigh = heigh;
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public String getType() {
        return this.type;
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
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeigh() {
        return this.heigh;
    }

    @Override
    public String getTexture() {
        return this.texture;
    }

}
