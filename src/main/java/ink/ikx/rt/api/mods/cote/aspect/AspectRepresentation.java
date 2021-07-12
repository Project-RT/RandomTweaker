package ink.ikx.rt.api.mods.cote.aspect;

import crafttweaker.CraftTweakerAPI;
import java.util.ArrayList;
import java.util.Objects;
import net.minecraft.util.ResourceLocation;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;
import thaumcraft.api.aspects.Aspect;

@ZenClass("mods.randomtweaker.cote.Aspect")
public class AspectRepresentation {

    @ZenProperty
    public String tag;
    @ZenProperty
    public int color;
    @ZenProperty
    public String image;
    @ZenProperty
    public int blend = 1;
    @ZenProperty
    public String[] components;

    public AspectRepresentation(String tag, int color) {
        this.tag = tag;
        this.color = color;
    }

    public Aspect[] asAspects() {
        if (Objects.nonNull(components)) {
            if (components.length != 2) {
                CraftTweakerAPI.logError("components' length must be two");
                return null;
            }

            ArrayList<Aspect> aspects = new ArrayList<>();
            for (String aspect : components) {
                aspects.add(Aspect.getAspect(aspect));
            }
            return (Aspect[]) aspects.toArray();
        }
        return null;
    }

    public ResourceLocation getResourceLocation() {
        if (Objects.nonNull(image)) {
            return new ResourceLocation(image.split(":")[0], image.split(":")[1]);
        }
        return new ResourceLocation("contenttweaker", "textures/aspects/" + tag.toLowerCase() + ".png");
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
    public String getImage() {
        return image;
    }

    @ZenMethod
    public void setImage(String image) {
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
        new Aspect(tag, color, this.asAspects(), this.getResourceLocation(), blend);
    }
}
