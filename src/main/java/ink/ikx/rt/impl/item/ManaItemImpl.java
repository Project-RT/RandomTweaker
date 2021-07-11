package ink.ikx.rt.impl.item;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IWorld;
import ink.ikx.rt.api.instance.item.ManaItem;
import ink.ikx.rt.api.mods.cote.item.ManaItemContent;
import net.minecraft.item.ItemStack;
import vazkii.botania.common.core.helper.ItemNBTHelper;

/**
 * @author superhelo
 */
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
        return itemIn.manaItem.hasFull();
    }

    @Override
    public boolean hasCreative() {
        return itemIn.manaItem.hasCreative();
    }

    @Override
    public boolean canExportManaToPool(IWorld world, IBlockPos pos) {
        return itemIn.manaItem.canExportManaToPool.handle(CraftTweakerMC.getIItemStack(stack), world, pos);
    }

    @Override
    public boolean canExportManaToItem(IItemStack otherStack) {
        return itemIn.manaItem.canExportManaToItem.handle(CraftTweakerMC.getIItemStack(stack), otherStack);
    }

    @Override
    public boolean canReceiveManaFromPool(IWorld world, IBlockPos pos) {
        return itemIn.manaItem.canReceiveManaFromPool.handle(CraftTweakerMC.getIItemStack(stack), world, pos);
    }

    @Override
    public boolean canReceiveManaFromItem(IItemStack otherStack) {
        return itemIn.manaItem.canReceiveManaFromItem.handle(CraftTweakerMC.getIItemStack(stack), otherStack);
    }
}
