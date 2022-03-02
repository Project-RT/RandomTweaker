package ink.ikx.rt.api.mods.thaumcraft;

import crafttweaker.annotations.ModOnly;
import crafttweaker.api.entity.IEntity;
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
@ZenExpansion("crafttweaker.entity.IEntity")
@ZenClass("mods.randomtweaker.thaumcraft.IEntity")
public abstract class IEntityExpansionTc {

    @ZenMethod
    public static IAspect[] getAspects(IEntity entity) {
        Aspect[] aspects = AspectHelper.getEntityAspects(CraftTweakerMC.getEntity(entity)).copy().getAspects();
        return Arrays.stream(aspects).map(IAspect::of).toArray(IAspect[]::new);

    }

}
