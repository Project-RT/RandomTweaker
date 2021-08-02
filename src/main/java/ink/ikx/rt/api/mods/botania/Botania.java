package ink.ikx.rt.api.mods.botania;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.mc1120.brackets.BracketHandlerOre;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.recipe.RecipeElvenTrade;

@ZenRegister
@ModOnly("botania")
@ZenClass("mods.randomtweaker.botania.Botania")
public class Botania {

    @ZenMethod
    public static Map<IIngredient[], IItemStack[]> getElvenTradeRecipes() {
        Map<IIngredient[], IItemStack[]> recipes = new HashMap<>();
        for (RecipeElvenTrade recipe : BotaniaAPI.elvenTradeRecipes) {
            List<IIngredient> tempInput = new ArrayList<>();
            for (Object input : recipe.getInputs()) {
                if (input instanceof String) {
                    tempInput.add(BracketHandlerOre.getOre((String) input));
                } else {
                    tempInput.add(CraftTweakerMC.getIItemStack((ItemStack) input));
                }
            }
            recipes.put(tempInput.toArray(new IIngredient[0]), CraftTweakerMC.getIItemStacks(recipe.getOutputs()));
        }
        return recipes;
    }

}
