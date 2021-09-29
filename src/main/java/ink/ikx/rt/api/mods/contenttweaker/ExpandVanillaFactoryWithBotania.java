package ink.ikx.rt.api.mods.contenttweaker;

import ink.ikx.rt.api.mods.contenttweaker.mana.bauble.IManaBaubleRepresentation;
import ink.ikx.rt.api.mods.contenttweaker.mana.item.IManaItemRepresentation;
import ink.ikx.rt.api.mods.contenttweaker.mana.item.tool.IIsUsesManaItemRepresentation;
import ink.ikx.rt.api.mods.contenttweaker.subtile.functional.ISubTileEntityFunctionalRepresentation;
import ink.ikx.rt.api.mods.contenttweaker.subtile.generating.ISubTileEntityGeneratingRepresentation;
import ink.ikx.rt.impl.mods.contenttweaker.mana.bauble.MCManaBaubleRepresentation;
import ink.ikx.rt.impl.mods.contenttweaker.mana.item.MCManaItemRepresentation;
import ink.ikx.rt.impl.mods.contenttweaker.mana.item.tool.MCIsUsesManaItemRepresentation;
import ink.ikx.rt.impl.mods.contenttweaker.subtile.MCSubTileEntityRepresentation;
import ink.ikx.rt.impl.mods.crafttweaker.ModTotal;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethodStatic;

@ModTotal({"botania", "contenttweaker"})
@ZenExpansion("mods.contenttweaker.VanillaFactory")
@ZenClass("mods.randomtweaker.cote.VanillaFactoryExpansionWithBotania")
public abstract class ExpandVanillaFactoryWithBotania {

    @ZenMethodStatic
    public static IManaItemRepresentation createManaItem(String unlocalizedName, @Optional int maxMana) {
        return new MCManaItemRepresentation(unlocalizedName, maxMana);
    }

    @ZenMethodStatic
    public static IIsUsesManaItemRepresentation createManaUsingItem(String unlocalizedName, @Optional int maxMana) {
        return new MCIsUsesManaItemRepresentation(unlocalizedName, maxMana);
    }

    @ZenMethodStatic
    public static IManaBaubleRepresentation createManaBauble(String unlocalizedName, String baubleType, @Optional int maxMana) {
        return new MCManaBaubleRepresentation(unlocalizedName, maxMana, baubleType);
    }

    @ZenMethodStatic
    public static ISubTileEntityGeneratingRepresentation createSubTileGenerating(String unlocalizedName, @Optional(valueLong = 0x4444FF) int color) {
        return new MCSubTileEntityRepresentation.MCSubTileEntityGeneratingRepresentation(color, unlocalizedName);
    }

    @ZenMethodStatic
    public static ISubTileEntityFunctionalRepresentation createSubTileFunctional(String unlocalizedName, @Optional(valueLong = 0x4444FF) int color) {
        return new MCSubTileEntityRepresentation.MCSubTileEntityFunctionalRepresentation(color, unlocalizedName);
    }

}
