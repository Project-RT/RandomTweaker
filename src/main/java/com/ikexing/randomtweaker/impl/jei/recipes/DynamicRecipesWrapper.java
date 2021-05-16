package com.ikexing.randomtweaker.impl.jei.recipes;

import com.ikexing.randomtweaker.api.jei.classes.JEIFontInfo;
import com.ikexing.randomtweaker.api.jei.classes.JEIRecipe;
import crafttweaker.api.item.IIngredient;
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
        for (IIngredient iIngredient : jeiRecipe.input) {
            if (!iIngredient.getItems().isEmpty()) {
                ingredients.setInputs(VanillaTypes.ITEM, getItemStacks(iIngredient.getItems()));
            }else{
                ingredients.setInputs(VanillaTypes.FLUID, getFluidStacks(iIngredient.getLiquids()));
            }
        }

        for (IIngredient iIngredient : jeiRecipe.output){
            if (!iIngredient.getItems().isEmpty()) {
                ingredients.setOutputs(VanillaTypes.ITEM, getItemStacks(iIngredient.getItems()));
            }else{
                ingredients.setOutputs(VanillaTypes.FLUID, getFluidStacks(iIngredient.getLiquids()));
            }
        }

//        for (JEIInput nowJeiRecipe : jeiInputs) {
//            if (nowJeiRecipe.isInput) {
//                if ("item".equals(nowJeiRecipe.type)) {
//                    ingredients.setInputs(VanillaTypes.ITEM, getItemStacks(nowJeiRecipe.items));
//                } else if ("fluid".equals(nowJeiRecipe.type)) {
//                    ingredients.setInputs(VanillaTypes.FLUID, getFluidStacks(nowJeiRecipe.fluids));
//                } else {
//                    CraftTweakerAPI.logError("Type is not supported");
//                }
//            } else {
//                if ("item".equals(nowJeiRecipe.type)) {
//                    ingredients.setOutputs(VanillaTypes.ITEM, getItemStacks(nowJeiRecipe.items));
//                } else if ("fluid".equals(nowJeiRecipe.type)) {
//                    ingredients.setOutputs(VanillaTypes.FLUID, getFluidStacks(nowJeiRecipe.fluids));
//                } else {
//                    CraftTweakerAPI.logError("Type is not supported");
//                }
//            }
//        }
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
