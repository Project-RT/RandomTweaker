package ink.ikx.rt.impl.mods.botania.event;

import ink.ikx.rt.api.mods.botania.event.CTAlfPortalDroppedEvent;
import ink.ikx.rt.api.mods.botania.event.CTElvenTradeEvent;
import ink.ikx.rt.api.mods.botania.event.CTPoolTradeEvent;

public class AbstractClassImplement {

    public static class CTElvenTradeEventImpl extends CTElvenTradeEvent {

        public CTElvenTradeEventImpl(ElvenTradeEvent event) {
            super(event);
        }

    }

    public static class CTAlfPortalDroppedEventImpl extends CTAlfPortalDroppedEvent {

        public CTAlfPortalDroppedEventImpl(AlfPortalDroppedEvent event) {
            super(event);
        }

    }

    public static class CTPoolTradeEventImpl extends CTPoolTradeEvent {

        public CTPoolTradeEventImpl(PoolTradeEvent event) {
            super(event);
        }

    }

}
