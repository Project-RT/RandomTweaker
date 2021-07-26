package ink.ikx.rt.api.mods.cote.item;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.RandomTweaker;
import java.util.Objects;
import javax.annotation.Nonnull;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import vazkii.botania.api.item.IBaubleRender;
import vazkii.botania.api.item.ICosmeticAttachable;
import vazkii.botania.api.item.IPhantomInkable;
import vazkii.botania.common.core.helper.ItemNBTHelper;
import youyihj.zenutils.api.cotx.annotation.ExpandContentTweakerEntry;

/**
 * @author superhelo
 */
@ExpandContentTweakerEntry
public class ManaBaubleContent extends ManaItemContent implements IBauble, ICosmeticAttachable, IPhantomInkable, IBaubleRender {

    public BaubleType baubleType;
    public final ManaBaubleRepresentation manaBauble;

    private static final String TAG_PHANTOM_INK = "phantomInk";
    private static final String TAG_COSMETIC_ITEM = "cosmeticItem";

    public ManaBaubleContent(ManaBaubleRepresentation manaBauble) {
        super(manaBauble);
        this.manaBauble = manaBauble;
        this.baubleType = BaubleType.valueOf(manaBauble.getBaubleType());
    }

    @ExpandContentTweakerEntry.RepresentationGetter
    public ManaBaubleRepresentation getRepresentation() {
        return manaBauble;
    }

    @Override
    public void onPlayerBaubleRender(ItemStack stack, EntityPlayer player, RenderType type, float partialTicks) {
        if (Objects.nonNull(this.manaBauble.onPlayerBaubleRender)) {
            RandomTweaker.proxy.onPlayerBaubleRender(this.manaBauble.onPlayerBaubleRender, CraftTweakerMC.getIItemStack(stack), CraftTweakerMC.getIPlayer(player), type.toString(), partialTicks);
        }
    }

    @Override
    public BaubleType getBaubleType(ItemStack var1) {
        if (Objects.nonNull(this.baubleType)) {
            return baubleType;
        }
        return BaubleType.RING;
    }

    @Override
    public boolean canExportManaToItem(ItemStack stack, ItemStack otherStack) {
        return this.baubleType != BaubleType.TRINKET && super.canExportManaToItem(stack, otherStack);
    }

    @Override
    public void onWornTick(ItemStack baubleItem, EntityLivingBase wearer) {
        if (Objects.nonNull(this.manaBauble.onWornTick)) {
            this.manaBauble.onWornTick.handle(CraftTweakerMC.getIItemStack(baubleItem), CraftTweakerMC.getIEntityLivingBase(wearer));
        }
    }

    @Override
    public void onEquipped(ItemStack baubleItem, EntityLivingBase wearer) {
        if (Objects.nonNull(this.manaBauble.onEquipped)) {
            this.manaBauble.onEquipped.handle(CraftTweakerMC.getIItemStack(baubleItem), CraftTweakerMC.getIEntityLivingBase(wearer));
        }
    }

    @Override
    public void onUnequipped(ItemStack baubleItem, EntityLivingBase wearer) {
        if (Objects.nonNull(this.manaBauble.onUnequipped)) {
            this.manaBauble.onUnequipped.handle(CraftTweakerMC.getIItemStack(baubleItem), CraftTweakerMC.getIEntityLivingBase(wearer));
        }
    }

    @Override
    public boolean canEquip(ItemStack baubleItem, EntityLivingBase wearer) {
        return !Objects.nonNull(this.manaBauble.canEquip) || this.manaBauble.canEquip.handle(CraftTweakerMC.getIItemStack(baubleItem), CraftTweakerMC.getIEntityLivingBase(wearer));
    }

    @Override
    public boolean canUnequip(ItemStack baubleItem, EntityLivingBase wearer) {
        return !Objects.nonNull(this.manaBauble.canUnEquip) || this.manaBauble.canUnEquip.handle(CraftTweakerMC.getIItemStack(baubleItem), CraftTweakerMC.getIEntityLivingBase(wearer));
    }

    @Override
    public boolean willAutoSync(ItemStack baubleItem, EntityLivingBase wearer) {
        return Objects.nonNull(this.manaBauble.willAutoSync) && this.manaBauble.willAutoSync.handle(CraftTweakerMC.getIItemStack(baubleItem), CraftTweakerMC.getIEntityLivingBase(wearer));
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
            cosmetic.writeToNBT(cmp);
        }
        ItemNBTHelper.setCompound(stack, TAG_COSMETIC_ITEM, cmp);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return !getContainerItem(stack).isEmpty();
    }

    @Nonnull
    @Override
    public ItemStack getContainerItem(@Nonnull ItemStack itemStack) {
        return getCosmeticItem(itemStack);
    }
}