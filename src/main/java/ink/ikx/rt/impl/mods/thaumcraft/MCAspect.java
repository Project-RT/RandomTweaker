package ink.ikx.rt.impl.mods.thaumcraft;

import com.blamejared.compat.thaumcraft.handlers.aspects.CTAspect;
import ink.ikx.rt.api.mods.thaumcraft.IAspect;
import thaumcraft.api.aspects.Aspect;

import java.util.Arrays;

public class MCAspect implements IAspect {

    private final Aspect internal;

    public MCAspect(Aspect aspect) {
        this.internal = aspect;
    }

    @Override
    public String getName() {
        return this.internal.getName();
    }

    @Override
    public IAspect[] getComponents() {
        return Arrays.stream(this.internal.getComponents()).map(IAspect::of).toArray(IAspect[]::new);
    }

    @Override
    public CTAspect asCTAspect() {
        return new CTAspect(this.internal);
    }

    @Override
    public Aspect getInternal() {
        return this.internal;
    }

}
