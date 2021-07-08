package ink.ikx.rt.impl.item;

import ink.ikx.rt.api.instance.item.ManaItem;
import ink.ikx.rt.api.mods.cote.item.ManaItemContent;
import net.minecraft.item.ItemStack;
import vazkii.botania.common.core.helper.ItemNBTHelper;

public class ManaItemImpl implements ManaItem {

    public final ItemStack stack;
    private final ManaItemContent itemIn;

    public ManaItemImpl(ItemStack stack) {
        this.stack = stack;
        this.itemIn = (ManaItemContent) stack.getItem();
    }

    @Override
    public int updateMana(int mana) {
        int originalMana = this.getMana();
        itemIn.addMana(stack, mana);

        if (itemIn.getMana(stack) < 0) {
            ItemNBTHelper.setInt(stack, "mana", 0);
            return -originalMana;
        }

        return (this.getMana() - originalMana);
    }

    @Override
    public int getMana() {
        return itemIn.getMana(stack);
    }

    @Override
    public int getMaxMana() {
        return itemIn.getMaxMana(stack);
    }

    @Override
    public boolean isNoExport() {
        return itemIn.isNoExport(stack);
    }

    @Override
    public boolean hasFull() {
        return itemIn.hasFull;
    }

    @Override
    public boolean hasCreative() {
        return itemIn.hasCreative;
    }

    @Override
    public boolean canExportManaToPool() {
        return itemIn.canExportManaToPool;
    }

    @Override
    public boolean canExportManaToItem() {
        return itemIn.canExportManaToItem;
    }

    @Override
    public boolean canReceiveManaFromPool() {
        return !ItemNBTHelper.getBoolean(stack, "oneUse", false) && itemIn.canReceiveManaFromPool;
    }

    @Override
    public boolean canReceiveManaFromItem() {
        return !itemIn.isCreative(stack) && itemIn.canReceiveManaFromItem;
    }
}
