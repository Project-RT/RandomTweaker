package ink.ikx.rt.impl.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

@Cancelable
public class SanityChangeEvent extends Event {

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
