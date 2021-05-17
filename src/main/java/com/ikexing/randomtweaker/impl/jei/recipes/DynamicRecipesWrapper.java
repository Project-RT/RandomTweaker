package com.ikexing.randomtweaker.impl.jei.recipes;

import com.ikexing.randomtweaker.api.jei.classes.JEIFontInfo;
import com.ikexing.randomtweaker.api.jei.classes.JEIRecipe;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ikexing
 */
public class DynamicRecipesWrapper implements IRecipeWrapper {

    private final List<JEIFontInfo> fontInfos;
    private final JEIRecipe jeiRecipe;

    public DynamicRecipesWrapper(List<JEIFontInfo> fontInfos, JEIRecipe jeiRecipe) {
        this.fontInfos = fontInfos;
        this.jeiRecipe = jeiRecipe;
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        List<List<FluidStack>> inputFluidStack = new ArrayList<>();
        List<List<ItemStack>> inputItemStack = new ArrayList<>();

        List<List<FluidStack>> outputFluidStack = new ArrayList<>();
        List<List<ItemStack>> outputItemStack = new ArrayList<>();

        for (crafttweaker.api.item.IIngredient it : jeiRecipe.input) {
            if (it.getLiquids().isEmpty()) {
                inputItemStack.add(getItemStacks(it.getItems()));
            } else {
                inputFluidStack.add(getFluidStacks(it.getLiquids()));
            }
        }
        ingredients.setInputLists(VanillaTypes.ITEM, inputItemStack);
        ingredients.setInputLists(VanillaTypes.FLUID, inputFluidStack);

        for (crafttweaker.api.item.IIngredient it : jeiRecipe.output) {
            if (it.getLiquids().isEmpty()) {
                outputItemStack.add(getItemStacks(it.getItems()));
            } else {
                outputFluidStack.add(getFluidStacks(it.getLiquids()));
            }
        }
        ingredients.setOutputLists(VanillaTypes.ITEM, outputItemStack);
        ingredients.setOutputLists(VanillaTypes.FLUID, outputFluidStack);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
        FontRenderer fontRenderer = minecraft.fontRenderer;
        if (!fontInfos.isEmpty()) {
            for (JEIFontInfo fontInfo : fontInfos) {
                fontRenderer.drawString(new TextComponentTranslation(fontInfo.name).getUnformattedComponentText(), fontInfo.x, fontInfo.y, fontInfo.color);
            }
        }
    }

    private List<ItemStack> getItemStacks(List<IItemStack> stacks) {
        return new ArrayList<>(Arrays.asList(CraftTweakerMC.getItemStacks(stacks)));
    }

    private List<FluidStack> getFluidStacks(List<ILiquidStack> stacks) {
        return new ArrayList<>(Arrays.asList(CraftTweakerMC.getLiquidStacks(stacks.toArray(new ILiquidStack[0]))));
    }
}
