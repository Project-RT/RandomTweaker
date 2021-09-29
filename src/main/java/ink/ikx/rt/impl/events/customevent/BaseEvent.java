package ink.ikx.rt.impl.events.customevent;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;

public class BaseEvent extends Event {

    public boolean post() {
        return MinecraftForge.EVENT_BUS.post(this);
    }
}
