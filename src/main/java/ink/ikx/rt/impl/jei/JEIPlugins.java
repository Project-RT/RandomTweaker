package ink.ikx.rt.impl.jei;

import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.RandomTweaker;
import ink.ikx.rt.impl.jei.recipes.DynamicRecipesCategory;
import ink.ikx.rt.impl.jei.recipes.DynamicRecipesWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mezz.jei.Internal;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.ISubtypeRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.gui.GuiHelper;

@SuppressWarnings("NullableProblems")
@JEIPlugin
public class JEIPlugins implements IModPlugin {

    List<DynamicRecipesWrapper> recipes = new ArrayList<>();

    @Override
    public void registerItemSubtypes(ISubtypeRegistry subtypeRegistry) {
        if (!RandomTweaker.JEIPanelList.isEmpty()) {
            System.out.println("[RandomTweaker] : Custom Jei loading]");
        }
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        GuiHelper guiHelper = Internal.getHelpers().getGuiHelper();
        if (!RandomTweaker.JEIPanelList.isEmpty()) {
            RandomTweaker.JEIPanelList.forEach(p -> {
                registry.addRecipeCategories(new DynamicRecipesCategory(guiHelper, p));
            });
        }
    }

    @Override
    public void register(IModRegistry registry) {
        if (!RandomTweaker.JEIPanelList.isEmpty()) {
            RandomTweaker.JEIPanelList.forEach(p -> {
                List<IIngredient> input = new ArrayList<>(Arrays.asList(p.getJEIInputRecipes()));
                List<IIngredient> output = new ArrayList<>(Arrays.asList(p.getJEIOutputRecipes()));

                for (IItemStack c : p.getRecipeCatalysts()) {
                    registry.addRecipeCatalyst(CraftTweakerMC.getItemStack(c));
                }
                recipes.add(new DynamicRecipesWrapper(input, output));
            });
            registry.addRecipes(recipes, DynamicRecipesCategory.UID);
        }
    }
}
