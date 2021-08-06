package ink.ikx.rt.impl.events.customevent;

import ink.ikx.rt.api.mods.botania.IMixinTileAlfPortal;
import ink.ikx.rt.impl.utils.Utils;
import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

@Cancelable
public class ElvenTradeEvent extends BaseEvent {

    private final IMixinTileAlfPortal alfPortal;
    private final List<ItemStack> input;

    private List<ItemStack> output;

    public ElvenTradeEvent(IMixinTileAlfPortal alfPortal, List<ItemStack> input, List<ItemStack> output) {
        this.alfPortal = alfPortal;
        this.input = Utils.getItemStackListCopy(input);
        this.output = Utils.getItemStackListCopy(output);
    }

    public IMixinTileAlfPortal getAlfPortal() {
        return alfPortal;
    }

    public List<ItemStack> getInput() {
        return input;
    }

    public List<ItemStack> getOutput() {
        return output;
    }

    public void setOutput(List<ItemStack> stacks) {
        this.output = stacks;
    }

    public void addOutput(ItemStack stack) {
        this.output.add(stack);
    }
}

