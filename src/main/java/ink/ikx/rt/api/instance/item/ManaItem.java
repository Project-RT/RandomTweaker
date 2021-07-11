package ink.ikx.rt.api.instance.item;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IWorld;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;

/**
 * @author superhelo
 */
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
    boolean canExportManaToPool(IWorld world, IBlockPos pos);

    @ZenGetter("canExportManaToItem")
    boolean canExportManaToItem(IItemStack otherStack);

    @ZenGetter("canReceiveManaFromPool")
    boolean canReceiveManaFromPool(IWorld world, IBlockPos pos);

    @ZenGetter("canReceiveManaFromItem")
    boolean canReceiveManaFromItem(IItemStack otherStack);

    @ZenMethod
    int updateMana(int mana);
}
