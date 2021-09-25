package ink.ikx.rt.api.internal.utils;

import crafttweaker.api.item.IIngredient;
import ink.ikx.rt.impl.internal.utils.MCInputPattern;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.Map;

@ZenClass("mods.randomtweaker.utils.IInputPattern")
public interface IInputPattern {

    @ZenMethod
    static IInputPattern create(String[] pattern) {
        return new MCInputPattern(pattern);
    }

    @ZenMethod
    static IIngredient[][] inputPattern(String[] pattern, Map<String, IIngredient> mapping) {
        return create(pattern).transform(mapping).get();
    }

    @ZenMethod
    static IIngredient[] inputPatternWithShapeLess(String[] pattern, Map<String, IIngredient> mapping) {
        return create(pattern).transform(mapping).getWithShapeless();
    }

    @ZenMethod
    IInputPattern with(String character, IIngredient ingredient);

    @ZenMethod
    IInputPattern transform(Map<String, IIngredient> mapping);

    @ZenMethod
    IIngredient[][] get();

    @ZenMethod
    IIngredient[] getWithShapeless();

}
