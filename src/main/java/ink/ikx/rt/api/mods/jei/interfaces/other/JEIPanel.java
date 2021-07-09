package ink.ikx.rt.api.mods.jei.interfaces.other;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import ink.ikx.rt.api.mods.jei.interfaces.element.JEIElement;
import ink.ikx.rt.api.mods.jei.interfaces.slots.JEISlot;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenSetter;

@ZenRegister
@ZenClass("mods.randomtweaker.jei.JEIPanel")
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

    @ZenGetter("JEIElements")
    JEIElement[] getJEIElements();

    @ZenSetter("onJEITooltip")
    void setJEITooltip(JEITooltip JEITooltip);

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
    void setJEIElements(JEIElement[] JEIElements);

    @ZenMethod
    void addJEISlot(JEISlot JEIISlot);

    @ZenMethod
    void addRecipeCatalyst(IItemStack recipeCatalyst);

    @ZenMethod
    void addJEIElement(JEIElement JEIElement);

    @ZenMethod
    void register();

    JEITooltip getJEITooltip();

}
