package ink.ikx.rt.api.mods.cote.mana.item;

import com.teamacronymcoders.base.registrysystem.ItemRegistry;
import com.teamacronymcoders.contenttweaker.ContentTweaker;
import com.teamacronymcoders.contenttweaker.modules.vanilla.items.ItemRepresentation;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;

/*
 * @author : superhelo
 */

@ZenClass("mods.randomtweaker.ManaItem")
public class ManaItemRepresentation extends ItemRepresentation {

    @ZenProperty
    final int maxMana;
    @ZenProperty
    boolean isNoExport = false;
    @ZenProperty
    boolean isCreative = false;
    @ZenProperty
    boolean canExportManaToPool = true;
    @ZenProperty
    boolean canExportManaToItem = true;
    @ZenProperty
    boolean canReceiveManaFromPool = true;
    @ZenProperty
    boolean canReceiveManaFromItem = true;

    public ManaItemRepresentation(String unlocalizedName, int maxMana) {
        setUnlocalizedName(unlocalizedName);
        this.maxMana = maxMana;
        this.setMaxStackSize(1);
    }


    @ZenMethod
    public int getMaxMana() {
        return maxMana;
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
    public boolean isCreative() {
        return isCreative;
    }


    @ZenMethod
    public void setCreative(boolean isCreative) {
        this.isCreative = isCreative;
    }


    @ZenMethod
    public boolean isCanReceiveManaFromPool() {
        return canReceiveManaFromPool;
    }


    @ZenMethod
    public void setCanReceiveManaFromPool(boolean canReceiveManaFromPool) {
        this.canReceiveManaFromPool = canReceiveManaFromPool;
    }


    @ZenMethod
    public boolean isCanReceiveManaFromItem() {
        return canReceiveManaFromItem;
    }


    @ZenMethod
    public void setCanReceiveManaFromItem(boolean canReceiveManaFromItem) {
        this.canReceiveManaFromItem = canReceiveManaFromItem;
    }


    @ZenMethod
    public boolean isCanExportManaToPool() {
        return canExportManaToPool;
    }


    @ZenMethod
    public void setCanExportManaToPool(boolean canExportManaToPool) {
        this.canExportManaToPool = canExportManaToPool;
    }


    @ZenMethod
    public boolean isCanExportManaToItem() {
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
