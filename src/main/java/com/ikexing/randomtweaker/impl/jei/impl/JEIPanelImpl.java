package com.ikexing.randomtweaker.impl.jei.impl;

import com.ikexing.randomtweaker.RandomTweaker;
import com.ikexing.randomtweaker.api.instance.jei.interfaces.JEIBackGroup;
import com.ikexing.randomtweaker.api.instance.jei.interfaces.JEIPanel;
import com.ikexing.randomtweaker.api.instance.jei.interfaces.slots.JEISlot;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.mc1120.brackets.BracketHandlerItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JEIPanelImpl implements JEIPanel {

    public String uid;
    public String localizationKey;
    public String modid = RandomTweaker.MODID;
    public IItemStack icon = BracketHandlerItem.getItem("minecraft:bedrock", 0);
    public JEIBackGroup JEIBackGroup;
    public List<IItemStack> recipeCatalysts = new ArrayList<>();
    public List<JEISlot> JEISlots = new ArrayList<>();
    public List<IIngredient> JEIInputRecipes = new ArrayList<>();
    public List<IIngredient> JEIOutputRecipes = new ArrayList<>();

    public JEIPanelImpl(String uid, String localizationKey) {
        this.uid = uid;
        this.localizationKey = localizationKey;
    }

    @Override
    public String getUid() {
        return this.uid;
    }

    @Override
    public String getLocalizationKey() {
        return this.localizationKey;
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
    public IItemStack[] getRecipeCatalysts() {
        return this.recipeCatalysts.toArray(new IItemStack[0]);
    }

    @Override
    public JEISlot[] getJEISlots() {
        return this.JEISlots.toArray(new JEISlot[0]);
    }

    @Override
    public IIngredient[] getJEIInputRecipes() {
        return this.JEIInputRecipes.toArray(new IIngredient[0]);
    }

    @Override
    public IIngredient[] getJEIOutputRecipes() {
        return this.JEIOutputRecipes.toArray(new IIngredient[0]);
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
    public void setJEIBackGroup(int width, int heigh) {
        this.JEIBackGroup = new JEIBackGroupImpl(width, heigh);
    }

    @Override
    public void setJEISlots(JEISlot[] JEISlots) {
        this.JEISlots = Arrays.asList(JEISlots);
    }

    @Override
    public void setRecipeCatalysts(IItemStack[] recipeCatalysts) {
        this.recipeCatalysts = Arrays.asList(recipeCatalysts);
    }

    @Override
    public void setJEIInputRecipes(IIngredient[] inputs) {
        this.JEIInputRecipes = Arrays.asList(inputs);
    }

    @Override
    public void setJEIOutputRecipes(IIngredient[] outputs) {
        this.JEIOutputRecipes = Arrays.asList(outputs);
    }

    @Override
    public void setJEIRecipe(IIngredient[] inputs, IIngredient[] outputs) {
        this.JEIInputRecipes = Arrays.asList(inputs);
        this.JEIOutputRecipes = Arrays.asList(outputs);
    }

    @Override
    public void addJEISlot(JEISlot JEISlot) {
        this.JEISlots.add(JEISlot);
    }

    @Override
    public void addRecipeCatalyst(IItemStack recipeCatalyst) {
        this.recipeCatalysts.add(recipeCatalyst);
    }

    @Override
    public void addJEIInputRecipe(IIngredient input) {
        this.JEIInputRecipes.add(input);
    }

    @Override
    public void addJEIOutPutRecipe(IIngredient output) {
        this.JEIOutputRecipes.add(output);
    }

    @Override
    public void register() {
        if (JEIBackGroup == null || recipeCatalysts.isEmpty() ||
            JEISlots.isEmpty() || JEIInputRecipes.isEmpty()) {
            CraftTweakerAPI.getLogger().logError("Parameters mustn't be empty !!!");
        } else if (modid.equals(RandomTweaker.MODID) || icon
            .matches(BracketHandlerItem.getItem("minecraft:bedrock", 0))) {
            CraftTweakerAPI.getLogger()
                .logInfo("Please modify modid and icon, even though this is not a requirement");
        } else {
            RandomTweaker.JEIPanel.add(this);
        }
    }
}
