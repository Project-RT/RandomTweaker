package com.ikexing.randomtweaker.api.jei;

import com.ikexing.randomtweaker.impl.jei.JEIRecipe;
import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

/**
 * @author ikexing
 */
@ZenRegister
@ZenExpansion("mods.jei.JEI")
public class JEIExpansion {
    @ZenMethod
    public static JEIRecipe create(int uid, String localizedname) {
        return new JEIRecipe(uid, localizedname);
    }
}
