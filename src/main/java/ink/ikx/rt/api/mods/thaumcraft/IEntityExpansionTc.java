package ink.ikx.rt.api.mods.thaumcraft;

import crafttweaker.annotations.ModOnly;
import crafttweaker.api.entity.IEntity;
import crafttweaker.api.minecraft.CraftTweakerMC;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectHelper;

import java.util.Arrays;

@ModOnly("thaumcraft")
@ZenExpansion("crafttweaker.entity.IEntity")
@ZenClass("mods.randomtweaker.thaumcraft.IEntity")
public abstract class IEntityExpansionTc {

    @ZenMethod
    public static String[] getAspects(IEntity entity) {
        Aspect[] aspects = AspectHelper.getEntityAspects(CraftTweakerMC.getEntity(entity)).copy().getAspects();
        return Arrays.stream(aspects).map(Aspect::getTag).toArray(String[]::new);
    }

}
