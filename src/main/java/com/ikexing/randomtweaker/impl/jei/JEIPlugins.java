package com.ikexing.randomtweaker.impl.jei;

import com.ikexing.randomtweaker.RandomTweaker;
import com.ikexing.randomtweaker.api.instance.jei.classes.JEICustom;
import com.ikexing.randomtweaker.api.instance.jei.classes.JEIRecipe;
import com.ikexing.randomtweaker.impl.jei.recipes.DynamicRecipesCategory;
import com.ikexing.randomtweaker.impl.jei.recipes.DynamicRecipesWrapper;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import java.util.ArrayList;
import java.util.List;
import mezz.jei.Internal;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.ISubtypeRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.gui.GuiHelper;

@JEIPlugin
public class JEIPlugins implements IModPlugin {

    List<DynamicRecipesWrapper> recipes = new ArrayList<>();

    @Override
    public void registerItemSubtypes(ISubtypeRegistry subtypeRegistry) {
        if (!RandomTweaker.jeiCustomList.isEmpty()) {
            System.out.println("[RT] : The JEI is Mine!!!]");
        }
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        GuiHelper guiHelper = Internal.getHelpers().getGuiHelper();
        if (!RandomTweaker.jeiCustomList.isEmpty()) {
            for (JEICustom jeiCustom : RandomTweaker.jeiCustomList) {
                registry.addRecipeCategories(new DynamicRecipesCategory(guiHelper, jeiCustom));
            }
        }
    }

    @Override
    public void register(IModRegistry registry) {
        if (!RandomTweaker.jeiCustomList.isEmpty()) {
            for (JEICustom jeiCustom : RandomTweaker.jeiCustomList) {
                for (IItemStack recipeCatalyst : jeiCustom.getRecipeCatalysts()) {
                    registry.addRecipeCatalyst(CraftTweakerMC.getItemStack(recipeCatalyst),
                        jeiCustom.uid);
                }
                for (JEIRecipe jeiRecipe : jeiCustom.getJeiRecipes()) {
                    recipes.add(new DynamicRecipesWrapper(jeiCustom.getJeiFontInfos(), jeiRecipe));
                }
            }
            registry.addRecipes(recipes, DynamicRecipesCategory.UID);
        }
    }
}
