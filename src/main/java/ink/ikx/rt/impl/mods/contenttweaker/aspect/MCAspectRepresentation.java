package ink.ikx.rt.impl.mods.contenttweaker.aspect;

import com.teamacronymcoders.contenttweaker.api.ctobjects.resourcelocation.CTResourceLocation;
import ink.ikx.rt.api.mods.contenttweaker.aspect.IAspectRepresentation;
import thaumcraft.api.aspects.Aspect;

public class MCAspectRepresentation extends IAspectRepresentation {

    public MCAspectRepresentation(String tag, int color) {
        this.setTag(tag);
        this.setColor(color);
        this.setImage(CTResourceLocation.create("contenttweaker:textures/aspects/" + tag.toLowerCase() + ".png"));
    }

    @Override
    public void register() {
        new Aspect(this.tag, this.color, this.asAspects(), this.image.getInternal(), this.blend);
    }

}
