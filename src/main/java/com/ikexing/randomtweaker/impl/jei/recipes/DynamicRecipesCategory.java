package com.ikexing.randomtweaker.impl.jei.recipes;

import com.ikexing.randomtweaker.api.jei.classes.JEIBackGroup;
import com.ikexing.randomtweaker.api.jei.classes.JEICustom;
import com.ikexing.randomtweaker.api.jei.classes.JEISpace;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.minecraft.CraftTweakerMC;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;
import java.util.List;

/**
 * @author ikexing
 */
public class DynamicRecipesCategory implements IRecipeCategory<DynamicRecipesWrapper> {

    public static String UID;

    private final List<JEISpace> jeiSpaces;
    private final IDrawable background;
    private final IDrawable icon;
    private final String title;
    private final String modName;

    public DynamicRecipesCategory(IGuiHelper guiHelper, JEICustom jeiCustom) {
        JEIBackGroup jeiBackGroup = jeiCustom.getJeiBackGroup();
        icon = guiHelper.createDrawableIngredient(CraftTweakerMC.getItemStack(jeiCustom.getIcon()));
        title = jeiCustom.title;
        UID = jeiCustom.uid;
        modName = jeiCustom.getModid();
        jeiSpaces = jeiCustom.jeiSpaces;

        if (jeiBackGroup.isNull()) {
            background = guiHelper.createBlankDrawable(jeiBackGroup.width, jeiBackGroup.heigh);
        } else {
            ResourceLocation location = new ResourceLocation(jeiBackGroup.namespaceIn, jeiBackGroup.pathIn);
            background = guiHelper.createDrawable(location, jeiBackGroup.u, jeiBackGroup.v, jeiBackGroup.width, jeiBackGroup.heigh);
        }
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
        for (JEISpace jeiSpace : jeiSpaces) {
            if (!jeiSpace.isInput) {
                if ("item".equals(jeiSpace.type)) {
                    recipeLayout.getItemStacks().init(i, true, jeiSpace.xPosition, jeiSpace.yPosition);
                    recipeLayout.getItemStacks().set(i, ingredients.getInputs(VanillaTypes.ITEM).get(i));
                } else if ("fluid".equals(jeiSpace.type)) {
                    recipeLayout.getFluidStacks().init(i, true, jeiSpace.xPosition, jeiSpace.yPosition, jeiSpace.width, jeiSpace.height, jeiSpace.capacityMb, jeiSpace.showCapacity, null);
                    recipeLayout.getFluidStacks().set(i, ingredients.getInputs(VanillaTypes.FLUID).get(i));
                } else {
                    CraftTweakerAPI.logError("Type is not supported");
                }
            } else {
                if ("item".equals(jeiSpace.type)) {
                    recipeLayout.getItemStacks().init(i, false, jeiSpace.xPosition, jeiSpace.yPosition);
                    recipeLayout.getItemStacks().set(i, ingredients.getOutputs(VanillaTypes.ITEM).get(i));
                } else if ("fluid".equals(jeiSpace.type)) {
                    recipeLayout.getFluidStacks().init(i, false, jeiSpace.xPosition, jeiSpace.yPosition, jeiSpace.width, jeiSpace.height, jeiSpace.capacityMb, jeiSpace.showCapacity, null);
                    recipeLayout.getFluidStacks().set(i, ingredients.getOutputs(VanillaTypes.FLUID).get(i));
                } else {
                    CraftTweakerAPI.logError("Type is not supported");
                }
            }
            i++;
        }
    }
}
