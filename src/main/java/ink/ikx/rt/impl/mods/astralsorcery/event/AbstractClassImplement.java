package ink.ikx.rt.impl.mods.astralsorcery.event;

import ink.ikx.rt.api.mods.astralsorcery.event.CTAttunementCompleteEvent;
import ink.ikx.rt.api.mods.astralsorcery.event.CTAttunementStartEvent;

public class AbstractClassImplement {

    public static class CTAttunementCompleteEventImpl extends CTAttunementCompleteEvent {

        public CTAttunementCompleteEventImpl(AttunementCompleteEvent event) {
            super(event);
        }

    }

    public static class CTAttunementStartEventImpl extends CTAttunementStartEvent {

        public CTAttunementStartEventImpl(AttunementStartEvent event) {
            super(event);
        }

    }


}
