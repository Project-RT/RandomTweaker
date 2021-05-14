package com.ikexing.randomtweaker.impl.jei.recipes;

import com.ikexing.randomtweaker.RandomTweaker;
import com.ikexing.randomtweaker.impl.jei.JEIRecipe;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

/**
 * @author ikexing
 */
public class DynamicRecipesCategory implements IRecipeCategory<DynamicRecipesWrapper> {

    public static final String UID = "testUid";
    private final IDrawable background;
    private final IDrawable icon;
    private final String localizedName;

    public DynamicRecipesCategory(IGuiHelper guiHelper, JEIRecipe jeiRecipe) {
        background = guiHelper.createBlankDrawable(128, 72);
        icon = guiHelper.createDrawableIngredient(new ItemStack(Blocks.COAL_ORE));
        localizedName = "测试JEI";
    }

    @Override
    public String getUid() {
        return UID;
    }

    @Override
    public String getTitle() {
        return localizedName;
    }

    @Override
    public String getModName() {
        return RandomTweaker.NAME;
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Nullable
    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, DynamicRecipesWrapper recipeWrapper, IIngredients ingredients) {
        recipeLayout.getItemStacks().init(0, true, 18, 12);
        recipeLayout.getItemStacks().set(0, ingredients.getInputs(VanillaTypes.ITEM).get(0));

        recipeLayout.getItemStacks().init(1, false, 90, 12);
        recipeLayout.getItemStacks().set(1, ingredients.getOutputs(VanillaTypes.ITEM).get(0));
    }

}
