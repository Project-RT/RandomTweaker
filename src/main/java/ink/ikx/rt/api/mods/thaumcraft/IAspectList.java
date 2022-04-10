package ink.ikx.rt.api.mods.thaumcraft;

import com.google.common.collect.Maps;
import crafttweaker.annotations.ModOnly;
import crafttweaker.api.item.IItemStack;
import ink.ikx.rt.Main;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import ink.ikx.rt.impl.mods.thaumcraft.MCAspectList;
import java.util.Map;
import stanhebben.zenscript.annotations.*;
import thaumcraft.api.aspects.AspectList;

@RTRegister
@ModOnly("thaumcraft")
@ZenClass("mods.randomtweaker.thaumcraft.IAspectList")
@IterableSimple("mods.randomtweaker.thaumcraft.IAspect")
public interface IAspectList extends Iterable<IAspect> {

    static IAspectList of(AspectList list) {
        return new MCAspectList(list);
    }

    @ZenMethod
    static IAspectList of() {
        return IAspectList.of(new AspectList());
    }

    @ZenMethod
    static Map<IItemStack, IAspectList> getAllRegStackWithAspects() {
        Map<IItemStack, IAspectList> map = Maps.newHashMap();
        Main.OBJECT_TAGS_FOR_RT.forEach((stack, aspectList) -> map.put(stack, of(aspectList)));
        return map;
    }

    @ZenMethod
    @ZenGetter("size")
    int getSize();

    @ZenMethod
    @ZenGetter("visSize")
    int getVisSize();

    @ZenMethod
    int getAmount(IAspect key);

    @ZenMethod
    IAspectList copy();

    @ZenMethod
    IAspect[] getAspects();

    @ZenMethod
    IAspect[] getAspectsSortedByName();

    @ZenMethod
    IAspect[] getAspectsSortedByAmount();

    @ZenMethod
    IAspectList add(IAspectList in);

    @ZenMethod
    IAspectList add(IAspect key, @Optional(valueLong = 1) int amount);

    @ZenMethod
    boolean reduce(IAspect key, @Optional(valueLong = 1) int amount);

    @ZenMethod
    IAspectList remove(IAspect key);

    @ZenMethod
    IAspectList remove(IAspect key, int amount);

    @ZenMethod
    IAspectList remove(IAspectList in);

    @ZenMethod
    IAspectList merge(IAspectList in);

    @ZenMethod
    IAspectList merge(IAspect key, @Optional(valueLong = 1) int amount);

    @ZenMethod
    @ZenMemberGetter
    @ZenOperator(OperatorType.INDEXGET)
    IAspect get(int index);

    @ZenMethod
    @ZenOperator(OperatorType.CONTAINS)
    boolean contains(IAspect aspect);

    AspectList getInternal();

}
