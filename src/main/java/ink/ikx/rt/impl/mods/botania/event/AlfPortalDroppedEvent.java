package ink.ikx.rt.impl.mods.botania.event;

import ink.ikx.rt.api.mods.botania.ITileAlfPortal;
import ink.ikx.rt.impl.internal.event.BaseEvent;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

import java.util.List;

@Cancelable
public class AlfPortalDroppedEvent extends BaseEvent {

    private final EntityItem input;
    private final ITileAlfPortal alfPortal;

    private boolean isDead = true;
    private List<ItemStack> output;

    public AlfPortalDroppedEvent(EntityItem input, ITileAlfPortal alfPortal) {
        this.input = input;
        this.alfPortal = alfPortal;
    }

    public EntityItem getInput() {
        return input;
    }

    public ITileAlfPortal getAlfPortal() {
        return alfPortal;
    }

    public List<ItemStack> getOutput() {
        return output;
    }

    public void setOutput(List<ItemStack> output) {
        this.output = output;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

}
