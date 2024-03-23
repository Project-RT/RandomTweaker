package ink.ikx.rt.api.mods.contenttweaker.subtile.generating;

import ink.ikx.rt.api.mods.contenttweaker.function.subtile.CanGeneratePassively;
import ink.ikx.rt.api.mods.contenttweaker.function.subtile.PopulateDropStackNBTs;
import ink.ikx.rt.api.mods.contenttweaker.subtile.ISubTileEntityRepresentation;
import youyihj.zenutils.api.zenscript.SidedZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;

@ZenClass("mods.randomtweaker.cote.ISubTileEntityGenerating")
public abstract class ISubTileEntityGeneratingRepresentation extends ISubTileEntityRepresentation {

    private static final String TYPE_NAME = "generating";

    @ZenProperty
    public boolean passiveFlower;
    @ZenProperty
    public int valueForPassiveGeneration = 1;
    @ZenProperty
    public int delayBetweenPassiveGeneration = 20;
    @ZenProperty
    public boolean shouldSyncPassiveGeneration;
    @ZenProperty
    public PopulateDropStackNBTs populateDropStackNBTs;
    @ZenProperty
    public CanGeneratePassively canGeneratePassively;

    protected ISubTileEntityGeneratingRepresentation(int color, String unlocalizedName) {
        super(color, unlocalizedName);
    }

    @ZenMethod
    public void register() {
        this.register(TYPE_NAME, false);
    }

}
