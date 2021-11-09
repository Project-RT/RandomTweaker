package ink.ikx.rt.api.mods.astralsorcery.event;

import crafttweaker.annotations.ModOnly;
import crafttweaker.api.event.IEventCancelable;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.impl.mods.astralsorcery.event.AttunementCompleteEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenSetter;

import java.util.List;

@ModOnly("astralsorcery")
@ZenClass("mods.randomtweaker.astralsorcery.AttunementCompleteEvent")
public abstract class CTAttunementCompleteEvent implements IEventCancelable {

    private final AttunementCompleteEvent event;

    public CTAttunementCompleteEvent(AttunementCompleteEvent event) {
        this.event = event;
    }

    @ZenGetter("input")
    public IItemStack getInput() {
        return CraftTweakerMC.getIItemStack(this.event.getInput());
    }

    @ZenGetter("output")
    public IItemStack getOutput() {
        return CraftTweakerMC.getIItemStack(this.event.getOutput());
    }

    @ZenSetter("output")
    public void setOutput(IItemStack output) {
        this.event.setOutput(CraftTweakerMC.getItemStack(output));
    }

    @ZenGetter("world")
    public World getWorld() {
        return this.event.getWorld();
    }

    @ZenGetter("constellation")
    public String getConstellation() {
        return this.event.getConstellation().getUnlocalizedName();
    }

    @ZenSetter("additionalOutput")
    @ZenMethod
    public void addAdditionalOutput(IItemStack additionalOutput) {
        this.event.getAdditionalOutput().add(CraftTweakerMC.getItemStack(additionalOutput));
    }

    @ZenGetter("additionalOutput")
    @ZenMethod
    public List<ItemStack> getAdditionalOutput() {
        return this.event.getAdditionalOutput();
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
