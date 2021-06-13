package com.ikexing.randomtweaker.api.instance.jei.classes;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import java.util.Arrays;
import java.util.List;
import stanhebben.zenscript.annotations.ZenClass;

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
