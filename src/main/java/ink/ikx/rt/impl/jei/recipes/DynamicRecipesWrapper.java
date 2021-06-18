package ink.ikx.rt.impl.jei.recipes;

import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

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
        List<List<ItemStack>> itemStack = new ArrayList<>();
        List<List<FluidStack>> fluidStack = new ArrayList<>();

        JEI_INPUT_RECIPES.forEach(i -> {
            if (i.getLiquids().isEmpty()) {
                itemStack.add(getItemStacks(i.getItems()));
            } else {
                fluidStack.add(getFluidStacks(i.getLiquids()));
            }
        });

        ingredients.setInputLists(VanillaTypes.ITEM, itemStack);
        ingredients.setInputLists(VanillaTypes.FLUID, fluidStack);

        itemStack.clear();
        fluidStack.clear();

        JEI_OUTPUT_RECIPES.forEach(i -> {
            if (i.getLiquids().isEmpty()) {
                itemStack.add(getItemStacks(i.getItems()));
            } else {
                fluidStack.add(getFluidStacks(i.getLiquids()));
            }
        });

        ingredients.setOutputLists(VanillaTypes.ITEM, itemStack);
        ingredients.setOutputLists(VanillaTypes.FLUID, fluidStack);
    }

    @Override
    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX,
        int mouseY) {
//        IRecipeWrapper.super.drawInfo(minecraft, recipeWidth, recipeHeight, mouseX, mouseY);
    }

    /** todo
     * //@Override
     * public boolean handleClick(Minecraft minecraft, int mouseX, int mouseY, int
     * mouseButton) { return IRecipeWrapper.super.handleClick(minecraft, mouseX, mouseY,
     * mouseButton); }
     */

    private List<ItemStack> getItemStacks(List<IItemStack> stacks) {
        return new ArrayList<>(Arrays.asList(CraftTweakerMC.getItemStacks(stacks)));
    }

    private List<FluidStack> getFluidStacks(List<ILiquidStack> stacks) {
        return new ArrayList<>(
            Arrays.asList(CraftTweakerMC.getLiquidStacks(stacks.toArray(new ILiquidStack[0]))));
    }
}
