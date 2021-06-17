package com.ikexing.randomtweaker.api.instance.jei.interfaces;

import com.ikexing.randomtweaker.RandomTweaker;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.mc1120.brackets.BracketHandlerItem;
import java.util.Queue;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("mods.randomtweaker.JEIPanel")
public interface JEIPanel {

    @ZenGetter("uid")
    String getUid();

    @ZenGetter("title")
    String getTitle();

    @ZenGetter("modid")
    default String getModID() {
        return RandomTweaker.MODID;
    }

    @ZenGetter("icon")
    default IItemStack getIcon() {
        return BracketHandlerItem.getItem("minecraft:bedrock", 0);
    }

    @ZenGetter("JEIBackGroupImpl")
    JEIBackGroup getJEIBackGroup();

    @ZenGetter("recipeCatalyst")
    Queue<IItemStack> getRecipeCatalysts();

    @ZenGetter("JEISlot")
    Queue<JEISlot> getJEISlots();

    @ZenMethod
    void setModID();

    @ZenMethod
    void setIcon();

    @ZenMethod
    void setJEIBackGroup();

    @ZenMethod
    void setJEISlots();

    @ZenMethod
    void setRecipeCatalysts();

    @ZenMethod
    void addJEISlot();

    @ZenMethod
    void addRecipeCatalyst();

}
