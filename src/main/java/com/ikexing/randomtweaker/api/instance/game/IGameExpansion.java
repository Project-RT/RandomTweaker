package com.ikexing.randomtweaker.api.instance.game;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.potions.IPotion;
import crafttweaker.mc1120.brackets.BracketHandlerPotion;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenExpansion("crafttweaker.game.IGame")
public class IGameExpansion {

    @ZenMethod
    public static IPotion getPotion(String potionName) {
        return BracketHandlerPotion.getPotion(potionName);
    }

}
