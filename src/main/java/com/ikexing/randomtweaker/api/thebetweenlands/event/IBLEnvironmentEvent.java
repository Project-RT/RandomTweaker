package com.ikexing.randomtweaker.api.thebetweenlands.event;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenSetter;
import thebetweenlands.api.environment.IEnvironmentEvent;

@ZenRegister
@ModOnly("thebetweenlands")
@ZenExpansion("mods.randomtweaker.IBLEnvironmentEvent")
public class IBLEnvironmentEvent {
    private final IEnvironmentEvent event;

    public IBLEnvironmentEvent(IEnvironmentEvent event) {
        this.event = event;
    }

    @ZenMethod("isActive")
    public boolean isActive() {
        return event.isActive();
    }

    @ZenMethod("isActiveAt")
    public boolean isActiveAt(double x, double y, double z){
        return event.isActiveAt(x,y,z);
    }

    @ZenGetter("getLocalizationEventName")
    public String getLocalizationEventName() {
        return event.getLocalizationEventName();
    }

    @ZenSetter("resetActiveState")
    public void resetActiveState() {
        event.resetActiveState();
    }

}
