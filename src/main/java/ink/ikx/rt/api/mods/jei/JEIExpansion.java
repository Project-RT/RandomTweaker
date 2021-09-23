package ink.ikx.rt.api.mods.jei;

import crafttweaker.annotations.ModOnly;
import ink.ikx.rt.api.mods.jei.core.IJeiPanel;
import ink.ikx.rt.api.mods.jei.core.IJeiRecipe;
import ink.ikx.rt.impl.mods.jei.impl.core.MCJeiPanel;
import ink.ikx.rt.impl.mods.jei.impl.core.MCJeiRecipe;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethodStatic;

@ModOnly("jei")
@ZenExpansion("mods.jei.JEI")
public abstract class JEIExpansion {

    @ZenMethodStatic
    public static IJeiPanel createJei(String uid, String title) {
        return new MCJeiPanel(uid, title);
    }

    @ZenMethodStatic
    public static IJeiRecipe createJeiRecipe(String uid) {
        return new MCJeiRecipe(uid);
    }

}
