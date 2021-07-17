package ink.ikx.rt.api.mods.cote.flower;

import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IWorld;
import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import net.minecraft.tileentity.TileEntity;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;
import vazkii.botania.api.subtile.ISubTileContainer;
import vazkii.botania.api.subtile.SubTileEntity;

@RTRegisterClass({"contenttweaker", "botania"})
@ZenExpansion("crafttweaker.world.IWorld")
public class ExpandWorldForSubTile {

    @ZenMethod
    public static SubTileEntityInGame getSubTileEntityInGame(IWorld world, IBlockPos pos) {
        TileEntity te = CraftTweakerMC.getWorld(world).getTileEntity(CraftTweakerMC.getBlockPos(pos));
        if (te instanceof ISubTileContainer) {
            SubTileEntity subtile = ((ISubTileContainer) te).getSubTile();
            if (subtile instanceof SubTileEntityInGame) {
                return (SubTileEntityInGame) subtile;
            }
        }
        return null;
    }

}
