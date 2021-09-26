package ink.ikx.rt.api.mods.botania.mana;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IWorld;
import ink.ikx.rt.impl.mods.crafttweaker.ModTotal;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;

/**
 * @author superhelo
 */
@ModTotal({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.item.IManaItem")
public interface IManaItem {

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

    @ZenGetter("isUseMana")
    boolean getUseMana();

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
