package com.ikexing.randomtweaker.api.instance.jei.interfaces.slots;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;

@ZenRegister
@ZenClass("mods.randomtweaker.JEIItemSlot")
public interface JEIItemSlot extends JEISlot {

    @ZenGetter("item")
    IItemStack getItem();
}
