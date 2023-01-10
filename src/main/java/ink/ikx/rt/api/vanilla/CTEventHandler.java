package ink.ikx.rt.api.vanilla;

import crafttweaker.api.event.IEventHandle;
import crafttweaker.util.EventList;
import crafttweaker.util.IEventHandler;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

/**
 * @author youyihj
 */
@RTRegister
@ZenExpansion("crafttweaker.events.IEventManager")
public class CTEventHandler {
    public static final EventList<IItemAttributeModificationEvent> elAttributeModification = new EventList<>();

    @ZenMethod
    public static IEventHandle onItemAttributeModificationEvent(IEventHandler<IItemAttributeModificationEvent> handler) {
        return elAttributeModification.add(handler);
    }
}
