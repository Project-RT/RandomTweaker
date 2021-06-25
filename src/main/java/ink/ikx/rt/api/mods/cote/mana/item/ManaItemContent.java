package ink.ikx.rt.api.mods.cote.mana.item;

import com.teamacronymcoders.contenttweaker.modules.vanilla.items.ItemContent;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import vazkii.botania.api.mana.ICreativeManaProvider;
import vazkii.botania.api.mana.IManaItem;
import vazkii.botania.api.mana.IManaTooltipDisplay;
import vazkii.botania.common.core.helper.ItemNBTHelper;

/*
 * @author : superhelo
 */

public class ManaItemContent extends ItemContent implements IManaItem, ICreativeManaProvider, IManaTooltipDisplay {

    private static final String TAG_MANA = "mana";
    public final int maxMana;
    public boolean isNoExport = false;
    public boolean isCreative = false;
    public boolean canExportManaToPool = true;
    public boolean canExportManaToItem = true;
    public boolean canReceiveManaFromPool = true;
    public boolean canReceiveManaFromItem = true;

    public ManaItemContent(ManaItemRepresentation manaItem) {
        super(manaItem);
        this.maxMana = manaItem.getMaxMana();
    }

    public static void setMana(ItemStack stack, int mana) {
        ItemNBTHelper.setInt(stack, TAG_MANA, mana);
    }

    @Override
    public int getMana(ItemStack stack) {
        return ItemNBTHelper.getInt(stack, TAG_MANA, 0);
    }

    @Override
    public int getMaxMana(ItemStack stack) {
        return isCreative ? maxMana + 1000 : maxMana;
    }


    @Override
    public void addMana(ItemStack stack, int mana) {
        if (!isCreative) {
            setMana(stack, Math.min(getMana(stack) + mana, maxMana));
        }
    }


    @Override
    public boolean canReceiveManaFromPool(ItemStack stack, TileEntity pool) {
        return !isCreative(stack) && canReceiveManaFromPool;
    }


    @Override
    public boolean canReceiveManaFromItem(ItemStack stack, ItemStack otherStack) {
        return !isCreative(stack) && canReceiveManaFromItem;
    }


    @Override
    public boolean canExportManaToPool(ItemStack stack, TileEntity pool) {
        return canExportManaToPool;
    }


    @Override
    public boolean canExportManaToItem(ItemStack stack, ItemStack otherStack) {
        return canExportManaToItem;
    }


    @Override
    public boolean isNoExport(ItemStack stack) {
        return isNoExport;
    }


    @Override
    public boolean isCreative(ItemStack stack) {
        return isCreative;
    }

    @Override
    public float getManaFractionForDisplay(ItemStack stack) {
        return (float) getMana(stack) / (float) getMaxMana(stack);
    }

    @Override
    public int getEntityLifespan(ItemStack itemStack, World world) {
        return Integer.MAX_VALUE;
    }
}