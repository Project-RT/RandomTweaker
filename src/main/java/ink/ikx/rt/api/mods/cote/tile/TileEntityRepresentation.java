package ink.ikx.rt.api.mods.cote.tile;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import ink.ikx.rt.api.mods.cote.function.TileEntityTick;
import ink.ikx.rt.api.mods.cote.tile.utils.TileEntityManager;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;

@ZenRegister
@ModOnly("contenttweaker")
@ZenClass("mods.randomtweaker.cote.TileEntity")
public class TileEntityRepresentation {

    @ZenProperty
    public TileEntityTick onTick = ((tileEntity, world, pos) -> {});

    private final String name;

    public TileEntityRepresentation(String name) {
        this.name = name;
    }

    @ZenGetter("name")
    @ZenMethod
    public String getName() {
        return name;
    }

    @ZenMethod
    public void register() {
        TileEntityManager.registerTileEntity(this);
    }
}
