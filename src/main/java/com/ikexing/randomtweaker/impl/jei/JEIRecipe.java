package com.ikexing.randomtweaker.impl.jei;

import com.ikexing.randomtweaker.RandomTweaker;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.List;

/**
 * @author ikexing
 */
@ZenRegister
@ZenClass("mods.icrtweaker.JEIRecipes")
public class JEIRecipe {
    private int uid;
    private String localizedname;

    private List<ItemStack> recipeCatalysts;
    private List<FontInfo> fontInfos;
    private List<Input> inputs;
    private List<Output> outputs;

    public JEIRecipe(int uid, String localizedname) {
        this.uid = uid;
        this.localizedname = localizedname;
    }

    @ZenMethod
    public List<ItemStack> getIcons() {
        return recipeCatalysts;
    }

    @ZenMethod
    public List<FontInfo> getFontInfo() {
        return fontInfos;
    }

    @ZenMethod
    public List<Input> getInputs() {
        return inputs;
    }

    @ZenMethod
    public List<Output> getOutputs() {
        return outputs;
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
        this.inputs.add(new Input(type, xPosition, yPosition, CraftTweakerMC.getItemStack(item)));
    }

    @ZenMethod
    public void addInputFluid(String type, int xPosition, int yPosition, ILiquidStack fluid) {
        this.inputs.add(new Input(type, xPosition, yPosition, CraftTweakerMC.getLiquidStack(fluid)));
    }

    @ZenMethod
    public void addOutputItem(String type, int xPosition, int yPosition, IItemStack item) {
        this.outputs.add(new Output(type, xPosition, yPosition, CraftTweakerMC.getItemStack(item)));
    }

    @ZenMethod
    public void addOutputFluid(String type, int xPosition, int yPosition, ILiquidStack fluid) {
        this.outputs.add(new Output(type, xPosition, yPosition, CraftTweakerMC.getLiquidStack(fluid)));
    }

    @ZenMethod
    public void register() {
        RandomTweaker.JEIRecipes.add(this);
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
        public FluidStack fluid = null;
        public ItemStack item = null;

        public Input(String type, int xPosition, int yPosition, ItemStack item) {
            this.type = type;
            this.xPosition = xPosition;
            this.yPosition = yPosition;
            this.item = item;
        }

        public Input(String type, int xPosition, int yPosition, FluidStack fluid) {
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
        public FluidStack fluid = null;
        public ItemStack item = null;

        public Output(String type, int xPosition, int yPosition, ItemStack item) {
            this.type = type;
            this.xPosition = xPosition;
            this.yPosition = yPosition;
            this.item = item;
        }

        public Output(String type, int xPosition, int yPosition, FluidStack fluid) {
            this.type = type;
            this.xPosition = xPosition;
            this.yPosition = yPosition;
            this.fluid = fluid;
        }
    }
}
