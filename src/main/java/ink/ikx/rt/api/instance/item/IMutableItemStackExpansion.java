package ink.ikx.rt.api.instance.item;

import crafttweaker.api.item.IMutableItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.api.mods.cote.mana.ManaBaubleContent;
import ink.ikx.rt.api.mods.cote.mana.ManaItemContent;
import ink.ikx.rt.impl.item.ManaBaubleImpl;
import ink.ikx.rt.impl.item.ManaItemImpl;
import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

/**
 * @author superhelo
 */
@RTRegisterClass({"zenutils", "botania"})
@ZenExpansion("crafttweaker.item.IMutableItemStack")
public class ManaHelper {

    @ZenMethod
    public static boolean isIManaItem(IMutableItemStack stack) {
        return CraftTweakerMC.getItemStack(stack).getItem() instanceof ManaItemContent;
    }

    @ZenMethod
    public static boolean isIManaBauble(IMutableItemStack stack) {
        return CraftTweakerMC.getItemStack(stack).getItem() instanceof ManaBaubleContent;
    }

    @ZenMethod
    public static ManaItem asIManaItem(IMutableItemStack stack) {
        return new ManaItemImpl(CraftTweakerMC.getItemStack(stack));
    }

    @ZenMethod
    public static ManaBauble asIManaBauble(IMutableItemStack stack) {
        return new ManaBaubleImpl(CraftTweakerMC.getItemStack(stack));
    }
}
