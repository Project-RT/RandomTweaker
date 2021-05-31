package com.ikexing.randomtweaker.impl.utils;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

import java.util.Objects;

/**
 * @author ikexing
 */
public class ItemDs {

    public final Item item;
    public final int meta;
    public final DamageSource damageSource;

    public ItemDs(ItemStack item, DamageSource damageSource) {
        this.item = item.getItem();
        this.meta = item.getMetadata();
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
        return meta == itemDs.meta && item == itemDs.item && Objects.equals(damageSource.getDamageType(), itemDs.damageSource.getDamageType());
    }

    @Override
    public int hashCode() {
        return item.getDefaultInstance().getDisplayName().hashCode() + meta + damageSource.getDamageType().hashCode();
    }

    @Override
    public String toString() {
        return "ItemDs{" +
                "item=" + Objects.requireNonNull(item.getRegistryName()).getNamespace() + Objects.requireNonNull(item.getRegistryName()).getPath() +
                ", meta=" + meta +
                ", damageSource=" + damageSource.getDamageType() +
                '}';
    }
}
