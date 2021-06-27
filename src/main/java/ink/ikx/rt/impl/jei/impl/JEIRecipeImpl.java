package ink.ikx.rt.impl.jei.impl;

import crafttweaker.api.item.IIngredient;
import ink.ikx.rt.api.instance.jei.interfaces.JEIRecipe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JEIRecipeImpl implements JEIRecipe {

    public List<IIngredient> inputs;
    public List<IIngredient> outputs = new ArrayList<>();

    public JEIRecipeImpl(IIngredient[] inputs, IIngredient[] outputs) {
        this.inputs = Arrays.asList(inputs);
        this.outputs = Arrays.asList(outputs);
    }

    public JEIRecipeImpl(IIngredient[] inputs) {
        this.inputs = Arrays.asList(inputs);
    }

    @Override
    public List<IIngredient> getInputs() {
        return this.inputs;
    }

    @Override
    public List<IIngredient> getOutputs() {
        return this.outputs;
    }
}
