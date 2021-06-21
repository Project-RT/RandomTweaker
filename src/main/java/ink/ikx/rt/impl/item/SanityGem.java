package ink.ikx.rt.impl.item;

import ink.ikx.rt.RandomTweaker;
import ink.ikx.rt.impl.utils.cap.PlayerSanityHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

@SuppressWarnings("NullableProblems")
public class SanityGem extends Item {

    public SanityGem() {
        setTranslationKey(RandomTweaker.MODID + ".sanity_gem");
        this.setRegistryName(RandomTweaker.MODID + ":sanity_gem");
        this.setMaxStackSize(1);
        this.setMaxDamage(6);
        this.setNoRepair();
        this.setCreativeTab(CreativeTabs.MISC);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);

        if (!worldIn.isRemote) {
            String message = I18n.format("randomtweaker.message.used",
                PlayerSanityHelper.getPlayerSanity(playerIn).getSanity());

            PlayerSanityHelper.playSound(playerIn);

            stack.damageItem(1, playerIn);
            playerIn.sendMessage(new TextComponentString(message).setStyle(new Style().setColor(
                TextFormatting.DARK_PURPLE).setBold(true)));
            playerIn.attackEntityFrom(DamageSource.MAGIC, 1);
            playerIn.setActiveHand(handIn);
            playerIn.getCooldownTracker().setCooldown(stack.getItem(), 60);
        }
        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }
}
