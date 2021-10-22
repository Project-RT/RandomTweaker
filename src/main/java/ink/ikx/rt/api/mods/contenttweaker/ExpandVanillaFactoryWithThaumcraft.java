package ink.ikx.rt.api.mods.contenttweaker;

import ink.ikx.rt.api.mods.contenttweaker.aspect.IAspectRepresentation;
import ink.ikx.rt.impl.mods.contenttweaker.aspect.MCAspectRepresentation;
import ink.ikx.rt.impl.mods.crafttweaker.ModTotal;
import ink.ikx.rt.impl.mods.crafttweaker.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethodStatic;

@ZenRegister
@ModTotal({"thaumcraft", "contenttweaker"})
@ZenExpansion("mods.contenttweaker.VanillaFactory")
@ZenClass("mods.randomtweaker.cote.VanillaFactoryExpansionWithThaumcraft")
public abstract class ExpandVanillaFactoryWithThaumcraft {

    @ZenMethodStatic
    public static IAspectRepresentation createAspect(String tag, int color) {
        return new MCAspectRepresentation(tag, color);
    }

}