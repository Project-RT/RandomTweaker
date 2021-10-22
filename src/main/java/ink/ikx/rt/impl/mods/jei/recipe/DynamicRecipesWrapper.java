package ink.ikx.rt.impl.mods.jei.recipe;

import crafttweaker.api.item.IIngredient;
import ink.ikx.rt.impl.internal.utils.InternalUtils;
import ink.ikx.rt.impl.mods.jei.impl.core.MCJeiRecipe;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ParametersAreNonnullByDefault
public class DynamicRecipesWrapper implements IRecipeWrapper {

    private final MCJeiRecipe recipe;

    public DynamicRecipesWrapper(MCJeiRecipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        ingredients.setInputLists(VanillaTypes.ITEM, recipe.inputs.stream()
                .map(IIngredient::getItems)
                .map(InternalUtils::getItemStacks)
                .collect(Collectors.toList()));
        ingredients.setInputLists(VanillaTypes.FLUID, recipe.inputs.stream()
                .map(IIngredient::getLiquids)
                .map(InternalUtils::getFluidStacks)
                .collect(Collectors.toList()));

        if (recipe.outputs.isEmpty()) return;

        ingredients.setOutputLists(VanillaTypes.ITEM, recipe.outputs.stream()
                .map(IIngredient::getItems)
                .map(InternalUtils::getItemStacks)
                .collect(Collectors.toList()));
        ingredients.setOutputLists(VanillaTypes.FLUID, recipe.outputs.stream()
                .map(IIngredient::getLiquids)
                .map(InternalUtils::getFluidStacks)
                .collect(Collectors.toList()));
    }

    @Override
    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
        GlStateManager.enableAlpha();
        recipe.elements.forEach(e -> e.render(minecraft));
        GlStateManager.disableAlpha();
    }

    @Nonnull
    @Override
    public List<String> getTooltipStrings(int mouseX, int mouseY) {
        if (Objects.nonNull(recipe.tooltip)) {
            return Arrays.stream(recipe.tooltip.action(mouseX, mouseY)).collect(Collectors.toList());
        }
        return IRecipeWrapper.super.getTooltipStrings(mouseX, mouseY);
    }

}
