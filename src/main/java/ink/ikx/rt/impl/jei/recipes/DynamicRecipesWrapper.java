package ink.ikx.rt.impl.jei.recipes;

import crafttweaker.api.item.IIngredient;
import java.util.List;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;

@SuppressWarnings("NullableProblems")
public class DynamicRecipesWrapper implements IRecipeWrapper {

    private final List<IIngredient> JEI_INPUT_RECIPES;
    private final List<IIngredient> JEI_OUTPUT_RECIPES;

    public DynamicRecipesWrapper(List<IIngredient> JEI_INPUT_RECIPES,
        List<IIngredient> JEI_OUTPUT_RECIPES) {
        this.JEI_INPUT_RECIPES = JEI_INPUT_RECIPES;
        this.JEI_OUTPUT_RECIPES = JEI_OUTPUT_RECIPES;
    }

    @Override
    public void getIngredients(IIngredients ingredients) {

    }

    @Override
    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX,
        int mouseY) {
        IRecipeWrapper.super.drawInfo(minecraft, recipeWidth, recipeHeight, mouseX, mouseY);
    }

    @Override
    public List<String> getTooltipStrings(int mouseX, int mouseY) {
        return IRecipeWrapper.super.getTooltipStrings(mouseX, mouseY);
    }

    @Override
    public boolean handleClick(Minecraft minecraft, int mouseX, int mouseY, int mouseButton) {
        return IRecipeWrapper.super.handleClick(minecraft, mouseX, mouseY, mouseButton);
    }
}
