package com.ikexing.randomtweaker.impl.botania.module;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ikexing, niyan
 */
public class ModHydroangeas {

    public static Block fluidFactor;

    public static List<HydroangeasHandler> handlerList = new ArrayList<>();
    public static Map<IItemStack, Double> blockFactorList = new HashMap();

    public static void setBlockBelowFactor(IItemStack block, double factor) {
        if (block.isItemBlock()) {
            blockFactorList.put(block, factor);
        } else {
            CraftTweakerAPI.getLogger().logError(block + " is not a block.");
        }
    }

    public static void setFluidFactor(ILiquidStack inputFluid) {
        fluidFactor = getBlock(inputFluid);
    }

    public static class HydroangeasHandler {

        ILiquidStack liquidConsume;
        int manaGen;
        double factor;

        public HydroangeasHandler(ILiquidStack input, int manaGen, double factor) {
            this.liquidConsume = input;
            this.manaGen = manaGen;
            this.factor = factor;
        }

        public Block getBlockLiquid() {
            return getBlock(liquidConsume);
        }

        public int getManaGen() {
            return this.manaGen;
        }

        public double getManaFactor() {
            return this.factor;
        }

    }

    public static Block getBlock(ILiquidStack inputFluid) {
        return CraftTweakerMC.getLiquidStack(inputFluid).getFluid().getBlock();
    }
}
