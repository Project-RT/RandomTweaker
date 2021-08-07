package ink.ikx.rt.impl.jei.impl.element;

import ink.ikx.rt.api.mods.jei.interfaces.element.JEIElement;

public abstract class JEIElementImpl implements JEIElement {

    public int x;
    public int y;
    public int width;
    public int heigh;

    public JEIElementImpl(int x, int y, int width, int heigh) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigh = heigh;
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
    public int getHeigh() {
        return this.heigh;
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
    public void setHeigh(int heigh) {
        this.heigh = heigh;
    }

    @Override
    public String getTexture() {
        return null;
    }

    @Override
    public void setTexture(String texture) {
    }

    @Override
    public int getU() {
        return 0;
    }

    @Override
    public void setU(int u) {

    }

    @Override
    public int getV() {
        return 0;
    }

    @Override
    public void setV(int v) {

    }
}
