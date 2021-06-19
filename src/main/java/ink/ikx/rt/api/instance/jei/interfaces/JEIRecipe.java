package ink.ikx.rt.api.instance.jei.interfaces;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import java.util.List;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;

@ZenRegister
@ZenClass("mods.randomtweaker.JEIRecipe")
public interface JEIRecipe {

    @ZenGetter("input")
    List<IIngredient> getInput();

    @ZenGetter("output")
    List<IIngredient> getOutput();
}
