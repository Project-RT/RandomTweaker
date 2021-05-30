package com.ikexing.randomtweaker.api.utils;

import com.google.common.collect.Lists;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import crafttweaker.api.world.IBlockPos;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import thaumcraft.api.capabilities.IPlayerKnowledge;
import thaumcraft.api.capabilities.ThaumcraftCapabilities;
import thaumcraft.common.config.ConfigItems;
import thaumcraft.common.lib.utils.InventoryUtils;

import java.util.List;
import java.util.Objects;

/**
 * @author ikexing
 */
@ZenClass("mods.randomtweaker.ICRTweaker")
public class RTGlobal {
    public RTGlobal() {
    }

    @ZenMethod
    public static void giverDreamJournl(IPlayer player) {
        EntityPlayer player1 = CraftTweakerMC.getPlayer(player);
        giverDreamJournl(player1);
        player1.sendMessage(new TextComponentString(TextFormatting.DARK_PURPLE + I18n.translateToLocal("got.dream")));
    }

    @ZenMethod
    public static IBlockPos[] getAllInBox(IBlockPos from, IBlockPos to) {
        Iterable<BlockPos> allInBox = BlockPos.getAllInBox(CraftTweakerMC.getBlockPos(from), CraftTweakerMC.getBlockPos(to));
        List<IBlockPos> list = Lists.newArrayList();
        allInBox.forEach(single -> list.add(CraftTweakerMC.getIBlockPos(single)));
        return list.toArray(new IBlockPos[0]);
    }

    @SideOnly(Side.CLIENT)
    @ZenMethod
    public static void sendMessage(String string) {
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new TextComponentString(string));
    }

    private static void giverDreamJournl(EntityPlayer player) {
        IPlayerKnowledge knowledge = ThaumcraftCapabilities.getKnowledge(player);
        knowledge.addResearch("!gotdream");
        knowledge.sync((EntityPlayerMP) player);
        ItemStack book = ConfigItems.startBook.copy();
        Objects.requireNonNull(book.getTagCompound()).setString("author", player.getName());
        if (!player.inventory.addItemStackToInventory(book)) {
            InventoryUtils.dropItemAtEntity(player.world, book, player);
        }
    }
}
