package com.ikexing.icrtweaker.api.entity;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.entity.IEntity;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.entity.Entity;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

import java.lang.reflect.Field;

@ZenRegister
@ZenExpansion("crafttweaker.entity.IEntity")
public class IEntityExpansion {

    @ZenMethod
    public static boolean isImmuneToFire(IEntity entity) {
        return CraftTweakerMC.getEntity(entity).isImmuneToFire();
    }

    @ZenMethod
    public static void setImmuneToFire(IEntity entity, boolean flag) {
        Entity mcEntity = CraftTweakerMC.getEntity(entity);
        Class<? extends Entity> Class = mcEntity.getClass();
        try {
            Field isImmuneToFire = Class.getDeclaredField("isImmuneToFire");
            isImmuneToFire.setAccessible(true);
            isImmuneToFire.set(mcEntity, flag);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            CraftTweakerAPI.logError("Maybe you need to report this error", e);
        }

    }
}
