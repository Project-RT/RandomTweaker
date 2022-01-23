package ink.ikx.rt.api.mods.contenttweaker.function.subtile;

import com.teamacronymcoders.contenttweaker.api.ctobjects.blockpos.IBlockPos;
import com.teamacronymcoders.contenttweaker.api.ctobjects.entity.player.ICTPlayer;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.world.IFacing;
import ink.ikx.rt.impl.mods.crafttweaker.ModTotal;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import stanhebben.zenscript.annotations.ZenClass;

@RTRegister
@FunctionalInterface
@ModTotal({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.CanSelect")
public interface CanSelect {

    boolean call(ICTPlayer player, IItemStack wand, IBlockPos pos, IFacing side);

}