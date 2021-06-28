package ink.ikx.rt.api.mods.cote.manaItem;

import com.teamacronymcoders.contenttweaker.modules.vanilla.items.ItemContent;
import java.util.List;
import javax.annotation.Nonnull;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vazkii.botania.api.mana.ICreativeManaProvider;
import vazkii.botania.api.mana.IManaItem;
import vazkii.botania.api.mana.IManaTooltipDisplay;
import vazkii.botania.common.core.helper.ItemNBTHelper;

/**
 * @author : superhelo
 */
public class ManaItemContent extends ItemContent implements IManaItem, ICreativeManaProvider, IManaTooltipDisplay {

    public int maxMana;
    public boolean hasFull;
    public boolean isNoExport;
    public boolean hasCreative;
    public boolean canExportManaToPool;
    public boolean canExportManaToItem;
    public boolean canReceiveManaFromPool;
    public boolean canReceiveManaFromItem;

    private static final String TAG_MANA = "mana";
    private static final String TAG_ONE_USE = "oneUse";
    private static final String TAG_CREATIVE = "creative";

    public ManaItemContent(ManaItemRepresentation manaItem) {
        super(manaItem);
        this.hasFull = manaItem.hasFull();
        this.maxMana = manaItem.getMaxMana();
        this.isNoExport = manaItem.isNoExport();
        this.hasCreative = manaItem.hasCreative();
        this.canExportManaToPool = manaItem.canExportManaToPool();
        this.canExportManaToItem = manaItem.canExportManaToItem();
        this.canReceiveManaFromPool = manaItem.canReceiveManaFromPool();
    }

    public static void setMana(ItemStack stack, int mana) {
        ItemNBTHelper.setInt(stack, TAG_MANA, mana);
    }

    public static void setStackCreative(ItemStack stack) {
        ItemNBTHelper.setBoolean(stack, TAG_CREATIVE, true);
    }

    public static boolean isStackCreative(ItemStack stack) {
        return ItemNBTHelper.getBoolean(stack, TAG_CREATIVE, false);
    }

    @Override
    public int getMana(ItemStack stack) {
        return ItemNBTHelper.getInt(stack, TAG_MANA, 0);
    }

    @Override
    public int getMaxMana(ItemStack stack) {
        return maxMana;
    }

    @Override
    public void addMana(ItemStack stack, int mana) {
        if (!isStackCreative(stack)) {
            setMana(stack, Math.min(getMana(stack) + mana, maxMana));
        }
    }

    @Override
    public boolean canReceiveManaFromPool(ItemStack stack, TileEntity pool) {
        return !ItemNBTHelper.getBoolean(stack, TAG_ONE_USE, false) && canReceiveManaFromPool;
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
        return isStackCreative(stack);
    }

    @Override
    public float getManaFractionForDisplay(ItemStack stack) {
        return (float) getMana(stack) / (float) getMaxMana(stack);
    }

    @Override
    public int getEntityLifespan(ItemStack itemStack, World world) {
        return Integer.MAX_VALUE;
    }

    @Override
    public int getDamage(ItemStack stack) {
        if (super.getDamage(stack) != 0) {
            super.setDamage(stack, 0);
        }

        return 0;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack par1ItemStack, World world, List<String> stacks, ITooltipFlag flags) {
        if (isCreative(par1ItemStack)) {
            stacks.add(I18n.format("botaniamisc.creative"));
        }
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return !isStackCreative(stack);
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        return 1.0 - getManaFractionForDisplay(stack);
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return MathHelper.hsvToRGB(getManaFractionForDisplay(stack) / 3.0F, 1.0F, 1.0F);
    }

    @Override
    public void getSubItems(@Nonnull CreativeTabs tab, @Nonnull NonNullList<ItemStack> stacks) {
        if (isInCreativeTab(tab)) {
            stacks.add(new ItemStack(this));

            if (this.hasCreative) {
                ItemStack creative = new ItemStack(this);
                setMana(creative, maxMana);
                setStackCreative(creative);
                stacks.add(creative);
            }

            if (this.hasFull) {
                ItemStack fullPower = new ItemStack(this);
                setMana(fullPower, maxMana);
                stacks.add(fullPower);
            }
        }
    }
}