package ink.ikx.rt.api.mods.world;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IWorld;
import de.ellpeck.naturesaura.api.aura.chunk.IAuraChunk;
import ink.ikx.rt.api.mods.naturesaura.AuraChunk;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ModOnly("naturesaura")
@ZenExpansion("crafttweaker.world.IWorld")
public class IWorldExpansionNA {

    @ZenMethod
    public static AuraChunk getAuraChunk(IWorld world, IBlockPos pos) {
        return new AuraChunk(world, pos);
    }

    @ZenMethod
    public static IBlockPos getHighestSpot(IWorld world, IBlockPos pos, int radius, IBlockPos defaultSpot) {
        return CraftTweakerMC.getIBlockPos(IAuraChunk.getHighestSpot(CraftTweakerMC.getWorld(world),
            CraftTweakerMC.getBlockPos(pos), radius, CraftTweakerMC.getBlockPos(defaultSpot)));
    }

    @ZenMethod
    public static IBlockPos getLowestSpot(IWorld world, IBlockPos pos, int radius, IBlockPos defaultSpot) {
        return CraftTweakerMC.getIBlockPos(IAuraChunk.getLowestSpot(CraftTweakerMC.getWorld(world),
            CraftTweakerMC.getBlockPos(pos), radius, CraftTweakerMC.getBlockPos(defaultSpot)));
    }

    @ZenMethod
    public static int getSpotAmountInArea(IWorld world, IBlockPos pos, int radius) {
        return IAuraChunk.getSpotAmountInArea(CraftTweakerMC.getWorld(world), CraftTweakerMC.getBlockPos(pos), radius);
    }

    @ZenMethod
    public static int getAuraInArea(IWorld world, IBlockPos pos, int radius) {
        return IAuraChunk.getAuraInArea(CraftTweakerMC.getWorld(world), CraftTweakerMC.getBlockPos(pos), radius);
    }

    @ZenMethod
    public static int triangulateAuraInArea(IWorld world, IBlockPos pos, int radius) {
        return IAuraChunk.triangulateAuraInArea(CraftTweakerMC.getWorld(world), CraftTweakerMC.getBlockPos(pos), radius);
    }
}