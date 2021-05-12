package com.ikexing.icrtweaker.api.jei;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;

//W I P

@ZenRegister
@ZenClass("mods.icrtweaker.Jei")
public class JEIExpansion {
    @ZenProperty
    public String unlocalizedName;

    @ZenMethod
    public void setUnlocalizedName(String unlocalizedName){
        this.unlocalizedName = unlocalizedName;
    }

    @ZenMethod
    public String getUnlocalizedName(){
        return this.unlocalizedName;
    }

}
