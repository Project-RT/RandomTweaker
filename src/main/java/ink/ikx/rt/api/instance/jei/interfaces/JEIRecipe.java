package ink.ikx.rt.api.instance.jei.interfaces;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("mods.randomtweaker.jei.JEIRecipe")
public interface JEIRecipe {

    @ZenGetter("inputs")
    IIngredient[] getInputs();

    @ZenMethod
    void setInputs(IIngredient[] inputs);

    @ZenGetter("outputs")
    IIngredient[] getOutputs();

    @ZenMethod
    void setOutputs(IIngredient[] outputs);

    @ZenGetter
    String getUid();

    @ZenGetter
    void setUid(String uid);

    @ZenMethod
    JEIRecipe addInput(IIngredient stack);

    @ZenMethod
    JEIRecipe addOutput(IIngredient stack);

    @ZenMethod
    void build();
}
