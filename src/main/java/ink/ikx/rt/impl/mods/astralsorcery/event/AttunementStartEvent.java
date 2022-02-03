package ink.ikx.rt.impl.mods.astralsorcery.event;

import hellfirepvp.astralsorcery.common.constellation.IConstellation;
import ink.ikx.rt.impl.internal.event.BaseEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

import java.util.ArrayList;
import java.util.List;

@Cancelable
public class AttunementStartEvent extends BaseEvent {

    private final Entity inputEntity;
    private final World world;
    private final IConstellation constellation;

    public AttunementStartEvent(Entity input, World world, IConstellation constellation) {
        this.inputEntity = input;
        this.world = world;
        this.constellation = constellation;
    }

    public World getWorld() {
        return world;
    }

    public IConstellation getConstellation() {
        return constellation;
    }

    public String getConstellationString() {
        return constellation.getUnlocalizedName();
    }

    public Entity getInputEntity(){ return inputEntity; }

}
