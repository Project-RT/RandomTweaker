package ink.ikx.rt.api.mods.thaumcraft;

import crafttweaker.annotations.ModOnly;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectHelper;

import java.util.Arrays;

@ModOnly("thaumcraft")
@ZenExpansion("crafttweaker.item.IItemStack")
@ZenClass("mods.randomtweaker.thaumcraft.IItemStack")
public abstract class IItemStackExpansionTc {

    @ZenMethod
    public static String[] getAspects(IItemStack stack) {
        Aspect[] aspects = AspectHelper.getObjectAspects(CraftTweakerMC.getItemStack(stack)).copy().getAspects();
        return Arrays.stream(aspects).map(Aspect::getTag).toArray(String[]::new);
    }

}
