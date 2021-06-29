package ink.ikx.rt.impl.jei.impl;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.item.IIngredient;
import ink.ikx.rt.RandomTweaker;
import ink.ikx.rt.api.instance.jei.interfaces.JEIRecipe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JEIRecipeImpl implements JEIRecipe {

    public String uid;
    public List<IIngredient> inputs = new ArrayList<>();
    public List<IIngredient> outputs = new ArrayList<>();

    public JEIRecipeImpl(String uid) {
        this.uid = uid;
    }

    @Override
    public IIngredient[] getInputs() {
        return inputs.toArray(new IIngredient[0]);
    }

    @Override
    public void setInputs(IIngredient[] inputs) {
        this.inputs = Arrays.asList(inputs);
    }

    @Override
    public IIngredient[] getOutputs() {
        return outputs.toArray(new IIngredient[0]);
    }

    @Override
    public void setOutputs(IIngredient[] outputs) {
        this.outputs = Arrays.asList(outputs);
    }

    @Override
    public String getUid() {
        return uid;
    }

    @Override
    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public JEIRecipe addInput(IIngredient stack) {
        this.inputs.add(stack);
        return this;
    }

    @Override
    public JEIRecipe addOutput(IIngredient stack) {
        this.outputs.add(stack);
        return this;
    }

    @Override
    public void build() {
        if (!inputs.isEmpty()) {
            RandomTweaker.JEIRecipeList.add(this);
        } else {
            CraftTweakerAPI.getLogger().logError("Recipe Input cannot be empty !");
        }
    }
}
