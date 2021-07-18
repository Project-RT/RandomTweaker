package ink.ikx.rt.api.mods.cote.flower.functional;

import ink.ikx.rt.api.mods.cote.flower.SubTileRepresentation;
import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@RTRegisterClass({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.SubTileFunctional")
public class SubTileFunctionalRepresentation extends SubTileRepresentation {

    private static final String TYPE_NAME = "functional";

    public SubTileFunctionalRepresentation(int color, String unlocalizedName) {
        super(color, unlocalizedName);
    }

    @ZenMethod
    public void register() {
        this.register(TYPE_NAME, this);
    }
}
