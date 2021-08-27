package ink.ikx.rt.api.mods.cote.mana.item;

import com.teamacronymcoders.base.registrysystem.ItemRegistry;
import com.teamacronymcoders.contenttweaker.ContentTweaker;
import com.teamacronymcoders.contenttweaker.modules.vanilla.items.ItemRepresentation;
import ink.ikx.rt.api.mods.cote.function.mana.ManaWithItem;
import ink.ikx.rt.api.mods.cote.function.mana.ManaWithPool;
import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;

/**
 * @author superhelo
 */
@RTRegisterClass({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.ManaItem")
public class ManaItemRepresentation extends ItemRepresentation {

    @ZenProperty
    public boolean hasFull;
    @ZenProperty
    public boolean isNoExport;
    @ZenProperty
    public boolean hasCreative;
    @ZenProperty
    public int maxMana = 500000;
    @ZenProperty
    public int maxItemUseDuration;
    @ZenProperty
    public ManaWithPool canExportManaToPool;
    @ZenProperty
    public ManaWithItem canExportManaToItem;
    @ZenProperty
    public ManaWithPool canReceiveManaFromPool;
    @ZenProperty
    public ManaWithItem canReceiveManaFromItem;

    public ManaItemRepresentation(String unlocalizedName, int maxMana) {
        this.setUnlocalizedName(unlocalizedName);
        this.setMaxMana(maxMana);
        this.setMaxStackSize(1);
    }

    @ZenMethod
    public ManaWithPool getCanExportManaToPool() {
        return canExportManaToPool;
    }

    @ZenMethod
    public void setCanExportManaToPool(ManaWithPool canExportManaToPool) {
        this.canExportManaToPool = canExportManaToPool;
    }

    @ZenMethod
    public ManaWithItem getCanExportManaToItem() {
        return canExportManaToItem;
    }

    @ZenMethod
    public void setCanExportManaToItem(ManaWithItem canExportManaToItem) {
        this.canExportManaToItem = canExportManaToItem;
    }

    @ZenMethod
    public ManaWithPool getCanReceiveManaFromPool() {
        return canReceiveManaFromPool;
    }

    @ZenMethod
    public void setCanReceiveManaFromPool(ManaWithPool canReceiveManaFromPool) {
        this.canReceiveManaFromPool = canReceiveManaFromPool;
    }

    @ZenMethod
    public ManaWithItem getCanReceiveManaFromItem() {
        return canReceiveManaFromItem;
    }

    @ZenMethod
    public void setCanReceiveManaFromItem(ManaWithItem canReceiveManaFromItem) {
        this.canReceiveManaFromItem = canReceiveManaFromItem;
    }

    @ZenMethod
    public int getMaxItemUseDuration() {
        return maxItemUseDuration;
    }

    @ZenMethod
    public void setMaxItemUseDuration(int maxItemUseDuration) {
        this.maxItemUseDuration = maxItemUseDuration;
    }

    @ZenMethod
    public boolean hasCreative() {
        return hasCreative;
    }

    @ZenMethod
    public void setHasCreative(boolean hasCreative) {
        this.hasCreative = hasCreative;
    }

    @ZenMethod
    public boolean hasFull() {
        return hasFull;
    }

    @ZenMethod
    public void setHasFull(boolean hasFull) {
        this.hasFull = hasFull;
    }

    @ZenMethod
    public int getMaxMana() {
        return maxMana;
    }

    @ZenMethod
    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    @ZenMethod
    public boolean isNoExport() {
        return isNoExport;
    }

    @ZenMethod
    public void setNoExport(boolean isNoExport) {
        this.isNoExport = isNoExport;
    }

    @Override
    public String getTypeName() {
        return "ManaItem";
    }

    @Override
    public void register() {
        ContentTweaker.instance.getRegistry(ItemRegistry.class, "ITEM").register(new ManaItemContent(this));
    }
}
