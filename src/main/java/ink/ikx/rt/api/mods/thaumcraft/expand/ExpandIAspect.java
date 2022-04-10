package ink.ikx.rt.api.mods.thaumcraft.expand;

import com.blamejared.compat.thaumcraft.handlers.aspects.CTAspect;
import ink.ikx.rt.api.mods.thaumcraft.IAspect;
import ink.ikx.rt.impl.mods.crafttweaker.ModTotal;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import stanhebben.zenscript.annotations.ZenCaster;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@RTRegister
@ModTotal({"thaumcraft", "modtweaker"})
@ZenExpansion("mods.randomtweaker.thaumcraft.IAspect")
@ZenClass("mods.randomtweaker.thaumcraft.expand.IAspect")
public abstract class ExpandIAspect {

    @ZenMethod
    @ZenCaster
    public static CTAspect asCTAspect(IAspect internal) {
        return new CTAspect(internal.getInternal());
    }

}
