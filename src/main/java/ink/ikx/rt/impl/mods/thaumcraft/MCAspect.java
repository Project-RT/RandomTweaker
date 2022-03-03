package ink.ikx.rt.impl.mods.thaumcraft;

import ink.ikx.rt.api.mods.thaumcraft.IAspect;
import java.util.Arrays;
import java.util.Objects;
import thaumcraft.api.aspects.Aspect;

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
        return Objects.nonNull(internal.getComponents()) ? Arrays.stream(this.internal.getComponents()).map(IAspect::of).toArray(IAspect[]::new) : null;
    }

    @Override
    public Aspect getInternal() {
        return this.internal;
    }

}
