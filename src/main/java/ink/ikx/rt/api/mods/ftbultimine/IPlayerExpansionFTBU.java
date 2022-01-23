package ink.ikx.rt.api.mods.ftbultimine;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import ink.ikx.rt.impl.internal.capability.CapabilityRegistryHandler;
import ink.ikx.rt.impl.internal.capability.CapabilityRegistryHandler.FTBUltimineTag;
import ink.ikx.rt.impl.internal.network.NetworkManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.Objects;

@ModOnly("ftbultimine")
@ZenExpansion("crafttweaker.player.IPlayer")
@ZenClass("mods.randomtweaker.ftbultimine.IPlayer")
public abstract class IPlayerExpansionFTBU {

    @ZenMethod
    public static void setAllowFTBUltimine(IPlayer player, boolean flag) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        if (!(mcPlayer instanceof EntityPlayerMP)) {
            CraftTweakerAPI.logError("The IPlayer object is not an EntityPlayerMP object.");
            return;
        }
        FTBUltimineTag capability = mcPlayer.getCapability(CapabilityRegistryHandler.FTB_ULTIMINE_CAPABILITY, null);
        Objects.requireNonNull(capability).setAllow(flag);

        NetworkManager.FTBUltimineTag.sendClientCustomPacket(mcPlayer); // send to client
    }

    @ZenMethod
    public static boolean isAllowFTBUltimine(IPlayer player) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        if (!(mcPlayer instanceof EntityPlayerMP)) {
            CraftTweakerAPI.logError("The IPlayer object is not an EntityPlayerMP object.");
            return false;
        }
        FTBUltimineTag capability = mcPlayer.getCapability(CapabilityRegistryHandler.FTB_ULTIMINE_CAPABILITY, null);
        return Objects.requireNonNull(capability).isAllow();
    }

}
