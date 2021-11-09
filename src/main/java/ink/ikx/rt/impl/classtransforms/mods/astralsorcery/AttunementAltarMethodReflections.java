package ink.ikx.rt.impl.classtransforms.mods.astralsorcery;

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
        //System.out.println("RandomTweakerASM: debug print");
        //System.out.println("RandomTweakerASM: " + object.toString());
    }

    public static void checkForAttunements(EntityItem itemStack) {
        //System.out.println("RandomTweakerASM: checking for attunements.");
        //System.out.println("RandomTweakerASM: item stack: " + itemStack.getItem());
    }

    public static void onAttunementStart(EntityItem itemStack) {
        //System.out.println("RandomTweakerASM: attunement starts.");
        //System.out.println("RandomTweakerASM: item stack: " + itemStack.getItem());
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


        /*
        //System.out.println("RandomTweakerASM: attunement finished.");
        //System.out.println("RandomTweakerASM: item stack: " + itemStack.getItem().toString());
        //System.out.println("RandomTweakerASM: original stack: " + original.getItem().toString());
        //System.out.println("RandomTweakerASM: world: " + world.toString());
        //System.out.println("RandomTweakerASM: constellation: " + constellation.toString());*/

    }

    public static boolean haveRecipe(IConstellation constellation, ItemStack itemStack) {
        //System.out.println("Checking Recipe on Item: " + CraftTweakerMC.getIItemStack(itemStack)+ " for constellation " + constellation.toString());
        for (CustomAttunementRecipe recipe : CustomAttunementRecipe.allRecipes) {
            //System.out.println("checking with recipe: " + recipe.getOriginal().toString());
            if (recipe.canDoRecipe(constellation, itemStack)) {
                //System.out.println("Found recipe!");
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
        //System.out.println("Logic patch: " + A + " " + B + " " + C);
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
