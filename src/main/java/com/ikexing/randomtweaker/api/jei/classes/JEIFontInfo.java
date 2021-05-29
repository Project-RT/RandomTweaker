package com.ikexing.randomtweaker.api.jei.classes;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;

/**
 * @author ikexing
 */
@ZenRegister
@ZenClass("mods.randomtweaker.JEIFontInfo")
public class JEIFontInfo {
    public String name;
    public int color;
    public int recipeWidth;
    public int recipeHeight;
    public int x;
    public int y;

    public JEIFontInfo(String name, int color, int recipeWidth, int recipeHeight, int x, int y) {
        this.name = name;
        this.color = color;
        this.recipeWidth = recipeWidth;
        this.recipeHeight = recipeHeight;
        this.x = x;
        this.y = y;
    }
}