package com.ikexing.randomtweaker.api.mouse;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.entity.IEntity;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IVector3d;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
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
        return CraftTweakerMC.getIVector3d(getMouse().hitVec);
    }

    @ZenMethod
    public static IBlockPos getMouseHitBlock() {
        return CraftTweakerMC.getIBlockPos(getMouse().getBlockPos());
    }

    @ZenMethod
    public static IEntity getMouseHitEntity() {
        return CraftTweakerMC.getIEntity(getMouse().entityHit);
    }

    private static RayTraceResult getMouse() {
        RayTraceResult mouseOver = Minecraft.getMinecraft().objectMouseOver;
        if (mouseOver != null) {
            return mouseOver;
        }

        EntityPlayerSP entity = Minecraft.getMinecraft().player;
        Vec3d start = entity.getPositionEyes(1);
        Vec3d end = start.add(entity.getLook(1).x * 6, entity.getLook(1).y * 6, entity.getLook(1).z * 6);
        mouseOver = entity.getEntityWorld().rayTraceBlocks(start, end);

        return mouseOver;
    }
}