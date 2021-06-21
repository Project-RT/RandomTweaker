package ink.ikx.rt.api.instance.jei.interfaces;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import ink.ikx.rt.api.instance.jei.interfaces.element.JEIElement;
import ink.ikx.rt.api.instance.jei.interfaces.slots.JEISlot;
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

    @ZenGetter("JEIRecipes")
    JEIRecipe[] getJEIRecipes();

    @ZenGetter("JEIElements")
    JEIElement[] getJEIElements();

    @ZenMethod
    void setModID(String modid);

    @ZenMethod
    void setIcon(IItemStack icon);

    @ZenMethod
    void setJEIBackGroup(JEIBackground JEIBackground);

    @ZenMethod
    void setJEIBackGroup(int width, int heigh);

    @ZenMethod
    void setRecipeCatalysts(IItemStack[] recipeCatalysts);

    @ZenMethod
    void setJEISlots(JEISlot[] JEISlots);

    @ZenMethod
    void setJEIRecipes(JEIRecipe[] JEIRecipes);

    @ZenMethod
    void setJEIElements(JEIElement[] JEIElements);

    @ZenMethod
    void addJEISlot(JEISlot JEIISlot);

    @ZenMethod
    void addRecipeCatalyst(IItemStack recipeCatalyst);

    @ZenMethod
    void addJEIRecipe(JEIRecipe JEIRecipe);

    @ZenMethod
    void addJEIElement(JEIElement JEIElement);

    @ZenMethod
    void register();

}
