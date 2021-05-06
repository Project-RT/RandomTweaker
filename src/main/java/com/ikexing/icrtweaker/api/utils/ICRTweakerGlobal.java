package com.ikexing.icrtweaker.api.utils;

import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import thaumcraft.api.capabilities.IPlayerKnowledge;
import thaumcraft.api.capabilities.ThaumcraftCapabilities;
import thaumcraft.common.config.ConfigItems;
import thaumcraft.common.lib.utils.InventoryUtils;

@ZenClass("mods.icrtweaker.ICRTweaker")
public class ICRTweakerGlobal {
    public ICRTweakerGlobal() {
    }

    @ZenMethod
    public static boolean giverDreamJournl(IPlayer player) {
        EntityPlayer player1 = CraftTweakerMC.getPlayer(player);

        IPlayerKnowledge knowledge = ThaumcraftCapabilities.getKnowledge(player1);
        giverDreamJournl(player1);
        player1.sendMessage(new TextComponentString(TextFormatting.DARK_PURPLE + I18n.translateToLocal("got.dream")));
        if (knowledge.isResearchKnown("!gotdream"))
            return false;
        else
            return true;
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
}
