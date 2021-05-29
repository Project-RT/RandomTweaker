package com.ikexing.randomtweaker.impl.jei.recipes;

import com.ikexing.randomtweaker.api.jei.classes.JEIBackGroup;
import com.ikexing.randomtweaker.api.jei.classes.JEICustom;
import com.ikexing.randomtweaker.api.jei.classes.JEISlot;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.minecraft.CraftTweakerMC;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiFluidStackGroup;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;
import java.util.List;

/**
 * @author ikexing
 */
public class DynamicRecipesCategory implements IRecipeCategory<DynamicRecipesWrapper> {

    public static String UID;
    public static int i;

    private final List<JEISlot> jeiSlots;
    private final IDrawable background;
    private final IDrawable icon;
    private final String title;
    private final String modName;


    public DynamicRecipesCategory(IGuiHelper guiHelper, JEICustom jeiCustom) {
        JEIBackGroup jeiBackGroup = jeiCustom.getJeiBackGroup();
        UID = jeiCustom.uid;

        this.icon = guiHelper.createDrawableIngredient(CraftTweakerMC.getItemStack(jeiCustom.getIcon()));
        this.title = jeiCustom.title;
        this.modName = jeiCustom.getModid();
        this.jeiSlots = jeiCustom.jeiSlots;

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
        for (JEISlot jeiSlot : this.jeiSlots) {
            String s = jeiSlot.type.toLowerCase();
            switch (s) {
                case "item":
                    group.init(i, jeiSlot.isInput, jeiSlot.xPosition, jeiSlot.yPosition);
                    break;
                case "fluid":
                    fgroup.init(i, jeiSlot.isInput, jeiSlot.xPosition, jeiSlot.yPosition, jeiSlot.width, jeiSlot.height, jeiSlot.capacityMb, jeiSlot.showCapacity, null);
                    break;
                case "font":
                    continue;
                default:
                    CraftTweakerAPI.logError("Type is not supported");
                    break;
            }
            i++;
        }
        group.set(ingredients);
        fgroup.set(ingredients);
    }
}
