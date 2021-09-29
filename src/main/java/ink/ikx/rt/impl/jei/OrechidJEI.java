package ink.ikx.rt.impl.jei;

import crafttweaker.api.block.IBlockState;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.item.IngredientOr;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.mc1120.brackets.BracketHandlerOre;
import ink.ikx.rt.api.mods.jei.JEIExpansion;
import ink.ikx.rt.api.mods.jei.interfaces.other.JEIPanel;
import ink.ikx.rt.impl.botania.module.SubTileOrechidManager;
import java.util.Map;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import vazkii.botania.common.block.ModBlocks;
import vazkii.botania.common.item.block.ItemBlockSpecialFlower;
import vazkii.botania.common.lib.LibBlockNames;

public class OrechidJEI {

    public static void init() {
        JEIPanel JH = JEIExpansion.createJEIPanel("randomtweaker.jei_orechid", "randomtweaker.jei_orechid");
        JH.setJEIBackGroup(JEIExpansion.createJEIBackground(148, 45));
        JH.addJEIElement(JEIExpansion.createJEICustomElement(48, 0, 64, 46, 0, 0, "botania:textures/gui/pureDaisyOverlay.png"));
        JH.setIcon(CraftTweakerMC.getIItemStack(ItemBlockSpecialFlower.ofType(LibBlockNames.SUBTILE_ORECHID)));
        JH.addRecipeCatalyst(CraftTweakerMC.getIItemStack(ItemBlockSpecialFlower.ofType(LibBlockNames.SUBTILE_ORECHID)));
        JH.addRecipeCatalyst(CraftTweakerMC.getIItemStack(ItemBlockSpecialFlower.ofType(new ItemStack(ModBlocks.floatingSpecialFlower), LibBlockNames.SUBTILE_ORECHID)));
        JH.addJEISlot(JEIExpansion.createItemSlot(true, 40, 13, false));
        JH.addJEISlot(JEIExpansion.createItemSlot(true, 70, 13, false));
        JH.addJEISlot(JEIExpansion.createItemSlot(false, 99, 13, false));
        if (!SubTileOrechidManager.oreWeights.isEmpty()) {
            JH.register();
            getOrechidRecipes();
        }
    }

    private static void getOrechidRecipes() {
        SubTileOrechidManager.oreWeights.forEach((k, v) -> {
            IBlockState blockState = CraftTweakerMC.getBlockState(k);
            ItemStack itemStack = new ItemStack(CraftTweakerMC.getBlock(blockState.getBlock()), 64, blockState.getMeta());
            IItemStack input = CraftTweakerMC.getIItemStack(itemStack);

            v.forEach((k1, v1) -> {
                if (!OreDictionary.getOres(k1).isEmpty()) {
                    JEIExpansion.createJEIRecipe("randomtweaker.jei_orechid")
                        .addInput(input)
                        .addInput(CraftTweakerMC.getIItemStack(ItemBlockSpecialFlower.ofType(LibBlockNames.SUBTILE_ORECHID)))
                        .addOutput(getOutPut(v, k1, v1))
                        .build();
                }
            });
        });
    }

    private static IIngredient getOutPut(Map<String, Integer> map, String k, Integer v) {
        return BracketHandlerOre.getOre(k).getItems().stream()
            .map(i -> (IIngredient) i.amount(getInputAmount(map, v)))
            .reduce(IngredientOr::new)
            .orElse(BracketHandlerOre.getOre(k));
    }

    private static int getInputAmount(Map<String, Integer> map, Integer weight) {
        return Math.max(1, Math.round((float) weight * 64 / (map.values().stream().reduce(Integer::sum)).orElse(weight * 64 * 64)));
    }
}