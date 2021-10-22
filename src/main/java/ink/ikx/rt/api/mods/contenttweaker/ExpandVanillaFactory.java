package ink.ikx.rt.api.mods.contenttweaker;

import crafttweaker.annotations.ModOnly;
import ink.ikx.rt.api.mods.contenttweaker.potion.IPotionRepresentation;
import ink.ikx.rt.api.mods.contenttweaker.potion.IPotionTypeRepresentation;
import ink.ikx.rt.impl.mods.contenttweaker.potion.MCPotionRepresentation;
import ink.ikx.rt.impl.mods.contenttweaker.potion.MCPotionTypeRepresentation;
import ink.ikx.rt.impl.mods.crafttweaker.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethodStatic;

@ZenRegister
@ModOnly("contenttweaker")
@ZenExpansion("mods.contenttweaker.VanillaFactory")
@ZenClass("mods.randomtweaker.cote.VanillaFactoryExpansion")
public abstract class ExpandVanillaFactory {

    @ZenMethodStatic
    public static IPotionRepresentation createPotion(String unlocalizedName, int color) {
        return new MCPotionRepresentation(color, unlocalizedName);
    }

    @ZenMethodStatic
    public static IPotionTypeRepresentation createPotionType(String unlocalizedName, IPotionRepresentation potion) {
        return new MCPotionTypeRepresentation(unlocalizedName, potion);
    }

}
