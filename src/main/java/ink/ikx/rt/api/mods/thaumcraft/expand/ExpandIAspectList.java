package ink.ikx.rt.api.mods.thaumcraft.expand;

import com.blamejared.compat.thaumcraft.handlers.aspects.CTAspectStack;
import ink.ikx.rt.api.mods.thaumcraft.IAspectList;
import ink.ikx.rt.impl.mods.crafttweaker.ModTotal;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@RTRegister
@ModTotal({"thaumcraft", "modtweaker"})
@ZenExpansion("mods.randomtweaker.thaumcraft.IAspectList")
@ZenClass("mods.randomtweaker.thaumcraft.expand.IAspectList")
public class ExpandIAspectList {

    @ZenMethod
    public static IAspectList add(IAspectList internal, CTAspectStack in) {
        internal.getInternal().add(in.getInternal().getInternal(), in.getAmount());
        return internal;
    }

    @ZenMethod
    public static boolean reduce(IAspectList internal, CTAspectStack key) {
        return internal.getInternal().reduce(key.getInternal().getInternal(), key.getAmount());
    }

    @ZenMethod
    public static IAspectList remove(IAspectList internal, CTAspectStack key) {
        internal.getInternal().remove(key.getInternal().getInternal(), key.getAmount());
        return internal;
    }

    @ZenMethod
    public static IAspectList merge(IAspectList internal, CTAspectStack in) {
        internal.getInternal().merge(in.getInternal().getInternal(), in.getAmount());
        return internal;
    }

}
