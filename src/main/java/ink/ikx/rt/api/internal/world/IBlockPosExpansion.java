package ink.ikx.rt.api.internal.world;

import com.google.common.collect.Lists;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.world.IBlockPos;
import java.util.List;
import net.minecraft.util.math.BlockPos;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenMethodStatic;

@ZenRegister
@ZenExpansion("crafttweaker.world.IBlockPos")
public class IBlockPosExpansion {

    @ZenMethodStatic
    public static IBlockPos[] getAllInBox(IBlockPos from, IBlockPos to) {
        Iterable<BlockPos> allInBox = BlockPos.getAllInBox(CraftTweakerMC.getBlockPos(from), CraftTweakerMC.getBlockPos(to));
        List<IBlockPos> list = Lists.newArrayList();
        allInBox.forEach(single -> list.add(CraftTweakerMC.getIBlockPos(single)));
        return list.toArray(new IBlockPos[0]);
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
    public static IBlockPos up(IBlockPos pos) {
        return CraftTweakerMC.getIBlockPos(CraftTweakerMC.getBlockPos(pos).up());
    }

    @ZenMethod
    public static IBlockPos up(IBlockPos pos, int n) {
        return CraftTweakerMC.getIBlockPos(CraftTweakerMC.getBlockPos(pos).up(n));
    }

    @ZenMethod
    public static IBlockPos down(IBlockPos pos) {
        return CraftTweakerMC.getIBlockPos(CraftTweakerMC.getBlockPos(pos).down());
    }

    @ZenMethod
    public static IBlockPos down(IBlockPos pos, int n) {
        return CraftTweakerMC.getIBlockPos(CraftTweakerMC.getBlockPos(pos).down(n));
    }

    @ZenMethod
    public static IBlockPos north(IBlockPos pos) {
        return CraftTweakerMC.getIBlockPos(CraftTweakerMC.getBlockPos(pos).north());
    }

    @ZenMethod
    public static IBlockPos north(IBlockPos pos, int n) {
        return CraftTweakerMC.getIBlockPos(CraftTweakerMC.getBlockPos(pos).north(n));
    }

    @ZenMethod
    public static IBlockPos south(IBlockPos pos) {
        return CraftTweakerMC.getIBlockPos(CraftTweakerMC.getBlockPos(pos).south());
    }

    @ZenMethod
    public static IBlockPos south(IBlockPos pos, int n) {
        return CraftTweakerMC.getIBlockPos(CraftTweakerMC.getBlockPos(pos).south(n));
    }

    @ZenMethod
    public static IBlockPos west(IBlockPos pos) {
        return CraftTweakerMC.getIBlockPos(CraftTweakerMC.getBlockPos(pos).west());
    }

    @ZenMethod
    public static IBlockPos west(IBlockPos pos, int n) {
        return CraftTweakerMC.getIBlockPos(CraftTweakerMC.getBlockPos(pos).west(n));
    }

    @ZenMethod
    public static IBlockPos east(IBlockPos pos) {
        return CraftTweakerMC.getIBlockPos(CraftTweakerMC.getBlockPos(pos).east());
    }

    @ZenMethod
    public static IBlockPos east(IBlockPos pos, int n) {
        return CraftTweakerMC.getIBlockPos(CraftTweakerMC.getBlockPos(pos).east(n));
    }
}
