package ink.ikx.rt.impl.jei.impl;

import crafttweaker.api.item.IIngredient;
import ink.ikx.rt.api.instance.jei.interfaces.JEIRecipe;
import java.util.Arrays;
import java.util.List;

public class JEIRecipeImpl implements JEIRecipe {

    public List<IIngredient> input;
    public List<IIngredient> output;

    public JEIRecipeImpl(IIngredient[] inputs, IIngredient[] outputs) {
        this.input = Arrays.asList(inputs);
        this.output = Arrays.asList(outputs);
    }

    public JEIRecipeImpl(IIngredient[] inputs) {
        this.input = Arrays.asList(inputs);
    }

    @Override
    public List<IIngredient> getInput() {
        return this.input;
    }

    @Override
    public List<IIngredient> getOutput() {
        return this.output;
    }
}
