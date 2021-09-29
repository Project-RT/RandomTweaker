package ink.ikx.rt.api.mods.cote;

import ink.ikx.rt.api.mods.cote.flower.functional.SubTileFunctionalRepresentation;
import ink.ikx.rt.api.mods.cote.flower.generating.SubTileGeneratingRepresentation;
import ink.ikx.rt.api.mods.cote.mana.bauble.ManaBaubleRepresentation;
import ink.ikx.rt.api.mods.cote.mana.item.ManaItemRepresentation;
import ink.ikx.rt.api.mods.cote.mana.item.tool.ManaUsingItemRepresentation;
import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethodStatic;

@RTRegisterClass({"botania", "contenttweaker"})
@ZenExpansion("mods.contenttweaker.VanillaFactory")
public class ExpandVanillaFactoryBotania {

    @ZenMethodStatic
    public static ManaItemRepresentation createManaItem(String unlocalizedName, @Optional int maxMana) {
        return new ManaItemRepresentation(unlocalizedName, maxMana);
    }

    @ZenMethodStatic
    public static ManaUsingItemRepresentation createManaUsingItem(String unlocalizedName, @Optional int maxMana) {
        return new ManaUsingItemRepresentation(unlocalizedName, maxMana);
    }

    @ZenMethodStatic
    public static ManaBaubleRepresentation createManaBauble(String unlocalizedName, String baubleType, @Optional int maxMana) {
        return new ManaBaubleRepresentation(unlocalizedName, maxMana, baubleType);
    }

    @ZenMethodStatic
    public static SubTileGeneratingRepresentation createSubTileGenerating(String unlocalizedName, int color) {
        return new SubTileGeneratingRepresentation(color, unlocalizedName);
    }

    @ZenMethodStatic
    public static SubTileFunctionalRepresentation createSubTileFunctional(String unlocalizedName, int color) {
        return new SubTileFunctionalRepresentation(color, unlocalizedName);
    }

}
