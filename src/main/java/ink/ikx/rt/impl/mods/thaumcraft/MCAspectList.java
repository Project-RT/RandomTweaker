package ink.ikx.rt.impl.mods.thaumcraft;

import com.blamejared.compat.thaumcraft.handlers.aspects.CTAspectStack;
import ink.ikx.rt.api.mods.thaumcraft.IAspect;
import ink.ikx.rt.api.mods.thaumcraft.IAspectList;
import thaumcraft.api.aspects.AspectList;

import java.util.Arrays;

public class MCAspectList implements IAspectList {

    private final AspectList internal;

    public MCAspectList(AspectList internal) {
        this.internal = internal;
    }

    @Override
    public int getSize() {
        return internal.size();
    }

    @Override
    public int getVisSize() {
        return internal.visSize();
    }

    @Override
    public int getAmount(IAspect key) {
        return internal.getAmount(key.getInternal());
    }

    @Override
    public boolean reduce(IAspect key, int amount) {
        return internal.reduce(key.getInternal(), amount);
    }

    @Override
    public IAspectList copy() {
        return IAspectList.of(internal.copy());
    }

    @Override
    public IAspect[] getAspects() {
        return Arrays.stream(internal.getAspects()).map(IAspect::of).toArray(IAspect[]::new);
    }

    @Override
    public IAspect[] getAspectsSortedByName() {
        return Arrays.stream(internal.getAspectsSortedByName()).map(IAspect::of).toArray(IAspect[]::new);
    }

    @Override
    public IAspect[] getAspectsSortedByAmount() {
        return Arrays.stream(internal.getAspectsSortedByAmount()).map(IAspect::of).toArray(IAspect[]::new);
    }

    @Override
    public IAspectList add(IAspectList in) {
        return IAspectList.of(internal.add(in.getInternal()));
    }

    @Override
    public IAspectList add(IAspect aspect, int amount) {
        return IAspectList.of(internal.add(aspect.getInternal(), amount));
    }

    @Override
    public IAspectList remove(IAspect key) {
        return IAspectList.of(internal.remove(key.getInternal()));
    }

    @Override
    public IAspectList remove(IAspect key, int amount) {
        return IAspectList.of(internal.remove(key.getInternal()));
    }

    @Override
    public IAspectList merge(IAspectList in) {
        return IAspectList.of(internal.merge(in.getInternal()));
    }

    @Override
    public IAspectList remove(IAspectList in) {
        return IAspectList.of(internal.remove(in.getInternal()));
    }

    @Override
    public IAspectList merge(IAspect aspect, int amount) {
        return IAspectList.of(internal.merge(aspect.getInternal(), amount));
    }

    @Override
    public boolean reduce(CTAspectStack key) {
        return internal.reduce(key.getInternal().getInternal(), key.getAmount());
    }

    @Override
    public IAspectList add(CTAspectStack in) {
        return IAspectList.of(internal.add(in.getInternal().getInternal(), in.getAmount()));
    }

    @Override
    public IAspectList remove(CTAspectStack key) {
        return IAspectList.of(internal.remove(key.getInternal().getInternal(), key.getAmount()));
    }

    @Override
    public IAspectList merge(CTAspectStack in) {
        return IAspectList.of(internal.merge(in.getInternal().getInternal(), in.getAmount()));
    }

    @Override
    public AspectList getInternal() {
        return this.internal;
    }

}
