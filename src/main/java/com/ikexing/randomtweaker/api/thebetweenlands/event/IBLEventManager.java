package com.ikexing.randomtweaker.api.thebetweenlands.event;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.event.IEventHandle;
import crafttweaker.api.event.IEventManager;
import crafttweaker.util.EventList;
import crafttweaker.util.IEventHandler;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ModOnly("thebetweenlands")
@ZenExpansion("crafttweaker.events.IEventManager")
public class IBLEventManager {
    private static final EventList<IBLEnvironmentEvent> elBLEnvironmentEvent = new EventList<>();

    public IBLEventManager() {
    }

    @ZenMethod
    public static IEventHandle onBLEnvironment(IEventManager manager, IEventHandler<IBLEnvironmentEvent> ev) {
        return elBLEnvironmentEvent.add(ev);
    }
}
