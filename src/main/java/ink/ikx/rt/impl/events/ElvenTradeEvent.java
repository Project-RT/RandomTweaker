package ink.ikx.rt.impl.events;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

@Cancelable
public class ElvenTradeEvent extends Event {

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
}

