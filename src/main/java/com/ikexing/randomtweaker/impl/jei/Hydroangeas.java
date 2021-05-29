package com.ikexing.randomtweaker.impl.jei;

import com.ikexing.randomtweaker.api.jei.JEIExpansion;
import com.ikexing.randomtweaker.api.jei.classes.JEICustom;
import com.ikexing.randomtweaker.api.jei.classes.JEIRecipe;
import com.ikexing.randomtweaker.impl.botania.module.ModHydroangeas;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import vazkii.botania.common.block.ModBlocks;
import vazkii.botania.common.item.block.ItemBlockSpecialFlower;
import vazkii.botania.common.lib.LibBlockNames;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ikexing
 */
public class Hydroangeas {

    public static void init() {
        JEICustom JH = JEIExpansion.create("jei_hydroangeas");
        JH.setJeiBackGroup("randomtweaker", "textures/gui/jei/hydroangeas.png", 98, 55);
        JH.setIcon(CraftTweakerMC.getIItemStack(ItemBlockSpecialFlower.ofType(LibBlockNames.SUBTILE_HYDROANGEAS)));
        JH.addRecipeCatalyst(CraftTweakerMC.getIItemStack(ItemBlockSpecialFlower.ofType(LibBlockNames.SUBTILE_HYDROANGEAS)));
        JH.addRecipeCatalyst(CraftTweakerMC.getIItemStack(ItemBlockSpecialFlower.ofType(new ItemStack(ModBlocks.floatingSpecialFlower), LibBlockNames.SUBTILE_HYDROANGEAS)));
        JH.addJeiSlot(true, "item", 5, 33);
        JH.addJeiSlot(true, "fluid", 77, 9);
        JH.addJeiSlot(true, "fluid", 77, 34);
        JH.setJeiRecipes(getHydroangeasRecipes());
        JH.register();
    }

    private static List<JEIRecipe> getHydroangeasRecipes() {
        List<JEIRecipe> jeiRecipes = new ArrayList<>();
        for (Map.Entry<IItemStack, Double> entry : ModHydroangeas.blockFactorList.entrySet()) {
            for (ModHydroangeas.HydroangeasHandler handler : ModHydroangeas.handlerList) {
                IItemStack blockBelow = entry.getKey();
                FluidStack blockInput = new FluidStack(FluidRegistry.lookupFluidForBlock(handler.getBlockLiquid()), 1000);
                FluidStack fluidFactor = new FluidStack(FluidRegistry.lookupFluidForBlock(ModHydroangeas.fluidFactor), 1000);
                IIngredient[] input = new IIngredient[]{
                        CraftTweakerMC.getIIngredient(blockInput),
                        CraftTweakerMC.getIIngredient(fluidFactor),
                        blockBelow
                };
                jeiRecipes.add(new JEIRecipe(input));
            }
        }
        return jeiRecipes;
    }

}
