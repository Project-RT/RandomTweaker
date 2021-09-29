package ink.ikx.rt.api.mods.cote;

import ink.ikx.rt.api.mods.cote.aspect.AspectRepresentation;
import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethodStatic;

@RTRegisterClass({"thaumcraft", "contenttweaker"})
@ZenExpansion("mods.contenttweaker.VanillaFactory")
public class ExpandVanillaFactoryThaumcraft {

    @ZenMethodStatic
    public static AspectRepresentation createAspect(String tag, int color) {
        return new AspectRepresentation(tag, color);
    }

}
