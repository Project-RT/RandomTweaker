package ink.ikx.rt.impl.jei.recipes;

import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.api.instance.jei.interfaces.JEIRecipe;
import ink.ikx.rt.api.instance.jei.interfaces.element.JEIElement;
import ink.ikx.rt.api.instance.jei.interfaces.slots.JEISlot;
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

    private final JEIRecipe JEIRecipe;
    private final JEISlot[] JEISlots;
    private final JEIElement[] JEIElements;

    public DynamicRecipesWrapper(JEIRecipe JEIRecipe, JEISlot[] JEISlots, JEIElement[] JEIElements) {
        this.JEIElements = JEIElements;
        this.JEISlots = JEISlots;
        this.JEIRecipe = JEIRecipe;
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        List<List<FluidStack>> inputFluidStack = new ArrayList<>();
        List<List<ItemStack>> inputItemStack = new ArrayList<>();

        List<List<FluidStack>> outputFluidStack = new ArrayList<>();
        List<List<ItemStack>> outputItemStack = new ArrayList<>();

        for (IIngredient i : JEIRecipe.getInput()) {
            if (i.getLiquids().isEmpty()) {
                inputItemStack.add(getItemStacks(i.getItems()));
            } else {
                inputFluidStack.add(getFluidStacks(i.getLiquids()));
            }
        }
        ingredients.setInputLists(VanillaTypes.ITEM, inputItemStack);
        ingredients.setInputLists(VanillaTypes.FLUID, inputFluidStack);

        if (!JEIRecipe.getOutput().isEmpty()) {
            for (IIngredient o : JEIRecipe.getOutput()) {
                if (o.getLiquids().isEmpty()) {
                    outputItemStack.add(getItemStacks(o.getItems()));
                } else {
                    outputFluidStack.add(getFluidStacks(o.getLiquids()));
                }
            }
            ingredients.setOutputLists(VanillaTypes.ITEM, outputItemStack);
            ingredients.setOutputLists(VanillaTypes.FLUID, outputFluidStack);
        }
    }

    @Override
    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX,
        int mouseY) {

        for (JEISlot JEISlot : JEISlots) {
            JEISlot.Render(minecraft);
        }
        for (JEIElement JEIElement : JEIElements) {
            JEIElement.Render(minecraft);
        }
    }

    private List<ItemStack> getItemStacks(List<IItemStack> stacks) {
        return new ArrayList<>(Arrays.asList(CraftTweakerMC.getItemStacks(stacks)));
    }

    private List<FluidStack> getFluidStacks(List<ILiquidStack> stacks) {
        return new ArrayList<>(
            Arrays.asList(CraftTweakerMC.getLiquidStacks(stacks.toArray(new ILiquidStack[0]))));
    }
}
