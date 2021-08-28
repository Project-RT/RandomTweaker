package ink.ikx.rt.api.mods.botania.events;

import crafttweaker.annotations.ModOnly;
import crafttweaker.api.entity.IEntityItem;
import crafttweaker.api.event.IEventCancelable;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.api.mods.botania.IMixinTileAlfPortal;
import ink.ikx.rt.impl.events.customevent.AlfPortalDroppedEvent;
import ink.ikx.rt.impl.utils.Utils;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenSetter;

import java.util.Arrays;
import java.util.stream.Collectors;

@ModOnly("botania")
@ZenClass("mods.randomtweaker.botania.AlfPortalDroppedEvent")
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
    public IItemStack[] getOutput() {
        return CraftTweakerMC.getIItemStacks(Utils.getItemStackListCopy(event.getOutput()));
    }

    @ZenMethod
    public void setOutput(IItemStack[] output) {
        event.setOutput(Arrays.stream(CraftTweakerMC.getItemStacks(output)).collect(Collectors.toList()));
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
