package ink.ikx.rt.impl.jei;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.RandomTweaker;
import ink.ikx.rt.api.mods.jei.interfaces.other.JEIPanel;
import ink.ikx.rt.api.mods.jei.interfaces.other.JEIRecipe;
import ink.ikx.rt.impl.jei.recipes.DynamicRecipesCategory;
import ink.ikx.rt.impl.jei.recipes.DynamicRecipesWrapper;
import java.util.ArrayList;
import java.util.List;
import mezz.jei.Internal;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.ISubtypeRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.gui.GuiHelper;

@SuppressWarnings("NullableProblems")
@JEIPlugin
public class JEIPlugins implements IModPlugin {

    @Override
    public void registerItemSubtypes(ISubtypeRegistry subtypeRegistry) {
        if (!RandomTweaker.JEIPanelList.isEmpty()) {
            RandomTweaker.logger.info("Custom Jei loading");
        }
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        GuiHelper guiHelper = Internal.getHelpers().getGuiHelper();
        if (!RandomTweaker.JEIPanelList.isEmpty()) {
            for (JEIPanel p : RandomTweaker.JEIPanelList) {
                registry.addRecipeCategories(new DynamicRecipesCategory(guiHelper, p));
            }
        }
    }

    @Override
    public void register(IModRegistry registry) {
        if (!RandomTweaker.JEIPanelList.isEmpty()) {
            for (JEIPanel p : RandomTweaker.JEIPanelList) {
                List<DynamicRecipesWrapper> recipes = new ArrayList<>();
                List<JEIRecipe> jeiRecipeList = new ArrayList<>();
                for (IItemStack c : p.getRecipeCatalysts()) {
                    registry.addRecipeCatalyst(CraftTweakerMC.getItemStack(c), p.getUid());
                }
                for (JEIRecipe jeiRecipe : RandomTweaker.JEIRecipeList) {
                    if (jeiRecipe.getUid().equals(p.getUid())) {
                        jeiRecipeList.add(jeiRecipe);
                    }
                }
                for (JEIRecipe r : jeiRecipeList) {
                    recipes.add(new DynamicRecipesWrapper(r));
                }
                if (!jeiRecipeList.isEmpty()) {
                    registry.addRecipes(recipes, p.getUid());
                }
            }
        }
    }
}
