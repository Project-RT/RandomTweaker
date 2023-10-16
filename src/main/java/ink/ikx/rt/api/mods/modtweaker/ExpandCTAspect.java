package ink.ikx.rt.api.mods.modtweaker;

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
@ZenExpansion("thaumcraft.aspect.CTAspect")
@ZenClass("mods.randomtweaker.modtweaker.CTAspect")
public  class ExpandCTAspect {

    @ZenMethod
    @ZenCaster
    public static IAspect asIAstral(CTAspect aspect) {
        return IAspect.of(aspect.getInternal());
    }

}
