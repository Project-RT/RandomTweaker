package ink.ikx.rt.api.mods.thaumcraft.expand;

import crafttweaker.annotations.ModOnly;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.api.mods.thaumcraft.IAspectList;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;
import thaumcraft.api.aspects.AspectHelper;

@RTRegister
@ModOnly("thaumcraft")
@ZenExpansion("crafttweaker.item.IItemStack")
@ZenClass("mods.randomtweaker.thaumcraft.IItemStack")
public abstract class ExpandIItemStack {

    @ZenMethod
    public static IAspectList getAspects(IItemStack stack) {
        return IAspectList.of(AspectHelper.getObjectAspects(CraftTweakerMC.getItemStack(stack)).copy());
    }

}
