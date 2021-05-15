package com.ikexing.randomtweaker.api.jei.classes;

import com.ikexing.randomtweaker.RandomTweaker;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ikexing
 */
@ZenRegister
@ZenClass("mods.randomtweaker.JEICustom")
public class JEICustom {
    public final String uid;
    public final String title;

    @ZenProperty
    public List<JEIFontInfo> jeiFontInfos = new ArrayList<>();
    @ZenProperty
    public List<JEIRecipe> jeiRecipes = new ArrayList<>();
    @ZenProperty
    private String modid = RandomTweaker.MODID;
    @ZenProperty
    private IItemStack icon = CraftTweakerMC.getIItemStack(new ItemStack(Blocks.BEDROCK));
    @ZenProperty
    private List<IItemStack> recipeCatalysts = new ArrayList<>();
    @ZenProperty
    private JEIBackGroup jeiBackGroup;

    public JEICustom(String uid, String localizedname) {
        this.uid = uid;
        this.title = I18n.format(localizedname);
    }

    @ZenMethod
    public JEIBackGroup getJeiBackGroup() {
        return jeiBackGroup;
    }

    @ZenMethod
    public void setJeiBackGroup(JEIBackGroup jeiBackGroup) {
        this.jeiBackGroup = jeiBackGroup;
    }

    @ZenMethod
    public void setJeiBackGroup(String namespaceIn, String pathIn, int u, int v, int width, int heigh) {
        this.jeiBackGroup = new JEIBackGroup(namespaceIn, pathIn, u, v, width, heigh);
    }

    @ZenMethod
    public void setJeiBackGroup(String namespaceIn, String pathIn, int width, int heigh) {
        this.jeiBackGroup = new JEIBackGroup(namespaceIn, pathIn, 0, 0, width, heigh);
    }

    @ZenMethod
    public void setJeiBackGroup(int width, int heigh) {
        this.jeiBackGroup = new JEIBackGroup(width, heigh);
    }

    @ZenMethod
    public String getModid() {
        return modid;
    }

    @ZenMethod
    public void setModid(String modid) {
        this.modid = modid;
    }

    @ZenMethod
    public IItemStack getIcon() {
        return icon;
    }

    @ZenMethod
    public void setIcon(IItemStack icon) {
        this.icon = icon;
    }

    @ZenMethod
    public List<IItemStack> getRecipeCatalysts() {
        return recipeCatalysts;
    }

    @ZenMethod
    public void setRecipeCatalysts(List<IItemStack> recipeCatalysts) {
        this.recipeCatalysts = recipeCatalysts;
    }

    @ZenMethod
    public void addRecipeCatalyst(IItemStack item) {
        this.recipeCatalysts.add(item);
    }

    @ZenMethod
    public void addJeiFontInfo(String fontInfoName, int color, int recipeWidth, int recipeHeight, int x, int y) {
        this.jeiFontInfos.add(new JEIFontInfo(fontInfoName, color, recipeWidth, recipeHeight, x, y));
    }

    @ZenMethod
    public void addJeiRecipe(boolean isInput, String type, int xPosition, int yPosition, IItemStack stack) {
        this.jeiRecipes.add(new JEIRecipe(isInput, type, xPosition, yPosition, stack, null));
    }

    @ZenMethod
    public void addJeiRecipe(boolean isInput, String type, int xPosition, int yPosition, ILiquidStack stack) {
        this.jeiRecipes.add(new JEIRecipe(isInput, type, xPosition, yPosition, null, stack));
    }

    @ZenMethod
    public void addJeiRecipe(boolean isInput, String type, int xPosition, int yPosition, IItemStack[] stacks) {
        this.jeiRecipes.add(new JEIRecipe(isInput, type, xPosition, yPosition, Arrays.asList(stacks), null));
    }

    @ZenMethod
    public void addJeiRecipe(boolean isInput, String type, int xPosition, int yPosition, ILiquidStack[] stacks) {
        this.jeiRecipes.add(new JEIRecipe(isInput, type, xPosition, yPosition, null, Arrays.asList(stacks)));

    }

    @ZenMethod
    public void addJeiRecipe(boolean isInput, String type, int xPosition, int yPosition, int width, int height, int capacityMb, boolean showCapacity, ILiquidStack fluid) {
        this.jeiRecipes.add(new JEIRecipe(isInput, type, xPosition, yPosition, width, height, capacityMb, showCapacity, fluid));
    }

    @ZenMethod
    public void addJeiRecipe(boolean isInput, String type, int xPosition, int yPosition, int width, int height, int capacityMb, boolean showCapacity, ILiquidStack[] fluid) {
        this.jeiRecipes.add(new JEIRecipe(isInput, type, xPosition, yPosition, width, height, capacityMb, showCapacity, Arrays.asList(fluid)));
    }

    @ZenMethod
    public void addJeiRecipe(JEIRecipe jeiRecipe) {
        this.jeiRecipes.add(jeiRecipe);
    }

    @ZenMethod
    public List<JEIFontInfo> getJeiFontInfos() {
        return jeiFontInfos;
    }

    @ZenMethod
    public void setJeiFontInfos(List<JEIFontInfo> jeiFontInfos) {
        this.jeiFontInfos = jeiFontInfos;
    }

    @ZenMethod
    public List<JEIRecipe> getJeiRecipes() {
        return jeiRecipes;
    }

    @ZenMethod
    public void setJeiRecipes(List<JEIRecipe> jeiRecipes) {
        this.jeiRecipes = jeiRecipes;
    }

    @ZenMethod
    public void register() {
        if (jeiBackGroup == null || jeiFontInfos.isEmpty() || jeiRecipes.isEmpty() || recipeCatalysts.isEmpty()) {
            CraftTweakerAPI.logError("Parameters mustn't be empty !!!");
        } else if (modid.equals(RandomTweaker.MODID) || icon.matches(CraftTweakerMC.getIItemStack(new ItemStack(Blocks.BEDROCK)))) {
            CraftTweakerAPI.logInfo("Please modify modid and icon, even though this is not a requirement");
        } else {
            RandomTweaker.jeiCustomList.add(this);
        }
    }

}
