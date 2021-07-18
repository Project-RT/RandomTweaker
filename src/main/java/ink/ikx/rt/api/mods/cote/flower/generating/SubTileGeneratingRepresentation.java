package ink.ikx.rt.api.mods.cote.flower.generating;

import ink.ikx.rt.api.mods.cote.flower.SubTileRepresentation;
import ink.ikx.rt.api.mods.cote.function.botania.CanGeneratePassively;
import ink.ikx.rt.api.mods.cote.function.botania.PopulateDropStackNBTs;
import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;

@RTRegisterClass({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.SubTileGenerating")
public class SubTileGeneratingRepresentation extends SubTileRepresentation {

    private static final String TYPE_NAME = "generating";

    @ZenProperty
    public boolean PassiveFlower;
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

    public SubTileGeneratingRepresentation(int color, String unlocalizedName) {
        super(color, unlocalizedName);
    }

    @ZenMethod
    public boolean isShouldSyncPassiveGeneration() {
        return shouldSyncPassiveGeneration;
    }

    @ZenMethod
    public void setShouldSyncPassiveGeneration(boolean shouldSyncPassiveGeneration) {
        this.shouldSyncPassiveGeneration = shouldSyncPassiveGeneration;
    }

    @ZenMethod
    public boolean isPassiveFlower() {
        return PassiveFlower;
    }

    @ZenMethod
    public void setPassiveFlower(boolean passiveFlower) {
        PassiveFlower = passiveFlower;
    }

    @ZenMethod
    public int getValueForPassiveGeneration() {
        return valueForPassiveGeneration;
    }

    @ZenMethod
    public void setValueForPassiveGeneration(int valueForPassiveGeneration) {
        this.valueForPassiveGeneration = valueForPassiveGeneration;
    }

    @ZenMethod
    public int getDelayBetweenPassiveGeneration() {
        return delayBetweenPassiveGeneration;
    }

    @ZenMethod
    public void setDelayBetweenPassiveGeneration(int delayBetweenPassiveGeneration) {
        this.delayBetweenPassiveGeneration = delayBetweenPassiveGeneration;
    }

    @ZenMethod
    public void register() {
        this.register(TYPE_NAME, this);
    }
}
