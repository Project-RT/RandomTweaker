package ink.ikx.rt.impl.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.item.ItemStack;

public class ItemStackList {

    private List<ItemStack> itemStackList = new ArrayList<>();

    private static boolean areItemStacksEqual(ItemStack stackA, ItemStack stackB) {
        if (stackA.isEmpty() && stackB.isEmpty()) {
            return true;
        } else {
            return !stackA.isEmpty() && !stackB.isEmpty() && isItemStackEqual(stackA, stackB);
        }
    }

    private static boolean isItemStackEqual(ItemStack stackA, ItemStack stackB) {
        if (stackA.getItem() != stackB.getItem()) {
            return false;
        } else if (stackA.getItemDamage() != stackB.getItemDamage()) {
            return false;
        } else if (stackA.getTagCompound() == null && stackB.getTagCompound() != null) {
            return false;
        } else {
            return (stackA.getTagCompound() == null || stackA.getTagCompound().equals(stackB.getTagCompound())) && stackA.areCapsCompatible(stackB);
        }
    }

    public void add(ItemStack stack) {
        if (isInclude(stack) == null) {
            itemStackList.add(stack);
            return;
        }
        itemStackList.stream()
            .filter(l -> areItemStacksEqual(l, stack))
            .peek(stack1 -> stack1.setCount(Math.min(stack1.getCount() + stack.getCount(), 64)))
            .collect(Collectors.toList())
            .stream();
    }

    public void clear() {
        itemStackList.clear();
    }

    public void remove(ItemStack stack) {
        itemStackList.stream()
            .filter(l -> areItemStacksEqual(l, stack))
            .peek(stack1 -> stack1.setCount(Math.max(stack1.getCount() - stack.getCount(), 0)))
            .collect(Collectors.toList());
    }

    public List<ItemStack> getItemStackList() {
        return itemStackList;
    }

    public void setItemStackList(List<ItemStack> itemStackList) {
        this.itemStackList = itemStackList;
    }

    private ItemStack isInclude(ItemStack stack) {
        return itemStackList.stream()
            .filter(l -> areItemStacksEqual(l, stack))
            .findFirst()
            .orElse(null);
    }
}
