package com.ikexing.randomtweaker.api.jei;

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

import java.util.List;

/**
 * @author ikexing
 */
@ZenRegister
@ZenClass("mods.randomtweaker.JEIRecipes")
public class JEIRecipe {
    private final String uid;
    private final String title;

    @ZenProperty
    private String modid = RandomTweaker.MODID;
    @ZenProperty
    private IItemStack icon = CraftTweakerMC.getIItemStack(new ItemStack(Blocks.BEDROCK));
    @ZenProperty
    private List<ItemStack> recipeCatalysts;
    @ZenProperty
    private List<FontInfo> fontInfos;
    @ZenProperty
    private List<Input> inputs;
    @ZenProperty
    private List<Output> outputs;

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
    public List<ItemStack> getRecipeCatalysts() {
        return recipeCatalysts;
    }

    @ZenMethod
    public void setRecipeCatalysts(List<ItemStack> recipeCatalysts) {
        this.recipeCatalysts = recipeCatalysts;
    }

    @ZenMethod
    public List<FontInfo> getFontInfos() {
        return fontInfos;
    }

    @ZenMethod
    public void setFontInfos(List<FontInfo> fontInfos) {
        this.fontInfos = fontInfos;
    }

    @ZenMethod
    public List<Input> getInputs() {
        return inputs;
    }

    @ZenMethod
    public void setInputs(List<Input> inputs) {
        this.inputs = inputs;
    }

    @ZenMethod
    public List<Output> getOutputs() {
        return outputs;
    }

    @ZenMethod
    public void setOutputs(List<Output> outputs) {
        this.outputs = outputs;
    }

    @ZenMethod
    public void addIcon(IItemStack item) {
        this.recipeCatalysts.add(CraftTweakerMC.getItemStack(item));
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

    public class FontInfo {
        public String fontInfoName;
        public int color;
        public int recipeWidth;
        public int recipeHeight;
        public int mouseX;
        public int mouseY;

        public FontInfo(String fontInfoName, int color, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
            this.fontInfoName = fontInfoName;
            this.recipeWidth = recipeWidth;
            this.recipeHeight = recipeHeight;
            this.mouseX = mouseX;
            this.mouseY = mouseY;
        }
    }

    public class Input {
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

    public class Output {
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
