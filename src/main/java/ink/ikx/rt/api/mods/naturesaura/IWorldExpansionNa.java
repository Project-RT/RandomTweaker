package ink.ikx.rt.api.mods.naturesaura;

import crafttweaker.annotations.ModOnly;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IWorld;
import ink.ikx.rt.impl.mods.naturesaura.MCAuraChunk;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ModOnly("naturesaura")
@ZenExpansion("crafttweaker.world.IWorld")
@ZenClass("mods.randomtweaker.mods.naturesaura.IWorld")
public abstract class IWorldExpansionNa {

    @ZenMethod
    public static IAuraChunk getAuraChunk(IWorld world, IBlockPos pos) {
        return new MCAuraChunk(world, pos);
    }

    @ZenMethod
    public static IBlockPos getHighestSpot(IWorld world, IBlockPos pos, int radius, IBlockPos defaultSpot) {
        return CraftTweakerMC.getIBlockPos(de.ellpeck.naturesaura.api.aura.chunk.IAuraChunk.getHighestSpot(
                CraftTweakerMC.getWorld(world), CraftTweakerMC.getBlockPos(pos), radius, CraftTweakerMC.getBlockPos(defaultSpot)));
    }

    @ZenMethod
    public static IBlockPos getLowestSpot(IWorld world, IBlockPos pos, int radius, IBlockPos defaultSpot) {
        return CraftTweakerMC.getIBlockPos(de.ellpeck.naturesaura.api.aura.chunk.IAuraChunk.getLowestSpot(
                CraftTweakerMC.getWorld(world), CraftTweakerMC.getBlockPos(pos), radius, CraftTweakerMC.getBlockPos(defaultSpot)));
    }

    @ZenMethod
    public static int getSpotAmountInArea(IWorld world, IBlockPos pos, int radius) {
        return de.ellpeck.naturesaura.api.aura.chunk.IAuraChunk.getSpotAmountInArea(
                CraftTweakerMC.getWorld(world), CraftTweakerMC.getBlockPos(pos), radius);
    }

    @ZenMethod
    public static int getAuraInArea(IWorld world, IBlockPos pos, int radius) {
        return de.ellpeck.naturesaura.api.aura.chunk.IAuraChunk.getAuraInArea(
                CraftTweakerMC.getWorld(world), CraftTweakerMC.getBlockPos(pos), radius);
    }

    @ZenMethod
    public static int triangulateAuraInArea(IWorld world, IBlockPos pos, int radius) {
        return de.ellpeck.naturesaura.api.aura.chunk.IAuraChunk.triangulateAuraInArea(
                CraftTweakerMC.getWorld(world), CraftTweakerMC.getBlockPos(pos), radius);
    }

}
