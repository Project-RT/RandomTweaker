package ink.ikx.rt.api.mods.jei;

import ink.ikx.rt.api.mods.jei.elements.IJeiElements;
import ink.ikx.rt.impl.mods.crafttweaker.ModTotal;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import ink.ikx.rt.impl.mods.jei.impl.elemenet.MCJeiElementManaBar;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethodStatic;

@RTRegister
@ModTotal({"jei", "botania"})
@ZenExpansion("mods.randomtweaker.jei.IJeiUtils")
public abstract class IJeiUtilsWithBotania {

    @ZenMethodStatic
    public static IJeiElements.IJeiElementManaBar createJeiManaBarElement(int x, int y, int mana, @Optional int mode) {
        return new MCJeiElementManaBar(x, y, mode, mana);
    }

}
