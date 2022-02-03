package ink.ikx.rt.api.mods.astralsorcery.event;

import crafttweaker.annotations.ModOnly;
import crafttweaker.api.event.IEventHandle;
import crafttweaker.api.event.IEventManager;
import crafttweaker.util.EventList;
import crafttweaker.util.IEventHandler;
import ink.ikx.rt.impl.mods.astralsorcery.event.AbstractClassImplement;
import ink.ikx.rt.impl.mods.astralsorcery.event.AttunementRecipeCompleteEvent;
import ink.ikx.rt.impl.mods.astralsorcery.event.AttunementStartEvent;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@RTRegister
@ModOnly("astralsorcery")
@ZenClass("mods.randomtweaker.astralsorcery.IEventManager")
@ZenExpansion("crafttweaker.events.IEventManager")
public abstract class CTEventManagerAS {

    private static final EventList<CTAttunementRecipeCompleteEvent> attunementCompleteEventList = new EventList<>();
    private static final EventList<CTAttunementStartEvent> attunementStartEventList = new EventList<>();

    @ZenMethod
    public static IEventHandle onAttunementRecipeComplete(IEventManager manager, IEventHandler<CTAttunementRecipeCompleteEvent> event) {
        return attunementCompleteEventList.add(event);
    }

    @ZenMethod
    public static IEventHandle onAttunementStart(IEventManager manager, IEventHandler<CTAttunementStartEvent> event) {
        return attunementStartEventList.add(event);
    }

    public static final class Handler {

        @SubscribeEvent
        public static void onAttunementRecipeComplete(AttunementRecipeCompleteEvent event) {
            if (attunementCompleteEventList.hasHandlers()) {
                attunementCompleteEventList.publish(new AbstractClassImplement.CTAttunementRecipeCompleteEventImpl(event));
            }
        }

        @SubscribeEvent
        public static void onAttunementStart(AttunementStartEvent event) {
            if (attunementStartEventList.hasHandlers()) {
                attunementStartEventList.publish(new AbstractClassImplement.CTAttunementStartEventImpl(event));
            }
        }

    }

}
