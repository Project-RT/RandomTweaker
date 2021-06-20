package ink.ikx.rt.impl.jei;

import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.api.instance.jei.JEIExpansion;
import ink.ikx.rt.api.instance.jei.interfaces.JEIPanel;
import ink.ikx.rt.api.instance.jei.interfaces.JEIRecipe;
import ink.ikx.rt.impl.botania.module.ModHydroangeas;
import ink.ikx.rt.impl.jei.impl.JEIRecipeImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import vazkii.botania.common.block.ModBlocks;
import vazkii.botania.common.item.block.ItemBlockSpecialFlower;
import vazkii.botania.common.lib.LibBlockNames;

public class Hydroangeas {

    public static void init() {
        JEIPanel JH = JEIExpansion
            .createJEIPanel("randomtweaker.jei_hydroangeas", "randomtweaker.jei_hydroangeas");
        JH.setJEIBackGroup(JEIExpansion
            .createJEIBackground("randomtweaker:textures/gui/jei/hydroangeas.png", 0, 0, 98, 55));
        JH.setIcon(CraftTweakerMC
            .getIItemStack(ItemBlockSpecialFlower.ofType(LibBlockNames.SUBTILE_HYDROANGEAS)));
        JH.addRecipeCatalyst(CraftTweakerMC
            .getIItemStack(ItemBlockSpecialFlower.ofType(LibBlockNames.SUBTILE_HYDROANGEAS)));
        JH.addRecipeCatalyst(CraftTweakerMC.getIItemStack(ItemBlockSpecialFlower
            .ofType(new ItemStack(ModBlocks.floatingSpecialFlower),
                LibBlockNames.SUBTILE_HYDROANGEAS)));
        JH.addJEISlot(JEIExpansion.createItemSlot(true, 5, 33, false));
        JH.addJEISlot(JEIExpansion.createLiquidSlot(true, 77, 9, false));
        JH.addJEISlot(JEIExpansion.createLiquidSlot(true, 77, 34, false));
        JH.setJEIRecipes(getHydroangeasRecipes().toArray(new JEIRecipe[0]));
        if (!ModHydroangeas.blockFactorList.isEmpty()) {
            JH.register();
        }
    }

    private static List<JEIRecipeImpl> getHydroangeasRecipes() {
        List<JEIRecipeImpl> jeiRecipes = new ArrayList<>();
        for (Map.Entry<IItemStack, Double> entry : ModHydroangeas.blockFactorList.entrySet()) {
            for (ModHydroangeas.HydroangeasHandler handler : ModHydroangeas.handlerList) {
                IItemStack blockBelow = entry.getKey();
                FluidStack blockInput = new FluidStack(
                    FluidRegistry.lookupFluidForBlock(handler.getBlockLiquid()), 1000);
                FluidStack fluidFactor = new FluidStack(
                    FluidRegistry.lookupFluidForBlock(ModHydroangeas.fluidFactor), 1000);
                IIngredient[] input = new IIngredient[]{
                    CraftTweakerMC.getIIngredient(blockInput),
                    CraftTweakerMC.getIIngredient(fluidFactor),
                    blockBelow
                };
                jeiRecipes.add(new JEIRecipeImpl(input));
            }
        }
        return jeiRecipes;
    }

}
