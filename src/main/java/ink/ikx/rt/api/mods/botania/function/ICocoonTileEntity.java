package ink.ikx.rt.api.mods.botania.function;

import crafttweaker.annotations.ModOnly;
import crafttweaker.api.data.IData;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IWorld;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;

@RTRegister
@ModOnly("botania")
@ZenClass("mods.randomtweaker.botania.ICocoonTileEntity")
public interface ICocoonTileEntity {

    @ZenMethod
    @ZenGetter("world")
    IWorld getIWorld();

    @ZenMethod
    @ZenGetter("pos")
    IBlockPos getIBlockPos();

    @ZenMethod
    @ZenGetter("data")
    IData getData();

    @ZenMethod
    void updateData(IData data);

}
