package ink.ikx.rt.api.internal.item;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.Objects;

@ZenExpansion("crafttweaker.item.IItemStack")
@ZenClass("mods.randomtweaker.vanilla.IItemStack")
public abstract class IItemStackExpansion {

    @ZenMethod
    public static int getTagSize(IItemStack stack) {
        ItemStack mcStack = CraftTweakerMC.getItemStack(stack);
        if (mcStack.hasTagCompound()) {
            return Objects.requireNonNull(mcStack.getTagCompound()).getKeySet().size();
        }
        return 0;
    }

}
