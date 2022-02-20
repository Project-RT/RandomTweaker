package ink.ikx.rt.impl.internal.utils;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.impl.internal.capability.CapabilityRegistryHandler;
import ink.ikx.rt.impl.internal.config.RTConfig;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Loader;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class InternalUtils {

    public static boolean isItemBlock(IItemStack block) {
        return block.isItemBlock();
    }

    @SuppressWarnings("deprecation")
    public static IBlockState getStateFromStack(IItemStack block) {
        if (isItemBlock(block)) {
            Block mcBlock = Block.getBlockFromItem(CraftTweakerMC.getItem(block.getDefinition()));
            return mcBlock.getStateFromMeta(block.getMetadata());
        }
        return null;
    }

    public static List<ItemStack> getItemStacks(List<IItemStack> stacks) {
        return stacks.stream().map(CraftTweakerMC::getItemStack).collect(Collectors.toList());
    }

    public static List<FluidStack> getFluidStacks(List<ILiquidStack> stacks) {
        return stacks.stream().map(CraftTweakerMC::getLiquidStack).collect(Collectors.toList());
    }

    public static boolean areItemStacksEqual(ItemStack stackA, ItemStack stackB) {
        if (stackA.isEmpty() && stackB.isEmpty()) {
            return true;
        } else {
            return !stackA.isEmpty() && !stackB.isEmpty() && isItemStackEqual(stackA, stackB);
        }
    }

    public static boolean isItemStackEqual(ItemStack stackA, ItemStack stackB) {
        if (stackA.getItem() != stackB.getItem()) {
            return false;
        } else if (stackA.getItemDamage() != stackB.getItemDamage()) {
            return false;
        } else if (stackA.getTagCompound() == null && stackB.getTagCompound() != null) {
            return false;
        } else {
            return (stackA.getTagCompound() == null || stackB.getTagCompound() == null || stackA.getTagCompound().equals(stackB.getTagCompound())) && stackA.areCapsCompatible(stackB);
        }
    }

    public static List<ItemStack> getItemStackListCopy(List<ItemStack> items) {
        return items.stream().map(ItemStack::copy).collect(Collectors.toList());
    }

    public static boolean collIsNotEmpty(Collection<?> coll) {
        return !coll.isEmpty();
    }

    public static boolean isOpenFTBUltimineControl() {
        return Loader.isModLoaded("ftbultimine") && RTConfig.FTBUltimine.AllowCrTControl;
    }

    public static void decouplingMethod(CallbackInfo ci) {
        if (InternalUtils.isOpenFTBUltimineControl()) {
            CapabilityRegistryHandler.FTBUltimineTag capability = Minecraft.getMinecraft().player.getCapability(CapabilityRegistryHandler.FTB_ULTIMINE_CAPABILITY, null);
            if (!Objects.requireNonNull(capability).isAllow()) {
                ci.cancel();
            }
        }
    }

}
