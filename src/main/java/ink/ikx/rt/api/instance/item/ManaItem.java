package ink.ikx.rt.api.instance.item;

import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.randomtweaker.item.IManaItem")
public interface ManaItem {

    @ZenGetter("mana")
    int getMana();

    @ZenGetter("maxMana")
    int getMaxMana();

    @ZenGetter("isNoExport")
    boolean isNoExport();

    @ZenGetter("hasFull")
    boolean hasFull();

    @ZenGetter("hasCreative")
    boolean hasCreative();

    @ZenGetter("canExportManaToPool")
    boolean canExportManaToPool();

    @ZenGetter("canExportManaToItem")
    boolean canExportManaToItem();

    @ZenGetter("canReceiveManaFromPool")
    boolean canReceiveManaFromPool();

    @ZenGetter("canReceiveManaFromItem")
    boolean canReceiveManaFromItem();

    @ZenMethod
    int updateMana(int amount);
}
