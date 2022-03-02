package ink.ikx.rt.api.mods.modtweaker;

import com.blamejared.compat.thaumcraft.handlers.aspects.CTAspect;
import crafttweaker.annotations.ModOnly;
import ink.ikx.rt.api.mods.thaumcraft.IAspect;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@RTRegister
@ModOnly("thaumcraft")
@ZenExpansion("thaumcraft.aspect.CTAspect")
@ZenClass("mods.randomtweaker.modtweaker.CTAspect")
public class ExpandCTAspect {

    @ZenMethod
    public static IAspect asIAstral(CTAspect aspect) {
        return IAspect.of(aspect.getInternal());
    }

}
