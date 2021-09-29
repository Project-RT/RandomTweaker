package ink.ikx.rt.api.internal.item;

import crafttweaker.api.damage.IDamageSource;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.impl.utils.ItemDs;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenMethodStatic;

import java.util.Objects;

import static ink.ikx.rt.RandomTweaker.itemDsSet;

@ZenExpansion("crafttweaker.item.IItemStack")
public class IItemStackExpansion {

    @ZenMethodStatic
    public static void addItemDs(IItemStack stack, IDamageSource damageSource) {
        itemDsSet.add(new ItemDs(CraftTweakerMC.getItemStack(stack), CraftTweakerMC.getDamageSource(damageSource)));
    }

    @ZenMethodStatic
    public static void removeItemDs(IItemStack stack, IDamageSource damageSource) {
        itemDsSet.remove(new ItemDs(CraftTweakerMC.getItemStack(stack), CraftTweakerMC.getDamageSource(damageSource)));
    }

    @ZenMethod
    public static int getTagSize(IItemStack stack) {
        ItemStack itemStack = CraftTweakerMC.getItemStack(stack);

        if (itemStack.hasTagCompound()) {
            return Objects.requireNonNull(itemStack.getTagCompound()).getKeySet().size();
        }
        return 0;
    }
}
