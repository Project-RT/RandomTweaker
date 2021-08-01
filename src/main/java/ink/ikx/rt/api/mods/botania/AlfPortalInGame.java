package ink.ikx.rt.api.mods.botania;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IWorld;
import ink.ikx.rt.impl.utils.IMixinTileAlfPortal;
import net.minecraft.tileentity.TileEntity;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ModOnly("botania")
@ZenExpansion("crafttweaker.world.IWorld")
public class AlfPortalInGame {

    @ZenMethod
    public static IMixinTileAlfPortal getAlfPortalInGame(IWorld world, IBlockPos blockPos) {
        TileEntity te = CraftTweakerMC.getWorld(world).getTileEntity(CraftTweakerMC.getBlockPos(blockPos));
        if (te instanceof IMixinTileAlfPortal) {
            return (IMixinTileAlfPortal) te;
        }
        return null;
    }

}
