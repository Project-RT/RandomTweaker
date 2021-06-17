package com.ikexing.randomtweaker.api.instance.jei.classes;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;

@ZenRegister
@ZenClass("mods.randomtweaker.JEISlot")
public class JEISlot {

    public String type;
    public boolean isInput;
    public int xPosition;
    public int yPosition;
    public int width = 16;
    public int height = 16;
    public int capacityMb = 1000;
    public boolean showCapacity = false;


    public JEISlot(boolean isInput, String type, int xPosition, int yPosition, int width,
        int height, int capacityMb, boolean showCapacity) {
        this.isInput = isInput;
        this.type = type;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        this.capacityMb = capacityMb;
        this.showCapacity = showCapacity;
    }

    public JEISlot(boolean isInput, String type, int xPosition, int yPosition) {
        this.isInput = isInput;
        this.type = type;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }
}
