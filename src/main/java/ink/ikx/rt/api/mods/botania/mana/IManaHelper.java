package ink.ikx.rt.api.mods.botania.mana;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.item.IMutableItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.impl.mods.botania.mana.MCManaBauble;
import ink.ikx.rt.impl.mods.botania.mana.MCManaItem;
import ink.ikx.rt.impl.mods.contenttweaker.mana.bauble.ManaBaubleContent;
import ink.ikx.rt.impl.mods.contenttweaker.mana.item.ManaItemContent;
import ink.ikx.rt.impl.mods.crafttweaker.ModTotal;
import stanhebben.zenscript.annotations.ZenCaster;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

/**
 * @author superhelo
 */
@ModTotal({"contenttweaker", "botania"})
@ZenExpansion("crafttweaker.item.IItemStack")
public class IManaHelper {

    @ZenMethod
    public static boolean isIManaItem(IItemStack stack) {
        return CraftTweakerMC.getItemStack(stack).getItem() instanceof ManaItemContent;
    }

    @ZenMethod
    public static boolean isIManaBauble(IItemStack stack) {
        return CraftTweakerMC.getItemStack(stack).getItem() instanceof ManaBaubleContent;
    }

    @ZenCaster
    @ZenMethod
    public static IManaItem asIManaItem(IItemStack stack) {
        if (stack instanceof IMutableItemStack) {
            return new MCManaItem(CraftTweakerMC.getItemStack((IMutableItemStack) stack));
        }
        return new MCManaItem(CraftTweakerMC.getItemStack(stack));
    }

    @ZenCaster
    @ZenMethod
    public static IManaBauble asIManaBauble(IItemStack stack) {
        if (stack instanceof IMutableItemStack) {
            return new MCManaBauble(CraftTweakerMC.getItemStack((IMutableItemStack) stack));
        }
        return new MCManaBauble(CraftTweakerMC.getItemStack(stack));
    }
}