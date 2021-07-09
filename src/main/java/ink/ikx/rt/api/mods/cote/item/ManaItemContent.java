package ink.ikx.rt.api.mods.cote.item;

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
import youyihj.zenutils.api.annotation.ExpandContentTweakerEntry;

/**
 * @author superhelo
 */
@ExpandContentTweakerEntry
public class ManaItemContent extends ItemContent implements IManaItem, ICreativeManaProvider, IManaTooltipDisplay {

    public final ManaItemRepresentation manaItem;

    private static final String TAG_MANA = "mana";
    private static final String TAG_ONE_USE = "oneUse";
    private static final String TAG_CREATIVE = "creative";

    public ManaItemContent(ManaItemRepresentation manaItem) {
        super(manaItem);
        this.manaItem = manaItem;
    }

    @ExpandContentTweakerEntry.RepresentationGetter
    public ManaItemRepresentation getRepresentation() {
        return manaItem;
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
    public void getSubItems(@Nonnull CreativeTabs tab, @Nonnull NonNullList<ItemStack> stacks) {
        if (isInCreativeTab(tab)) {
            stacks.add(new ItemStack(this));

            if (this.manaItem.hasCreative()) {
                ItemStack creative = new ItemStack(this);
                setMana(creative, this.manaItem.getMaxMana());
                setStackCreative(creative);
                stacks.add(creative);
            }

            if (this.manaItem.hasFull()) {
                ItemStack fullPower = new ItemStack(this);
                setMana(fullPower, this.manaItem.getMaxMana());
                stacks.add(fullPower);
            }
        }
    }

    public boolean canReceiveManaFromPool(ItemStack stack) {
        return !ItemNBTHelper.getBoolean(stack, TAG_ONE_USE, false) && this.manaItem.canReceiveManaFromPool();
    }

    public boolean canExportManaToPool() {
        return this.manaItem.canExportManaToPool();
    }

    @Override
    public int getMana(ItemStack stack) {
        return ItemNBTHelper.getInt(stack, TAG_MANA, 0);
    }

    @Override
    public int getMaxMana(ItemStack stack) {
        return this.manaItem.getMaxMana();
    }

    @Override
    public void addMana(ItemStack stack, int mana) {
        if (!isStackCreative(stack)) {
            setMana(stack, Math.min(this.getMana(stack) + mana, this.manaItem.getMaxMana()));
        }
    }

    @Override
    public boolean canReceiveManaFromPool(ItemStack stack, TileEntity pool) {
        return this.canReceiveManaFromPool(stack);
    }

    @Override
    public boolean canReceiveManaFromItem(ItemStack stack, ItemStack otherStack) {
        return !isCreative(stack) && this.manaItem.canReceiveManaFromItem();
    }

    @Override
    public boolean canExportManaToPool(ItemStack stack, TileEntity pool) {
        return this.canExportManaToPool();
    }

    @Override
    public boolean canExportManaToItem(ItemStack stack, ItemStack otherStack) {
        return this.manaItem.canExportManaToItem();
    }

    @Override
    public boolean isNoExport(ItemStack stack) {
        return this.manaItem.isNoExport();
    }

    @Override
    public boolean isCreative(ItemStack stack) {
        return isStackCreative(stack);
    }

    @Override
    public float getManaFractionForDisplay(ItemStack stack) {
        return (float) this.getMana(stack) / (float) this.getMaxMana(stack);
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
        if (this.isCreative(par1ItemStack)) {
            stacks.add(I18n.format("botaniamisc.creative"));
        }
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return !isStackCreative(stack);
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        return 1.0 - this.getManaFractionForDisplay(stack);
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return MathHelper.hsvToRGB(this.getManaFractionForDisplay(stack) / 3.0F, 1.0F, 1.0F);
    }
}