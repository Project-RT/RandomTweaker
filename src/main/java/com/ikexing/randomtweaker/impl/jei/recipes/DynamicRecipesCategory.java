package com.ikexing.randomtweaker.impl.jei.recipes;

import com.ikexing.randomtweaker.api.jei.JEIRecipe;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;

import javax.annotation.Nullable;
import java.util.List;

/**
 * @author ikexing
 */
public class DynamicRecipesCategory implements IRecipeCategory<DynamicRecipesWrapper> {

    public static String UID;
    public final List<JEIRecipe.Output> outputs;
    public final List<JEIRecipe.Input> inputs;

    private final IDrawable background;
    private final IDrawable icon;
    private final String title;
    private final String modName;

    public DynamicRecipesCategory(IGuiHelper guiHelper, JEIRecipe jeiRecipe) {
        background = guiHelper.createBlankDrawable(128, 72);
        icon = guiHelper.createDrawableIngredient(jeiRecipe.getIcon());
        title = jeiRecipe.getTitle();
        UID = jeiRecipe.getUid();
        modName = jeiRecipe.getModid();
        inputs = jeiRecipe.getInputs();
        outputs = jeiRecipe.getOutputs();
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
//        recipeLayout.getItemStacks().init(0, true, 18, 12);
//        recipeLayout.getItemStacks().set(0, ingredients.getInputs(VanillaTypes.ITEM).get(0));
//
//        recipeLayout.getItemStacks().init(1, false, 90, 12);
//        recipeLayout.getItemStacks().set(1, ingredients.getOutputs(VanillaTypes.ITEM).get(0));

        int i = 0;
        for (JEIRecipe.Input input : inputs) {
            recipeLayout.getItemStacks().init(i, true, input.xPosition, input.yPosition);
            i++;
        }
        i = 0;
        for (JEIRecipe.Output output : outputs) {
            recipeLayout.getItemStacks().init(i, false, output.xPosition, output.yPosition);
            i++;
        }
    }

}
