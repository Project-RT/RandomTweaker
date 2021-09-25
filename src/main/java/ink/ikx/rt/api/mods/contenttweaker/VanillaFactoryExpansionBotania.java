package ink.ikx.rt.api.mods.contenttweaker;

import ink.ikx.rt.api.mods.contenttweaker.mana.bauble.IManaBaubleRepresentation;
import ink.ikx.rt.api.mods.contenttweaker.mana.item.IManaItemRepresentation;
import ink.ikx.rt.api.mods.contenttweaker.mana.item.tool.IManaUsingItemRepresentation;
import ink.ikx.rt.impl.mods.contenttweaker.mana.bauble.MCManaBaubleRepresentation;
import ink.ikx.rt.impl.mods.contenttweaker.mana.item.MCManaItemRepresentation;
import ink.ikx.rt.impl.mods.contenttweaker.mana.item.tool.MCManaUsingItemRepresentation;
import ink.ikx.rt.impl.mods.crafttweaker.ModTotal;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethodStatic;

@ModTotal({"botania", "contenttweaker"})
@ZenExpansion("mods.contenttweaker.VanillaFactory")
@ZenClass("mods.randomtweaker.cote.VanillaFactoryExpansionBotania")
public abstract class VanillaFactoryExpansionBotania {

    @ZenMethodStatic
    public static IManaItemRepresentation createManaItem(String unlocalizedName, @Optional int maxMana) {
        return new MCManaItemRepresentation(unlocalizedName, maxMana);
    }

    @ZenMethodStatic
    public static IManaUsingItemRepresentation createManaUsingItem(String unlocalizedName, @Optional int maxMana) {
        return new MCManaUsingItemRepresentation(unlocalizedName, maxMana);
    }

    @ZenMethodStatic
    public static IManaBaubleRepresentation createManaBauble(String unlocalizedName, String baubleType, @Optional int maxMana) {
        return new MCManaBaubleRepresentation(unlocalizedName, maxMana, baubleType);
    }

}
