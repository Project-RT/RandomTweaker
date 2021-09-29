package ink.ikx.rt.api.mods.cote.aspect;

import com.teamacronymcoders.contenttweaker.api.ctobjects.resourcelocation.CTResourceLocation;
import crafttweaker.CraftTweakerAPI;
import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;
import thaumcraft.api.aspects.Aspect;

@RTRegisterClass({"thaumcraft", "contenttweaker"})
@ZenClass("mods.randomtweaker.cote.Aspect")
public class AspectRepresentation {

    @ZenProperty
    public int color;
    @ZenProperty
    public String tag;
    @ZenProperty
    public int blend = 1;
    @ZenProperty
    public String[] components;
    @ZenProperty
    public CTResourceLocation image;

    public AspectRepresentation(String tag, int color) {
        this.setTag(tag);
        this.setColor(color);
        this.setImage(CTResourceLocation.create("contenttweaker:textures/aspects/" + tag.toLowerCase() + ".png"));
    }

    public Aspect[] asAspects() {
        if (Objects.nonNull(components)) {
            if (components.length != 2) {
                CraftTweakerAPI.logError("components' length must be two");
                return null;
            }

            List<Aspect> aspects = new ArrayList<>();
            for (String aspect : components) {
                aspects.add(Aspect.getAspect(aspect));
            }
            return aspects.toArray(new Aspect[0]);
        }
        return null;
    }

    @ZenMethod
    public String getTag() {
        return tag;
    }

    @ZenMethod
    public void setTag(String tag) {
        this.tag = tag;
    }

    @ZenMethod
    public int getColor() {
        return color;
    }

    @ZenMethod
    public void setColor(int color) {
        this.color = color;
    }

    @ZenMethod
    public CTResourceLocation getImage() {
        return image;
    }

    @ZenMethod
    public void setImage(CTResourceLocation image) {
        this.image = image;
    }

    @ZenMethod
    public int getBlend() {
        return blend;
    }

    @ZenMethod
    public void setBlend(int blend) {
        this.blend = blend;
    }

    @ZenMethod
    public void register() {
        new Aspect(this.tag, this.color, this.asAspects(), this.image.getInternal(), this.blend);
    }
}
