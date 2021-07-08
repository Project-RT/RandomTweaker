package ink.ikx.rt.proxy;

import net.minecraft.item.ItemStack;

public class SeverProxy extends CommonProxy {

    private void throwException() {
        throw new IllegalStateException("This is only run in clent");
    }

    @Override
    public void renderTrinket(ItemStack renderStack, double[] toScale, float[] toTranslate) {
        throwException();
    }
}
