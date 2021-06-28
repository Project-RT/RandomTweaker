package ink.ikx.rt.api.instance.jei.interfaces;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import java.util.List;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;

@ZenRegister
@ZenClass("mods.randomtweaker.jei.JEIRecipe")
public interface JEIRecipe {

    @ZenGetter("inputs")
    List<IIngredient> getInputs();

    @ZenGetter("outputs")
    List<IIngredient> getOutputs();
}
