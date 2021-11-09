package ink.ikx.rt.classTransforms.mods.astralsorcery;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import hellfirepvp.astralsorcery.common.constellation.IConstellation;
import hellfirepvp.astralsorcery.common.constellation.IWeakConstellation;
import hellfirepvp.astralsorcery.common.item.crystal.CrystalProperties;
import hellfirepvp.astralsorcery.common.item.crystal.CrystalPropertyItem;
import hellfirepvp.astralsorcery.common.item.crystal.base.ItemRockCrystalBase;
import hellfirepvp.astralsorcery.common.item.crystal.base.ItemTunedCrystalBase;
import ink.ikx.rt.impl.mods.astralsorcery.CustomAttunementRecipe;
import ink.ikx.rt.impl.mods.astralsorcery.event.AttunementCompleteEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@SuppressWarnings("unused")
public class AttunementAltarMethodReflections {

    public static void debugPrint(Object object) {


    }

    public static void checkForAttunements(EntityItem itemStack) {


    }

    public static void onAttunementStart(EntityItem itemStack) {


    }

    public static void onCraftingFinish(ItemStack itemStack, EntityItem original, World world, IConstellation constellation) {
        for (CustomAttunementRecipe recipe : CustomAttunementRecipe.allRecipes) {
            if (recipe.canDoRecipe(constellation, original.getItem())) {
                itemStack.setCount(recipe.getResult().getCount());
            }
        }
        AttunementCompleteEvent event = new AttunementCompleteEvent(itemStack, original, world, constellation);
        boolean eventExec = event.post();

        if (!eventExec) {
            itemStack = event.getOutput();
            for (ItemStack stack : event.getAdditionalOutput()) {
                if (!world.isRemote) {
                    EntityItem additionalStack = new EntityItem(world,
                            original.posX,
                            original.posY,
                            original.posZ,
                            stack);
                    additionalStack.motionX = 0.0D;
                    additionalStack.motionY = 0.0D;
                    additionalStack.motionZ = 0.0D;
                    world.spawnEntity(additionalStack);
                    additionalStack.setDefaultPickupDelay();
                }
            }
        } else {
            itemStack.setCount(0);
        }
    }

    public static boolean haveRecipe(IConstellation constellation, ItemStack itemStack) {

        for (CustomAttunementRecipe recipe : CustomAttunementRecipe.allRecipes) {

            if (recipe.canDoRecipe(constellation, itemStack)) {

                return true;
            }
        }
        return false;
    }

    public static boolean haveRecipe(IConstellation constellation, Entity entity) {
        if (entity instanceof EntityItem) {
            return haveRecipe(constellation, ((EntityItem) entity).getItem());
        } else {
            return false;
        }
    }

    public static boolean haveRecipe(IConstellation constellation, EntityItem itemStack) {
        return haveRecipe(constellation, itemStack.getItem());
    }

    public static boolean haveAnyRecipe(Entity entity) {
        if (entity instanceof EntityItem) {
            IItemStack itemStack = CraftTweakerMC.getIItemStack(((EntityItem) entity).getItem());
            for (CustomAttunementRecipe recipe : CustomAttunementRecipe.allRecipes) {
                if (recipe.getOriginal().matches(itemStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void applyCrystalProperties(ItemStack itemStack, CrystalProperties props) {
        if (itemStack.getItem() instanceof CrystalPropertyItem && props != null) {
            CrystalProperties.applyCrystalProperties(itemStack, props);
        }
    }

    public static boolean logicPatch(boolean A, boolean B, boolean C) {

        return (A && B) || C;
    }

    public static Item getTunedItemVariant(Item item, IConstellation constellation) {
        if (item instanceof ItemRockCrystalBase) {
            return ((ItemRockCrystalBase) item).getTunedItemVariant();
        } else {
            for (CustomAttunementRecipe recipe : CustomAttunementRecipe.allRecipes) {
                if (recipe.canDoRecipe(constellation, new ItemStack(item))) {
                    return recipe.getResult().getItem();
                }
            }
        }
        return item;
    }

    public static void applyMainConstellation(ItemStack itemStack, IConstellation constellation) {
        if (itemStack.getItem() instanceof ItemTunedCrystalBase && constellation instanceof IWeakConstellation) {
            ItemTunedCrystalBase.applyMainConstellation(itemStack, (IWeakConstellation) constellation);
        }
    }

}
