package ink.ikx.rt.impl.events.customevent;

import java.util.Arrays;
import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

@Cancelable
public class ElvenTradeEvent extends BaseEvent {

    private final World world;
    private final BlockPos pos;
    private final ItemStack[] input;
    private ItemStack[] output;

    public ElvenTradeEvent(World world, BlockPos pos, ItemStack[] input, ItemStack[] output) {
        this.world = world;
        this.pos = pos;
        this.input = input;
        this.output = output;
    }

    public World getWorld() {
        return world;
    }

    public BlockPos getBlockPos() {
        return pos;
    }

    public ItemStack[] getInput() {
        return input;
    }

    public ItemStack[] getOutput() {
        return output;
    }

    public void setOutput(ItemStack[] stacks) {
        this.output = stacks;
    }

    public void addOutput(ItemStack stack) {
        List<ItemStack> itemStacks = Arrays.asList(output);
        itemStacks.add(stack);
        this.output = itemStacks.toArray(new ItemStack[0]);
    }
}

