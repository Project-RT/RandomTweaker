package com.ikexing.randomtweaker.api.jei.classes;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import stanhebben.zenscript.annotations.ZenClass;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ikexing
 */
@ZenRegister
@ZenClass("mods.randomtweaker.JEIRecipe")
public class JEIRecipe {
    public boolean isInput;
    public String type;
    public int xPosition;
    public int yPosition;
    public int width = 18;
    public int height = 18;
    public int capacityMb = 1000;
    public boolean showCapacity = false;
    public List<ILiquidStack> fluids = new ArrayList<>();
    public List<IItemStack> items = new ArrayList<>();

    public JEIRecipe(boolean isInput, String type, int xPosition, int yPosition, int width, int height, int capacityMb, boolean showCapacity, List<ILiquidStack> fluids) {
        this.isInput = isInput;
        this.type = type;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        this.capacityMb = capacityMb;
        this.showCapacity = showCapacity;
        this.fluids = fluids;
    }

    public JEIRecipe(boolean isInput, String type, int xPosition, int yPosition, int width, int height, int capacityMb, boolean showCapacity, ILiquidStack fluid) {
        this.isInput = isInput;
        this.type = type;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        this.capacityMb = capacityMb;
        this.showCapacity = showCapacity;
        this.fluids.add(fluid);
    }

    public JEIRecipe(boolean isInput, String type, int xPosition, int yPosition, List<IItemStack> items, List<ILiquidStack> fluids) {
        this.isInput = isInput;
        this.type = type;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.fluids = fluids;
        this.items = items;
    }

    public JEIRecipe(boolean isInput, String type, int xPosition, int yPosition, IItemStack item, ILiquidStack fluid) {
        this.isInput = isInput;
        this.type = type;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.items.add(item);
    }
}
