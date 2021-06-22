package ink.ikx.rt.api.instance.utils;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import java.util.Objects;
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

@ZenRegister
@ZenClass("mods.randomtweaker.randomtweaker")
public class RTGlobal {

    @ZenMethod
    public static void giverDreamJournl(IPlayer player) {
        EntityPlayer mcPlayer = CraftTweakerMC.getPlayer(player);
        giverDreamJournl(mcPlayer);
        mcPlayer.sendMessage(new TextComponentString(TextFormatting.DARK_PURPLE + I18n.translateToLocal("got.dream")));
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
