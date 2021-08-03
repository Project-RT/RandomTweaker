package ink.ikx.rt.impl.events.customevent;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

@Cancelable
public class AlfPortalDroppedEvent extends BaseEvent {

    private final World world;
    private final ItemStack input;
    private final BlockPos blockPos;

    private ItemStack output = null;

    public AlfPortalDroppedEvent(World world, BlockPos blockPos, ItemStack input) {
        this.world = world;
        this.input = input;
        this.blockPos = blockPos;
    }

    public World getWorld() {
        return world;
    }

    public ItemStack getInput() {
        return input;
    }

    public BlockPos getBlockPos() {
        return blockPos;
    }

    public ItemStack getOutput() {
        return output;
    }

    public void setOutput(ItemStack output) {
        this.output = output;
    }
}
