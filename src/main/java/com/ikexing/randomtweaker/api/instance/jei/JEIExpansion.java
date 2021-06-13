package com.ikexing.randomtweaker.api.instance.jei;

import com.ikexing.randomtweaker.api.instance.jei.classes.JEICustom;
import com.ikexing.randomtweaker.api.instance.jei.classes.JEIFontInfo;
import com.ikexing.randomtweaker.api.instance.jei.classes.JEIRecipe;
import com.ikexing.randomtweaker.api.instance.jei.classes.JEISlot;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import java.util.Random;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethodStatic;

@ZenRegister
@ZenExpansion("mods.jei.JEI")
public class JEIExpansion {

    @ZenMethodStatic
    public static JEICustom create(String name) {
        return create(getRandomString(8), name);
    }

    @ZenMethodStatic
    public static JEICustom create(String uid, String name) {
        return new JEICustom(uid, name);
    }

    @ZenMethodStatic
    public static JEIFontInfo createFontInfo(String fontInfoName, int color, int recipeWidth,
        int recipeHeight, int x, int y) {
        return new JEIFontInfo(fontInfoName, color, recipeWidth, recipeHeight, x, y);
    }

    @ZenMethodStatic
    public static JEISlot createSlot(boolean isInput, String type, int xPosition, int yPosition) {
        return new JEISlot(isInput, type, xPosition, yPosition);
    }

    @ZenMethodStatic
    public static JEISlot createSlot(boolean isInput, String type, int xPosition, int yPosition,
        int width, int height, int capacityMb, boolean showCapacity) {
        return new JEISlot(isInput, type, xPosition, yPosition, width, height, capacityMb,
            showCapacity);
    }

    @ZenMethodStatic
    public static JEIRecipe createRecipe(IIngredient[] input, IIngredient[] output) {
        return new JEIRecipe(input, output);
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
