package com.ikexing.randomtweaker.api.thebetweenlands;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.entity.IEntity;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import thebetweenlands.common.capability.circlegem.CircleGem.CombatType;
import thebetweenlands.common.capability.circlegem.CircleGemHelper;
import thebetweenlands.common.capability.circlegem.CircleGemType;

/**
 * @author ikexing
 */
@ZenRegister
@ModOnly("thebetweenlands")
@ZenClass("mods.randomtweaker.CircleGem")
public class BLCircleGem {
    @ZenMethod
    public static void setGem(IItemStack stack, String gemType) {
        CircleGemType circleGemType = getCircleGemType(gemType);
        if (circleGemType != null) {
            CircleGemHelper.setGem(CraftTweakerMC.getItemStack(stack), circleGemType);
        } else {
            CraftTweakerAPI.logError("gemType was non-existent");
        }
    }

    @ZenMethod
    public static String getGem(IItemStack stack) {
        return CircleGemHelper.getGem(CraftTweakerMC.getItemStack(stack)).toString();
    }

    @ZenMethod
    public static void addGem(IEntity entity, String gemType, String combatType) {
        CircleGemType circleGemType = getCircleGemType(gemType);
        CombatType combatType1 = getCombatType(combatType);
        if (circleGemType != null) {
            if (combatType1 != null) {
                CircleGemHelper.addGem(CraftTweakerMC.getEntity(entity), circleGemType, combatType1);
            } else {
                CraftTweakerAPI.logError("combatType was non-existent");
            }
        } else {
            CraftTweakerAPI.logError("gemType was non-existent");
        }
    }

    private static CircleGemType getCircleGemType(String s) {
        switch (s.toLowerCase()) {
            case "aqua":
                return CircleGemType.AQUA;
            case "crimson":
                return CircleGemType.CRIMSON;
            case "green":
                return CircleGemType.GREEN;
            case "none":
                return CircleGemType.NONE;
            default:
                return null;
        }
    }

    private static CombatType getCombatType(String s) {
        switch (s.toUpperCase()) {
            case "OFFENSIVE":
                return CombatType.OFFENSIVE;
            case "DEFENSIVE":
                return CombatType.DEFENSIVE;
            case "BOTH":
                return CombatType.BOTH;
            default:
                return null;
        }
    }
}
