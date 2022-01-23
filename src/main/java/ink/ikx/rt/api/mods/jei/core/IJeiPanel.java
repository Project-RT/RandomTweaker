package ink.ikx.rt.api.mods.jei.core;

import crafttweaker.annotations.ModOnly;
import crafttweaker.api.item.IItemStack;
import ink.ikx.rt.api.mods.jei.elements.IJeiElement;
import ink.ikx.rt.api.mods.jei.slots.IJeiSlot;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@RTRegister
@ModOnly("jei")
@ZenClass("mods.randomtweaker.jei.IJeiPanel")
public interface IJeiPanel {

    @ZenMethod
    IJeiPanel setModid(String modid);

    @ZenMethod
    IJeiPanel setIcon(IItemStack icon);

    @ZenMethod
    IJeiPanel addSlot(IJeiSlot slot);

    @ZenMethod
    IJeiPanel setSlots(IJeiSlot[] slots);

    @ZenMethod
    IJeiPanel onTooltip(IJeiTooltip tooltip);

    @ZenMethod
    IJeiPanel addElement(IJeiElement elements);

    @ZenMethod
    IJeiPanel setElements(IJeiElement[] elements);

    @ZenMethod
    IJeiPanel addRecipeCatalyst(IItemStack stack);

    @ZenMethod
    IJeiPanel setRecipeCatalysts(IItemStack[] stacks);

    @ZenMethod
    IJeiPanel setBackground(IJeiBackground background);

    @ZenMethod
    IJeiSlot[] getJeiSlots();

    @ZenMethod
    IJeiSlot getJeiSlot(String slotName);

    @ZenMethod
    IJeiElement[] getJeiElements();

    @ZenMethod
    IJeiElement getJeiElement(String elementName);

    @ZenMethod
    void register();

    void register_();
}
