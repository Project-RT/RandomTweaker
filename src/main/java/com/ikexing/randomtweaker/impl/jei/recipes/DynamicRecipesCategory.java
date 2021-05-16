package com.ikexing.randomtweaker.impl.jei.recipes;

import com.ikexing.randomtweaker.api.jei.classes.JEIBackGroup;
import com.ikexing.randomtweaker.api.jei.classes.JEICustom;
import com.ikexing.randomtweaker.api.jei.classes.JEISpace;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.minecraft.CraftTweakerMC;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiFluidStackGroup;
import mezz.jei.api.gui.IGuiItemStackGroup;
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
        IGuiItemStackGroup group = recipeLayout.getItemStacks();
        IGuiFluidStackGroup fgroup = recipeLayout.getFluidStacks();
        int i = 0;
        for (JEISpace jeiSpace : this.jeiSpaces) {
            if (jeiSpace.isInput) {
                if ("item".equals(jeiSpace.type)) {
                    group.init(i, true, jeiSpace.xPosition, jeiSpace.yPosition);
                } else if ("fluid".equals(jeiSpace.type)) {
                    fgroup.init(i, true, jeiSpace.xPosition, jeiSpace.yPosition, jeiSpace.width, jeiSpace.height, jeiSpace.capacityMb, jeiSpace.showCapacity, null);
                } else {
                    CraftTweakerAPI.logError("Type is not supported");
                }
            } else {
                if ("item".equals(jeiSpace.type)) {
                    group.init(i, false, jeiSpace.xPosition, jeiSpace.yPosition);
                    group.init(i, false, jeiSpace.xPosition, jeiSpace.yPosition);
                } else if ("fluid".equals(jeiSpace.type)) {
                    fgroup.init(i, false, jeiSpace.xPosition, jeiSpace.yPosition, jeiSpace.width, jeiSpace.height, jeiSpace.capacityMb, jeiSpace.showCapacity, null);
                } else {
                    CraftTweakerAPI.logError("Type is not supported");
                }
            }
            i++;
        }
        group.set(ingredients);
        fgroup.set(ingredients);
    }
}
