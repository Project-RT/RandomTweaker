package ink.ikx.rt.api.mods.contenttweaker.mana;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.item.IMutableItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.impl.mods.contenttweaker.mana.bauble.MCManaBauble;
import ink.ikx.rt.impl.mods.contenttweaker.mana.bauble.MCManaBaubleContent;
import ink.ikx.rt.impl.mods.contenttweaker.mana.item.MCManaItem;
import ink.ikx.rt.impl.mods.contenttweaker.mana.item.MCManaItemContent;
import ink.ikx.rt.impl.mods.crafttweaker.ModTotal;
import ink.ikx.rt.impl.mods.crafttweaker.ZenRegister;
import stanhebben.zenscript.annotations.ZenCaster;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

/**
 * @author superhelo
 */
@ZenRegister
@ModTotal({"contenttweaker", "botania"})
@ZenExpansion("crafttweaker.item.IItemStack")
@ZenClass("mods.randomtweaker.botania.IItemStack")
public abstract class IManaHelper {

    @ZenMethod
    public static boolean isIManaItem(IItemStack stack) {
        return CraftTweakerMC.getItemStack(stack).getItem() instanceof MCManaItemContent;
    }

    @ZenMethod
    public static boolean isIManaBauble(IItemStack stack) {
        return CraftTweakerMC.getItemStack(stack).getItem() instanceof MCManaBaubleContent;
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