package ink.ikx.rt.api.mods.cote.block.tile;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ModOnly("contenttweaker")
@ZenClass("mods.randomtweaker.cote.TileEntity")
public class TileEntityRepresentation {
    private final String id;

    public TileEntityRepresentation(String id) {
        this.id = id;
    }

    @ZenGetter("id")
    public String getId() {
        return id;
    }

    @ZenMethod
    public void register() {
        // TODO: 2021/8/21
    }
}
