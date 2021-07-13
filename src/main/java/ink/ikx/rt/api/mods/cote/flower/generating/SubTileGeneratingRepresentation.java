package ink.ikx.rt.api.mods.cote.flower.generating;

import crafttweaker.CraftTweakerAPI;
import ink.ikx.rt.RandomTweaker;
import ink.ikx.rt.api.mods.cote.function.botania.BlockActivated;
import ink.ikx.rt.api.mods.cote.function.botania.BlockAdded;
import ink.ikx.rt.api.mods.cote.function.botania.BlockHarvested;
import ink.ikx.rt.api.mods.cote.function.botania.BlockPlacedBy;
import ink.ikx.rt.api.mods.cote.function.botania.CanGeneratePassively;
import ink.ikx.rt.api.mods.cote.function.botania.CanSelect;
import ink.ikx.rt.api.mods.cote.function.botania.PopulateDropStackNBTs;
import ink.ikx.rt.api.mods.cote.function.botania.UpdateWithGenerating;
import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import java.util.Objects;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;

@RTRegisterClass({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.SubTileGenerating")
public class SubTileGeneratingRepresentation {

    @ZenProperty
    public int color;
    @ZenProperty
    public String unlocalizedName;

    @ZenProperty
    public int range = 1;
    @ZenProperty
    public int maxMana = 1000;
    @ZenProperty
    public boolean PassiveFlower = true;
    @ZenProperty
    public BlockAdded onBlockAdded = null;
    @ZenProperty
    public boolean acceptsRedstone = false;
    @ZenProperty
    public int valueForPassiveGeneration = 1;
    @ZenProperty
    public CanSelect canSelect = null;
    @ZenProperty
    public boolean overgrowthAffected = false;
    @ZenProperty
    public BlockPlacedBy onBlockPlaceBy = null;
    @ZenProperty
    public UpdateWithGenerating onUpdate = null;
    @ZenProperty
    public int delayBetweenPassiveGeneration = 20;
    @ZenProperty
    public BlockHarvested onBlockHarvested = null;
    @ZenProperty
    public BlockActivated onBlockActivated = null;
    @ZenProperty
    public CanGeneratePassively canGeneratePassively = null;
    @ZenProperty
    public PopulateDropStackNBTs populateDropStackNBTs = null;

    private SubTileGeneratingRepresentation(int color, String unlocalizedName) {
        this.color = color;
        this.unlocalizedName = unlocalizedName;
    }

    @ZenMethod
    public static SubTileGeneratingRepresentation of(int s, String b) {
        return new SubTileGeneratingRepresentation(s, b);
    }

    @ZenMethod
    public int getColor() {
        return color;
    }

    @ZenMethod
    public void setColor(int color) {
        this.color = color;
    }

    @ZenMethod
    public int getRange() {
        return range;
    }

    @ZenMethod
    public void setRange(int range) {
        this.range = range;
    }

    @ZenMethod
    public boolean isAcceptsRedstone() {
        return acceptsRedstone;
    }

    @ZenMethod
    public void setAcceptsRedstone(boolean acceptsRedstone) {
        this.acceptsRedstone = acceptsRedstone;
    }

    @ZenMethod
    public String getUnlocalizedName() {
        return unlocalizedName;
    }

    @ZenMethod
    public void setUnlocalizedName(String unlocalizedName) {
        this.unlocalizedName = unlocalizedName;
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
    public int getMaxMana() {
        return maxMana;
    }

    @ZenMethod
    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
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
    public boolean isOvergrowthAffected() {
        return overgrowthAffected;
    }

    @ZenMethod
    public void setOvergrowthAffected(boolean overgrowthAffected) {
        this.overgrowthAffected = overgrowthAffected;
    }

    @ZenMethod
    public void register() {
        if (Objects.nonNull(RandomTweaker.subTileGeneratingMap.putIfAbsent(getUnlocalizedName(), this))) {
            CraftTweakerAPI.logError("All Potions must be unique. Key: contenttweaker:" + unlocalizedName + " is not.", new UnsupportedOperationException());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SubTileGeneratingRepresentation that = (SubTileGeneratingRepresentation) o;

        return unlocalizedName.equals(that.unlocalizedName);
    }

    @Override
    public int hashCode() {
        return unlocalizedName.hashCode();
    }
}
