package ink.ikx.rt.api.mods.astralsorcery;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import hellfirepvp.astralsorcery.common.constellation.ConstellationRegistry;
import hellfirepvp.astralsorcery.common.constellation.IConstellation;
import ink.ikx.rt.impl.mods.astralsorcery.CustomAttunementRecipe;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ModOnly("astralsorcery")
@ZenClass("mods.randomtweaker.astralsorcery.AttunementAltar")
public abstract class IAttunementAltar {

    @ZenMethod
    public static void addRecipe(IIngredient input, IItemStack output, String constellationString) {
        IConstellation constellation = ConstellationRegistry.getConstellationByName(constellationString);
        if (constellation == null) {
            CraftTweakerAPI.logError("Unknown constellation for attunement altar recipe!");
            CraftTweakerAPI.logError("Got: " + constellationString);
            return;
        }
        CustomAttunementRecipe.allRecipes.add(
                new CustomAttunementRecipe(constellation, input, output)
        );
    }

    @ZenMethod
    public static void addRecipe(IIngredient input, IItemStack output) {
        CustomAttunementRecipe.allRecipes.add(
                new CustomAttunementRecipe(null, input, output)
        );
    }
}
