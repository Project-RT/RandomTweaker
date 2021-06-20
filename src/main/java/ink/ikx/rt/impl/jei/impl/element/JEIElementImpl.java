package ink.ikx.rt.impl.jei.impl.element;

import ink.ikx.rt.api.instance.jei.interfaces.element.JEIElement;

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
}
