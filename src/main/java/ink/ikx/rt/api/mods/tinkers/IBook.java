package ink.ikx.rt.api.mods.tinkers;

import crafttweaker.annotations.ModOnly;
import crafttweaker.api.item.IItemStack;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : wdcftgg
 * @create 2023/10/3 19:06
 */
@RTRegister
@ModOnly("tconstruct")
@ZenClass("mods.randomtweaker.tconstruct.IBook")
public abstract class IBook {

    public static List<String> hiddenmaterialList = new ArrayList<>();

    public static HashMap<String, IItemStack> materialshowitem = new HashMap<String, IItemStack>();

    @ZenMethod
    public static void addHiddenMaterial(String material) {
        hiddenmaterialList.add(material);
    }

    @ZenMethod
    public static void changeMaterialItem(String material, IItemStack item) {
        materialshowitem.put(material, item);
    }
}
