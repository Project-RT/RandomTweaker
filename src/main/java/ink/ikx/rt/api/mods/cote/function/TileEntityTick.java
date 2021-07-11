package ink.ikx.rt.api.mods.cote.function;

import com.teamacronymcoders.contenttweaker.api.ctobjects.blockpos.IBlockPos;
import com.teamacronymcoders.contenttweaker.api.ctobjects.world.IWorld;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import ink.ikx.rt.api.mods.cote.tile.TileEntityContent;
import stanhebben.zenscript.annotations.ZenClass;

@ZenRegister
@ModOnly("contenttweaker")
@ZenClass("mods.randomtweaker.cote.TileEntityTick")
public interface TileEntityTick {
    void onUpdate(TileEntityContent tileEntity, IWorld world, IBlockPos pos);
}

