package ink.ikx.rt.impl.jei.recipes;

import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.api.instance.jei.interfaces.element.JEIElement;
import ink.ikx.rt.api.instance.jei.interfaces.other.JEIRecipe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

@SuppressWarnings("NullableProblems")
public class DynamicRecipesWrapper implements IRecipeWrapper {

    private final JEIRecipe JEIRecipe;

    public List<List<FluidStack>> fluidStack = new ArrayList<>();
    public List<List<ItemStack>> itemStack = new ArrayList<>();

    public DynamicRecipesWrapper(JEIRecipe JEIRecipe) {
        this.JEIRecipe = JEIRecipe;
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        itemStack.clear();
        fluidStack.clear();

        for (IIngredient i : JEIRecipe.getInputs()) {
            if (i.getLiquids().isEmpty()) {
                itemStack.add(getItemStacks(i.getItems()));
            } else {
                fluidStack.add(getFluidStacks(i.getLiquids()));
            }
        }
        ingredients.setInputLists(VanillaTypes.ITEM, itemStack);
        ingredients.setInputLists(VanillaTypes.FLUID, fluidStack);

        fluidStack.clear();
        itemStack.clear();

        if (!(JEIRecipe.getOutputs().length == 0)) {
            for (IIngredient o : JEIRecipe.getOutputs()) {
                if (o.getLiquids().isEmpty()) {
                    itemStack.add(getItemStacks(o.getItems()));
                } else {
                    fluidStack.add(getFluidStacks(o.getLiquids()));
                }
            }
            ingredients.setOutputLists(VanillaTypes.ITEM, itemStack);
            ingredients.setOutputLists(VanillaTypes.FLUID, fluidStack);
        }
    }

    @Override
    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
        for (JEIElement JEIElement : JEIRecipe.getJEIElements()) {
            JEIElement.Render(minecraft);
        }
    }

    @Override
    public List<String> getTooltipStrings(int mouseX, int mouseY) {
        if (Objects.nonNull(JEIRecipe.getJEITooltip())) {
            return Arrays.asList(JEIRecipe.getJEITooltip().handler(mouseX, mouseY));
        }
        return IRecipeWrapper.super.getTooltipStrings(mouseX, mouseY);
    }

    private List<ItemStack> getItemStacks(List<IItemStack> stacks) {
        return new ArrayList<>(Arrays.asList(CraftTweakerMC.getItemStacks(stacks)));
    }

    private List<FluidStack> getFluidStacks(List<ILiquidStack> stacks) {
        return new ArrayList<>(Arrays.asList(CraftTweakerMC.getLiquidStacks(stacks.toArray(new ILiquidStack[0]))));
    }
}
