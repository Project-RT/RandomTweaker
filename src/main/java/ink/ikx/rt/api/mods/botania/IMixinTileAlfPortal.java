package ink.ikx.rt.api.mods.botania;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.data.IData;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IWorld;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ModOnly("botania")
@ZenClass("mods.randomtweaker.BotaniaTileInGame")
public interface IMixinTileAlfPortal {

    @ZenMethod
    IItemStack[] getInputList();

    @ZenMethod
    void setInputList(IItemStack[] newList);

    @ZenMethod
    void clearInputList();

    @ZenMethod
    void delInput(IItemStack stack);

    @ZenMethod
    void addInput(IItemStack stack);

    @ZenMethod
    boolean consumeMana(int totalCost);

    @ZenMethod
    void spawnItem(IItemStack stack);

    @ZenGetter("pos")
    IBlockPos getBlockPos();

    @ZenGetter("world")
    IWorld getIWorrld();

    @ZenGetter("data")
    IData getData();

    @ZenMethod
    boolean isEmpty(IData data);

    @ZenMethod
    void updateData(IData data);
}
