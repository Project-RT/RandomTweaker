package ink.ikx.rt.api.mods.thaumcraft;

import crafttweaker.annotations.ModOnly;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectHelper;

import java.util.Arrays;

@RTRegister
@ModOnly("thaumcraft")
@ZenExpansion("crafttweaker.item.IItemStack")
@ZenClass("mods.randomtweaker.thaumcraft.IItemStack")
public abstract class IItemStackExpansionTc {

    @ZenMethod
    public static IAspect[] getAspects(IItemStack stack) {
        Aspect[] aspects = AspectHelper.getObjectAspects(CraftTweakerMC.getItemStack(stack)).copy().getAspects();
        return Arrays.stream(aspects).map(IAspect::of).toArray(IAspect[]::new);
    }

}
