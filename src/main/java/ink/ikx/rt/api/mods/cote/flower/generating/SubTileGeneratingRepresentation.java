package ink.ikx.rt.api.mods.cote.flower.generating;

import crafttweaker.annotations.ZenRegister;
import ink.ikx.rt.api.mods.cote.function.botania.BlockActivated;
import ink.ikx.rt.api.mods.cote.function.botania.BlockAdded;
import ink.ikx.rt.api.mods.cote.function.botania.BlockHarvested;
import ink.ikx.rt.api.mods.cote.function.botania.BlockPlacedBy;
import ink.ikx.rt.api.mods.cote.function.botania.PopulateDropStackNBTs;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;

@ZenRegister
@ZenClass("mods.randomtweaker.cote.SubTileGenerating")
public class SubTileGeneratingRepresentation {

    @ZenProperty
    public int color;
    @ZenProperty
    public String name;

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
    public BlockPlacedBy onBlockPlaceBy = null;
    @ZenProperty
    public BlockHarvested onBlockHarvested = null;
    @ZenProperty
    public BlockActivated onBlockActivated = null;
    @ZenProperty
    public PopulateDropStackNBTs populateDropStackNBTs = null;

    private SubTileGeneratingRepresentation(int color, String name) {
        this.color = color;
        this.name = name;
    }

    @ZenMethod
    public static SubTileGeneratingRepresentation of(int s, String b) {
        return new SubTileGeneratingRepresentation(123, "123");
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
    public String getName() {
        return name;
    }

    @ZenMethod
    public void setName(String name) {
        this.name = name;
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
    public void register() {

    }
}
