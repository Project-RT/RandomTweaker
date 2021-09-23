package ink.ikx.rt.impl.mods.jei;

import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.Main;
import ink.ikx.rt.impl.mods.jei.impl.core.MCJeiPanel;
import ink.ikx.rt.impl.mods.jei.impl.core.MCJeiRecipe;
import ink.ikx.rt.impl.mods.jei.recipe.DynamicRecipesCategory;
import ink.ikx.rt.impl.mods.jei.recipe.DynamicRecipesWrapper;
import mezz.jei.Internal;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.gui.GuiHelper;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.stream.Collectors;

@JEIPlugin
@ParametersAreNonnullByDefault
public class JeiPlugin implements IModPlugin {

    public static final String DEFAULT_TEXTURE = "randomtweaker:textures/gui/jei/jei_default.png";

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        GuiHelper guiHelper = Internal.getHelpers().getGuiHelper();
        Main.JEI_PANEL_SET.forEach(p -> registry.addRecipeCategories(new DynamicRecipesCategory(guiHelper, (MCJeiPanel) p)));
    }

    @Override
    public void register(IModRegistry registry) {
        Main.JEI_PANEL_SET.forEach(p -> {
            MCJeiPanel panel = (MCJeiPanel) p;
            panel.recipeCatalysts.forEach(c -> registry.addRecipeCatalyst(CraftTweakerMC.getItemStack(c), panel.uid));
            List<MCJeiRecipe> recipeList = Main.JEI_RECIPE_SET.stream()
                    .filter(r -> r.getUid().equals(panel.uid))
                    .map(r -> (MCJeiRecipe) r)
                    .collect(Collectors.toList());
            registry.addRecipes(recipeList.stream().map(DynamicRecipesWrapper::new).collect(Collectors.toList()), panel.uid);
        });
    }

}