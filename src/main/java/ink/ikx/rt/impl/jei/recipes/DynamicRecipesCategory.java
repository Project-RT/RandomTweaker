package ink.ikx.rt.impl.jei.recipes;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.api.instance.jei.interfaces.element.JEIElement;
import ink.ikx.rt.api.instance.jei.interfaces.other.JEIBackground;
import ink.ikx.rt.api.instance.jei.interfaces.other.JEIPanel;
import ink.ikx.rt.api.instance.jei.interfaces.other.JEITooltip;
import ink.ikx.rt.api.instance.jei.interfaces.slots.JEIItemSlot;
import ink.ikx.rt.api.instance.jei.interfaces.slots.JEILiquidSlot;
import ink.ikx.rt.api.instance.jei.interfaces.slots.JEISlot;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiFluidStackGroup;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;

@SuppressWarnings("NullableProblems")
public class DynamicRecipesCategory implements IRecipeCategory<DynamicRecipesWrapper> {

    private final String UID;
    private final JEIPanel JEI_PANEL;
    private final IDrawable BACKGROUND;
    private final IDrawable ICON;
    private final List<JEISlot> JEISlotList;
    private final JEITooltip JEITooltip;

    public DynamicRecipesCategory(IGuiHelper guiHelper, JEIPanel JEIPanel) {
        JEIBackground JEIBackground = JEIPanel.getJEIBackground();
        UID = JEIPanel.getUid();

        this.JEITooltip = JEIPanel.getJEITooltip();
        this.JEISlotList = Arrays.asList(JEIPanel.getJEISlots());
        this.JEI_PANEL = JEIPanel;
        this.ICON = guiHelper.createDrawableIngredient(CraftTweakerMC.getItemStack(JEIPanel.getIcon()));

        if (null == JEIBackground.getResourceName() || JEIBackground.getResourceName().isEmpty()) {
            this.BACKGROUND = guiHelper.createBlankDrawable(JEIBackground.getWidth(), JEIBackground.getHeight());
        } else {
            ResourceLocation location = new ResourceLocation(JEIBackground.getResourceName());
            this.BACKGROUND = guiHelper.createDrawable(location, JEIBackground.getU(), JEIBackground.getV(), JEIBackground.getWidth(), JEIBackground.getHeight());
        }
    }

    @Override
    public String getUid() {
        return this.UID;
    }

    @Override
    public String getTitle() {
        return I18n.translateToLocal(this.JEI_PANEL.getLocalizationKey());
    }

    @Override
    public String getModName() {
        return this.JEI_PANEL.getModID();
    }

    @Override
    public IDrawable getBackground() {
        return this.BACKGROUND;
    }

    @Nullable
    @Override
    public IDrawable getIcon() {
        return this.ICON;
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, DynamicRecipesWrapper recipeWrapper,
        IIngredients ingredients) {

        IGuiItemStackGroup group = recipeLayout.getItemStacks();
        IGuiFluidStackGroup fGroup = recipeLayout.getFluidStacks();

        int index = 0;

        for (JEISlot s : JEISlotList) {
            if (s instanceof JEIItemSlot) {
                JEIItemSlot i = (JEIItemSlot) s;
                group.init(index, i.isInput(), i.getX(), i.getY());
            } else if (s instanceof JEILiquidSlot) {
                JEILiquidSlot f = ((JEILiquidSlot) s);
                fGroup.init(index, f.isInput(), f.getX(), f.getY(), f.getWidth(), f.getHeigh(), f.getCapacityMb(), f.isShowCapacity(), null);
            } else {
                CraftTweakerAPI.logError("Type is not supported and you shouldn't goto in here");
            }
            index++;
        }
        group.set(ingredients);
        fGroup.set(ingredients);
    }

    @Override
    public List<String> getTooltipStrings(int mouseX, int mouseY) {
        if (Objects.nonNull(JEITooltip)) {
            return Arrays.asList(JEITooltip.handler(mouseX, mouseY));
        }
        return IRecipeCategory.super.getTooltipStrings(mouseX, mouseY);
    }

    @Override
    public void drawExtras(Minecraft minecraft) {
        for (JEISlot JEISlot : JEISlotList) {
            JEISlot.Render(minecraft);
        }
        for (JEIElement JEIElement : JEI_PANEL.getJEIElements()) {
            JEIElement.Render(minecraft);
        }
    }
}
