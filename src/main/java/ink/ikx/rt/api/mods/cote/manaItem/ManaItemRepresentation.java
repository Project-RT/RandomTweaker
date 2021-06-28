package ink.ikx.rt.api.mods.cote.manaItem;

import com.teamacronymcoders.base.registrysystem.ItemRegistry;
import com.teamacronymcoders.contenttweaker.ContentTweaker;
import com.teamacronymcoders.contenttweaker.modules.vanilla.items.ItemRepresentation;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;

/**
 * @author : superhelo
 */
@ZenClass("mods.randomtweaker.cote.ManaItem")
public class ManaItemRepresentation extends ItemRepresentation {

    @ZenProperty
    public int maxMana;
    @ZenProperty
    public boolean hasFull = false;
    @ZenProperty
    public boolean isNoExport = false;
    @ZenProperty
    public boolean hasCreative = false;
    @ZenProperty
    public boolean canExportManaToPool = true;
    @ZenProperty
    public boolean canExportManaToItem = true;
    @ZenProperty
    public boolean canReceiveManaFromPool = true;
    @ZenProperty
    public boolean canReceiveManaFromItem = true;

    public ManaItemRepresentation(String unlocalizedName, int maxMana) {
        this.setUnlocalizedName(unlocalizedName);
        this.setMaxMana(maxMana);
        this.setMaxStackSize(1);
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

    @ZenMethod
    public boolean canReceiveManaFromPool() {
        return canReceiveManaFromPool;
    }

    @ZenMethod
    public void setCanReceiveManaFromPool(boolean canReceiveManaFromPool) {
        this.canReceiveManaFromPool = canReceiveManaFromPool;
    }

    @ZenMethod
    public boolean canReceiveManaFromItem() {
        return canReceiveManaFromItem;
    }

    @ZenMethod
    public void setCanReceiveManaFromItem(boolean canReceiveManaFromItem) {
        this.canReceiveManaFromItem = canReceiveManaFromItem;
    }

    @ZenMethod
    public boolean canExportManaToPool() {
        return canExportManaToPool;
    }

    @ZenMethod
    public void setCanExportManaToPool(boolean canExportManaToPool) {
        this.canExportManaToPool = canExportManaToPool;
    }

    @ZenMethod
    public boolean canExportManaToItem() {
        return canExportManaToItem;
    }

    @ZenMethod
    public void setCanExportManaToItem(boolean canExportManaToItem) {
        this.canExportManaToItem = canExportManaToItem;
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
