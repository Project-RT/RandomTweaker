package ink.ikx.rt.impl.jei.recipes;

import ink.ikx.rt.api.instance.jei.interfaces.JEIBackground;
import ink.ikx.rt.api.instance.jei.interfaces.JEIPanel;
import crafttweaker.api.minecraft.CraftTweakerMC;
import javax.annotation.Nullable;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;

@SuppressWarnings("NullableProblems")
public class DynamicRecipesCategory implements IRecipeCategory<DynamicRecipesWrapper> {

    private final JEIPanel JEI_PANEL;
    private final IDrawable BACKGROUND;
    private final IDrawable ICON;

    public DynamicRecipesCategory(IGuiHelper guiHelper, JEIPanel JEIPanel) {
        JEIBackground JEIBackground = JEIPanel.getJEIBackground();
        this.JEI_PANEL = JEIPanel;
        this.ICON = guiHelper
            .createDrawableIngredient(CraftTweakerMC.getItemStack(JEIPanel.getIcon()));

        if (null == JEIBackground.getResourceName() || JEIBackground.getResourceName().isEmpty()) {
            this.BACKGROUND = guiHelper
                .createBlankDrawable(JEIBackground.getWidth(), JEIBackground.getHeight());
        } else {
            ResourceLocation location = new ResourceLocation(JEIBackground.getResourceName());
            this.BACKGROUND = guiHelper
                .createDrawable(location, JEIBackground.getU(), JEIBackground.getV(),
                    JEIBackground.getWidth(), JEIBackground.getHeight());
        }
    }

    @Override
    public String getUid() {
        return this.JEI_PANEL.getUid();
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

    }
}
