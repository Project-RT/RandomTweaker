package ink.ikx.rt.impl.events.customevent;

import ink.ikx.rt.api.mods.botania.IMixinTileAlfPortal;
import java.util.Arrays;
import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

@Cancelable
public class ElvenTradeEvent extends BaseEvent {

    private final IMixinTileAlfPortal alfPortal;
    private final ItemStack[] input;
    private ItemStack[] output;

    public ElvenTradeEvent(IMixinTileAlfPortal alfPortal, ItemStack[] input, ItemStack[] output) {
        this.alfPortal = alfPortal;
        this.input = input;
        this.output = output;
    }

    public IMixinTileAlfPortal getAlfPortal() {
        return alfPortal;
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

