package ink.ikx.rt.api.mods.botania.events;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.event.IEventCancelable;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IWorld;
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

    @ZenGetter("world")
    public IWorld getWorld() {
        return CraftTweakerMC.getIWorld(event.getWorld());
    }

    @ZenGetter("blockPos")
    public IBlockPos getBlockPos() {
        return CraftTweakerMC.getIBlockPos(event.getBlockPos());
    }

    @ZenGetter("input")
    public IItemStack getInput() {
        return CraftTweakerMC.getIItemStack(event.getInput());
    }

    @ZenGetter("output")
    public IItemStack getOutput() {
        return CraftTweakerMC.getIItemStack(event.getOutput());
    }

    @ZenMethod
    @ZenSetter("output")
    public void IItemStack(IItemStack output) {
        event.setOutput(CraftTweakerMC.getItemStack(output));
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

