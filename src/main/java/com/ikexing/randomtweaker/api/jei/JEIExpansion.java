package com.ikexing.randomtweaker.api.jei;

import com.ikexing.randomtweaker.api.jei.classes.JEIRecipe;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

/**
 * @author ikexing
 */
@ZenRegister
@ZenExpansion("mods.jei.JEI")
public class JEIExpansion {
    @ZenMethod
    public static JEIRecipe create(String uid, String localizedname) {
        return new JEIRecipe(uid, localizedname);
    }

    @ZenMethod
    public static JEIRecipe.FontInfo createFontInfo(String fontInfoName, int color, int recipeWidth, int recipeHeight, int x, int y){
        return new JEIRecipe.FontInfo(fontInfoName, color, recipeWidth, recipeHeight, x, y);
    }

    @ZenMethod
    public static JEIRecipe.Input createInput(String type, int xPosition, int yPosition, IItemStack item){
        return new JEIRecipe.Input(type, xPosition, yPosition, item);
    }

    @ZenMethod
    public static JEIRecipe.Input createInput(String type, int xPosition, int yPosition, ILiquidStack fluid){
        return new JEIRecipe.Input(type, xPosition, yPosition, fluid);
    }

    @ZenMethod
    public static JEIRecipe.Output createOutput(String type, int xPosition, int yPosition, IItemStack item){
        return new JEIRecipe.Output(type, xPosition, yPosition, item);
    }

    @ZenMethod
    public static JEIRecipe.Output createOutput(String type, int xPosition, int yPosition, ILiquidStack fluid){
        return new JEIRecipe.Output(type, xPosition, yPosition, fluid);
    }
}
