package com.ikexing.randomtweaker.api.jei.classes;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;

/**
 * @author ikexing
 */
@ZenRegister
@ZenClass("mods.randomtweaker.JEISpace")
public class JEISlot {
    public boolean isInput;
    public String type;
    public int xPosition;
    public int yPosition;
    public int width = 18;
    public int height = 18;
    public int capacityMb = 1000;
    public boolean showCapacity = false;

    public JEISlot(boolean isInput, String type, int xPosition, int yPosition, int width, int height, int capacityMb, boolean showCapacity) {
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
