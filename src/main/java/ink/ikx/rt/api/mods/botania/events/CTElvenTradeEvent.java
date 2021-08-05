package ink.ikx.rt.api.mods.botania.events;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.event.IEventCancelable;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.api.mods.botania.IMixinTileAlfPortal;
import ink.ikx.rt.impl.events.customevent.ElvenTradeEvent;
import java.util.Arrays;
import java.util.stream.Collectors;
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

    @ZenGetter("alfPortal")
    public IMixinTileAlfPortal getAlfPortal() {
        return event.getAlfPortal();
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
        event.setOutput(Arrays.stream(CraftTweakerMC.getItemStacks(output)).collect(Collectors.toList()));
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