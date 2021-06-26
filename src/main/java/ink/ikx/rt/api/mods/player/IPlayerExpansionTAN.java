package ink.ikx.rt.api.mods.player;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import net.minecraft.entity.player.EntityPlayer;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;
import toughasnails.api.TANCapabilities;
import toughasnails.api.stat.capability.IThirst;
import toughasnails.api.thirst.ThirstHelper;
import toughasnails.thirst.ThirstHandler;

@ZenRegister
@ModOnly("toughasnails")
@ZenExpansion("crafttweaker.player.IPlayer")
public class IPlayerExpansionTAN {

    @ZenMethod
    public void setThirst(IPlayer player, int thirst) {
        IThirst cap = ThirstHelper.getThirstData(CraftTweakerMC.getPlayer(player));
        cap.setThirst(thirst);
    }

    @ZenMethod
    public void setHydration(IPlayer player, float hydration) {
        IThirst cap = ThirstHelper.getThirstData(CraftTweakerMC.getPlayer(player));
        cap.setHydration(hydration);
    }

    @ZenMethod
    public void setExhaustion(IPlayer player, float exhaustion) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        ThirstHandler thirstHandler = (ThirstHandler) mcPlayer.getCapability(TANCapabilities.THIRST, null);
        thirstHandler.addExhaustion(exhaustion);
    }

    @ZenMethod
    public void addStats(IPlayer player, int thirst, float hydration) {
        IThirst cap = ThirstHelper.getThirstData(CraftTweakerMC.getPlayer(player));
        cap.addStats(thirst, hydration);
    }

    @ZenMethod
    public int getThirst(IPlayer player) {
        IThirst cap = ThirstHelper.getThirstData(CraftTweakerMC.getPlayer(player));
        return cap.getThirst();
    }

    @ZenMethod
    public float getHydration(IPlayer player) {
        IThirst cap = ThirstHelper.getThirstData(CraftTweakerMC.getPlayer(player));
        return cap.getHydration();
    }

    @ZenMethod
    public float getExhaustion(IPlayer player) {
        IThirst cap = ThirstHelper.getThirstData(CraftTweakerMC.getPlayer(player));
        return cap.getExhaustion();
    }
}
