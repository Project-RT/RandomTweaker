package ink.ikx.rt.impl.mods.contenttweaker.aspect;

import ink.ikx.rt.api.mods.contenttweaker.aspect.IAspectRepresentation;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.aspects.Aspect;

public class MCAspectRepresentation extends IAspectRepresentation {

    public MCAspectRepresentation(String tag, int color) {
        this.setTag(tag);
        this.setColor(color);
        this.setImage("contenttweaker:textures/aspects/" + tag.toLowerCase() + ".png");
    }

    @Override
    public void register() {
        new Aspect(this.tag, this.color, this.asAspects(), new ResourceLocation(this.image), this.blend);
    }

}
