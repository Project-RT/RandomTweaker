package ink.ikx.rt.api.mods.thaumcraft;

import crafttweaker.annotations.ModOnly;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import ink.ikx.rt.impl.mods.thaumcraft.MCAspectList;
import java.util.Arrays;
import java.util.Objects;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

@RTRegister
@ModOnly("thaumcraft")
@ZenClass("mods.randomtweaker.thaumcraft.IAspectList")
public interface IAspectList {

    static IAspectList of(AspectList list) {
        return new MCAspectList(list);
    }

    @ZenMethod
    static IAspectList of() {
        return IAspectList.of(new AspectList());
    }

    @ZenMethod
    static IAspectList of(IAspect... aspect) {
        AspectList list = new AspectList();
        Arrays.stream(aspect).filter(Objects::nonNull).forEach(aspectx -> list.add(aspectx.getInternal(), 1));
        return IAspectList.of(list);
    }

    @ZenMethod
    static IAspectList of(String... aspectName) {
        AspectList list = new AspectList();
        Arrays.stream(aspectName).forEach(aspect -> {
            Aspect aspectCache = Aspect.getAspect(aspect);
            if (Objects.nonNull(aspectCache)) {
                list.add(aspectCache, 1);
            }
        });
        return IAspectList.of(list);
    }

    @ZenMethod
    @ZenGetter("size")
    int getSize();

    @ZenMethod
    @ZenGetter("visSize")
    int getVisSize();

    @ZenMethod
    int getAmount(String key);

    @ZenMethod
    int getAmount(IAspect key);

    @ZenMethod
    IAspectList copy();

    @ZenMethod
    IAspect[] getAspects();

    @ZenMethod
    IAspect[] getAspectsSortedByName();

    @ZenMethod
    IAspect[] getAspectsSortedByAmount();

    @ZenMethod
    IAspectList add(IAspectList in);

    @ZenMethod
    IAspectList add(String key, @Optional(valueLong = 1) int amount);

    @ZenMethod
    IAspectList add(IAspect key, @Optional(valueLong = 1) int amount);

    @ZenMethod
    boolean reduce(String key, @Optional(valueLong = 1) int amount);

    @ZenMethod
    boolean reduce(IAspect key, @Optional(valueLong = 1) int amount);

    @ZenMethod
    IAspectList remove(IAspect key);

    @ZenMethod
    IAspectList remove(String key);

    @ZenMethod
    IAspectList remove(String key, int amount);

    @ZenMethod
    IAspectList remove(IAspect key, int amount);

    @ZenMethod
    IAspectList remove(IAspectList in);

    @ZenMethod
    IAspectList merge(IAspectList in);

    @ZenMethod
    IAspectList merge(String key, @Optional(valueLong = 1) int amount);

    @ZenMethod
    IAspectList merge(IAspect key, @Optional(valueLong = 1) int amount);

    AspectList getInternal();

}
