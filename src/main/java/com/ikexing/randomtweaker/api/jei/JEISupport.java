package com.ikexing.randomtweaker.api.jei;

import com.ikexing.randomtweaker.api.jei.classes.JEICustom;
import com.ikexing.randomtweaker.api.jei.classes.JEIFontInfo;
import com.ikexing.randomtweaker.api.jei.classes.JEIRecipe;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author ikexing
 */
@ZenRegister
@ZenClass("mods.randomtweaker.JEI")
public class JEISupport {

    @ZenMethod
    public static JEICustom create(String localizedname) {
        return new JEICustom(getRandomString(8), localizedname);
    }

    @ZenMethod
    public static JEICustom create(String uid, String localizedname) {
        return new JEICustom(uid, localizedname);
    }

    @ZenMethod
    public static JEIFontInfo createFontInfo(String fontInfoName, int color, int recipeWidth, int recipeHeight, int x, int y) {
        return new JEIFontInfo(fontInfoName, color, recipeWidth, recipeHeight, x, y);
    }

    @ZenMethod
    public static JEIRecipe createRecipe(boolean isInput, String type, int xPosition, int yPosition, IItemStack[] stacks) {
        return new JEIRecipe(isInput, type, xPosition, yPosition, Arrays.asList(stacks), null);
    }

    @ZenMethod
    public static JEIRecipe createRecipe(boolean isInput, String type, int xPosition, int yPosition, ILiquidStack[] stacks) {
        return new JEIRecipe(isInput, type, xPosition, yPosition, null, Arrays.asList(stacks));
    }

    @ZenMethod
    public static JEIRecipe createRecipe(boolean isInput, String type, int xPosition, int yPosition, int width, int height, int capacityMb, boolean showCapacity, ILiquidStack fluid){
        return new JEIRecipe(isInput, type, xPosition, yPosition, width, height, capacityMb, showCapacity, fluid);
    }

    @ZenMethod
    public static JEIRecipe createRecipe(boolean isInput, String type, int xPosition, int yPosition, int width, int height, int capacityMb, boolean showCapacity, List<ILiquidStack> fluids){
        return new JEIRecipe(isInput, type, xPosition, yPosition, width, height, capacityMb, showCapacity, fluids);
    }

    @SuppressWarnings("SameParameterValue")
    protected static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
