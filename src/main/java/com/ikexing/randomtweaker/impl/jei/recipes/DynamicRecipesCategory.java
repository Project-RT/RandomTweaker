package com.ikexing.randomtweaker.impl.jei.recipes;

import com.ikexing.randomtweaker.api.jei.classes.JEICustom;
import com.ikexing.randomtweaker.api.jei.classes.JEIRecipe;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.minecraft.CraftTweakerMC;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiFluidStackGroup;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeCategory;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ikexing
 */
public class DynamicRecipesCategory implements IRecipeCategory<DynamicRecipesWrapper> {

    public static String UID;

    private final List<JEIRecipe> jeiRecipes;
    private final IDrawable background;
    private final IDrawable icon;
    private final String title;
    private final String modName;

    public DynamicRecipesCategory(IGuiHelper guiHelper, JEICustom jeiCustom) {
        background = guiHelper.createBlankDrawable(128, 72);
        icon = guiHelper.createDrawableIngredient(CraftTweakerMC.getItemStack(jeiCustom.getIcon()));
        title = jeiCustom.title;
        UID = jeiCustom.uid;
        modName = jeiCustom.getModid();
        this.jeiRecipes = jeiCustom.jeiRecipes;
    }

    @Override
    public String getUid() {
        return UID;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getModName() {
        return modName;
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
        int i = 0;
        for (JEIRecipe nowJeiRecipe : jeiRecipes) {
            if (nowJeiRecipe.isInput) {
                if ("item".equals(nowJeiRecipe.type)) {
                    recipeLayout.getItemStacks().init(i, true, nowJeiRecipe.xPosition, nowJeiRecipe.yPosition);
                    recipeLayout.getItemStacks().set(i, ingredients.getInputs(VanillaTypes.ITEM).get(i));
                } else if ("fluid".equals(nowJeiRecipe.type)) {
                    recipeLayout.getFluidStacks().init(i, true, nowJeiRecipe.xPosition, nowJeiRecipe.yPosition, nowJeiRecipe.width, nowJeiRecipe.height, nowJeiRecipe.capacityMb, nowJeiRecipe.showCapacity, null);
                    recipeLayout.getFluidStacks().set(i, ingredients.getInputs(VanillaTypes.FLUID).get(i));
                } else {
                    CraftTweakerAPI.logError("Type is not supported");
                }
                i++;
            }
        }
        i = 0;
        for (JEIRecipe nowJeiRecipe : jeiRecipes) {
            if (!nowJeiRecipe.isInput) {
                if ("item".equals(nowJeiRecipe.type)) {
                    recipeLayout.getItemStacks().init(i, false, nowJeiRecipe.xPosition, nowJeiRecipe.yPosition);
                    recipeLayout.getItemStacks().set(i, ingredients.getOutputs(VanillaTypes.ITEM).get(i));
                } else if ("fluid".equals(nowJeiRecipe.type)) {
                    recipeLayout.getFluidStacks().init(i, false, nowJeiRecipe.xPosition, nowJeiRecipe.yPosition, nowJeiRecipe.width, nowJeiRecipe.height, nowJeiRecipe.capacityMb, nowJeiRecipe.showCapacity, null);
                    recipeLayout.getFluidStacks().set(i, ingredients.getOutputs(VanillaTypes.FLUID).get(i));
                } else {
                    CraftTweakerAPI.logError("Type is not supported");
                }
                i++;
            }
        }
    }
}
