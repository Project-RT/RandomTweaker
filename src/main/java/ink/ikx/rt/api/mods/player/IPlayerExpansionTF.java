package ink.ikx.rt.api.mods.player;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import ink.ikx.rt.impl.twilight.RTTeleporter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;
import twilightforest.TFConfig;

/**
 * @author niyan
 */
@ZenRegister
@ModOnly("twilightforest")
@ZenExpansion("crafttweaker.player.IPlayer")
public class IPlayerExpansionTF {

    @ZenMethod
    public static void teleportPlayer(IPlayer playerIn) {
        int destination = TFConfig.dimension.dimensionID;

        EntityPlayer player = CraftTweakerMC.getPlayer(playerIn);
        if (player.isDead || player.world.isRemote)
            return;

        if (player instanceof EntityPlayerMP) {
            player.changeDimension(destination, RTTeleporter.getTeleporterForDim(((EntityPlayerMP) player).server, destination));
        }
    }

}
