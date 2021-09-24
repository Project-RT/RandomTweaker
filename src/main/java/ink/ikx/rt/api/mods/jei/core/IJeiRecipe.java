package ink.ikx.rt.api.mods.jei.core;

import crafttweaker.annotations.ModOnly;
import crafttweaker.api.item.IIngredient;
import ink.ikx.rt.api.mods.jei.elements.IJeiElement;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ModOnly("jei")
@ZenClass("mods.randomtweaker.jei.IJeiRecipe")
public interface IJeiRecipe {

    @ZenMethod
    IJeiRecipe setInputs(IIngredient[] inputs);

    @ZenMethod
    IJeiRecipe setOutputs(IIngredient[] outputs);

    @ZenMethod
    IJeiRecipe setElements(IJeiElement[] elements);

    @ZenMethod
    IJeiRecipe addInput(IIngredient input);

    @ZenMethod
    IJeiRecipe addOutput(IIngredient output);

    @ZenMethod
    IJeiRecipe addElement(IJeiElement element);

    @ZenMethod
    IJeiRecipe onJEITooltip(IJeiTooltip tooltip);

    @ZenMethod
    void build();

    void build_();

    String getUid();

}
