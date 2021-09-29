package ink.ikx.rt.impl.jei;

import java.util.ArrayList;
import java.util.List;

import crafttweaker.api.item.IIngredient;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.api.mods.jei.JEIExpansion;
import ink.ikx.rt.api.mods.jei.interfaces.element.JEIManaBarElement;
import ink.ikx.rt.api.mods.jei.interfaces.other.JEIPanel;
import ink.ikx.rt.api.mods.jei.interfaces.other.JEIRecipe;
import ink.ikx.rt.api.mods.jei.interfaces.other.JEITooltip;
import ink.ikx.rt.impl.botania.module.ModHydroangeas;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import vazkii.botania.common.block.ModBlocks;
import vazkii.botania.common.item.block.ItemBlockSpecialFlower;
import vazkii.botania.common.lib.LibBlockNames;

public class HydroangeasJEI {

    public static void init() {
        JEIPanel JH = JEIExpansion.createJEIPanel("randomtweaker.jei_hydroangeas", "randomtweaker.jei_hydroangeas");
        JH.setJEIBackGroup(JEIExpansion.createJEIBackground("randomtweaker:textures/gui/jei/hydroangeas.png", 0, 0, 105, 64));
        JH.setIcon(CraftTweakerMC.getIItemStack(ItemBlockSpecialFlower.ofType(LibBlockNames.SUBTILE_HYDROANGEAS)));
        JH.addRecipeCatalyst(CraftTweakerMC.getIItemStack(ItemBlockSpecialFlower.ofType(LibBlockNames.SUBTILE_HYDROANGEAS)));
        JH.addRecipeCatalyst(CraftTweakerMC.getIItemStack(ItemBlockSpecialFlower.ofType(new ItemStack(ModBlocks.floatingSpecialFlower), LibBlockNames.SUBTILE_HYDROANGEAS)));
        JH.addJEISlot(JEIExpansion.createLiquidSlot(true, 77, 9, false));
        JH.addJEISlot(JEIExpansion.createLiquidSlot(true, 77, 34, false));
        if (!ModHydroangeas.blockFactorList.isEmpty() && !ModHydroangeas.handlerList.isEmpty()) {
            JH.register();
            getHydroangeasRecipes();
        }
    }

    private static void getHydroangeasRecipes() {
        for (ModHydroangeas.HydroangeasHandler handler : ModHydroangeas.handlerList) {
            FluidStack blockInput = new FluidStack(
                FluidRegistry.lookupFluidForBlock(handler.getBlockLiquid()), 1000);

            int mana = handler.getManaGen() * ModHydroangeas.burnTime;
            JEIManaBarElement manaBar = JEIExpansion.createJEIManaBarElement(2, 60, mana, 1);
            JEITooltip tooltip = new JEITooltip() {
                @Override
                public String[] handler(int mouseX, int mouseY) {
                    List<String> text = new ArrayList<>();
                    if (
                        mouseX >= 2 && mouseX <= 103 &&
                        mouseY >= 60 && mouseY <= 64
                    ) {
                        text.add("mana: " + mana);
                    }
                    return text.toArray(new String[0]);
                }
            };
            // JEIFontInfoElement factorInfo = JEIExpansion.createJEIFontInfoElement(52, 32, "x" + handler.getFluidFactor(), 0x000000, 0, 0);
            IIngredient iBlockInput = CraftTweakerMC.getIIngredient(blockInput);

            JEIRecipe recipe = JEIExpansion.createJEIRecipe("randomtweaker.jei_hydroangeas")
                               .addInput(iBlockInput)
                               .addJEIElement(manaBar)
                               .onJEITooltip(tooltip);
            // .addJEIElement(factorInfo)
            if (handler.getBlockLiquidCatalyst() != Blocks.AIR) {
                FluidStack fluidFactor = new FluidStack(FluidRegistry.lookupFluidForBlock(handler.getBlockLiquidCatalyst()), 1000);
                IIngredient iFluidFactor = CraftTweakerMC.getIIngredient(fluidFactor);
                recipe.addInput(iFluidFactor);
            }

            recipe.build();
        }
    }

}
