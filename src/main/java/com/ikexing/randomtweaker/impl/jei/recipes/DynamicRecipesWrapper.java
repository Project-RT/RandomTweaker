package com.ikexing.randomtweaker.impl.jei.recipes;

import com.ikexing.randomtweaker.api.jei.JEIRecipe.FontInfo;
import com.ikexing.randomtweaker.api.jei.JEIRecipe.Input;
import com.ikexing.randomtweaker.api.jei.JEIRecipe.Output;
import crafttweaker.api.minecraft.CraftTweakerMC;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * @author ikexing
 */
public class DynamicRecipesWrapper implements IRecipeWrapper {

    private final List<FontInfo> fontInfos;
    private final List<Output> outputs;
    private final List<Input> inputs;

    public DynamicRecipesWrapper(List<Output> outputs, List<Input> inputs, List<FontInfo> fontInfos) {
        this.outputs = outputs;
        this.inputs = inputs;
        this.fontInfos = fontInfos;
    }


    @Override
    public void getIngredients(IIngredients ingredients) {

        for (Input input : inputs) {
            if ("item".equals(input.type)) {
                ingredients.setInput(VanillaTypes.ITEM, CraftTweakerMC.getItemStack(input.item));
            } else {
                ingredients.setInput(VanillaTypes.FLUID, CraftTweakerMC.getLiquidStack(input.fluid));
            }
        }

        for (Output output : outputs) {
            if ("item".equals(output.type)) {
                ingredients.setOutput(VanillaTypes.ITEM, CraftTweakerMC.getItemStack(output.item));
            } else {
                ingredients.setOutput(VanillaTypes.FLUID, CraftTweakerMC.getLiquidStack(output.fluid));
            }
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
        FontRenderer fontRenderer = minecraft.fontRenderer;

        for (FontInfo fontInfo : fontInfos) {
            fontRenderer.drawString(new TextComponentTranslation(fontInfo.fontInfoName).getUnformattedComponentText(), fontInfo.mouseX, fontInfo.mouseY, fontInfo.color);
        }
    }

}
