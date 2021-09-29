package ink.ikx.rt.impl.utils;

import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.item.ItemStack;

public class Utils {

    public static boolean areItemStacksEqual(ItemStack stackA, ItemStack stackB) {
        if (stackA.isEmpty() && stackB.isEmpty()) {
            return true;
        } else {
            return !stackA.isEmpty() && !stackB.isEmpty() && isItemStackEqual(stackA, stackB);
        }
    }

    public static boolean isItemStackEqual(ItemStack stackA, ItemStack stackB) {
        if (stackA.getItem() != stackB.getItem()) {
            return false;
        } else if (stackA.getItemDamage() != stackB.getItemDamage()) {
            return false;
        } else if (stackA.getTagCompound() == null && stackB.getTagCompound() != null) {
            return false;
        } else {
            return (stackA.getTagCompound() == null || stackB.getTagCompound() == null || stackA.getTagCompound().equals(stackB.getTagCompound())) && stackA.areCapsCompatible(stackB);
        }
    }

    public static List<ItemStack> getItemStackListCopy(List<ItemStack> items) {
        return items.stream().map(ItemStack::copy).collect(Collectors.toList());
    }
}
