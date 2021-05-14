package com.ikexing.randomtweaker.impl.jei;

import com.ikexing.randomtweaker.RandomTweaker;
import com.ikexing.randomtweaker.api.jei.JEIRecipe;
import com.ikexing.randomtweaker.impl.jei.recipes.DynamicRecipesCategory;
import com.ikexing.randomtweaker.impl.jei.recipes.DynamicRecipesWrapper;
import mezz.jei.Internal;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.ISubtypeRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.gui.GuiHelper;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ikexing
 */
@JEIPlugin
public class JEIPlugins implements IModPlugin {

    List<DynamicRecipesWrapper> recipes = new ArrayList<>();

    @Override
    public void registerItemSubtypes(ISubtypeRegistry subtypeRegistry) {
        System.out.println("JEIPlugin Loading");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        GuiHelper guiHelper = Internal.getHelpers().getGuiHelper();
        for (JEIRecipe jeiRecipe : RandomTweaker.JEIRecipes) {
            registry.addRecipeCategories(new DynamicRecipesCategory(guiHelper, jeiRecipe));
        }
//        registry.addRecipeCategories(new DynamicRecipesCategory(guiHelper));
    }

    @Override
    public void register(IModRegistry registry) {
        for (JEIRecipe jeiRecipe : RandomTweaker.JEIRecipes) {
            for (ItemStack recipeCatalyst : jeiRecipe.getRecipeCatalysts()) {
                registry.addRecipeCatalyst(recipeCatalyst, jeiRecipe.getUid());
            }
            recipes.add(new DynamicRecipesWrapper(jeiRecipe.getOutputs(), jeiRecipe.getInputs(), jeiRecipe.getFontInfos()));
        }
//        registry.addRecipeCatalyst(new ItemStack(Blocks.COAL_ORE), DynamicRecipesCategory.getUID());

//        recipes.add(new DynamicRecipesWrapper(new ItemStack(Items.GOLDEN_APPLE), new ItemStack(Items.APPLE)));
//        recipes.add(new DynamicRecipesWrapper(new ItemStack(Items.GOLDEN_APPLE), new ItemStack(Items.APPLE)));

        registry.addRecipes(recipes, DynamicRecipesCategory.UID);
    }
}
