package ink.ikx.rt.api.mods.naturesaura;

import crafttweaker.annotations.ModOnly;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IWorld;
import de.ellpeck.naturesaura.api.aura.chunk.IAuraChunk;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;


@ModOnly("naturesaura")
@ZenClass("mods.randomtweaker.naturesaura.AuraChunk")
public class AuraChunk {

    private final IAuraChunk auraChunk;

    public AuraChunk(IWorld world, IBlockPos pos) {
        this.auraChunk = IAuraChunk.getAuraChunk(CraftTweakerMC.getWorld(world), CraftTweakerMC.getBlockPos(pos));
    }

    @ZenMethod
    public int drainAura(IBlockPos pos, int amount, boolean aimForZero, boolean simulate) {
        return auraChunk.drainAura(CraftTweakerMC.getBlockPos(pos), amount, aimForZero, simulate);
    }

    @ZenMethod
    public int drainAura(IBlockPos pos, int amount) {
        return auraChunk.drainAura(CraftTweakerMC.getBlockPos(pos), amount);
    }

    @ZenMethod
    public int storeAura(IBlockPos pos, int amount, boolean aimForZero, boolean simulate) {
        return auraChunk.storeAura(CraftTweakerMC.getBlockPos(pos), amount, aimForZero, simulate);
    }

    @ZenMethod
    public int storeAura(IBlockPos pos, int amount) {
        return auraChunk.storeAura(CraftTweakerMC.getBlockPos(pos), amount);
    }

    @ZenMethod
    public int getDrainSpot(IBlockPos pos) {
        return auraChunk.getDrainSpot(CraftTweakerMC.getBlockPos(pos));
    }

}