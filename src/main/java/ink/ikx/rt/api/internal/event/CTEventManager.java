package ink.ikx.rt.api.internal.event;

import crafttweaker.api.event.IEventHandle;
import crafttweaker.api.event.IEventManager;
import crafttweaker.util.EventList;
import crafttweaker.util.IEventHandler;
import ink.ikx.rt.api.mods.botania.event.CTAlfPortalDroppedEvent;
import ink.ikx.rt.api.mods.botania.event.CTElvenTradeEvent;
import ink.ikx.rt.impl.mods.botania.event.AbstractClassImplement;
import ink.ikx.rt.impl.mods.botania.event.AlfPortalDroppedEvent;
import ink.ikx.rt.impl.mods.botania.event.ElvenTradeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.randomtweaker.events.IEventManager")
@ZenExpansion("crafttweaker.events.IEventManager")
public abstract class CTEventManager {

    private static final EventList<CTElvenTradeEvent> elvenTradeEventList = new EventList<>();
    private static final EventList<CTAlfPortalDroppedEvent> alfPortalDroppedEventList = new EventList<>();

    @ZenMethod
    public static IEventHandle onElvenTrade(IEventManager manager, IEventHandler<CTElvenTradeEvent> event) {
        return elvenTradeEventList.add(event);
    }

    @ZenMethod
    public static IEventHandle onAlfPortalDropped(IEventManager manager, IEventHandler<CTAlfPortalDroppedEvent> event) {
        return alfPortalDroppedEventList.add(event);
    }

    @Mod.EventBusSubscriber
    public static final class Handler {

        @SubscribeEvent
        public static void onElvenTrade(ElvenTradeEvent event) {
            if (elvenTradeEventList.hasHandlers()) {
                elvenTradeEventList.publish(new AbstractClassImplement.CTElvenTradeEventImpl(event));
            }
        }

        @SubscribeEvent
        public static void onAlfPortalDropped(AlfPortalDroppedEvent event) {
            if (alfPortalDroppedEventList.hasHandlers()) {
                alfPortalDroppedEventList.publish(new AbstractClassImplement.CTAlfPortalDroppedEventImpl(event));
            }
        }

    }

}
