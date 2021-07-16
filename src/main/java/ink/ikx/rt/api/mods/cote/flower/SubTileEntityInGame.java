package ink.ikx.rt.api.mods.cote.flower;

import crafttweaker.api.data.IData;
import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenSetter;

@RTRegisterClass({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.SubTileEntityInGame")
public interface SubTileEntityInGame {

    @ZenMethod
    void sync();

    @ZenMethod
    String typeOf();

    @ZenMethod
    @ZenGetter("data")
    IData getCustomData();

    @ZenMethod
    @ZenSetter("data")
    void setCustomData(IData data);

    @ZenMethod
    void updateCustomData(IData data);

    @ZenMethod
    void addMana(int mana);

    @ZenMethod
    int getMana();

    @ZenMethod
    void setMana(int mana);

    @ZenMethod
    int getRedstoneSignal();

    @ZenMethod
    int getKnownMana();

    @ZenMethod
    int getPassiveDecayTicks();
}
