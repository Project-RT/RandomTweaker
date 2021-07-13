package ink.ikx.rt.api.mods.cote.function.botania;

import com.teamacronymcoders.contenttweaker.api.ctobjects.blockpos.IBlockPos;
import com.teamacronymcoders.contenttweaker.api.ctobjects.entity.player.CTPlayer;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.world.IFacing;
import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import stanhebben.zenscript.annotations.ZenClass;

@FunctionalInterface
@RTRegisterClass({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.BlockPlacedBy")
public interface BindToOrCanSelect {

    boolean call(CTPlayer player, IItemStack wand, IBlockPos pos, IFacing side);
}
