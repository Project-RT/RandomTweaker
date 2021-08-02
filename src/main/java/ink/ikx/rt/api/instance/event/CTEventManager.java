package ink.ikx.rt.api.instance.event;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.event.IEventHandle;
import crafttweaker.api.event.IEventManager;
import crafttweaker.util.EventList;
import crafttweaker.util.IEventHandler;
import ink.ikx.rt.api.mods.botania.events.CTAlfPortalDroppedEvent;
import ink.ikx.rt.api.mods.botania.events.CTElvenTradeEvent;
import ink.ikx.rt.impl.events.AlfPortalDroppedEvent;
import ink.ikx.rt.impl.events.ElvenTradeEvent;
import ink.ikx.rt.impl.events.SanityChangeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenExpansion("crafttweaker.events.IEventManager")
public class CTEventManager {

    private static final EventList<CTPlayerSanityChangeEvent> playerSanityChangeEventList = new EventList<>();
    private static final EventList<CTElvenTradeEvent> elvenTradeEvent = new EventList<>();
    private static final EventList<CTAlfPortalDroppedEvent> alfPortalDroppedEvent = new EventList<>();

    @ZenMethod
    public static IEventHandle onPlayerSanityChange(IEventManager manager, IEventHandler<CTPlayerSanityChangeEvent> event) {
        return playerSanityChangeEventList.add(event);
    }

    @ZenMethod
    public static IEventHandle onElvenTrade(IEventManager manager, IEventHandler<CTElvenTradeEvent> event) {
        return elvenTradeEvent.add(event);
    }

    @ZenMethod
    public static IEventHandle onAlfPortalDropped(IEventManager manager, IEventHandler<CTAlfPortalDroppedEvent> event) {
        return alfPortalDroppedEvent.add(event);
    }

    @EventBusSubscriber
    public static final class Handler {

        @SubscribeEvent
        public static void onPlayerSanityChange(SanityChangeEvent event) {
            if (playerSanityChangeEventList.hasHandlers()) {
                playerSanityChangeEventList.publish(new CTPlayerSanityChangeEvent(event));
            }
        }

        @SubscribeEvent
        public static void onElvenTrade(ElvenTradeEvent event) {
            if (elvenTradeEvent.hasHandlers()) {
                elvenTradeEvent.publish(new CTElvenTradeEvent(event));
            }
        }

        @SubscribeEvent
        public static void onAlfPortalDropped(AlfPortalDroppedEvent event) {
            if (alfPortalDroppedEvent.hasHandlers()) {
                alfPortalDroppedEvent.publish(new CTAlfPortalDroppedEvent(event));
            }
        }

    }
}
