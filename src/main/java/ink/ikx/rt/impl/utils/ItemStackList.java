package ink.ikx.rt.impl.utils;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.item.ItemStack;

public class ItemStackList {

    private List<ItemStack> itemStackList = new ArrayList<>();

    public void add(ItemStack stack) {
        if (isInclude(stack) == null) {
            itemStackList.add(stack);
        } else {
            itemStackList.stream()
                .filter(l -> Utils.areItemStacksEqual(l, stack))
                .forEach(stack1 -> stack1.setCount(Math.min(stack1.getCount() + stack.getCount(), 64)));
        }
    }

    public void clear() {
        itemStackList.clear();
    }

    public void remove(ItemStack stack) {
        itemStackList.stream()
            .filter(l -> Utils.areItemStacksEqual(l, stack))
            .forEach(stack1 -> stack1.setCount(Math.max(stack1.getCount() - stack.getCount(), 0)));
        delZeroCount();
    }

    public List<ItemStack> getItemStackList() {
        return itemStackList;
    }

    public void setItemStackList(List<ItemStack> itemStackList) {
        this.itemStackList = itemStackList;
    }

    private ItemStack isInclude(ItemStack stack) {
        return itemStackList.stream()
            .filter(l -> Utils.areItemStacksEqual(l, stack))
            .findFirst()
            .orElse(null);
    }

    private void delZeroCount() {
        for (int i = 0; i < itemStackList.size(); i++) {
            if (itemStackList.get(i).getCount() == 0) {
                itemStackList.remove(i);
                break;
            }
        }
    }
}
