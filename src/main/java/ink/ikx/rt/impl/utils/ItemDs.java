package ink.ikx.rt.impl.utils;

import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class ItemDs {

    public final ItemStack item;
    public final DamageSource damageSource;

    public ItemDs(ItemStack item, DamageSource damageSource) {
        this.item = item;
        this.damageSource = damageSource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ItemDs itemDs = (ItemDs) o;
        return ItemStack.areItemStacksEqual(this.item, itemDs.item);
    }

    @Override
    public int hashCode() {
        return item.getItem().getDefaultInstance().getDisplayName().hashCode() + item.getMetadata() + damageSource
            .getDamageType().hashCode();
    }
}
