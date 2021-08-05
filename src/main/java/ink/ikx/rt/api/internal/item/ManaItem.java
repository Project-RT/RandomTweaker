package ink.ikx.rt.api.internal.item;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IWorld;
import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;

/**
 * @author superhelo
 */
@RTRegisterClass({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.item.IManaItem")
public interface ManaItem {

    @ZenGetter("mana")
    int getMana();

    @ZenGetter("maxMana")
    int getMaxMana();

    @ZenGetter("noExport")
    boolean isNoExport();

    @ZenGetter("hasFull")
    boolean hasFull();

    @ZenGetter("hasCreative")
    boolean hasCreative();

    @ZenGetter("creative")
    boolean isCreative();

    @ZenGetter("full")
    boolean isFull();

    @ZenMethod
    boolean canExportManaToPool(IWorld world, IBlockPos pos);

    @ZenMethod
    boolean canExportManaToItem(IItemStack otherStack);

    @ZenMethod
    boolean canReceiveManaFromPool(IWorld world, IBlockPos pos);

    @ZenMethod
    boolean canReceiveManaFromItem(IItemStack otherStack);

    @ZenMethod
    int updateMana(int mana);
}
