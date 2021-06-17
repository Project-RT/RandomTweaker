package com.ikexing.randomtweaker.api.instance.jei.interfaces.slots;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.liquid.ILiquidStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;

@ZenRegister
@ZenClass("mods.randomtweaker.JEILiquidSlot")
public interface JEILiquidSlot extends JEISlot {

    @ZenGetter("liquid")
    ILiquidStack liquid();

}
