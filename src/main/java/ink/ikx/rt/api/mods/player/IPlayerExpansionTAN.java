package ink.ikx.rt.api.mods.player;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import java.util.Objects;
import net.minecraft.entity.player.EntityPlayer;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;
import toughasnails.api.TANCapabilities;
import toughasnails.api.stat.capability.ITemperature;
import toughasnails.api.stat.capability.IThirst;
import toughasnails.api.temperature.Temperature;
import toughasnails.api.temperature.TemperatureHelper;
import toughasnails.api.thirst.ThirstHelper;
import toughasnails.thirst.ThirstHandler;

@ZenRegister
@ModOnly("toughasnails")
@ZenExpansion("crafttweaker.player.IPlayer")
public class IPlayerExpansionTAN {

    @ZenMethod
    public static void setThirst(IPlayer player, int thirst) {
        IThirst cap = ThirstHelper.getThirstData(CraftTweakerMC.getPlayer(player));
        cap.setThirst(thirst);
    }

    @ZenMethod
    public static void setTemperature(IPlayer player, int temp) {
        ITemperature cap = TemperatureHelper.getTemperatureData(CraftTweakerMC.getPlayer(player));
        cap.setTemperature(new Temperature(temp));
    }

    @ZenMethod
    public static void setHydration(IPlayer player, float hydration) {
        IThirst cap = ThirstHelper.getThirstData(CraftTweakerMC.getPlayer(player));
        cap.setHydration(hydration);
    }

    @ZenMethod
    public static void setExhaustion(IPlayer player, float exhaustion) {
        IThirst cap = ThirstHelper.getThirstData(CraftTweakerMC.getPlayer(player));
        cap.setExhaustion(exhaustion);
    }

    @ZenMethod
    public static void addExhaustion(IPlayer player, float exhaustion) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        ThirstHandler thirstHandler = (ThirstHandler) mcPlayer.getCapability(TANCapabilities.THIRST, null);
        Objects.requireNonNull(thirstHandler).addExhaustion(exhaustion);
    }

    @ZenMethod
    public static void addTemperature(IPlayer player, int temp) {
        ITemperature cap = TemperatureHelper.getTemperatureData(CraftTweakerMC.getPlayer(player));
        cap.addTemperature(new Temperature(temp));
    }

    @ZenMethod
    public static void addStats(IPlayer player, int thirst, float hydration) {
        IThirst cap = ThirstHelper.getThirstData(CraftTweakerMC.getPlayer(player));
        cap.addStats(thirst, hydration);
    }

    @ZenMethod
    public static int getThirst(IPlayer player) {
        IThirst cap = ThirstHelper.getThirstData(CraftTweakerMC.getPlayer(player));
        return cap.getThirst();
    }

    @ZenMethod
    public static float getHydration(IPlayer player) {
        IThirst cap = ThirstHelper.getThirstData(CraftTweakerMC.getPlayer(player));
        return cap.getHydration();
    }

    @ZenMethod
    public static float getExhaustion(IPlayer player) {
        IThirst cap = ThirstHelper.getThirstData(CraftTweakerMC.getPlayer(player));
        return cap.getExhaustion();
    }

    @ZenMethod
    public static int getTemperature(IPlayer player) {
        ITemperature cap = TemperatureHelper.getTemperatureData(CraftTweakerMC.getPlayer(player));
        return cap.getTemperature().getRawValue();
    }

    @ZenMethod
    public static int getPlayerTarget(IPlayer player) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        ITemperature cap = TemperatureHelper.getTemperatureData(mcPlayer);
        return cap.getPlayerTarget(mcPlayer);
    }
}
