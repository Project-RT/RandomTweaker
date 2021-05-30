package com.ikexing.randomtweaker.api.jei.classes;

import com.ikexing.randomtweaker.RandomTweaker;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;

import java.util.ArrayList;
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
    public List<JEIRecipe> jeiRecipes = new ArrayList<>();
    @ZenProperty
    public List<JEISlot> jeiSlots = new ArrayList<>();
    @ZenProperty
    public List<JEIFontInfo> jeiFontInfos = new ArrayList<>();
    @ZenProperty
    private String modid = RandomTweaker.MODID;
    @ZenProperty
    private IItemStack icon = CraftTweakerMC.getIItemStack(new ItemStack(Blocks.BEDROCK));
    @ZenProperty
    private List<IItemStack> recipeCatalysts = new ArrayList<>();
    @ZenProperty
    private JEIBackGroup jeiBackGroup;

    @SideOnly(Side.CLIENT)
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
    public List<JEIFontInfo> getJeiFontInfos() {
        return jeiFontInfos;
    }

    @ZenMethod
    public void setJeiFontInfos(List<JEIFontInfo> jeiFontInfos) {
        this.jeiFontInfos = jeiFontInfos;
    }

    @ZenMethod
    public List<JEISlot> getJeiSlots() {
        return jeiSlots;
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
    public void addJeiRecipe(JEIRecipe jeiRecipe) {
        this.jeiRecipes.add(jeiRecipe);
    }

    @ZenMethod
    public void addJeiRecipe(IIngredient[] inputs, IIngredient[] outputs) {
        this.jeiRecipes.add(new JEIRecipe(inputs, outputs));
    }

    @ZenMethod
    public void setJeiSlots(List<JEISlot> jeiSlots) {
        this.jeiSlots = jeiSlots;
    }

    @ZenMethod
    public void addJeiSlot(JEISlot jeiSlot) {
        this.jeiSlots.add(jeiSlot);
    }

    @ZenMethod
    public void addJeiSlot(boolean isInput, String type, int xPosition, int yPosition) {
        this.jeiSlots.add(new JEISlot(isInput, type, xPosition, yPosition));
    }

    @ZenMethod
    public void register() {
        if (jeiBackGroup == null || jeiRecipes.isEmpty() || recipeCatalysts.isEmpty() || jeiSlots.isEmpty()) {
            CraftTweakerAPI.logError("Parameters mustn't be empty !!!");
            return;
        } else if (modid.equals(RandomTweaker.MODID) || icon.matches(CraftTweakerMC.getIItemStack(new ItemStack(Blocks.BEDROCK)))) {
            CraftTweakerAPI.logInfo("Please modify modid and icon, even though this is not a requirement");
        }
        RandomTweaker.jeiCustomList.add(this);
    }

}
