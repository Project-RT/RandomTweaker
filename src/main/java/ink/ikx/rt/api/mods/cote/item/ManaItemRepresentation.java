package ink.ikx.rt.api.mods.cote.item;

import com.teamacronymcoders.base.registrysystem.ItemRegistry;
import com.teamacronymcoders.contenttweaker.ContentTweaker;
import com.teamacronymcoders.contenttweaker.modules.vanilla.items.ItemRepresentation;
import ink.ikx.rt.api.mods.cote.function.mana.ManaItemForItemFunction;
import ink.ikx.rt.api.mods.cote.function.mana.ManaItemForPoolFunction;
import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;

/**
 * @author superhelo
 */
@RTRegisterClass({"zenutils", "botania"})
@ZenClass("mods.randomtweaker.cote.ManaItem")
public class ManaItemRepresentation extends ItemRepresentation {

    @ZenProperty
    public int maxMana;
    @ZenProperty
    public boolean hasFull;
    @ZenProperty
    public boolean isNoExport;
    @ZenProperty
    public boolean hasCreative;
    @ZenProperty
    public ManaItemForPoolFunction canExportManaToPool;
    @ZenProperty
    public ManaItemForItemFunction canExportManaToItem;
    @ZenProperty
    public ManaItemForPoolFunction canReceiveManaFromPool;
    @ZenProperty
    public ManaItemForItemFunction canReceiveManaFromItem;

    public ManaItemRepresentation(String unlocalizedName, int maxMana) {
        this.setUnlocalizedName(unlocalizedName);
        this.setMaxMana(maxMana);
        this.setMaxStackSize(1);
    }

    @ZenMethod
    public ManaItemForPoolFunction getCanExportManaToPool() {
        return canExportManaToPool;
    }

    @ZenMethod
    public void setCanExportManaToPool(ManaItemForPoolFunction canExportManaToPool) {
        this.canExportManaToPool = canExportManaToPool;
    }

    @ZenMethod
    public ManaItemForItemFunction getCanExportManaToItem() {
        return canExportManaToItem;
    }

    @ZenMethod
    public void setCanExportManaToItem(ManaItemForItemFunction canExportManaToItem) {
        this.canExportManaToItem = canExportManaToItem;
    }

    @ZenMethod
    public ManaItemForPoolFunction getCanReceiveManaFromPool() {
        return canReceiveManaFromPool;
    }

    @ZenMethod
    public void setCanReceiveManaFromPool(ManaItemForPoolFunction canReceiveManaFromPool) {
        this.canReceiveManaFromPool = canReceiveManaFromPool;
    }

    @ZenMethod
    public ManaItemForItemFunction getCanReceiveManaFromItem() {
        return canReceiveManaFromItem;
    }

    @ZenMethod
    public void setCanReceiveManaFromItem(ManaItemForItemFunction canReceiveManaFromItem) {
        this.canReceiveManaFromItem = canReceiveManaFromItem;
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
