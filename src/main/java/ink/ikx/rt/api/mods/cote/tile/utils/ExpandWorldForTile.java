package ink.ikx.rt.api.mods.cote.tile.utils;

import com.teamacronymcoders.contenttweaker.api.ctobjects.blockpos.IBlockPos;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.world.IWorld;
import ink.ikx.rt.api.mods.cote.tile.TileEntityContent;
import javax.annotation.Nullable;
import net.minecraft.tileentity.TileEntity;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ModOnly("contenttweaker")
@ZenExpansion("crafttweaker.world.IWorld")
public class ExpandWorldForTile {

    @ZenMethod
    @Nullable
    public static TileEntityContent getTileEntityInCot(IWorld world, IBlockPos pos) {
        TileEntity tileEntity = CraftTweakerMC.getWorld(world).getTileEntity(CraftTweakerMC.getBlockPos(pos));
        if (tileEntity instanceof TileEntityContent) {
            return (TileEntityContent) tileEntity;
        }
        return null;
    }
}
