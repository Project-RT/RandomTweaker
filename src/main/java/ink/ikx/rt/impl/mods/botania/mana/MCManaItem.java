package ink.ikx.rt.impl.mods.botania.mana;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IWorld;
import ink.ikx.rt.api.mods.botania.mana.IManaItem;
import ink.ikx.rt.impl.mods.contenttweaker.mana.item.MCManaItemContent;
import ink.ikx.rt.impl.mods.contenttweaker.mana.item.tool.MCIsUsesManaItemContent;
import java.util.Objects;
import net.minecraft.item.ItemStack;
import vazkii.botania.common.core.helper.ItemNBTHelper;

/**
 * @author superhelo
 */
public class MCManaItem implements IManaItem {

    protected final ItemStack stack;
    protected final MCManaItemContent itemIn;

    public MCManaItem(ItemStack stack) {
        this.stack = stack.copy();
        this.itemIn = (MCManaItemContent) stack.getItem();
    }

    @Override
    public boolean isCreative() {
        return itemIn.isCreative(stack);
    }

    @Override
    public boolean isFull() {
        return this.getMana() == this.getMaxMana();
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
    public boolean getUseMana() {
        return itemIn instanceof MCIsUsesManaItemContent && ((MCIsUsesManaItemContent) itemIn).usesMana(stack);
    }

    @Override
    public boolean canExportManaToPool(IWorld world, IBlockPos pos) {
        return Objects.isNull(itemIn.manaItem.canExportManaToPool) || itemIn.manaItem.canExportManaToPool.call(CraftTweakerMC.getIItemStack(stack), world, pos);
    }

    @Override
    public boolean canExportManaToItem(IItemStack otherStack) {
        return Objects.isNull(itemIn.manaItem.canExportManaToItem) || itemIn.manaItem.canExportManaToItem.call(CraftTweakerMC.getIItemStack(stack), otherStack);
    }

    @Override
    public boolean canReceiveManaFromPool(IWorld world, IBlockPos pos) {
        return !ItemNBTHelper.getBoolean(stack, "oneUse", false) && (Objects.isNull(itemIn.manaItem.canReceiveManaFromPool) || itemIn.manaItem.canReceiveManaFromPool.call(CraftTweakerMC.getIItemStack(stack), world, pos));
    }

    @Override
    public boolean canReceiveManaFromItem(IItemStack otherStack) {
        return !itemIn.isCreative(stack) && (Objects.isNull(itemIn.manaItem.canReceiveManaFromItem) || itemIn.manaItem.canReceiveManaFromItem.call(CraftTweakerMC.getIItemStack(stack), otherStack));
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

}
