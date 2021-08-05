package ink.ikx.rt.api.internal.event;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.event.IEventCancelable;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import ink.ikx.rt.impl.events.customevent.SanityChangeEvent;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;

@ZenRegister
@ZenClass("mods.randomtweaker.PlayerSanityChangeEvent")
public class CTPlayerSanityChangeEvent implements IEventCancelable {

    private final SanityChangeEvent event;

    public CTPlayerSanityChangeEvent(SanityChangeEvent event) {
        this.event = event;
    }

    @ZenGetter("player")
    public IPlayer getPlayer() {
        return CraftTweakerMC.getIPlayer(event.getPlayer());
    }

    @ZenGetter("sanity")
    public float getSanity() {
        return event.getSanity();
    }

    @ZenGetter("originalSanity")
    public float getOriginalSanity(){
        return event.getOriginalSanity();
    }

    @Override
    public boolean isCanceled() {
        return event.isCanceled();
    }

    @Override
    public void setCanceled(boolean canceled) {
        event.setCanceled(canceled);
    }
}
