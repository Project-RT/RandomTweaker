package ink.ikx.rt.api.mods.thaumcraft;

import com.blamejared.compat.thaumcraft.handlers.aspects.CTAspectStack;
import crafttweaker.annotations.ModOnly;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import ink.ikx.rt.impl.mods.thaumcraft.MCAspectList;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;
import thaumcraft.api.aspects.AspectList;

@RTRegister
@ModOnly("thaumcraft")
@ZenClass("mods.randomtweaker.thaumcraft.IAspectList")
public interface IAspectList {

    static MCAspectList of(AspectList list) {
        return new MCAspectList(list);
    }

    @ZenMethod
    @ZenGetter("size")
    int getSize();

    @ZenMethod
    @ZenGetter("visSize")
    int getVisSize();

    @ZenMethod
    int getAmount(IAspect key);

    @ZenMethod
    boolean reduce(IAspect key, int amount);

    @ZenMethod
    @ModOnly("modtweaker")
    boolean reduce(CTAspectStack key);

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
    IAspectList add(IAspect aspect, int amount);

    @ZenMethod
    @ModOnly("modtweaker")
    IAspectList add(CTAspectStack in);

    @ZenMethod
    IAspectList remove(IAspect key);

    @ZenMethod
    IAspectList remove(IAspect key, int amount);

    @ZenMethod
    @ModOnly("modtweaker")
    IAspectList remove(CTAspectStack key);

    @ZenMethod
    IAspectList merge(IAspectList in);

    @ZenMethod
    @ModOnly("modtweaker")
    IAspectList merge(CTAspectStack in);

    @ZenMethod
    IAspectList remove(IAspectList in);

    @ZenMethod
    IAspectList merge(IAspect aspect, int amount);

    AspectList getInternal();

}
