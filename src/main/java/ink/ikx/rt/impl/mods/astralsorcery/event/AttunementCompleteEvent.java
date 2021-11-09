package ink.ikx.rt.impl.mods.astralsorcery.event;

import hellfirepvp.astralsorcery.common.constellation.IConstellation;
import ink.ikx.rt.impl.internal.event.BaseEvent;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

import java.util.ArrayList;
import java.util.List;

@Cancelable
public class AttunementCompleteEvent extends BaseEvent {

    private final ItemStack input;
    private ItemStack output;
    private final List<ItemStack> additionalOutput = new ArrayList<>();
    private final World world;
    private final IConstellation constellation;

    public AttunementCompleteEvent(ItemStack output, EntityItem input, World world, IConstellation constellation) {
        this.input = input.getItem();
        this.output = output;
        this.world = world;
        this.constellation = constellation;
    }

    public ItemStack getInput() {
        return this.input;
    }

    public ItemStack getOutput() {
        return this.output;
    }

    public void setOutput(ItemStack output) {
        this.output = output;
    }

    public World getWorld() {
        return world;
    }

    public IConstellation getConstellation() {
        return constellation;
    }

    public String getConstellationString() {
        return constellation.getUnlocalizedName();
    }

    public void addAdditionalOutput(ItemStack additionalOutput) {
        this.additionalOutput.add(additionalOutput);
    }

    public List<ItemStack> getAdditionalOutput() {
        return this.additionalOutput;
    }

}
