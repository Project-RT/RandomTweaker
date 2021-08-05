package ink.ikx.rt.api.mods.botania.events;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.entity.IEntityItem;
import crafttweaker.api.event.IEventCancelable;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.api.mods.botania.IMixinTileAlfPortal;
import ink.ikx.rt.impl.events.customevent.AlfPortalDroppedEvent;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenSetter;

@ZenRegister
@ModOnly("botania")
@ZenClass("mods.randomtweaker.AlfPortalDroppedEvent")
public class CTAlfPortalDroppedEvent implements IEventCancelable {

    private final AlfPortalDroppedEvent event;

    public CTAlfPortalDroppedEvent(AlfPortalDroppedEvent event) {
        this.event = event;
    }

    @ZenGetter("alfPortal")
    public IMixinTileAlfPortal getAlfPortal() {
        return event.getAlfPortal();
    }

    @ZenGetter("input")
    public IEntityItem getInput() {
        return CraftTweakerMC.getIEntityItem(event.getInput());
    }

    @ZenGetter("output")
    public IItemStack getOutput() {
        return CraftTweakerMC.getIItemStack(event.getOutput());
    }

    @ZenMethod
    @ZenSetter("output")
    public void setOutput(IItemStack output) {
        event.setOutput(CraftTweakerMC.getItemStack(output));
    }

    @ZenGetter("isDead")
    public boolean isDead() {
        return event.isDead();
    }

    @ZenMethod
    @ZenSetter("isDead")
    public void setDead(boolean dead) {
        event.setDead(dead);
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

