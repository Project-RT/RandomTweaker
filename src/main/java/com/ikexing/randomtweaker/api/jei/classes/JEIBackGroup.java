package com.ikexing.randomtweaker.api.jei.classes;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;

/**
 * @author ikexing
 */
@ZenRegister
@ZenClass("mods.randomtweaker.JEIBackGroup")
public class JEIBackGroup {
    public String namespaceIn;
    public String pathIn;
    public int u = 0;
    public int v = 0;
    public int width = 0;
    public int heigh = 0;

    public JEIBackGroup(String namespaceIn, String pathIn, int u, int v, int width, int heigh) {
        this.namespaceIn = namespaceIn;
        this.pathIn = pathIn;
        this.u = u;
        this.v = v;
        this.width = width;
        this.heigh = heigh;
    }

    public JEIBackGroup(int width, int heigh) {
        this.width = width;
        this.heigh = heigh;
    }

    public boolean isNull() {
        return this.namespaceIn == null || namespaceIn.length() == 0;
    }
}
