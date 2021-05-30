package com.ikexing.randomtweaker.api.item;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethodStatic;

import static com.ikexing.randomtweaker.RandomTweaker.noBurnItems;

/**
 * @author ikexing
 */
@ZenRegister
@ZenExpansion("crafttweaker.item.IItemStack")
public class IItemStackExpansion {

    @ZenMethodStatic
    public static void addNoBurn(IItemStack stack) {
        noBurnItems.putIfAbsent(CraftTweakerMC.getItemStack(stack).getItem(), stack.getMetadata());
    }

    @ZenMethodStatic
    public static void removeNoBurn(IItemStack stack) {
        noBurnItems.remove(CraftTweakerMC.getItemStack(stack).getItem(), stack.getMetadata());
    }
}
