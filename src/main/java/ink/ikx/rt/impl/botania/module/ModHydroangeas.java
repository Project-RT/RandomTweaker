package ink.ikx.rt.impl.botania.module;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;

/**
 * @author niyan
 */
public class ModHydroangeas {

    public static List<HydroangeasHandler> handlerList = new ArrayList<>();
    public static Map<IItemStack, Double> blockFactorList = new HashMap<>();
    public static int burnTime = 40;

    public static void setBlockBelowFactor(IItemStack block, double factor) {
        if (block.isItemBlock()) {
            blockFactorList.put(block, factor);
        } else {
            CraftTweakerAPI.getLogger().logError(block + " is not a block.");
        }
    }

    public static void setFluidFactor(ILiquidStack inputFluid, ILiquidStack liquidCat, double factor) {
        for (HydroangeasHandler handler : handlerList) {
            if (handler.liquidConsume.equals(inputFluid)) {
                handler.liquidCatalyst = liquidCat;
                handler.fluidFactor = factor;
            }
        }
    }

    public static class HydroangeasHandler {

        ILiquidStack liquidConsume;
        ILiquidStack liquidCatalyst;
        double fluidFactor;
        int manaGen;

        public HydroangeasHandler(ILiquidStack input, int manaGen, ILiquidStack liquidCatalyst, double factor) {
            this.liquidConsume = input;
            this.manaGen = manaGen;
            this.fluidFactor = factor;
            this.liquidCatalyst = liquidCatalyst;
        }

        public Block getBlockLiquid() {
            return getBlock(liquidConsume);
        }

        public int getManaGen() {
            return this.manaGen;
        }

        public double getFluidFactor() {
            return this.fluidFactor;
        }

        public Block getBlockLiquidCatalyst() {
            return getBlock(liquidCatalyst);
        }

    }

    public static Block getBlock(ILiquidStack inputFluid) {
        return CraftTweakerMC.getLiquidStack(inputFluid).getFluid().getBlock();
    }
}
