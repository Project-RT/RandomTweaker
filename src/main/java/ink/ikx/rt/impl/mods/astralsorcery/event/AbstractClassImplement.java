package ink.ikx.rt.impl.mods.astralsorcery.event;

import ink.ikx.rt.api.mods.astralsorcery.event.CTAttunementRecipeCompleteEvent;
import ink.ikx.rt.api.mods.astralsorcery.event.CTAttunementStartEvent;

public class AbstractClassImplement {

    public static class CTAttunementRecipeCompleteEventImpl extends CTAttunementRecipeCompleteEvent {

        public CTAttunementRecipeCompleteEventImpl(AttunementRecipeCompleteEvent event) {
            super(event);
        }

    }

    public static class CTAttunementStartEventImpl extends CTAttunementStartEvent {

        public CTAttunementStartEventImpl(AttunementStartEvent event) {
            super(event);
        }

    }


}
