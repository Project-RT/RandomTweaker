package ink.ikx.rt.impl.jei.impl.other;

import ink.ikx.rt.api.instance.jei.interfaces.other.JEIBackground;

public class JEIBackgroundImpl implements JEIBackground {

    public String resourceName;
    public int u;
    public int v;
    public int width;
    public int heigh;

    public JEIBackgroundImpl(String resourceName, int u, int v, int width, int heigh) {
        this.resourceName = resourceName;
        this.u = u;
        this.v = v;
        this.width = width;
        this.heigh = heigh;
    }

    public JEIBackgroundImpl(int width, int heigh) {
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
