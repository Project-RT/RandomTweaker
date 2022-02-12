package ink.ikx.rt.api.mods.ftbultimine;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import crafttweaker.annotations.ModOnly;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import ink.ikx.rt.impl.internal.capability.CapabilityRegistryHandler;
import ink.ikx.rt.impl.internal.capability.CapabilityRegistryHandler.FTBUltimineTag;
import ink.ikx.rt.impl.internal.network.NetworkManager;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenMethodStatic;

import java.util.Objects;

@RTRegister
@ModOnly("ftbultimine")
@ZenExpansion("crafttweaker.player.IPlayer")
@ZenClass("mods.randomtweaker.ftbultimine.IPlayer")
public abstract class IPlayerExpansionFTBU {

    public static String langKey = null;

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

    @ZenMethodStatic
    public static void setFTBUReminderMessage(String langKey) {
        CraftTweakerAPI.apply(new ActionReminderMessage(langKey));
    }

    public static class ActionReminderMessage implements IAction {

        private final String langKey;

        public ActionReminderMessage(String langKey) {
            this.langKey = langKey;
        }

        @Override
        public void apply() {
            IPlayerExpansionFTBU.langKey = langKey;
        }

        @Override
        public String describe() {
            return "Setting FTBUltimine reminder message to " + langKey;
        }

    }

}
