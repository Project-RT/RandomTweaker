package ink.ikx.rt.api.mods.cote.item;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.api.mods.cote.function.BaubleFunction;
import ink.ikx.rt.api.mods.cote.function.BaubleFunctionWithReturn;
import ink.ikx.rt.api.mods.cote.function.BaubleRender;
import ink.ikx.rt.impl.proxy.CommonProxy;
import java.util.Objects;
import javax.annotation.Nonnull;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.SidedProxy;
import vazkii.botania.api.item.IBaubleRender;
import vazkii.botania.api.item.ICosmeticAttachable;
import vazkii.botania.api.item.ICosmeticBauble;
import vazkii.botania.api.item.IPhantomInkable;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.common.core.helper.ItemNBTHelper;

/**
 * @author : superhelo
 */
public class ManaBaubleContent extends ManaItemContent implements IBauble, ICosmeticAttachable, IPhantomInkable, IBaubleRender {

    @SidedProxy(clientSide = "ink.ikx.rt.impl.proxy.ClientProxy",
        serverSide = "ink.ikx.rt.impl.proxy.SeverProxy")
    public static CommonProxy proxy;
    public final BaubleRender onPlayerBaubleRender;
    public final BaubleFunction onWornTick;
    public final BaubleFunction onEquipped;
    public final BaubleFunction onUnequipped;
    public BaubleType baubleType;
    public final BaubleFunctionWithReturn canEquip;
    public final BaubleFunctionWithReturn canUnEquip;
    public final BaubleFunctionWithReturn willAutoSync;

    private static final String TAG_PHANTOM_INK = "phantomInk";
    private static final String TAG_COSMETIC_ITEM = "cosmeticItem";

    public ManaBaubleContent(ManaBaubleRepresentation manaBauble) {
        super(manaBauble);
        this.canEquip = manaBauble.canEquip;
        this.canUnEquip = manaBauble.canUnEquip;
        this.onWornTick = manaBauble.onWornTick;
        this.onEquipped = manaBauble.onEquipped;
        this.onUnequipped = manaBauble.onUnequipped;
        this.willAutoSync = manaBauble.willAutoSync;
        this.baubleType = BaubleType.valueOf(manaBauble.baubleType);
        this.onPlayerBaubleRender = manaBauble.onPlayerBaubleRender;
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
    public void onPlayerBaubleRender(ItemStack stack, EntityPlayer player, RenderType type, float partialTicks) {
        if (Objects.nonNull(onPlayerBaubleRender)) {
            proxy.onPlayerBaubleRender(onPlayerBaubleRender, CraftTweakerMC.getIItemStack(stack), CraftTweakerMC.getIPlayer(player), type.toString(), partialTicks);
        }
    }

    @Override
    public BaubleType getBaubleType(ItemStack var1) {
        if (Objects.nonNull(baubleType)) {
            return baubleType;
        }
        return BaubleType.RING;
    }

    @Override
    public boolean canExportManaToItem(ItemStack stack, ItemStack otherStack) {
        if (baubleType != BaubleType.RING) {
            return false;
        }
        return super.canExportManaToItem(stack, otherStack);
    }

    @Override
    public void onWornTick(ItemStack baubleItem, EntityLivingBase wearer) {
        if (Objects.nonNull(onWornTick)) {
            onWornTick.handle(CraftTweakerMC.getIItemStack(baubleItem), CraftTweakerMC.getIEntityLivingBase(wearer));
        }
    }

    @Override
    public void onEquipped(ItemStack baubleItem, EntityLivingBase wearer) {
        if (Objects.nonNull(onEquipped)) {
            onEquipped.handle(CraftTweakerMC.getIItemStack(baubleItem), CraftTweakerMC.getIEntityLivingBase(wearer));
        }
    }

    @Override
    public void onUnequipped(ItemStack baubleItem, EntityLivingBase wearer) {
        if (Objects.nonNull(onUnequipped)) {
            onUnequipped.handle(CraftTweakerMC.getIItemStack(baubleItem), CraftTweakerMC.getIEntityLivingBase(wearer));
        }
    }

    @Override
    public boolean canEquip(ItemStack baubleItem, EntityLivingBase wearer) {
        if (Objects.nonNull(canEquip)) {
            return canEquip.handle(CraftTweakerMC.getIItemStack(baubleItem), CraftTweakerMC.getIEntityLivingBase(wearer));
        }
        return true;
    }

    @Override
    public boolean canUnequip(ItemStack baubleItem, EntityLivingBase wearer) {
        if (Objects.nonNull(canUnEquip)) {
            return canUnEquip.handle(CraftTweakerMC.getIItemStack(baubleItem), CraftTweakerMC.getIEntityLivingBase(wearer));
        }
        return true;
    }

    @Override
    public boolean willAutoSync(ItemStack baubleItem, EntityLivingBase wearer) {
        if (Objects.nonNull(willAutoSync)) {
            return willAutoSync.handle(CraftTweakerMC.getIItemStack(baubleItem), CraftTweakerMC.getIEntityLivingBase(wearer));
        }
        return false;
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

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return !getContainerItem(stack).isEmpty();
    }

    @Nonnull
    @Override
    public ItemStack getContainerItem(@Nonnull ItemStack itemStack) {
        return getCosmeticItem(itemStack);
    }

    public class ManaUsingItem extends ManaBaubleContent implements IManaUsingItem {

        public boolean useMana;

        public ManaUsingItem(ManaBaubleRepresentation manaBauble) {
            super(manaBauble);
            this.useMana = manaBauble.isUseMana();
        }

        @Override
        public boolean usesMana(ItemStack stack) {
            if (this.getMana(stack) > 0) {
                return false;
            }
            return useMana;
        }
    }

    public class ManaTrinketContent extends ManaBaubleContent implements ICosmeticBauble {

        public ManaTrinketContent(ManaBaubleRepresentation manaBauble) {
            super(manaBauble);
        }
    }
}