package ink.ikx.rt.api.mods.botania.function;

import crafttweaker.annotations.ModOnly;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.player.IPlayer;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import stanhebben.zenscript.annotations.ZenClass;

@RTRegister
@ModOnly("botania")
@ZenClass("mods.randomtweaker.botania.DynamicSpawnTable")
@FunctionalInterface
public interface DynamicSpawnTable {

    String call(IItemStack stack, IPlayer player, ICocoonTileEntity tile);

}
