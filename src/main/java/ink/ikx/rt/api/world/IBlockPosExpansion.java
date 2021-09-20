package ink.ikx.rt.api.world;

import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.world.IBlockPos;
import net.minecraft.util.math.BlockPos;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenMethodStatic;

import java.util.stream.StreamSupport;

@ZenExpansion("crafttweaker.world.IBlockPos")
public class IBlockPosExpansion {

    @ZenMethodStatic
    public static IBlockPos[] getAllInBox(IBlockPos from, IBlockPos to) {
        Iterable<BlockPos> allInBox = BlockPos.getAllInBox(CraftTweakerMC.getBlockPos(from), CraftTweakerMC.getBlockPos(to));
        return StreamSupport.stream(allInBox.spliterator(), false)
                .map(CraftTweakerMC::getIBlockPos)
                .toArray(IBlockPos[]::new);
    }

    @ZenMethod
    public static IBlockPos add(IBlockPos pos, double x, double y, double z) {
        return CraftTweakerMC.getIBlockPos(CraftTweakerMC.getBlockPos(pos).add(x, y, z));
    }

    @ZenMethod
    public static IBlockPos add(IBlockPos pos, int x, int y, int z) {
        return CraftTweakerMC.getIBlockPos(CraftTweakerMC.getBlockPos(pos).add(x, y, z));
    }

    @ZenMethod
    public static IBlockPos up(IBlockPos pos, @Optional int n) {
        return CraftTweakerMC.getIBlockPos(CraftTweakerMC.getBlockPos(pos).up(n));
    }

    @ZenMethod
    public static IBlockPos down(IBlockPos pos, @Optional int n) {
        return CraftTweakerMC.getIBlockPos(CraftTweakerMC.getBlockPos(pos).down());
    }

    @ZenMethod
    public static IBlockPos north(IBlockPos pos, @Optional int n) {
        return CraftTweakerMC.getIBlockPos(CraftTweakerMC.getBlockPos(pos).north(n));
    }

    @ZenMethod
    public static IBlockPos south(IBlockPos pos, @Optional int n) {
        return CraftTweakerMC.getIBlockPos(CraftTweakerMC.getBlockPos(pos).south(n));
    }

    @ZenMethod
    public static IBlockPos west(IBlockPos pos, @Optional int n) {
        return CraftTweakerMC.getIBlockPos(CraftTweakerMC.getBlockPos(pos).west(n));
    }

    @ZenMethod
    public static IBlockPos east(IBlockPos pos, @Optional int n) {
        return CraftTweakerMC.getIBlockPos(CraftTweakerMC.getBlockPos(pos).east(n));
    }

}
