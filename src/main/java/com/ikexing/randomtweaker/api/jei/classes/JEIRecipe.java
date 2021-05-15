package com.ikexing.randomtweaker.api.jei.classes;

import com.ikexing.randomtweaker.RandomTweaker;
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
import java.util.List;

/**
 * @author ikexing
 */
@ZenRegister
@ZenClass("mods.randomtweaker.JEIRecipes")
public class JEIRecipe {
    private final String uid;
    private final String title;

    public List<FontInfo> fontInfos = new ArrayList<>();
    public List<Input> inputs = new ArrayList<>();
    public List<Output> outputs = new ArrayList<>();

    @ZenProperty
    private String modid = RandomTweaker.MODID;
    @ZenProperty
    private IItemStack icon = CraftTweakerMC.getIItemStack(new ItemStack(Blocks.BEDROCK));
    @ZenProperty
    private List<IItemStack> recipeCatalysts = new ArrayList<>();

    public JEIRecipe(String uid, String localizedname) {
        this.uid = uid;
        this.title = I18n.format(localizedname);
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
    public void addRecipeCatalyst(IItemStack item){
        this.recipeCatalysts.add(item);
    }

    @ZenMethod
    public void addFontInfo(String fontInfoName, int color, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
        this.fontInfos.add(new FontInfo(fontInfoName, color, recipeWidth, recipeHeight, mouseX, mouseY));
    }

    @ZenMethod
    public void addInputItem(String type, int xPosition, int yPosition, IItemStack item) {
        this.inputs.add(new Input(type, xPosition, yPosition, item));
    }

    @ZenMethod
    public void addInputFluid(String type, int xPosition, int yPosition, ILiquidStack fluid) {
        this.inputs.add(new Input(type, xPosition, yPosition, fluid));
    }

    @ZenMethod
    public void addOutputItem(String type, int xPosition, int yPosition, IItemStack item) {
        this.outputs.add(new Output(type, xPosition, yPosition, item));
    }

    @ZenMethod
    public void addOutputFluid(String type, int xPosition, int yPosition, ILiquidStack fluid) {
        this.outputs.add(new Output(type, xPosition, yPosition, fluid));
    }

    @ZenMethod
    public void register() {
        RandomTweaker.JEIRecipes.add(this);
    }

    public String getTitle() {
        return title;
    }

    public String getUid() {
        return uid;
    }

    public static class FontInfo {
        public String fontInfoName;
        public int color;
        public int recipeWidth;
        public int recipeHeight;
        public int x;
        public int y;

        public FontInfo(String fontInfoName, int color, int recipeWidth, int recipeHeight, int x, int y) {
            this.fontInfoName = fontInfoName;
            this.recipeWidth = recipeWidth;
            this.recipeHeight = recipeHeight;
            this.x = x;
            this.y = y;
        }
    }

    public static class Input {
        public String type;
        public int xPosition;
        public int yPosition;
        public ILiquidStack fluid = null;
        public IItemStack item = null;

        public Input(String type, int xPosition, int yPosition, IItemStack item) {
            this.type = type;
            this.xPosition = xPosition;
            this.yPosition = yPosition;
            this.item = item;
        }

        public Input(String type, int xPosition, int yPosition, ILiquidStack fluid) {
            this.type = type;
            this.xPosition = xPosition;
            this.yPosition = yPosition;
            this.fluid = fluid;
        }
    }

    public static class Output {
        public String type;
        public int xPosition;
        public int yPosition;
        public ILiquidStack fluid = null;
        public IItemStack item = null;

        public Output(String type, int xPosition, int yPosition, IItemStack item) {
            this.type = type;
            this.xPosition = xPosition;
            this.yPosition = yPosition;
            this.item = item;
        }

        public Output(String type, int xPosition, int yPosition, ILiquidStack fluid) {
            this.type = type;
            this.xPosition = xPosition;
            this.yPosition = yPosition;
            this.fluid = fluid;
        }
    }
}
