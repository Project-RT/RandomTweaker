package com.ikexing.randomtweaker.impl.jei.impl;

import com.ikexing.randomtweaker.api.instance.jei.interfaces.JEIBackGroup;

public class JEIBackGroupImpl implements JEIBackGroup {

    public String resourceName;
    public int u;
    public int v;
    public int width;
    public int heigh;

    public JEIBackGroupImpl(String resourceName, int u, int v, int width, int heigh) {
        this.resourceName = resourceName;
        this.u = u;
        this.v = v;
        this.width = width;
        this.heigh = heigh;
    }

    public JEIBackGroupImpl(int width, int heigh) {
        this.width = width;
        this.heigh = heigh;
    }

    @Override
    public String getResourceName() {
        return this.resourceName;
    }

    @Override
    public int getU() {
        return this.u;
    }

    @Override
    public int getV() {
        return this.v;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.heigh;
    }
}
