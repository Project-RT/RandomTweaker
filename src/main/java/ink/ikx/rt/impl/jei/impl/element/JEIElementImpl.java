package ink.ikx.rt.impl.jei.impl.element;

import ink.ikx.rt.api.mods.jei.interfaces.element.JEIElement;

public abstract class JEIElementImpl implements JEIElement {

    public int x;
    public int y;
    public int width;
    public int height;
    public String texture = "randomtweaker:textures/gui/jei/jei_default.png";

    public JEIElementImpl(int x, int y, int width, int heigh) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = heigh;
    }

    @Override
    public int getU() {
        return 0;
    }

    @Override
    public void setU(int u) {
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getV() {
        return 0;
    }

    @Override
    public void setV(int v) {
    }

    @Override
    public String getTexture() {
        return this.texture;
    }

    @Override
    public void setTexture(String texture) {
        this.texture = texture;
    }
}
