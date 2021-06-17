package com.ikexing.randomtweaker.impl.jei.recipes;

import com.ikexing.randomtweaker.api.instance.jei.classes.JEICustom;
import javax.annotation.Nullable;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;

@SuppressWarnings("NullableProblems")
public class DynamicRecipesCategory implements IRecipeCategory<DynamicRecipesWrapper> {

    public DynamicRecipesCategory(IGuiHelper guiHelper) {
        
    }

    @Override
    public String getUid() {
    }

    @Override
    public String getTitle() {
    }

    @Override
    public String getModName() {
    }

    @Override
    public IDrawable getBackground() {
    }

    @Nullable
    @Override
    public IDrawable getIcon() {
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, DynamicRecipesWrapper recipeWrapper,
        IIngredients ingredients) {

    }
}
