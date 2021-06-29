package ink.ikx.rt.api.instance.jei;

import crafttweaker.annotations.ZenRegister;
import ink.ikx.rt.api.instance.jei.interfaces.JEIBackground;
import ink.ikx.rt.api.instance.jei.interfaces.JEIPanel;
import ink.ikx.rt.api.instance.jei.interfaces.JEIRecipe;
import ink.ikx.rt.api.instance.jei.interfaces.element.JEIArrowElement;
import ink.ikx.rt.api.instance.jei.interfaces.element.JEICustomElement;
import ink.ikx.rt.api.instance.jei.interfaces.element.JEIFluidElement;
import ink.ikx.rt.api.instance.jei.interfaces.element.JEIFontInfoElement;
import ink.ikx.rt.api.instance.jei.interfaces.element.JEIItemElement;
import ink.ikx.rt.api.instance.jei.interfaces.slots.JEIItemSlot;
import ink.ikx.rt.api.instance.jei.interfaces.slots.JEILiquidSlot;
import ink.ikx.rt.impl.jei.impl.JEIBackgroundImpl;
import ink.ikx.rt.impl.jei.impl.JEIPanelImpl;
import ink.ikx.rt.impl.jei.impl.JEIRecipeImpl;
import ink.ikx.rt.impl.jei.impl.element.JEIArrowElementImpl;
import ink.ikx.rt.impl.jei.impl.element.JEICustomElementImpl;
import ink.ikx.rt.impl.jei.impl.element.JEIFluidElementImpl;
import ink.ikx.rt.impl.jei.impl.element.JEIFontInfoElementImpl;
import ink.ikx.rt.impl.jei.impl.element.JEIItemInputElementImpl;
import ink.ikx.rt.impl.jei.impl.element.JEIItemOutputElementImpl;
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
    public static JEIBackground createJEIBackground(String resourceName, int u, int v, int width, int heigh) {
        return new JEIBackgroundImpl(resourceName, u, v, width, heigh);
    }

    @ZenMethodStatic
    public static JEILiquidSlot createLiquidSlot(boolean isInput, int x, int y, int width, int heigh, int capacityMb, boolean showCapacity, @Optional(valueBoolean = true) boolean hasBase) {
        return new JEILiquidSlotImpl(isInput, x, y, width, heigh, capacityMb, showCapacity, hasBase);
    }

    @ZenMethodStatic
    public static JEILiquidSlot createLiquidSlot(boolean isInput, int x, int y, @Optional(valueBoolean = true) boolean hasBase) {
        return createLiquidSlot(isInput, x, y, 16, 16, 1000, false, hasBase);
    }

    @ZenMethodStatic
    public static JEIItemSlot createItemSlot(boolean isInput, int x, int y, @Optional(valueBoolean = true) boolean hasBase) {
        return new JEIItemSlotImpl(isInput, x, y, hasBase);
    }

    @ZenMethodStatic
    public static JEIRecipe createJEIRecipe(String uid) {
        return new JEIRecipeImpl(uid);
    }

    //-------------------------------------------------------------------------------------------

    //Please make sure you really need this.
    @ZenMethodStatic
    public static JEIItemElement createJEIItemInputElement(int x, int y) {
        return new JEIItemInputElementImpl(x, y);
    }

    //Please make sure you really need this.
    @ZenMethodStatic
    public static JEIItemElement createJEIItemOutputElement(int x, int y) {
        return new JEIItemOutputElementImpl(x, y);
    }

    //Please make sure you really need this.
    @ZenMethodStatic
    public static JEIFluidElement createJEIFluidElement(int x, int y, int width, int heigh) {
        return new JEIFluidElementImpl(x, y, width, heigh);
    }

    @ZenMethodStatic
    public static JEIFontInfoElement createJEIFontInfoElement(int x, int y, String info, int color) {
        return new JEIFontInfoElementImpl(x, y, info, color);
    }

    @ZenMethodStatic
    public static JEIArrowElement createJEIArrowElement(int x, int y, int direction) {
        return new JEIArrowElementImpl(x, y, direction);
    }

    @ZenMethodStatic
    public static JEICustomElement createJEICustomElement(int x, int y, int width, int heigh, int u, int v, String texture) {
        return new JEICustomElementImpl(x, y, width, heigh, u, v, texture);
    }
}