package com.ikexing.randomtweaker.impl.jei.impl;

import com.ikexing.randomtweaker.RandomTweaker;
import com.ikexing.randomtweaker.api.instance.jei.interfaces.JEIBackGroup;
import com.ikexing.randomtweaker.api.instance.jei.interfaces.JEIPanel;
import com.ikexing.randomtweaker.api.instance.jei.interfaces.JEISlot;
import crafttweaker.api.item.IItemStack;
import crafttweaker.mc1120.brackets.BracketHandlerItem;
import java.util.Arrays;
import java.util.Queue;

public class JEIPanelImpl implements JEIPanel {

    public String uid;
    public String title;
    public String modid = RandomTweaker.MODID;
    public IItemStack icon = BracketHandlerItem.getItem("minecraft:bedrock", 0);
    public JEIBackGroup JEIBackGroup;
    public Queue<IItemStack> recipeCatalysts;
    public Queue<JEISlot> JEISlots;

    public JEIPanelImpl(String uid, String title, String modid, IItemStack icon,
        JEIBackGroup JEIBackGroup, IItemStack[] recipeCatalysts, JEISlot[] JEISlots) {
        this.uid = uid;
        this.title = title;
        this.modid = modid;
        this.icon = icon;
        this.JEIBackGroup = JEIBackGroup;
        this.recipeCatalysts.addAll(Arrays.asList(recipeCatalysts));
        this.JEISlots.addAll(Arrays.asList(JEISlots));
    }

    @Override
    public String getUid() {
        return this.uid;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getModID() {
        return this.modid;
    }

    @Override
    public IItemStack getIcon() {
        return this.icon;
    }

    @Override
    public JEIBackGroup getJEIBackGroup() {
        return this.JEIBackGroup;
    }

    @Override
    public Queue<IItemStack> getRecipeCatalysts() {
        return this.recipeCatalysts;
    }

    @Override
    public Queue<JEISlot> getJEISlots() {
        return this.JEISlots;
    }

    @Override
    public void setModID(String modid) {
        this.modid = modid;
    }

    @Override
    public void setIcon(IItemStack icon) {
        this.icon = icon;
    }

    @Override
    public void setJEIBackGroup(JEIBackGroup JEIBackGroup) {
        this.JEIBackGroup = JEIBackGroup;
    }

    @Override
    public void setJEISlots(JEISlot[] JEISlots) {
        this.JEISlots.addAll(Arrays.asList(JEISlots));
    }

    @Override
    public void setRecipeCatalysts(IItemStack[] recipeCatalysts) {
        this.recipeCatalysts.addAll(Arrays.asList(recipeCatalysts));
    }

    @Override
    public void addJEISlot(JEISlot JEISlot) {
        this.JEISlots.add(JEISlot);
    }

    @Override
    public void addRecipeCatalyst(IItemStack recipeCatalyst) {
        this.recipeCatalysts.add(recipeCatalyst);
    }
}
