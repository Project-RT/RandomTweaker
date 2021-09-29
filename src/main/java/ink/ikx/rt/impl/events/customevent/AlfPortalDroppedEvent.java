package ink.ikx.rt.impl.events.customevent;

import ink.ikx.rt.api.mods.botania.IMixinTileAlfPortal;
import java.util.List;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

@Cancelable
public class AlfPortalDroppedEvent extends BaseEvent {

    private final EntityItem input;
    private final IMixinTileAlfPortal alfPortal;

    private boolean isDead = true;
    private List<ItemStack> output = null;

    public AlfPortalDroppedEvent(EntityItem input, IMixinTileAlfPortal alfPortal) {
        this.input = input;
        this.alfPortal = alfPortal;
    }

    public EntityItem getInput() {
        return input;
    }

    public IMixinTileAlfPortal getAlfPortal() {
        return alfPortal;
    }

    public List<ItemStack> getOutput() {
        return output;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public void setOutput(List<ItemStack> output) {
        this.output = output;
    }
}
