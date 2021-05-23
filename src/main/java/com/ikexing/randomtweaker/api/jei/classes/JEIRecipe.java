package com.ikexing.randomtweaker.api.jei.classes;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenClass;

import java.util.Arrays;
import java.util.List;

/**
 * @author ikexing
 */
@ZenRegister
@ZenClass("mods.randomtweaker.JEIRecipe")
public class JEIRecipe {
    public List<IIngredient> input;
    public List<IIngredient> output;

    public JEIRecipe(IIngredient[] inputs, IIngredient[] outputs) {
        this.input = Arrays.asList(inputs);
        this.output = Arrays.asList(outputs);
    }

    public JEIRecipe(IIngredient[] inputs) {
        this.input = Arrays.asList(inputs);
    }
}
