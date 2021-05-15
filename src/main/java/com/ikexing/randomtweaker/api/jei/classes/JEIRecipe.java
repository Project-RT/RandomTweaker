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
    public List<ILiquidStack> fluids = new ArrayList<>();
    public List<IItemStack> items = new ArrayList<>();

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
        this.fluids.add(fluid);
        this.items.add(item);
    }
}
