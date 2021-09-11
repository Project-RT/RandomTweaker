package ink.ikx.rt.api.mods.cote.flower.functional;

import ink.ikx.rt.api.mods.cote.flower.SubTileRepresentation;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;

@ZenClass("mods.randomtweaker.cote.SubTileFunctional")
public class SubTileFunctionalRepresentation extends SubTileRepresentation {

    @ZenProperty
    public boolean hasMini;
    @ZenProperty
    public int miniRange = 1;

    private static final String TYPE_NAME = "functional";

    public SubTileFunctionalRepresentation(int color, String unlocalizedName) {
        super(color, unlocalizedName);
    }

    @ZenMethod
    public boolean hasMini() {
        return hasMini;
    }

    @ZenMethod
    public void hasMini(boolean hasMini) {
        this.hasMini = hasMini;
    }

    @ZenMethod
    public int getMiniRange() {
        return miniRange;
    }

    @ZenMethod
    public void setMiniRange(int miniRange) {
        this.miniRange = miniRange;
    }

    @ZenMethod
    public void register() {
        this.register(TYPE_NAME, hasMini);
    }
}
