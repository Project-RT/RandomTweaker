package ink.ikx.rt.api.mods.contenttweaker.subtile.functional;

import ink.ikx.rt.api.mods.contenttweaker.subtile.ISubTileEntityRepresentation;
import ink.ikx.rt.impl.mods.crafttweaker.ModTotal;
import ink.ikx.rt.impl.mods.crafttweaker.RTRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;

@RTRegister
@ModTotal({"botania", "contenttweaker"})
@ZenClass("mods.randomtweaker.cote.ISubTileEntityFunctional")
public abstract class ISubTileEntityFunctionalRepresentation extends ISubTileEntityRepresentation {

    private static final String TYPE_NAME = "functional";

    @ZenProperty
    public boolean hasMini;
    @ZenProperty
    public int miniRange = 1;

    protected ISubTileEntityFunctionalRepresentation(int color, String unlocalizedName) {
        super(color, unlocalizedName);
    }

    @ZenMethod
    public void register() {
        this.register(TYPE_NAME, hasMini);
    }

}
