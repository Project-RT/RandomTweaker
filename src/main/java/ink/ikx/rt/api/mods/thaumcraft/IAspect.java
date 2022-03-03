package ink.ikx.rt.api.mods.thaumcraft;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import ink.ikx.rt.impl.mods.thaumcraft.MCAspect;
import org.apache.commons.lang3.StringUtils;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;
import thaumcraft.api.aspects.Aspect;

@RTRegister
@ModOnly("thaumcraft")
@ZenClass("mods.randomtweaker.thaumcraft.IAspect")
public interface IAspect {

    static IAspect of(Aspect aspect) {
        return new MCAspect(aspect);
    }

    @ZenMethod
    static IAspect of(String name) {
        if (StringUtils.isAnyBlank(name) || !Aspect.aspects.containsKey(name)) {
            CraftTweakerAPI.logError("Invalid aspect name: " + name);
            return null;
        }
        return IAspect.of(Aspect.getAspect(name));
    }

    @ZenMethod
    static IAspect[] getAllAspects() {
        return Aspect.aspects.values().stream().map(IAspect::of).toArray(IAspect[]::new);
    }

    @ZenMethod
    @ZenGetter("name")
    String getName();

    @ZenMethod
    @ZenGetter("components")
    IAspect[] getComponents();

    @ZenMethod
    @ZenGetter("chatColor")
    String getChatcolor();

    Aspect getInternal();

}
