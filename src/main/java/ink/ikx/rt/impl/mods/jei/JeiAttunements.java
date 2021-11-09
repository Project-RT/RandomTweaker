package ink.ikx.rt.impl.mods.jei;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import hellfirepvp.astralsorcery.common.lib.BlocksAS;
import ink.ikx.rt.api.mods.jei.IJeiUtils;
import ink.ikx.rt.api.mods.jei.JEIExpansion;
import ink.ikx.rt.impl.mods.astralsorcery.CustomAttunementRecipe;
import ink.ikx.rt.impl.mods.jei.recipe.JEIAttunementRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;

public class JeiAttunements {

    public static final String UID = "randomtweaker:jei_attunements";
    private static final String TEXTURE = "randomtweaker:textures/gui/jei/altarattunement.png";
    private static final IItemStack ALTAR = CraftTweakerMC.getIItemStack(new ItemStack(BlocksAS.attunementAltar));

    public static void init() {
        JEIExpansion.createJei(UID, I18n.translateToLocal("randomtweaker.jei_attunements"))
                .setIcon(ALTAR)
                .setBackground(IJeiUtils.createBackground(0, 0, 115, 161, TEXTURE))
                .addRecipeCatalyst(ALTAR)
                .addSlot(IJeiUtils.createItemSlot(49, 76, true, false))
                .addSlot(IJeiUtils.createItemSlot(49, 17, false, false))
                .register_();
        getRecipes();
    }

    private static void getRecipes() {
        for (CustomAttunementRecipe recipe : CustomAttunementRecipe.allRecipes) {
            JEIAttunementRecipe JEIRecipe = (JEIAttunementRecipe)
                    new JEIAttunementRecipe(UID)
                            .setConstellation(recipe.getConstellation())
                            .addInput(recipe.getOriginal())
                            .addOutput(CraftTweakerMC.getIItemStack(recipe.getResult()));
            JEIRecipe.build_();
        }
    }
}
