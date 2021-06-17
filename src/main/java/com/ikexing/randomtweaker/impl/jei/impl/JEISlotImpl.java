package com.ikexing.randomtweaker.impl.jei.impl;

import com.ikexing.randomtweaker.api.instance.jei.interfaces.JEISlot;

public class JEISlotImpl implements JEISlot {

    public int id;
    public boolean isInput;
    public int x;
    public int y;
    public int width;
    public int heigh;
    public boolean isBase;
    public String texture;

    public JEISlotImpl(int id, boolean isInput, int x, int y, int width, int heigh,
        boolean isBase, String texture) {
        this.id = id;
        this.isInput = isInput;
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigh = heigh;
        this.isBase = isBase;
        this.texture = texture;
    }

    @Override
    public int getID() {
        return this.id;
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
    public boolean isBase() {
        return this.isBase;
    }

    @Override
    public String getTexture() {
        return this.texture;
    }

}
