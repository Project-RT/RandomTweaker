package ink.ikx.rt.api.mods.naturesaura;

import crafttweaker.annotations.ModOnly;
import crafttweaker.api.world.IBlockPos;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ModOnly("naturesaura")
@ZenClass("mods.randomtweaker.naturesaura.AuraChunk")
public interface IAuraChunk {

    @ZenMethod
    int drainAura(IBlockPos pos, int amount);

    @ZenMethod
    int drainAura(IBlockPos pos, int amount, boolean aimForZero, boolean simulate);

    @ZenMethod
    int storeAura(IBlockPos pos, int amount);

    @ZenMethod
    int storeAura(IBlockPos pos, int amount, boolean aimForZero, boolean simulate);

    @ZenMethod
    int getDrainSpot(IBlockPos pos);

}
