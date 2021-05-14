package com.ikexing.icrtweaker.api.utils;

import com.google.common.collect.Lists;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import crafttweaker.api.world.IBlockPos;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import thaumcraft.api.capabilities.IPlayerKnowledge;
import thaumcraft.api.capabilities.ThaumcraftCapabilities;
import thaumcraft.common.config.ConfigItems;
import thaumcraft.common.lib.utils.InventoryUtils;

import java.util.List;

/**
 * @author ikexing
 */
@ZenClass("mods.icrtweaker.ICRTweaker")
public class ICRTweakerGlobal {
    public ICRTweakerGlobal() {
    }

    @ZenMethod
    public static void giverDreamJournl(IPlayer player) {
        EntityPlayer player1 = CraftTweakerMC.getPlayer(player);
        giverDreamJournl(player1);
        player1.sendMessage(new TextComponentString(TextFormatting.DARK_PURPLE + I18n.translateToLocal("got.dream")));
    }

    private static void giverDreamJournl(EntityPlayer player) {
        IPlayerKnowledge knowledge = ThaumcraftCapabilities.getKnowledge(player);
        knowledge.addResearch("!gotdream");
        knowledge.sync((EntityPlayerMP) player);
        ItemStack book = ConfigItems.startBook.copy();
        book.getTagCompound().setString("author", player.getName());
        if (!player.inventory.addItemStackToInventory(book)) {
            InventoryUtils.dropItemAtEntity(player.world, book, player);
        }
    }

    @ZenMethod
    public static IBlockPos[] getAllInBox(IBlockPos from, IBlockPos to) {
        Iterable<BlockPos> allInBox = BlockPos.getAllInBox(CraftTweakerMC.getBlockPos(from), CraftTweakerMC.getBlockPos(to));
        List<IBlockPos> list = Lists.newArrayList();
        allInBox.forEach(single -> list.add(CraftTweakerMC.getIBlockPos(single)));
        return list.toArray(new IBlockPos[0]);
    }
}
