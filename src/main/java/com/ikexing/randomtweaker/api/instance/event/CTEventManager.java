package com.ikexing.randomtweaker.api.instance.event;

import com.ikexing.randomtweaker.impl.events.SanityChangeEvent;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.event.IEventHandle;
import crafttweaker.api.event.IEventManager;
import crafttweaker.util.EventList;
import crafttweaker.util.IEventHandler;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenExpansion("crafttweaker.events.IEventManager")
public class CTEventManager {

    private static final EventList<CTPlayerSanityChangeEvent> playerSanityChangeEventList = new EventList<>();

    @ZenMethod
    public static IEventHandle onPlayerSanityChange(IEventManager manager,
        IEventHandler<CTPlayerSanityChangeEvent> event) {
        return playerSanityChangeEventList.add(event);
    }

    @EventBusSubscriber
    public static final class Handler {

        @SubscribeEvent
        public static void onPlayerSanityChange(SanityChangeEvent event) {
            if (playerSanityChangeEventList.hasHandlers()) {
                playerSanityChangeEventList.publish(new CTPlayerSanityChangeEvent(event));
            }
        }
    }
}
