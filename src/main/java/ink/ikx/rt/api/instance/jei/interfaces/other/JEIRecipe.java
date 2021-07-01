package ink.ikx.rt.api.instance.jei.interfaces.other;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import ink.ikx.rt.api.instance.jei.interfaces.element.JEIElement;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenSetter;

@ZenRegister
@ZenClass("mods.randomtweaker.jei.JEIRecipe")
public interface JEIRecipe {

    @ZenGetter("uid")
    String getUid();

    @ZenGetter("inputs")
    IIngredient[] getInputs();

    @ZenGetter("outputs")
    IIngredient[] getOutputs();

    @ZenGetter("JEIElements")
    JEIElement[] getJEIElements();

    @ZenMethod
    JEIRecipe setJEIElements(JEIElement[] JEIElements);

    @ZenMethod
    JEIRecipe setUid(String uid);

    @ZenSetter("onJEITooltip")
    void setJEIRecipe(JEITooltip JEITooltip);

    @ZenMethod
    JEIRecipe addJEIElement(JEIElement JEIElement);

    @ZenMethod
    JEIRecipe setInputs(IIngredient[] inputs);

    @ZenMethod
    JEIRecipe setOutputs(IIngredient[] outputs);

    @ZenMethod
    JEIRecipe addInput(IIngredient stack);

    @ZenMethod
    JEIRecipe addOutput(IIngredient stack);

    @ZenMethod
    void build();

    JEITooltip getJEITooltip();

}
