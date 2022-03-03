package ink.ikx.rt.impl.mods.thaumcraft;

import ink.ikx.rt.api.mods.thaumcraft.IAspect;
import ink.ikx.rt.api.mods.thaumcraft.IAspectList;
import java.util.Arrays;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

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
    public int getAmount(String key) {
        return internal.getAmount(Aspect.getAspect(key));
    }

    @Override
    public int getAmount(IAspect key) {
        return internal.getAmount(key.getInternal());
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
        internal.add(in.getInternal());
        return this;
    }

    @Override
    public IAspectList add(String key, int amount) {
        if(containsKey(key))
            internal.add(getAspect(key), amount);
        return this;
    }

    @Override
    public IAspectList add(IAspect key, int amount) {
        internal.add(key.getInternal(), amount);
        return this;
    }

    @Override
    public boolean reduce(String key, int amount) {
        if(containsKey(key))
            return internal.reduce(getAspect(key), amount);
        return false;
    }

    @Override
    public boolean reduce(IAspect key, int amount) {
        return internal.reduce(key.getInternal(), amount);
    }

    @Override
    public IAspectList remove(String key) {
        if(containsKey(key))
            internal.remove(getAspect(key));
        return this;
    }

    @Override
    public IAspectList remove(IAspect key) {
        internal.remove(key.getInternal());
        return this;
    }

    @Override
    public IAspectList remove(String key, int amount) {
        if(containsKey(key))
            internal.remove(getAspect(key), amount);
        return this;
    }

    @Override
    public IAspectList remove(IAspect key, int amount) {
        internal.remove(key.getInternal(), amount);
        return this;
    }

    @Override
    public IAspectList remove(IAspectList in) {
        internal.remove(in.getInternal());
        return this;
    }

    @Override
    public IAspectList merge(String key, int amount) {
        if(containsKey(key))
            internal.merge(getAspect(key), amount);
        return this;
    }

    @Override
    public IAspectList merge(IAspect key, int amount) {
        internal.merge(key.getInternal(), amount);
        return this;
    }

    @Override
    public IAspectList merge(IAspectList in) {
        internal.merge(in.getInternal());
        return this;
    }

    @Override
    public AspectList getInternal() {
        return this.internal;
    }

    private boolean containsKey(String key) {
        return Aspect.aspects.containsKey(key);
    }

    private Aspect getAspect(String key) {
        return Aspect.getAspect(key);
    }

}
