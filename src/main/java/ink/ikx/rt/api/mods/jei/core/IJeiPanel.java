package ink.ikx.rt.api.mods.jei.core;

import crafttweaker.annotations.ModOnly;
import crafttweaker.api.item.IItemStack;
import ink.ikx.rt.api.mods.jei.elements.IJeiElement;
import ink.ikx.rt.api.mods.jei.slots.IJeiSlot;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ModOnly("jei")
@ZenClass("mods.randomtweaker.jei.IJeiPanel")
public interface IJeiPanel {

    @ZenMethod
    IJeiPanel setModid(String modid);

    @ZenMethod
    IJeiPanel setIcon(IItemStack icon);

    @ZenMethod
    IJeiPanel addJeiSlot(IJeiSlot slot);

    @ZenMethod
    IJeiPanel setJeiSlots(IJeiSlot[] slots);

    @ZenMethod
    IJeiPanel setJeiTooltip(IJeiTooltip tooltip);

    @ZenMethod
    IJeiPanel addJeiElement(IJeiElement elements);

    @ZenMethod
    IJeiPanel setJeiElements(IJeiElement[] elements);

    @ZenMethod
    IJeiPanel addRecipeCatalyst(IItemStack stack);

    @ZenMethod
    IJeiPanel setRecipeCatalysts(IItemStack[] stacks);

    @ZenMethod
    IJeiPanel setJeiBackground(IJeiBackground background);

    @ZenMethod
    void register();

}
