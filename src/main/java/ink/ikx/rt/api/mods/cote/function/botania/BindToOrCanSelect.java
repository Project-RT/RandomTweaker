package ink.ikx.rt.api.mods.cote.function.botania;

import com.teamacronymcoders.contenttweaker.api.ctobjects.blockpos.IBlockPos;
import com.teamacronymcoders.contenttweaker.api.ctobjects.entity.player.CTPlayer;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.world.IFacing;
import stanhebben.zenscript.annotations.ZenClass;

@FunctionalInterface
@ZenClass("mods.randomtweaker.cote.BlockPlacedBy")
public interface BindToOrCanSelect {

    boolean call(CTPlayer player, IItemStack wand, IBlockPos pos, IFacing side);
}
