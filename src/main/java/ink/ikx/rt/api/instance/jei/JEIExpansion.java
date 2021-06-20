package ink.ikx.rt.api.instance.jei;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import ink.ikx.rt.api.instance.jei.interfaces.JEIBackground;
import ink.ikx.rt.api.instance.jei.interfaces.JEIPanel;
import ink.ikx.rt.api.instance.jei.interfaces.JEIRecipe;
import ink.ikx.rt.api.instance.jei.interfaces.element.JEIItemElement;
import ink.ikx.rt.api.instance.jei.interfaces.slots.JEIItemSlot;
import ink.ikx.rt.impl.jei.impl.JEIBackgroundImpl;
import ink.ikx.rt.impl.jei.impl.JEIPanelImpl;
import ink.ikx.rt.impl.jei.impl.JEIRecipeImpl;
import ink.ikx.rt.impl.jei.impl.element.JEIItemInputElementImpl;
import ink.ikx.rt.impl.jei.impl.slots.JEIItemSlotImpl;
import ink.ikx.rt.impl.jei.impl.slots.JEILiquidSlotImpl;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethodStatic;

@ZenRegister
@ZenExpansion("mods.jei.JEI")
public class JEIExpansion {

    @ZenMethodStatic
    public static JEIPanel createJEIPanel(String uid, String localizationKey) {
        return new JEIPanelImpl(uid, localizationKey);
    }

    @ZenMethodStatic
    public static JEIBackground createJEIBackground(int width, int heigh) {
        return new JEIBackgroundImpl(width, heigh);
    }

    @ZenMethodStatic
    public static JEIBackground createJEIBackground(String resourceName, int u, int v, int width,
        int heigh) {
        return new JEIBackgroundImpl(resourceName, u, v, width, heigh);
    }

    @ZenMethodStatic
    public static JEILiquidSlotImpl createLiquidSlot(boolean isInput,
        int x, int y, int width, int heigh, int capacityMb, boolean showCapacity,
        @Optional(valueBoolean = true) boolean isBase) {

        return new JEILiquidSlotImpl(isInput, x, y, width, heigh, capacityMb, showCapacity,
            isBase);
    }

    @ZenMethodStatic
    public static JEILiquidSlotImpl createLiquidSlot(boolean isInput,
        int x, int y,
        @Optional(valueBoolean = true) boolean isBase) {

        return createLiquidSlot(isInput, x, y, 16, 16, 1000, false, isBase);
    }

    @ZenMethodStatic
    public static JEIItemSlot createItemSlot(boolean isInput, int x, int y,
        @Optional(valueBoolean = true) boolean isBase) {

        return new JEIItemSlotImpl(isInput, x, y, isBase);
    }

    @ZenMethodStatic
    public static JEIRecipe createJEIRecipe(IIngredient[] inputs, IIngredient[] outputs) {
        return new JEIRecipeImpl(inputs, outputs);
    }

    @ZenMethodStatic
    public static JEIRecipe createJEIRecipe(IIngredient[] inputs) {
        return new JEIRecipeImpl(inputs);
    }

    //-------------------------------------------------------------------------------------------

    //Please make sure you really need this.
    @ZenMethodStatic
    public static JEIItemElement createJEIItemInputElement(int x, int y) {
        return new JEIItemInputElementImpl(x, y);
    }
}