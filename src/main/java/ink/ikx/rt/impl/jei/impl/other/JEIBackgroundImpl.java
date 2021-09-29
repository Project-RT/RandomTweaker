package ink.ikx.rt.impl.jei.impl.other;

import ink.ikx.rt.api.mods.jei.interfaces.other.JEIBackground;

public class JEIBackgroundImpl implements JEIBackground {

    public String resourceName;
    public int u;
    public int v;
    public int width;
    public int height;

    public JEIBackgroundImpl(String resourceName, int u, int v, int width, int height) {
        this.resourceName = resourceName;
        this.u = u;
        this.v = v;
        this.width = width;
        this.height = height;
    }

    public JEIBackgroundImpl(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String getResourceName() {
        return resourceName;
    }

    @Override
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    @Override
    public int getU() {
        return u;
    }

    @Override
    public void setU(int u) {
        this.u = u;
    }

    @Override
    public int getV() {
        return v;
    }

    @Override
    public void setV(int v) {
        this.v = v;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }
}
