package ink.ikx.rt.api.mods.cote.function.botania;

import com.teamacronymcoders.contenttweaker.api.ctobjects.blockpos.IBlockPos;
import com.teamacronymcoders.contenttweaker.api.ctobjects.world.IWorld;
import crafttweaker.api.block.IBlockState;
import crafttweaker.api.entity.IEntityLivingBase;
import crafttweaker.api.item.IItemStack;
import stanhebben.zenscript.annotations.ZenClass;

@FunctionalInterface
@ZenClass("mods.randomtweaker.cote.BlockPlacedBy")
public interface BlockPlacedBy {
    void call(IWorld world, IBlockPos pos, IBlockState state, IEntityLivingBase entity, IItemStack stack);
}
