package ink.ikx.rt.api.mods.thaumcraft;

import com.blamejared.compat.thaumcraft.handlers.aspects.CTAspect;
import com.blamejared.compat.thaumcraft.handlers.aspects.CTAspectStack;
import com.blamejared.compat.thaumcraft.handlers.brackets.BracketHandlerAspect;
import crafttweaker.api.entity.IEntity;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.impl.mods.crafttweaker.ModTotal;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectHelper;

import java.util.Arrays;

@RTRegister
@ModTotal({"thaumcraft", "modtweaker"})
@ZenExpansion("crafttweaker.entity.IEntity")
@ZenClass("mods.randomtweaker.thaumcraft.IEntity")
public abstract class IEntityExpansionTc {

    @ZenMethod
    public static CTAspect[] getAspects(IEntity entity) {
        Aspect[] aspects = AspectHelper.getEntityAspects(CraftTweakerMC.getEntity(entity)).copy().getAspects();
        return Arrays.stream(aspects)
                .map(Aspect::getTag)
                .map(BracketHandlerAspect::getAspect)
                .map(CTAspectStack::getInternal).toArray(CTAspect[]::new);
    }

}
