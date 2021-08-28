package ink.ikx.rt.api.internal.event;

import crafttweaker.api.event.IEventHandle;
import crafttweaker.api.event.IEventManager;
import crafttweaker.util.EventList;
import crafttweaker.util.IEventHandler;
import ink.ikx.rt.api.mods.botania.events.CTAlfPortalDroppedEvent;
import ink.ikx.rt.api.mods.botania.events.CTElvenTradeEvent;
import ink.ikx.rt.api.mods.botania.events.CTPoolTradeEvent;
import ink.ikx.rt.impl.events.customevent.AlfPortalDroppedEvent;
import ink.ikx.rt.impl.events.customevent.ElvenTradeEvent;
import ink.ikx.rt.impl.events.customevent.PoolTradeEvent;
import ink.ikx.rt.impl.events.customevent.SanityChangeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenExpansion("crafttweaker.events.IEventManager")
public class CTEventManager {

    private static final EventList<CTPlayerSanityChangeEvent> playerSanityChangeEventList = new EventList<>();
    private static final EventList<CTElvenTradeEvent> elvenTradeEventList = new EventList<>();
    private static final EventList<CTAlfPortalDroppedEvent> alfPortalDroppedEventList = new EventList<>();
    private static final EventList<CTPoolTradeEvent> poolTradeEventList = new EventList<>();

    @ZenMethod
    public static IEventHandle onPlayerSanityChange(IEventManager manager, IEventHandler<CTPlayerSanityChangeEvent> event) {
        return playerSanityChangeEventList.add(event);
    }

    @ZenMethod
    public static IEventHandle onElvenTrade(IEventManager manager, IEventHandler<CTElvenTradeEvent> event) {
        return elvenTradeEventList.add(event);
    }

    @ZenMethod
    public static IEventHandle onAlfPortalDropped(IEventManager manager, IEventHandler<CTAlfPortalDroppedEvent> event) {
        return alfPortalDroppedEventList.add(event);
    }

    @ZenMethod
    public static IEventHandle onPoolTrade(IEventManager manager, IEventHandler<CTPoolTradeEvent> event) {
        return poolTradeEventList.add(event);
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
            if (elvenTradeEventList.hasHandlers()) {
                elvenTradeEventList.publish(new CTElvenTradeEvent(event));
            }
        }

        @SubscribeEvent
        public static void onAlfPortalDropped(AlfPortalDroppedEvent event) {
            if (alfPortalDroppedEventList.hasHandlers()) {
                alfPortalDroppedEventList.publish(new CTAlfPortalDroppedEvent(event));
            }
        }

        @SubscribeEvent
        public static void onPoolTrade(PoolTradeEvent event) {
            if (poolTradeEventList.hasHandlers()) {
                poolTradeEventList.publish(new CTPoolTradeEvent(event));
            }
        }

    }
}
