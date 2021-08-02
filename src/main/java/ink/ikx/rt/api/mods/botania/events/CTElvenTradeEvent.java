package ink.ikx.rt.api.mods.botania.events;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.event.IEventCancelable;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IWorld;
import ink.ikx.rt.impl.events.customevent.ElvenTradeEvent;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenSetter;

@ZenRegister
@ModOnly("botania")
@ZenClass("mods.randomtweaker.ElvenTradeEvent")
public class CTElvenTradeEvent implements IEventCancelable {

    private final ElvenTradeEvent event;

    public CTElvenTradeEvent(ElvenTradeEvent event) {
        this.event = event;
    }

    @ZenGetter("world")
    public IWorld getWorld() {
        return CraftTweakerMC.getIWorld(event.getWorld());
    }

    @ZenGetter("pos")
    public IBlockPos getPos() {
        return CraftTweakerMC.getIBlockPos(event.getBlockPos());
    }

    @ZenGetter("input")
    public IItemStack[] getInput() {
        return CraftTweakerMC.getIItemStacks(event.getInput());
    }

    @ZenGetter("output")
    public IItemStack[] getOutput() {
        return CraftTweakerMC.getIItemStacks(event.getOutput());
    }

    @ZenSetter("output")
    @ZenMethod
    public void setOutput(IItemStack[] output) {
        event.setOutput(CraftTweakerMC.getItemStacks(output));
    }

    @ZenMethod
    public void addOutput(IItemStack stack) {
        event.addOutput(CraftTweakerMC.getItemStack(stack));
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