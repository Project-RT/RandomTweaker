package ink.ikx.rt.api.mods.cote.manaItem;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.api.mods.cote.function.CanEquip;
import ink.ikx.rt.api.mods.cote.function.CanUnequip;
import ink.ikx.rt.api.mods.cote.function.OnEquipped;
import ink.ikx.rt.api.mods.cote.function.OnUnequipped;
import ink.ikx.rt.api.mods.cote.function.OnWornTick;
import ink.ikx.rt.api.mods.cote.function.WillAutoSync;
import javax.annotation.Nonnull;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import vazkii.botania.api.item.ICosmeticAttachable;
import vazkii.botania.api.item.IPhantomInkable;
import vazkii.botania.common.core.helper.ItemNBTHelper;


/**
 * @author : superhelo
 */

public class ManaRingContent extends ManaItemContent implements IBauble, ICosmeticAttachable, IPhantomInkable {

    public final OnWornTick onWornTick;
    public final OnEquipped onEquipped;
    public final OnUnequipped onUnequipped;
    public final CanEquip canEquip;
    public final CanUnequip canUnequip;
    public final WillAutoSync willAutoSync;

    private static final String TAG_PHANTOM_INK = "phantomInk";
    private static final String TAG_COSMETIC_ITEM = "cosmeticItem";

    public ManaRingContent(ManaRingRepresentation manaBauble) {
        super(manaBauble);
        this.canEquip = manaBauble.canEquip;
        this.canUnequip = manaBauble.canUnequip;
        this.onWornTick = manaBauble.onWornTick;
        this.onEquipped = manaBauble.onEquipped;
        this.onUnequipped = manaBauble.onUnequipped;
        this.willAutoSync = manaBauble.willAutoSync;
    }

    @Override
    public void getSubItems(@Nonnull CreativeTabs tab, @Nonnull NonNullList<ItemStack> stacks) {
        if (isInCreativeTab(tab)) {
            stacks.add(new ItemStack(this));

            if (this.hasFull) {
                ItemStack full = new ItemStack(this);
                setMana(full, this.getMaxMana(full));
                stacks.add(full);
            }
        }
    }

    @Override
    public void onWornTick(ItemStack baubleItem, EntityLivingBase wearer) {
        if (onWornTick != null) {
            onWornTick.handle(CraftTweakerMC.getIItemStack(baubleItem), CraftTweakerMC.getIEntityLivingBase(wearer));
        }
    }

    @Override
    public void onEquipped(ItemStack baubleItem, EntityLivingBase wearer) {
        if (onEquipped != null) {
            onEquipped.handle(CraftTweakerMC.getIItemStack(baubleItem), CraftTweakerMC.getIEntityLivingBase(wearer));
        }

    }

    @Override
    public void onUnequipped(ItemStack baubleItem, EntityLivingBase wearer) {
        if (onUnequipped != null) {
            onUnequipped.handle(CraftTweakerMC.getIItemStack(baubleItem), CraftTweakerMC.getIEntityLivingBase(wearer));
        }

    }

    @Override
    public boolean canEquip(ItemStack baubleItem, EntityLivingBase wearer) {
        if (canEquip != null) {
            return canEquip.handle(CraftTweakerMC.getIItemStack(baubleItem), CraftTweakerMC.getIEntityLivingBase(wearer));
        }
        return true;
    }

    @Override
    public boolean canUnequip(ItemStack baubleItem, EntityLivingBase wearer) {
        if (canUnequip != null) {
            return canUnequip.handle(CraftTweakerMC.getIItemStack(baubleItem), CraftTweakerMC.getIEntityLivingBase(wearer));
        }
        return true;
    }

    @Override
    public boolean willAutoSync(ItemStack baubleItem, EntityLivingBase wearer) {
        if (willAutoSync != null) {
            return willAutoSync.handle(CraftTweakerMC.getIItemStack(baubleItem), CraftTweakerMC.getIEntityLivingBase(wearer));
        }
        return false;
    }

    @Override
    public BaubleType getBaubleType(ItemStack var1) {
        return BaubleType.RING;
    }

    @Override
    public boolean hasPhantomInk(ItemStack stack) {
        return ItemNBTHelper.getBoolean(stack, TAG_PHANTOM_INK, false);
    }

    @Override
    public void setPhantomInk(ItemStack stack, boolean ink) {
        ItemNBTHelper.setBoolean(stack, TAG_PHANTOM_INK, ink);
    }

    @Override
    public ItemStack getCosmeticItem(ItemStack stack) {
        NBTTagCompound cmp = ItemNBTHelper.getCompound(stack, TAG_COSMETIC_ITEM, true);
        if (cmp == null) {
            return ItemStack.EMPTY;
        }
        return new ItemStack(cmp);
    }

    @Override
    public void setCosmeticItem(ItemStack stack, ItemStack cosmetic) {
        NBTTagCompound cmp = new NBTTagCompound();
        if (!cosmetic.isEmpty()) {
            cmp = cosmetic.writeToNBT(cmp);
        }
        ItemNBTHelper.setCompound(stack, TAG_COSMETIC_ITEM, cmp);
    }
}