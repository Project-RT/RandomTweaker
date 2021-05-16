package com.ikexing.randomtweaker.api.jei.classes;

import com.google.common.collect.FluentIterable;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import stanhebben.zenscript.annotations.ZenClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
}
