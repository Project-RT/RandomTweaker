package ink.ikx.rt.impl.events.customevent;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

@Cancelable
public class SanityChangeEvent extends BaseEvent {

    private final EntityPlayer player;
    private final float sanity;
    private final int originalSanity;

    public SanityChangeEvent(float sanity, int originalSanity, EntityPlayer player) {
        this.sanity = sanity;
        this.player = player;
        this.originalSanity = originalSanity;
    }

    public int getOriginalSanity() {
        return originalSanity;
    }

    public float getSanity() {
        return sanity;
    }

    public EntityPlayer getPlayer() {
        return player;
    }
}
