package com.ikexing.randomtweaker.api.mouse;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.entity.IEntity;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IVector3d;
import net.minecraft.client.Minecraft;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

/**
 * @author ikexing
 */
@ZenRegister
@ZenClass("mods.randomtweaker.IMouse")
public class IMouse {
    @ZenMethod
    public static IVector3d getMouseHit() {
        return CraftTweakerMC.getIVector3d(Minecraft.getMinecraft().objectMouseOver.hitVec);
    }

    @ZenMethod
    public static IBlockPos getMouseHitBlock() {
        return CraftTweakerMC.getIBlockPos(Minecraft.getMinecraft().objectMouseOver.getBlockPos());
    }

    @ZenMethod
    public static IEntity getMouseHitEntity() {
        return CraftTweakerMC.getIEntity(Minecraft.getMinecraft().objectMouseOver.entityHit);
    }
}