package ink.ikx.rt.api.mods.botania;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ModOnly("botania")
@ZenClass("mods.randomtweaker.AlfPortalInGame")
public interface IMixinTileAlfPortal {

    @ZenMethod
    IItemStack[] getAllInput();

    @ZenMethod
    void setAllInput(IItemStack[] newList);

    @ZenMethod
    void clearAllInput();

    @ZenMethod
    void delAllInput(IItemStack stack);

    @ZenMethod
    void addAllInput(IItemStack stack);

    @ZenMethod
    boolean consumeMana(int totalCost);
}
