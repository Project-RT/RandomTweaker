package com.ikexing.icrtweaker.api.jei.recipes;

import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;
import java.util.List;

public class DynamicRecipesCategory implements IRecipeCategory<DynamicRecipesWrapper> {
    @Override
    public String getUid() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getModName() {
        return null;
    }

    @Override
    public IDrawable getBackground() {
        return null;
    }

    @Nullable
    @Override
    public IDrawable getIcon() {
        return IRecipeCategory.super.getIcon();
    }

    @Override
    public void drawExtras(Minecraft minecraft) {
        IRecipeCategory.super.drawExtras(minecraft);
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, DynamicRecipesWrapper recipeWrapper, IIngredients ingredients) {

    }

    @Override
    public List<String> getTooltipStrings(int mouseX, int mouseY) {
        return IRecipeCategory.super.getTooltipStrings(mouseX, mouseY);
    }
}
