package com.ikexing.randomtweaker.impl.jei;

import com.ikexing.randomtweaker.RandomTweaker;
import com.ikexing.randomtweaker.api.jei.classes.JEICustom;
import com.ikexing.randomtweaker.impl.jei.recipes.DynamicRecipesCategory;
import com.ikexing.randomtweaker.impl.jei.recipes.DynamicRecipesWrapper;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import mezz.jei.Internal;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.ISubtypeRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.gui.GuiHelper;

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
        for (JEICustom jeiCustom : RandomTweaker.jeiCustomList) {
            registry.addRecipeCategories(new DynamicRecipesCategory(guiHelper, jeiCustom));
        }
    }

    @Override
    public void register(IModRegistry registry) {
        for (JEICustom jeiCustom : RandomTweaker.jeiCustomList) {
            for (IItemStack recipeCatalyst : jeiCustom.getRecipeCatalysts()) {
                registry.addRecipeCatalyst(CraftTweakerMC.getItemStack(recipeCatalyst), jeiCustom.uid);
            }
            recipes.add(new DynamicRecipesWrapper(jeiCustom.getJeiFontInfos(), jeiCustom.getJeiRecipes()));
        }
        registry.addRecipes(recipes, DynamicRecipesCategory.UID);
    }
}
