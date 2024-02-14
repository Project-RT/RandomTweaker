package ink.ikx.rt.api.mods.thaumcraft.expand;

import crafttweaker.annotations.ModOnly;
import crafttweaker.api.entity.IEntity;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ink.ikx.rt.api.mods.thaumcraft.IAspectList;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;
import thaumcraft.api.aspects.AspectHelper;
import thaumcraft.api.aspects.AspectList;

@RTRegister
@ModOnly("thaumcraft")
@ZenExpansion("crafttweaker.entity.IEntity")
@ZenClass("mods.randomtweaker.thaumcraft.IEntity")
public abstract class ExpandIEntity {

    @ZenMethod
    public static IAspectList getAspects(IEntity entity) {
        AspectList entityAspects = AspectHelper.getEntityAspects(CraftTweakerMC.getEntity(entity));
        if (entityAspects != null) {
            return IAspectList.of(entityAspects.copy());
        }
        return IAspectList.of();
    }

}
