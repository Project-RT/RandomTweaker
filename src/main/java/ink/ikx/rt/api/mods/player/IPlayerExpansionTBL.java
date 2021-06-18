package ink.ikx.rt.api.mods.player;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import net.minecraft.entity.player.EntityPlayer;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;
import thebetweenlands.api.capability.IDecayCapability;
import thebetweenlands.common.registries.CapabilityRegistry;

@ZenRegister
@ModOnly("thebetweenlands")
@ZenExpansion("crafttweaker.player.IPlayer")
public class IPlayerExpansionTBL {

    @ZenMethod
    public static boolean isCapBeNull(IPlayer player) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        IDecayCapability cap = mcPlayer.getCapability(CapabilityRegistry.CAPABILITY_DECAY, null);
        return cap == null;
    }

    @ZenMethod
    public static void addStats(IPlayer player, int decay, float saturationModifier) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        IDecayCapability cap = mcPlayer.getCapability(CapabilityRegistry.CAPABILITY_DECAY, null);
        assert cap != null;
        cap.getDecayStats().addStats(decay, saturationModifier);
    }

    @ZenMethod
    public static int getDecayLevel(IPlayer player) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        IDecayCapability cap = mcPlayer.getCapability(CapabilityRegistry.CAPABILITY_DECAY, null);
        assert cap != null;
        return cap.getDecayStats().getDecayLevel();
    }

    @ZenMethod
    public static int getPrevDecayLevel(IPlayer player) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        IDecayCapability cap = mcPlayer.getCapability(CapabilityRegistry.CAPABILITY_DECAY, null);
        assert cap != null;
        return cap.getDecayStats().getPrevDecayLevel();
    }

    @ZenMethod
    public static void addDecayAcceleration(IPlayer player, float acceleration) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        IDecayCapability cap = mcPlayer.getCapability(CapabilityRegistry.CAPABILITY_DECAY, null);
        assert cap != null;
        cap.getDecayStats().addDecayAcceleration(acceleration);
    }

    @ZenMethod
    public static float getSaturationLevel(IPlayer player) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        IDecayCapability cap = mcPlayer.getCapability(CapabilityRegistry.CAPABILITY_DECAY, null);
        assert cap != null;
        return cap.getDecayStats().getSaturationLevel();
    }

    @ZenMethod
    public static float getAccelerationLevel(IPlayer player) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        IDecayCapability cap = mcPlayer.getCapability(CapabilityRegistry.CAPABILITY_DECAY, null);
        assert cap != null;
        return cap.getDecayStats().getAccelerationLevel();
    }

    @ZenMethod
    public static void setDecayLevel(IPlayer player, int decay) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        IDecayCapability cap = mcPlayer.getCapability(CapabilityRegistry.CAPABILITY_DECAY, null);
        assert cap != null;
        cap.getDecayStats().setDecayLevel(decay);
    }

    @ZenMethod
    public static void setDecaySaturationLevel(IPlayer player, float saturation) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        IDecayCapability cap = mcPlayer.getCapability(CapabilityRegistry.CAPABILITY_DECAY, null);
        assert cap != null;
        cap.getDecayStats().setDecaySaturationLevel(saturation);
    }

}
