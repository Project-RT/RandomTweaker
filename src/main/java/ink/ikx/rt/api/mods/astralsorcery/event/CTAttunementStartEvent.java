package ink.ikx.rt.api.mods.astralsorcery.event;

import crafttweaker.annotations.ModOnly;
import crafttweaker.api.entity.IEntity;
import crafttweaker.api.event.IEntityEvent;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.impl.mods.astralsorcery.event.AttunementStartEvent;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import net.minecraft.world.World;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;

@RTRegister
@ModOnly("astralsorcery")
@ZenClass("mods.randomtweaker.astralsorcery.AttunementCompleteEvent")
public abstract class CTAttunementStartEvent implements IEntityEvent {

    private final AttunementStartEvent event;

    public CTAttunementStartEvent(AttunementStartEvent event) {
        this.event = event;
    }

    @ZenGetter("world")
    @ZenMethod
    public World getWorld() {
        return this.event.getWorld();
    }

    @ZenGetter("constellation")
    @ZenMethod
    public String getConstellation() {
        return this.event.getConstellation().getUnlocalizedName();
    }

    //the entity being attuned
    @ZenGetter("entity")
    public IEntity getEntity() {return (IEntity) this.event.getInputEntity();}

}
