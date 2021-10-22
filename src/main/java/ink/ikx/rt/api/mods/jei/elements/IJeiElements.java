package ink.ikx.rt.api.mods.jei.elements;

import crafttweaker.annotations.ModOnly;
import ink.ikx.rt.impl.mods.crafttweaker.ModTotal;
import ink.ikx.rt.impl.mods.crafttweaker.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenProperty;

public abstract class IJeiElements {

    @ZenRegister
    @ModOnly("jei")
    @ZenClass("mods.randomtweaker.jei.IJeiElementItemInput")
    public abstract static class IJeiElementItemInput extends IJeiElement {

        protected IJeiElementItemInput(int x, int y) {
            super(x, y, 18, 18);
        }

    }

    @ZenRegister
    @ModOnly("jei")
    @ZenClass("mods.randomtweaker.jei.IJeiElementItemOutput")
    public abstract static class IJeiElementItemOutput extends IJeiElement {

        protected IJeiElementItemOutput(int x, int y) {
            super(80, 0, x, y, 27, 27);
        }

    }

    @ZenRegister
    @ModOnly("jei")
    @ZenClass("mods.randomtweaker.jei.IJeiElementLiquid")
    public abstract static class IJeiElementLiquid extends IJeiElement {

        protected IJeiElementLiquid(int x, int y, int width, int height) {
            super(x, y, width, height);
        }

    }

    @ZenRegister
    @ModOnly("jei")
    @ZenClass("mods.randomtweaker.jei.IJeiElementArrow")
    public abstract static class IJeiElementArrow extends IJeiElement {

        @ZenProperty
        public int direction;

        protected IJeiElementArrow(int x, int y, int direction) {
            super(x, y, 0, 0);
            this.direction = direction;
        }

    }

    @ZenRegister
    @ModOnly("jei")
    @ZenClass("mods.randomtweaker.jei.IJeiElementFontInfo")
    public abstract static class IJeiElementFontInfo extends IJeiElement {

        @ZenProperty
        public int color;

        @ZenProperty
        public String info;

        protected IJeiElementFontInfo(int x, int y, int width, int height, int color, String info) {
            super(x, y, width, height);
            this.info = info;
            this.color = color;
        }

    }

    @ZenRegister
    @ModTotal({"jei", "botania"})
    @ZenClass("mods.randomtweaker.jei.IJeiElementManaBar")
    public abstract static class IJeiElementManaBar extends IJeiElement {

        @ZenProperty
        public int mode;

        @ZenProperty
        public int mana;

        protected IJeiElementManaBar(int x, int y, int mode, int mana) {
            super(x, y, 0, 0);
            this.mode = mode;
            this.mana = mana;
        }

    }

    @ZenRegister
    @ModOnly("jei")
    @ZenClass("mods.randomtweaker.jei.IJeiElementImage")
    public abstract static class IJeiElementImage extends IJeiElement {

        @ZenProperty
        public String texture;

        @ZenProperty
        public int textureHeight;

        @ZenProperty
        public int textureWidth;

        protected IJeiElementImage(int u, int v, int x, int y, int width, int height,
                                   String texture, int textureWidth, int textureHeight) {
            super(u, v, x, y, width, height);
            this.texture = texture;
            this.textureWidth = textureWidth;
            this.textureHeight = textureHeight;
        }

    }

}
