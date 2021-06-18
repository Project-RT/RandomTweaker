package ink.ikx.rt.api.instance.jei;

import ink.ikx.rt.api.instance.jei.interfaces.JEIBackground;
import ink.ikx.rt.api.instance.jei.interfaces.JEIPanel;
import ink.ikx.rt.api.instance.jei.interfaces.slots.JEIItemSlot;
import ink.ikx.rt.impl.jei.impl.JEIBackgroundImpl;
import ink.ikx.rt.impl.jei.impl.JEIPanelImpl;
import ink.ikx.rt.impl.jei.impl.slots.JEIItemSlotImpl;
import ink.ikx.rt.impl.jei.impl.slots.JEILiquidSlotImpl;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import java.util.Random;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethodStatic;

@ZenRegister
@ZenExpansion("mods.jei.JEI")
public class JEIExpansion {

    @ZenMethodStatic
    public static JEIPanel createJEIPanel(String localizationKey) {
        return createJEIPanel(getRandomString(8), localizationKey);
    }

    @ZenMethodStatic
    public static JEIPanel createJEIPanel(String uid, String localizationKey) {
        return new JEIPanelImpl(uid, localizationKey);
    }

    @ZenMethodStatic
    public static JEIBackground createJEIBackGroup(String resourceName, int u, int v, int width,
        int heigh) {
        return new JEIBackgroundImpl(resourceName, u, v, width, heigh);
    }

    @ZenMethodStatic
    public static JEILiquidSlotImpl createLiquidSlot(ILiquidStack liquid, int id, boolean isInput,
        int x, int y,
        int width, int heigh, @Optional(valueBoolean = true) boolean isBase,
        @Optional("randomtweaker:textures/gui/jei/jei_default.png") String texture) {

        return new JEILiquidSlotImpl(liquid, id, isInput, x, y, width, heigh, isBase, texture);
    }

    @ZenMethodStatic
    public static JEIItemSlot createItemSlot(IItemStack item, int id, boolean isInput,
        int x, int y, int width, int heigh, @Optional(valueBoolean = true) boolean isBase,
        @Optional("randomtweaker:textures/gui/jei/jei_default.png") String texture) {

        return new JEIItemSlotImpl(item, id, isInput, x, y, width, heigh, isBase, texture);
    }

    @SuppressWarnings("SameParameterValue")
    protected static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}