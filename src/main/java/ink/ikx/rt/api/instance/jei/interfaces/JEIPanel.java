package ink.ikx.rt.api.instance.jei.interfaces;

import ink.ikx.rt.api.instance.jei.interfaces.slots.JEISlot;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("mods.randomtweaker.JEIPanel")
public interface JEIPanel {

    @ZenGetter("uid")
    String getUid();

    @ZenGetter("localizationKey")
    String getLocalizationKey();

    @ZenGetter("modid")
    String getModID();

    @ZenGetter("icon")
    IItemStack getIcon();

    @ZenGetter("JEIBackground")
    JEIBackground getJEIBackground();

    @ZenGetter("recipeCatalysts")
    IItemStack[] getRecipeCatalysts();

    @ZenGetter("JEISlots")
    JEISlot[] getJEISlots();

    @ZenGetter("JEIInputRecipes")
    IIngredient[] getJEIInputRecipes();

    @ZenGetter("JEIOutputRecipes")
    IIngredient[] getJEIOutputRecipes();

    @ZenMethod
    void setModID(String modid);

    @ZenMethod
    void setIcon(IItemStack icon);

    @ZenMethod
    void setJEIBackGroup(JEIBackground JEIBackground);

    @ZenMethod
    void setJEIBackGroup(int width, int heigh);

    @ZenMethod
    void setJEISlots(JEISlot[] JEISlots);

    @ZenMethod
    void setRecipeCatalysts(IItemStack[] recipeCatalysts);

    @ZenMethod
    void setJEIInputRecipes(IIngredient[] inputs);

    @ZenMethod
    void setJEIOutputRecipes(IIngredient[] outputs);

    @ZenMethod
    void setJEIRecipe(IIngredient[] inputs, IIngredient[] outputs);

    @ZenMethod
    void addJEISlot(JEISlot JEIISlot);

    @ZenMethod
    void addRecipeCatalyst(IItemStack recipeCatalyst);

    @ZenMethod
    void addJEIRecipe(IIngredient input, IIngredient output);

    @ZenMethod
    void register();

}
